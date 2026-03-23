#ifndef AppVersion
  #define AppVersion "0.0.0"
#endif

#ifndef StageDir
  #define StageDir AddBackslash(SourcePath) + "..\..\build\windows-installer\stage"
#endif

#ifndef OutputDir
  #define OutputDir AddBackslash(SourcePath) + "..\..\build\windows-installer\output"
#endif

#define MyAppId "{{2ECF476D-5FE6-4E7C-9D62-2A12BFCB3E31}"
#define MyAppName "Vacuum Supervisor"
#define MyAppPublisher "Vacuum Supervisor"
#define MyAppExeName "vacuum-supervisor.vbs"
#define MyAppProtocol "vacuum-supervisor"

[Setup]
AppId={#MyAppId}
AppName={#MyAppName}
AppVersion={#AppVersion}
AppPublisher={#MyAppPublisher}
DefaultDirName={localappdata}\VacuumSupervisor
DefaultGroupName={#MyAppName}
DisableProgramGroupPage=yes
PrivilegesRequired=lowest
OutputDir={#OutputDir}
OutputBaseFilename=VacuumSupervisorSetup-{#AppVersion}
SetupIconFile={#StageDir}\vacuum-supervisor-shortcut.ico
UninstallDisplayIcon={app}\vacuum-supervisor-shortcut.ico
Compression=lzma2/ultra64
SolidCompression=yes
WizardStyle=modern

[Tasks]
Name: "desktopicon"; Description: "Create a desktop shortcut"; Flags: unchecked

[Files]
Source: "{#StageDir}\app\*"; DestDir: "{app}\app"; Flags: ignoreversion recursesubdirs createallsubdirs
Source: "{#StageDir}\runtime\*"; DestDir: "{app}\runtime"; Flags: ignoreversion recursesubdirs createallsubdirs
Source: "{#StageDir}\vacuum-supervisor.cmd"; DestDir: "{app}"; Flags: ignoreversion
Source: "{#StageDir}\vacuum-supervisor.vbs"; DestDir: "{app}"; Flags: ignoreversion
Source: "{#StageDir}\vacuum-supervisor.png"; DestDir: "{app}"; Flags: ignoreversion
Source: "{#StageDir}\vacuum-supervisor-shortcut.ico"; DestDir: "{app}"; Flags: ignoreversion

[Icons]
Name: "{userprograms}\{#MyAppName}"; Filename: "{sys}\wscript.exe"; Parameters: """{app}\{#MyAppExeName}"""; WorkingDir: "{app}"; IconFilename: "{app}\vacuum-supervisor-shortcut.ico"
Name: "{userdesktop}\{#MyAppName}"; Filename: "{sys}\wscript.exe"; Parameters: """{app}\{#MyAppExeName}"""; WorkingDir: "{app}"; IconFilename: "{app}\vacuum-supervisor-shortcut.ico"; Tasks: desktopicon

[Registry]
Root: HKCU; Subkey: "Software\Classes\{#MyAppProtocol}"; ValueType: string; ValueName: ""; ValueData: "URL:{#MyAppName} Protocol"; Flags: uninsdeletekey
Root: HKCU; Subkey: "Software\Classes\{#MyAppProtocol}"; ValueType: string; ValueName: "URL Protocol"; ValueData: ""
Root: HKCU; Subkey: "Software\Classes\{#MyAppProtocol}\DefaultIcon"; ValueType: string; ValueName: ""; ValueData: "{app}\vacuum-supervisor-shortcut.ico,0"; Flags: uninsdeletekey
Root: HKCU; Subkey: "Software\Classes\{#MyAppProtocol}\shell\open\command"; ValueType: string; ValueName: ""; ValueData: """{sys}\wscript.exe"" ""{app}\{#MyAppExeName}"" ""%1"""; Flags: uninsdeletekey
