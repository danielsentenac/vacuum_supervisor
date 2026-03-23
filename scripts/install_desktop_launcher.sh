#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
REPO_ROOT="$(cd "${SCRIPT_DIR}/.." && pwd)"
APP_ID="vacuum-supervisor"
APP_NAME="Vacuum Supervisor"
URI_SCHEME="vacuum-supervisor"
DEFAULT_BACKEND_HOST="olserver135.virgo.infn.it"
BIN_DIR="${XDG_BIN_HOME:-${HOME}/.local/bin}"
DATA_HOME="${XDG_DATA_HOME:-${HOME}/.local/share}"
CONFIG_HOME="${XDG_CONFIG_HOME:-${HOME}/.config}"
APPLICATIONS_DIR="${DATA_HOME}/applications"
ICON_DIR="${DATA_HOME}/icons/hicolor/192x192/apps"
WRAPPER_PATH="${BIN_DIR}/${APP_ID}"
DESKTOP_FILE_PATH="${APPLICATIONS_DIR}/${APP_ID}.desktop"
LEGACY_DESKTOP_FILE_PATH="${APPLICATIONS_DIR}/Supervisor.desktop"
ICON_SOURCE_PATH="${REPO_ROOT}/MainApp/src/android/res/mipmap-xxxhdpi/ic_launcher.png"
ICON_INSTALL_PATH="${ICON_DIR}/${APP_ID}.png"
DESKTOP_CLASSPATH_PATH="${REPO_ROOT}/MainApp/build/desktop-launch/classpath.txt"
MAIN_CLASS_NAME="com.gluonapplication.Main"
REPO_GRADLE_PROPS="${REPO_ROOT}/gradle.properties"
USER_GRADLE_PROPS="${HOME}/.gradle/gradle.properties"
SKIP_BUILD=0
JAVA_HOME_OVERRIDE=""

