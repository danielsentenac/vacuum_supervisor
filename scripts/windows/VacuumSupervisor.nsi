Unicode true
RequestExecutionLevel user
SetCompressor /SOLID lzma

!include "MUI2.nsh"
!include "x64.nsh"

!ifndef APP_VERSION
  !define APP_VERSION "0.0.0"
!endif

!ifndef STAGE_DIR
  !error "STAGE_DIR must be defined"
!endif

!ifndef OUTPUT_DIR
  !error "OUTPUT_DIR must be defined"
!endif

!define APP_NAME "Vacuum Supervisor"
!define APP_PUBLISHER "Vacuum Supervisor"
!define APP_EXE "vacuum-supervisor.cmd"
!define APP_PROTOCOL "vacuum-supervisor"
!define START_MENU_DIR "$SMPROGRAMS\Vacuum Supervisor"
!define UNINSTALL_REG_KEY "Software\Microsoft\Windows\CurrentVersion\Uninstall\VacuumSupervisor"

Name "${APP_NAME}"
OutFile "${OUTPUT_DIR}/VacuumSupervisorSetup-${APP_VERSION}.exe"
InstallDir "$LOCALAPPDATA\VacuumSupervisor"
InstallDirRegKey HKCU "${UNINSTALL_REG_KEY}" "InstallLocation"
Icon "${STAGE_DIR}/vacuum-supervisor.ico"
UninstallIcon "${STAGE_DIR}/vacuum-supervisor.ico"
ShowInstDetails show
ShowUninstDetails show
BrandingText "Vacuum Supervisor Installer"

!insertmacro MUI_PAGE_WELCOME
!insertmacro MUI_PAGE_DIRECTORY
!insertmacro MUI_PAGE_INSTFILES
!insertmacro MUI_PAGE_FINISH

!insertmacro MUI_UNPAGE_CONFIRM
!insertmacro MUI_UNPAGE_INSTFILES

!insertmacro MUI_LANGUAGE "English"

Function .onInit
  ${IfNot} ${RunningX64}
    MessageBox MB_ICONSTOP "This installer requires 64-bit Windows."
    Abort
  ${EndIf}
FunctionEnd

Section "Install"
  SetOutPath "$INSTDIR"
  File /r "${STAGE_DIR}/app"
  File /r "${STAGE_DIR}/runtime"
  File "${STAGE_DIR}/vacuum-supervisor.cmd"
  File "${STAGE_DIR}/vacuum-supervisor.png"
  File "${STAGE_DIR}/vacuum-supervisor.ico"

  CreateDirectory "${START_MENU_DIR}"
  CreateShortcut "${START_MENU_DIR}\Vacuum Supervisor.lnk" "$INSTDIR\${APP_EXE}" "" "$INSTDIR\vacuum-supervisor.ico"
  CreateShortcut "${START_MENU_DIR}\Uninstall Vacuum Supervisor.lnk" "$INSTDIR\Uninstall.exe" "" "$INSTDIR\vacuum-supervisor.ico"
  CreateShortcut "$DESKTOP\Vacuum Supervisor.lnk" "$INSTDIR\${APP_EXE}" "" "$INSTDIR\vacuum-supervisor.ico"

  WriteRegStr HKCU "Software\Classes\${APP_PROTOCOL}" "" "URL:${APP_NAME} Protocol"
  WriteRegStr HKCU "Software\Classes\${APP_PROTOCOL}" "URL Protocol" ""
  WriteRegStr HKCU "Software\Classes\${APP_PROTOCOL}\DefaultIcon" "" "$INSTDIR\vacuum-supervisor.ico,0"
  WriteRegStr HKCU "Software\Classes\${APP_PROTOCOL}\shell\open\command" "" '"$INSTDIR\${APP_EXE}" "%1"'

  WriteRegStr HKCU "${UNINSTALL_REG_KEY}" "DisplayName" "${APP_NAME}"
  WriteRegStr HKCU "${UNINSTALL_REG_KEY}" "DisplayVersion" "${APP_VERSION}"
  WriteRegStr HKCU "${UNINSTALL_REG_KEY}" "Publisher" "${APP_PUBLISHER}"
  WriteRegStr HKCU "${UNINSTALL_REG_KEY}" "InstallLocation" "$INSTDIR"
  WriteRegStr HKCU "${UNINSTALL_REG_KEY}" "DisplayIcon" "$INSTDIR\vacuum-supervisor.ico"
  WriteRegStr HKCU "${UNINSTALL_REG_KEY}" "UninstallString" '"$INSTDIR\Uninstall.exe"'
  WriteRegDWORD HKCU "${UNINSTALL_REG_KEY}" "NoModify" 1
  WriteRegDWORD HKCU "${UNINSTALL_REG_KEY}" "NoRepair" 1

  WriteUninstaller "$INSTDIR\Uninstall.exe"
SectionEnd

Section "Uninstall"
  Delete "$DESKTOP\Vacuum Supervisor.lnk"
  Delete "${START_MENU_DIR}\Vacuum Supervisor.lnk"
  Delete "${START_MENU_DIR}\Uninstall Vacuum Supervisor.lnk"
  RMDir "${START_MENU_DIR}"

  DeleteRegKey HKCU "Software\Classes\${APP_PROTOCOL}"
  DeleteRegKey HKCU "${UNINSTALL_REG_KEY}"

  Delete "$INSTDIR\Uninstall.exe"
  RMDir /r "$INSTDIR"
SectionEnd
