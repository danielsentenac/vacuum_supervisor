[CmdletBinding()]
param(
    [switch]$SkipBuild,
    [string]$JavaHome,
    [string]$InstallDir = (Join-Path $env:LOCALAPPDATA 'VacuumSupervisor'),
    [switch]$NoDesktopShortcut
)

$ErrorActionPreference = 'Stop'

$ScriptDir = Split-Path -Parent $MyInvocation.MyCommand.Path
$RepoRoot = [System.IO.Path]::GetFullPath((Join-Path $ScriptDir '..'))
$AppId = 'vacuum-supervisor'
$AppName = 'Vacuum Supervisor'
$UriScheme = 'vacuum-supervisor'
$DistributionSource = Join-Path $RepoRoot 'MainApp\build\install\MainApp'
$DistributionLauncher = Join-Path $DistributionSource 'bin\MainApp.bat'
$AppInstallDir = Join-Path $InstallDir 'app'
$WrapperPath = Join-Path $InstallDir 'vacuum-supervisor.cmd'
$IconPngSource = Join-Path $RepoRoot 'MainApp\src\android\res\mipmap-xxxhdpi\ic_launcher.png'
$IconPngPath = Join-Path $InstallDir 'vacuum-supervisor.png'
$IconIcoPath = Join-Path $InstallDir 'vacuum-supervisor.ico'
$RepoGradleProperties = Join-Path $RepoRoot 'gradle.properties'
$UserGradleProperties = Join-Path $env:USERPROFILE '.gradle\gradle.properties'
$StartMenuPrograms = [Environment]::GetFolderPath('Programs')
$DesktopDirectory = [Environment]::GetFolderPath('Desktop')
$StartMenuShortcut = Join-Path $StartMenuPrograms ($AppName + '.lnk')
$DesktopShortcut = Join-Path $DesktopDirectory ($AppName + '.lnk')
$ProtocolRoot = 'HKCU:\Software\Classes\' + $UriScheme
$ProtocolCommand = '"' + $WrapperPath + '" "%1"'

function Get-GradleProperty {
    param(
        [string]$FilePath,
        [string]$Key
    )

    if (-not (Test-Path -LiteralPath $FilePath)) {
        return $null
    }

    foreach ($Line in Get-Content -LiteralPath $FilePath) {
        if ($Line.StartsWith($Key + '=')) {
            return $Line.Substring($Key.Length + 1).Trim()
        }
    }

    return $null
}

function Resolve-JavaHome {
    $Candidates = @(
        $JavaHome,
        $env:JAVA_HOME,
        (Get-GradleProperty -FilePath $UserGradleProperties -Key 'org.gradle.java.home'),
        (Get-GradleProperty -FilePath $RepoGradleProperties -Key 'org.gradle.java.home')
    )

    foreach ($Candidate in $Candidates) {
        if ([string]::IsNullOrWhiteSpace($Candidate)) {
            continue
        }

        $JavaExe = Join-Path $Candidate 'bin\java.exe'
        if (Test-Path -LiteralPath $JavaExe) {
            return (Resolve-Path -LiteralPath $Candidate).Path
        }
    }

    throw 'A JavaFX-enabled JDK was not found. Pass -JavaHome or set JAVA_HOME to a JDK that includes java.exe and JavaFX.'
}

function Write-PortableIcon {
    param(
        [string]$PngPath,
        [string]$IcoPath
    )

    Add-Type -AssemblyName System.Drawing
    $Bitmap = New-Object System.Drawing.Bitmap($PngPath)
    $PngBytes = [System.IO.File]::ReadAllBytes($PngPath)
    $Stream = New-Object System.IO.MemoryStream
    $Writer = New-Object System.IO.BinaryWriter($Stream)

    try {
        $WidthByte = if ($Bitmap.Width -ge 256) { [byte]0 } else { [byte]$Bitmap.Width }
        $HeightByte = if ($Bitmap.Height -ge 256) { [byte]0 } else { [byte]$Bitmap.Height }

        $Writer.Write([UInt16]0)
        $Writer.Write([UInt16]1)
        $Writer.Write([UInt16]1)
        $Writer.Write([byte]$WidthByte)
        $Writer.Write([byte]$HeightByte)
        $Writer.Write([byte]0)
        $Writer.Write([byte]0)
        $Writer.Write([UInt16]1)
        $Writer.Write([UInt16]32)
        $Writer.Write([UInt32]$PngBytes.Length)
        $Writer.Write([UInt32]22)
        $Writer.Write($PngBytes)
        [System.IO.File]::WriteAllBytes($IcoPath, $Stream.ToArray())
    }
    finally {
        $Writer.Dispose()
        $Stream.Dispose()
        $Bitmap.Dispose()
    }
}