usage() {
  cat <<EOF
Usage: $0 [--skip-build] [--java-home /absolute/path/to/javafx-jdk]

Builds the desktop runtime launcher, installs a launcher in:
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

is_valid_java_home() {
  local candidate="$1"
  [[ -n "${candidate}" && -x "${candidate}/bin/java" ]]
}

resolve_java_home() {
  if is_valid_java_home "${JAVA_HOME_OVERRIDE}"; then
    printf '%s\n' "${JAVA_HOME_OVERRIDE}"
    return 0
  fi

  local repo_java_home
  repo_java_home="$(read_gradle_property "${REPO_GRADLE_PROPS}" "org.gradle.java.home")"
  if is_valid_java_home "${repo_java_home}"; then
    printf '%s\n' "${repo_java_home}"
    return 0
  fi

  local user_java_home
  user_java_home="$(read_gradle_property "${USER_GRADLE_PROPS}" "org.gradle.java.home")"
  if is_valid_java_home "${user_java_home}"; then
    printf '%s\n' "${user_java_home}"
    return 0
  fi

  if is_valid_java_home "${JAVA_HOME:-}"; then
    printf '%s\n' "${JAVA_HOME}"
    return 0
  fi

  local java_path=""
  java_path="$(command -v java 2>/dev/null || true)"
  if [[ -n "${java_path}" ]]; then
    local resolved_java_path=""
    resolved_java_path="$(readlink -f "${java_path}")"
    local resolved_java_home=""
    resolved_java_home="$(cd "$(dirname "${resolved_java_path}")/.." && pwd)"
    if is_valid_java_home "${resolved_java_home}"; then
      printf '%s\n' "${resolved_java_home}"
      return 0
    fi
    if [[ "$(basename "${resolved_java_home}")" == "jre" ]]; then
      local resolved_jdk_home=""
      resolved_jdk_home="$(cd "${resolved_java_home}/.." && pwd)"
      if is_valid_java_home "${resolved_jdk_home}"; then
        printf '%s\n' "${resolved_jdk_home}"
        return 0
      fi
    fi
  fi

  if [[ -n "${JAVA_HOME_OVERRIDE}" && ! -x "${JAVA_HOME_OVERRIDE}/bin/java" ]]; then
    echo "Ignoring invalid --java-home: ${JAVA_HOME_OVERRIDE}" >&2
  fi
  if [[ -n "${repo_java_home}" && ! -x "${repo_java_home}/bin/java" ]]; then
    echo "Ignoring invalid org.gradle.java.home from ${REPO_GRADLE_PROPS}: ${repo_java_home}" >&2
  fi
  if [[ -n "${user_java_home}" && ! -x "${user_java_home}/bin/java" ]]; then
    echo "Ignoring invalid org.gradle.java.home from ${USER_GRADLE_PROPS}: ${user_java_home}" >&2
  fi
  if [[ -n "${JAVA_HOME:-}" && ! -x "${JAVA_HOME}/bin/java" ]]; then
    echo "Ignoring invalid JAVA_HOME: ${JAVA_HOME}" >&2
  fi

  return 1
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
  echo "Preparing desktop launch classpath..."
  (
    cd "${REPO_ROOT}"
    ./gradlew :MainApp:writeDesktopLaunchClasspath
  )
fi

if [[ ! -f "${DESKTOP_CLASSPATH_PATH}" ]]; then
  echo "Desktop launch classpath not found: ${DESKTOP_CLASSPATH_PATH}" >&2
  echo "Run ./gradlew :MainApp:writeDesktopLaunchClasspath first." >&2
  exit 1
fi

if [[ ! -f "${ICON_SOURCE_PATH}" ]]; then
  echo "Android launcher icon not found: ${ICON_SOURCE_PATH}" >&2
  exit 1
fi

LAUNCH_JAVA_HOME="$(cd "$(dirname "${LAUNCH_JAVA_HOME}")" && pwd)/$(basename "${LAUNCH_JAVA_HOME}")"
DESKTOP_CLASSPATH_PATH="$(cd "$(dirname "${DESKTOP_CLASSPATH_PATH}")" && pwd)/$(basename "${DESKTOP_CLASSPATH_PATH}")"

mkdir -p "${BIN_DIR}" "${APPLICATIONS_DIR}" "${CONFIG_HOME}" "${ICON_DIR}"
cp "${ICON_SOURCE_PATH}" "${ICON_INSTALL_PATH}"

cat > "${WRAPPER_PATH}" <<EOF
#!/usr/bin/env bash
set -euo pipefail

DESKTOP_CLASSPATH_PATH="${DESKTOP_CLASSPATH_PATH}"
MAIN_CLASS_NAME="${MAIN_CLASS_NAME}"
JAVA_HOME_VALUE="${LAUNCH_JAVA_HOME}"
ICON_PATH="${ICON_INSTALL_PATH}"
BACKEND_HOST_DEFAULT="${DEFAULT_BACKEND_HOST}"
LOG_DIR="\${XDG_CACHE_HOME:-\${HOME}/.cache}/${APP_ID}"
LOG_FILE="\${LOG_DIR}/launcher.log"

mkdir -p "\${LOG_DIR}"
exec >>"\${LOG_FILE}" 2>&1

echo "[\$(date '+%Y-%m-%d %H:%M:%S')] Launching ${APP_NAME} \$*"

if [[ ! -f "\${DESKTOP_CLASSPATH_PATH}" ]]; then
  echo "Desktop launch classpath not found: \${DESKTOP_CLASSPATH_PATH}" >&2
  echo "Rebuild with ./gradlew :MainApp:writeDesktopLaunchClasspath and rerun the launcher installer." >&2
  exit 1
fi

if [[ ! -x "\${JAVA_HOME_VALUE}/bin/java" ]]; then
  echo "JavaFX-enabled java not found: \${JAVA_HOME_VALUE}/bin/java" >&2
  exit 1
fi

DESKTOP_CLASSPATH="\$(<"\${DESKTOP_CLASSPATH_PATH}")"
if [[ -z "\${DESKTOP_CLASSPATH}" ]]; then
  echo "Desktop launch classpath is empty: \${DESKTOP_CLASSPATH_PATH}" >&2
  exit 1
fi

export JAVA_HOME="\${JAVA_HOME_VALUE}"
export VACUUM_SUPERVISOR_DESKTOP_ICON_PATH="\${ICON_PATH}"
if [[ -z "\${VACUUM_SUPERVISOR_BACKEND_HOST:-}" ]]; then
  export VACUUM_SUPERVISOR_BACKEND_HOST="\${BACKEND_HOST_DEFAULT}"
fi

JAVA_ARGS=()
if [[ -n "\${JAVA_OPTS:-}" ]]; then
  # shellcheck disable=SC2206
  JAVA_ARGS+=( \${JAVA_OPTS} )
fi
JAVA_ARGS+=( "-Dvacuum.supervisor.backend.host=\${VACUUM_SUPERVISOR_BACKEND_HOST}" )
JAVA_ARGS+=( "-Dvacuum.supervisor.desktop.icon=\${ICON_PATH}" )

echo "Using backend host: \${VACUUM_SUPERVISOR_BACKEND_HOST}"

exec "\${JAVA_HOME_VALUE}/bin/java" "\${JAVA_ARGS[@]}" -cp "\${DESKTOP_CLASSPATH}" "\${MAIN_CLASS_NAME}" "\$@"
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
StartupWMClass=com.gluonapplication.Main
Categories=Utility;
MimeType=x-scheme-handler/${URI_SCHEME};
EOF

rm -f "${LEGACY_DESKTOP_FILE_PATH}"

if command -v update-desktop-database >/dev/null 2>&1; then
  update-desktop-database "${APPLICATIONS_DIR}" >/dev/null 2>&1 || true
fi

if command -v xdg-mime >/dev/null 2>&1; then
  xdg-mime default "$(basename "${DESKTOP_FILE_PATH}")" "x-scheme-handler/${URI_SCHEME}" || true
fi

echo "Installed launcher: ${WRAPPER_PATH}"
echo "Installed desktop entry: ${DESKTOP_FILE_PATH}"
echo "Removed legacy desktop entry: ${LEGACY_DESKTOP_FILE_PATH}"
echo "Installed icon: ${ICON_INSTALL_PATH}"
echo "Using Java home: ${LAUNCH_JAVA_HOME}"
echo "Default backend host: ${DEFAULT_BACKEND_HOST}"
echo "Registered URI scheme: ${URI_SCHEME}"
echo "Example link: ${URI_SCHEME}://open?view=CB"
