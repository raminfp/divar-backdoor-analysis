#!/usr/bin/env bash
# تشخیص وجود کد مخرب (ReportDeserializer) در یک فایل APK دیوار
# استفاده:  ./scan.sh path/to/app.apk
# نشانه قطعی آلودگی: کلاس ir.divar.chat.util.ReportDeserializer
set -euo pipefail
apk="${1:?usage: scan.sh app.apk}"
tmp="$(mktemp)"; trap 'rm -f "$tmp"' EXIT
unzip -p "$apk" 'classes*.dex' > "$tmp" 2>/dev/null

count() { grep -a -c -F "$1" "$tmp" 2>/dev/null || true; }

rd=$(count ReportDeserializer)
ob=$(count objectify)
printf '  %-22s %s\n' "ReportDeserializer" "$([ "$rd" -gt 0 ] && echo "PRESENT ($rd)" || echo absent)"
printf '  %-22s %s\n' "objectify"          "$([ "$ob" -gt 0 ] && echo "PRESENT ($ob)" || echo absent)"

if [ "$rd" -gt 0 ]; then
    echo "==> INFECTED: $apk"; exit 1
else
    echo "==> clean: $apk"; exit 0
fi
