#!/usr/bin/env bash
set -euo pipefail

REPO_ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
DEFAULT_TARGET_ROOT="$REPO_ROOT/MainApp/src/main/java"
EXAMPLE_HOST="${EXAMPLE_HOST:-online-data-provider.example}"
DRY_RUN="${DRY_RUN:-0}"
STATE_DIR="$REPO_ROOT/.sanitize_state"
BACKUP_DIR="$STATE_DIR/backup"
MANIFEST_FILE="$STATE_DIR/manifest.txt"

die() {
  printf 'error: %s\n' "$*" >&2
  exit 1
}

usage() {
  cat <<EOF
Usage:
  $(basename "$0") [apply] [target_path]
  $(basename "$0") restore
  $(basename "$0") status

Environment:
  EXAMPLE_HOST=online-data-provider.example  Replacement hostname for apply mode
  DRY_RUN=1                                  Preview files without modifying

Description:
  apply   Replace olserver134/135 hostnames with EXAMPLE_HOST and create restorable backups.
          This is the default mode if no command is provided.
  restore Restore original files from .sanitize_state backups.
  status  Show whether sanitize backup state is currently active.
EOF
}

find_matches() {
  local target_root="$1"

  if command -v rg >/dev/null 2>&1; then
    rg -l -0 'olserver13[45](\.virgo\.infn\.it)?' "$target_root" || true
  else
    # grep fallback is newline-delimited; paths in this repo do not contain newlines.
    grep -RIlE 'olserver13(4|5)(\.virgo\.infn\.it)?' "$target_root" || true
  fi
}

normalize_target_root() {
  local target_input="$1"
  local target_abs

  [[ -d "$target_input" ]] || die "target path does not exist: $target_input"
  target_abs="$(cd "$target_input" && pwd)"

  case "$target_abs" in
    "$REPO_ROOT"|"$REPO_ROOT"/*) ;;
    *) die "target path must be inside repository: $target_abs" ;;
  esac

  printf '%s\n' "$target_abs"
}

apply_sanitize() {
  local target_root="$1"
  local file rel backup_path manifest_tmp
  local changed_count=0
  local -a files=()

  [[ ! -f "$MANIFEST_FILE" ]] || die "sanitize state already exists; run '$0 restore' before applying again"

  if command -v rg >/dev/null 2>&1; then
    mapfile -d '' -t files < <(find_matches "$target_root")
  else
    mapfile -t files < <(find_matches "$target_root")
  fi

  if [[ ${#files[@]} -eq 0 ]]; then
    echo "No internal olserver addresses found under $target_root"
    return 0
  fi

  echo "Found ${#files[@]} file(s) with internal olserver addresses."

  if [[ "$DRY_RUN" == "1" ]]; then
    printf '%s\n' "${files[@]}"
    echo "Dry run only. No files changed."
    return 0
  fi

  mkdir -p "$BACKUP_DIR"
  manifest_tmp="$(mktemp)"

  for file in "${files[@]}"; do
    [[ -f "$file" ]] || continue
    rel="${file#$REPO_ROOT/}"
    backup_path="$BACKUP_DIR/$rel"
    mkdir -p "$(dirname "$backup_path")"
    cp -- "$file" "$backup_path"
    EXAMPLE_HOST="$EXAMPLE_HOST" perl -pi -e 's/olserver13[45](?:\.virgo\.infn\.it)?/$ENV{EXAMPLE_HOST}/g' "$file"
    printf '%s\n' "$rel" >> "$manifest_tmp"
    echo "Sanitized: $rel"
    changed_count=$((changed_count + 1))
  done

  if ((changed_count == 0)); then
    rm -f -- "$manifest_tmp"
    rm -rf -- "$STATE_DIR"
    echo "No files changed."
    return 0
  fi

  mv -- "$manifest_tmp" "$MANIFEST_FILE"
  echo "Sanitization complete: $changed_count file(s) updated."
  echo "Done. Replaced olserver134/135 hostnames with: $EXAMPLE_HOST"
  echo "Run '$0 restore' to restore original files."
}

restore_sanitize() {
  local rel_path restored_count=0

  [[ -f "$MANIFEST_FILE" ]] || die "no sanitize state found; nothing to restore"

  while IFS= read -r rel_path; do
    [[ -n "$rel_path" ]] || continue
    [[ -f "$BACKUP_DIR/$rel_path" ]] || die "missing backup for: $rel_path"
    cp -- "$BACKUP_DIR/$rel_path" "$REPO_ROOT/$rel_path"
    restored_count=$((restored_count + 1))
  done < "$MANIFEST_FILE"

  rm -rf -- "$STATE_DIR"
  echo "Restore complete: $restored_count file(s) restored."
}

status_sanitize() {
  if [[ -f "$MANIFEST_FILE" ]]; then
    echo "Sanitize state: ACTIVE"
    echo "Backed up files: $(wc -l < "$MANIFEST_FILE")"
    echo "Run '$0 restore' to restore original files."
  else
    echo "Sanitize state: INACTIVE"
  fi
}

main() {
  local cmd="${1:-apply}"
  local target_root

  case "$cmd" in
    apply)
      shift
      target_root="$(normalize_target_root "${1:-$DEFAULT_TARGET_ROOT}")"
      apply_sanitize "$target_root"
      ;;
    restore)
      shift
      [[ $# -eq 0 ]] || die "'restore' does not accept a target path"
      restore_sanitize
      ;;
    status)
      shift
      [[ $# -eq 0 ]] || die "'status' does not accept a target path"
      status_sanitize
      ;;
    help|-h|--help)
      usage
      ;;
    *)
      # Backward compatibility: first arg is target path in default apply mode.
      target_root="$(normalize_target_root "$cmd")"
      apply_sanitize "$target_root"
      ;;
  esac
}

main "${@:-}"
