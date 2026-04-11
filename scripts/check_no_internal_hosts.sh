#!/usr/bin/env bash
set -euo pipefail

REPO_ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
PATTERN='olserver13(4|5)(\.virgo\.infn\.it)?'

cd "$REPO_ROOT"

if git grep -nIE "$PATTERN" -- . ':(exclude)scripts/check_no_internal_hosts.sh'; then
  echo
  echo "error: internal hostnames detected in tracked files" >&2
  exit 1
fi

echo "OK: no internal hostnames found in tracked files."