function New-WindowsShortcut {
    param(
        [string]$ShortcutPath,
        [string]$TargetPath,
        [string]$WorkingDirectory,
        [string]$IconPath
    )

    $Shell = New-Object -ComObject WScript.Shell
    $Shortcut = $Shell.CreateShortcut($ShortcutPath)
    $Shortcut.TargetPath = $TargetPath
    $Shortcut.WorkingDirectory = $WorkingDirectory
    if (Test-Path -LiteralPath $IconPath) {
        $Shortcut.IconLocation = $IconPath + ',0'
    }
    $Shortcut.Save()
}

function Register-Protocol {
    param(
        [string]$RootPath,
        [string]$CommandValue,
        [string]$IconPath
    )

    New-Item -Path $RootPath -Force | Out-Null
    New-Item -Path (Join-Path $RootPath 'DefaultIcon') -Force | Out-Null
    New-Item -Path (Join-Path $RootPath 'shell\open\command') -Force | Out-Null

    Set-Item -Path $RootPath -Value ('URL:' + $AppName + ' Protocol')
    New-ItemProperty -Path $RootPath -Name 'URL Protocol' -Value '' -PropertyType String -Force | Out-Null
    Set-Item -Path (Join-Path $RootPath 'DefaultIcon') -Value ($IconPath + ',0')
    Set-Item -Path (Join-Path $RootPath 'shell\open\command') -Value $CommandValue
}

$ResolvedJavaHome = Resolve-JavaHome
$GradleBat = Join-Path $RepoRoot 'gradlew.bat'

if (-not $SkipBuild) {
    if (-not (Test-Path -LiteralPath $GradleBat)) {
        throw 'gradlew.bat was not found in the repository root.'
    }

    Write-Host 'Building Windows distribution with Gradle...'
    $PreviousJavaHome = $env:JAVA_HOME
    try {
        $env:JAVA_HOME = $ResolvedJavaHome
        & $GradleBat ('-Dorg.gradle.java.home=' + $ResolvedJavaHome) ':MainApp:installDist'
        if ($LASTEXITCODE -ne 0) {
            throw 'Gradle installDist failed.'
        }
    }
    finally {
        $env:JAVA_HOME = $PreviousJavaHome
    }
}

if (-not (Test-Path -LiteralPath $DistributionLauncher)) {
    throw 'MainApp\build\install\MainApp\bin\MainApp.bat was not found. Run gradlew.bat :MainApp:installDist first.'
}

if (-not (Test-Path -LiteralPath $IconPngSource)) {
    throw 'Android launcher icon was not found under MainApp\src\android\res\mipmap-xxxhdpi\ic_launcher.png.'
}

New-Item -ItemType Directory -Force -Path $InstallDir | Out-Null

if (Test-Path -LiteralPath $AppInstallDir) {
    Remove-Item -LiteralPath $AppInstallDir -Recurse -Force
}

Copy-Item -LiteralPath $DistributionSource -Destination $AppInstallDir -Recurse -Force
Copy-Item -LiteralPath $IconPngSource -Destination $IconPngPath -Force
Write-PortableIcon -PngPath $IconPngPath -IcoPath $IconIcoPath

$WrapperContent = @"
@echo off
setlocal
set "APP_HOME=%~dp0"
set "JAVA_HOME=$ResolvedJavaHome"
set "VACUUM_SUPERVISOR_DESKTOP_ICON_PATH=%APP_HOME%vacuum-supervisor.png"
set "LOG_DIR=%LOCALAPPDATA%\VacuumSupervisor\logs"
if not exist "%LOG_DIR%" mkdir "%LOG_DIR%" >NUL 2>&1
echo [%date% %time%] Launching $AppName %*>> "%LOG_DIR%\launcher.log"
call "%APP_HOME%app\bin\MainApp.bat" %*
set "EXIT_CODE=%ERRORLEVEL%"
endlocal & exit /b %EXIT_CODE%
"@
[System.IO.File]::WriteAllText($WrapperPath, $WrapperContent, [System.Text.Encoding]::ASCII)

Register-Protocol -RootPath $ProtocolRoot -CommandValue $ProtocolCommand -IconPath $IconIcoPath
New-WindowsShortcut -ShortcutPath $StartMenuShortcut -TargetPath $WrapperPath -WorkingDirectory $InstallDir -IconPath $IconIcoPath

if (-not $NoDesktopShortcut) {
    New-WindowsShortcut -ShortcutPath $DesktopShortcut -TargetPath $WrapperPath -WorkingDirectory $InstallDir -IconPath $IconIcoPath
}

Write-Host "Installed wrapper: $WrapperPath"
Write-Host "Installed app payload: $AppInstallDir"
Write-Host "Installed icon: $IconIcoPath"
Write-Host "Registered protocol: $UriScheme://"
Write-Host "Start menu shortcut: $StartMenuShortcut"
if (-not $NoDesktopShortcut) {
    Write-Host "Desktop shortcut: $DesktopShortcut"
}
Write-Host "Using Java home: $ResolvedJavaHome"
