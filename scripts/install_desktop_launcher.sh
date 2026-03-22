#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
REPO_ROOT="$(cd "${SCRIPT_DIR}/.." && pwd)"
APP_ID="vacuum-supervisor"
APP_NAME="Vacuum Supervisor"
URI_SCHEME="vacuum-supervisor"
BIN_DIR="${XDG_BIN_HOME:-${HOME}/.local/bin}"
DATA_HOME="${XDG_DATA_HOME:-${HOME}/.local/share}"
CONFIG_HOME="${XDG_CONFIG_HOME:-${HOME}/.config}"
APPLICATIONS_DIR="${DATA_HOME}/applications"
ICON_DIR="${DATA_HOME}/icons/hicolor/192x192/apps"
WRAPPER_PATH="${BIN_DIR}/${APP_ID}"
DESKTOP_FILE_PATH="${APPLICATIONS_DIR}/${APP_ID}.desktop"
ICON_SOURCE_PATH="${REPO_ROOT}/MainApp/src/android/res/mipmap-xxxhdpi/ic_launcher.png"
ICON_INSTALL_PATH="${ICON_DIR}/${APP_ID}.png"
DIST_INSTALL_PATH="${REPO_ROOT}/MainApp/build/install/MainApp"
DIST_SCRIPT_PATH="${DIST_INSTALL_PATH}/bin/MainApp"
REPO_GRADLE_PROPS="${REPO_ROOT}/gradle.properties"
USER_GRADLE_PROPS="${HOME}/.gradle/gradle.properties"
SKIP_BUILD=0
JAVA_HOME_OVERRIDE=""

usage() {
  cat <<EOF
Usage: $0 [--skip-build] [--java-home /absolute/path/to/javafx-jdk]

Builds the desktop distribution, installs a launcher in:
  ${WRAPPER_PATH}

and a desktop entry in:
  ${DESKTOP_FILE_PATH}

Then registers the URI scheme:
  ${URI_SCHEME}://open?view=CB
EOF
}

read_gradle_property() {
  local file_path="$1"
  local key="$2"
  if [[ -f "${file_path}" ]]; then
    sed -n "s/^${key}=//p" "${file_path}" | tail -n1
  fi
}

resolve_java_home() {
  if [[ -n "${JAVA_HOME_OVERRIDE}" ]]; then
    printf '%s\n' "${JAVA_HOME_OVERRIDE}"
    return 0
  fi

  local repo_java_home
  repo_java_home="$(read_gradle_property "${REPO_GRADLE_PROPS}" "org.gradle.java.home")"
  if [[ -n "${repo_java_home}" ]]; then
    printf '%s\n' "${repo_java_home}"
    return 0
  fi

  local user_java_home
  user_java_home="$(read_gradle_property "${USER_GRADLE_PROPS}" "org.gradle.java.home")"
  if [[ -n "${user_java_home}" ]]; then
    printf '%s\n' "${user_java_home}"
    return 0
  fi

  if [[ -n "${JAVA_HOME:-}" ]]; then
    printf '%s\n' "${JAVA_HOME}"
  fi
}

while [[ $# -gt 0 ]]; do
  case "$1" in
    --skip-build)
      SKIP_BUILD=1
      shift
      ;;
    --java-home)
      if [[ $# -lt 2 ]]; then
        echo "Missing value for --java-home" >&2
        exit 1
      fi
      JAVA_HOME_OVERRIDE="$2"
      shift 2
      ;;
    -h|--help)
      usage
      exit 0
      ;;
    *)
      echo "Unknown argument: $1" >&2
      usage >&2
      exit 1
      ;;
  esac
done

LAUNCH_JAVA_HOME="$(resolve_java_home)"

if [[ -z "${LAUNCH_JAVA_HOME}" ]]; then
  echo "Could not resolve a Java home for the desktop launcher." >&2
  echo "Set org.gradle.java.home in gradle.properties or pass --java-home." >&2
  exit 1
fi

if [[ ! -x "${LAUNCH_JAVA_HOME}/bin/java" ]]; then
  echo "Java executable not found under: ${LAUNCH_JAVA_HOME}/bin/java" >&2
  exit 1
fi

if [[ "${SKIP_BUILD}" -ne 1 ]]; then
  echo "Building desktop distribution..."
  (
    cd "${REPO_ROOT}"
    ./gradlew :MainApp:installDist
  )
fi

if [[ ! -x "${DIST_SCRIPT_PATH}" ]]; then
  echo "Desktop launcher script not found: ${DIST_SCRIPT_PATH}" >&2
  echo "Run ./gradlew :MainApp:installDist first." >&2
  exit 1
fi

if [[ ! -f "${ICON_SOURCE_PATH}" ]]; then
  echo "Android launcher icon not found: ${ICON_SOURCE_PATH}" >&2
  exit 1
fi

LAUNCH_JAVA_HOME="$(cd "$(dirname "${LAUNCH_JAVA_HOME}")" && pwd)/$(basename "${LAUNCH_JAVA_HOME}")"
DIST_SCRIPT_PATH="$(cd "$(dirname "${DIST_SCRIPT_PATH}")" && pwd)/$(basename "${DIST_SCRIPT_PATH}")"

mkdir -p "${BIN_DIR}" "${APPLICATIONS_DIR}" "${CONFIG_HOME}" "${ICON_DIR}"
cp "${ICON_SOURCE_PATH}" "${ICON_INSTALL_PATH}"

cat > "${WRAPPER_PATH}" <<EOF
#!/usr/bin/env bash
set -euo pipefail

DIST_SCRIPT_PATH="${DIST_SCRIPT_PATH}"
JAVA_HOME_VALUE="${LAUNCH_JAVA_HOME}"
ICON_PATH="${ICON_INSTALL_PATH}"
LOG_DIR="\${XDG_CACHE_HOME:-\${HOME}/.cache}/${APP_ID}"
LOG_FILE="\${LOG_DIR}/launcher.log"

mkdir -p "\${LOG_DIR}"
exec >>"\${LOG_FILE}" 2>&1

echo "[\$(date '+%Y-%m-%d %H:%M:%S')] Launching ${APP_NAME} \$*"

if [[ ! -x "\${DIST_SCRIPT_PATH}" ]]; then
  echo "Desktop distribution script not found: \${DIST_SCRIPT_PATH}" >&2
  echo "Rebuild with ./gradlew :MainApp:installDist and rerun the launcher installer." >&2
  exit 1
fi

if [[ ! -x "\${JAVA_HOME_VALUE}/bin/java" ]]; then
  echo "JavaFX-enabled java not found: \${JAVA_HOME_VALUE}/bin/java" >&2
  exit 1
fi

export JAVA_HOME="\${JAVA_HOME_VALUE}"
export VACUUM_SUPERVISOR_DESKTOP_ICON_PATH="\${ICON_PATH}"

exec "\${DIST_SCRIPT_PATH}" "\$@"
EOF

chmod +x "${WRAPPER_PATH}"

cat > "${DESKTOP_FILE_PATH}" <<EOF
[Desktop Entry]
Version=1.0
Type=Application
Name=${APP_NAME}
Comment=Vacuum Supervisor desktop launcher
Exec=${WRAPPER_PATH} %u
Icon=${ICON_INSTALL_PATH}
Path=${REPO_ROOT}
Terminal=false
StartupNotify=true
Categories=Utility;
MimeType=x-scheme-handler/${URI_SCHEME};
EOF

if command -v update-desktop-database >/dev/null 2>&1; then
  update-desktop-database "${APPLICATIONS_DIR}" >/dev/null 2>&1 || true
fi

if command -v xdg-mime >/dev/null 2>&1; then
  xdg-mime default "$(basename "${DESKTOP_FILE_PATH}")" "x-scheme-handler/${URI_SCHEME}" || true
fi

echo "Installed launcher: ${WRAPPER_PATH}"
echo "Installed desktop entry: ${DESKTOP_FILE_PATH}"
echo "Installed icon: ${ICON_INSTALL_PATH}"
echo "Using Java home: ${LAUNCH_JAVA_HOME}"
echo "Registered URI scheme: ${URI_SCHEME}"
echo "Example link: ${URI_SCHEME}://open?view=CB"
