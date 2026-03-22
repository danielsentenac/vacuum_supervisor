[CmdletBinding()]
param(
    [switch]$SkipBuild,
    [string]$JavaHome,
    [string]$StageRoot = (Join-Path (Join-Path (Split-Path -Parent $MyInvocation.MyCommand.Path) '..') 'build\windows-installer'),
    [string]$IsccPath
)

$ErrorActionPreference = 'Stop'

$ScriptDir = Split-Path -Parent $MyInvocation.MyCommand.Path
$RepoRoot = [System.IO.Path]::GetFullPath((Join-Path $ScriptDir '..'))
$ManifestPath = Join-Path $RepoRoot 'MainApp\src\android\AndroidManifest.xml'
$DistributionSource = Join-Path $RepoRoot 'MainApp\build\install\MainApp'
$DistributionLauncher = Join-Path $DistributionSource 'bin\MainApp.bat'
$RepoGradleProperties = Join-Path $RepoRoot 'gradle.properties'
$UserGradleProperties = Join-Path $env:USERPROFILE '.gradle\gradle.properties'
$IconPngSource = Join-Path $RepoRoot 'MainApp\src\android\res\mipmap-xxxhdpi\ic_launcher.png'
$StageDir = Join-Path $StageRoot 'stage'
$OutputDir = Join-Path $StageRoot 'output'
$AppStageDir = Join-Path $StageDir 'app'
$RuntimeStageDir = Join-Path $StageDir 'runtime'
$IconPngStagePath = Join-Path $StageDir 'vacuum-supervisor.png'
$IconIcoStagePath = Join-Path $StageDir 'vacuum-supervisor.ico'
$WrapperStagePath = Join-Path $StageDir 'vacuum-supervisor.cmd'
$InnoScriptPath = Join-Path $ScriptDir 'windows\VacuumSupervisor.iss'

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

    throw 'A Windows JavaFX-enabled JDK was not found. Pass -JavaHome or set JAVA_HOME to a Windows JDK that contains bin\java.exe.'
}

function Get-AppVersion {
    if (-not (Test-Path -LiteralPath $ManifestPath)) {
        throw 'AndroidManifest.xml was not found.'
    }

    $ManifestText = Get-Content -LiteralPath $ManifestPath -Raw
    $Match = [regex]::Match($ManifestText, 'android:versionName="([^"]+)"')
    if (-not $Match.Success) {
        throw 'Could not read android:versionName from AndroidManifest.xml.'
    }

    return $Match.Groups[1].Value
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

function Resolve-IsccPath {
    if (-not [string]::IsNullOrWhiteSpace($IsccPath) -and (Test-Path -LiteralPath $IsccPath)) {
        return (Resolve-Path -LiteralPath $IsccPath).Path
    }

    if (-not [string]::IsNullOrWhiteSpace($env:INNO_SETUP_COMPILER) -and (Test-Path -LiteralPath $env:INNO_SETUP_COMPILER)) {
        return (Resolve-Path -LiteralPath $env:INNO_SETUP_COMPILER).Path
    }

    $Candidates = @(
        'C:\Program Files (x86)\Inno Setup 6\ISCC.exe',
        'C:\Program Files\Inno Setup 6\ISCC.exe'
    )

    foreach ($Candidate in $Candidates) {
        if (Test-Path -LiteralPath $Candidate) {
            return (Resolve-Path -LiteralPath $Candidate).Path
        }
    }

    return $null
}

$ResolvedJavaHome = Resolve-JavaHome
$AppVersion = Get-AppVersion
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

if (-not (Test-Path -LiteralPath $InnoScriptPath)) {
    throw 'Inno Setup script was not found under scripts\windows\VacuumSupervisor.iss.'
}

if (Test-Path -LiteralPath $StageDir) {
    Remove-Item -LiteralPath $StageDir -Recurse -Force
}

New-Item -ItemType Directory -Force -Path $AppStageDir | Out-Null
New-Item -ItemType Directory -Force -Path $RuntimeStageDir | Out-Null
New-Item -ItemType Directory -Force -Path $OutputDir | Out-Null

Copy-Item -LiteralPath $DistributionSource -Destination $AppStageDir -Recurse -Force
Get-ChildItem -LiteralPath $ResolvedJavaHome -Force | Copy-Item -Destination $RuntimeStageDir -Recurse -Force
Copy-Item -LiteralPath $IconPngSource -Destination $IconPngStagePath -Force
Write-PortableIcon -PngPath $IconPngStagePath -IcoPath $IconIcoStagePath

$WrapperContent = @"
@echo off
setlocal
set "APP_HOME=%~dp0"
set "JAVA_HOME=%APP_HOME%runtime"
set "VACUUM_SUPERVISOR_DESKTOP_ICON_PATH=%APP_HOME%vacuum-supervisor.png"
set "LOG_DIR=%LOCALAPPDATA%\VacuumSupervisor\logs"
if not exist "%LOG_DIR%" mkdir "%LOG_DIR%" >NUL 2>&1
echo [%date% %time%] Launching Vacuum Supervisor %*>> "%LOG_DIR%\launcher.log"
call "%APP_HOME%app\MainApp\bin\MainApp.bat" %*
set "EXIT_CODE=%ERRORLEVEL%"
endlocal & exit /b %EXIT_CODE%
"@
[System.IO.File]::WriteAllText($WrapperStagePath, $WrapperContent, [System.Text.Encoding]::ASCII)

$ResolvedIsccPath = Resolve-IsccPath
if ([string]::IsNullOrWhiteSpace($ResolvedIsccPath)) {
    Write-Host "Staging complete: $StageDir"
    Write-Host "Inno Setup compiler not found."
    Write-Host "Install Inno Setup 6 and run:"
    Write-Host ('  "' + 'C:\Program Files (x86)\Inno Setup 6\ISCC.exe' + '" ' +
        '/DAppVersion=' + $AppVersion + ' ' +
        '/DStageDir="' + $StageDir + '" ' +
        '/DOutputDir="' + $OutputDir + '" ' +
        '"' + $InnoScriptPath + '"')
    exit 0
}

Write-Host "Compiling Setup.exe with Inno Setup..."
& $ResolvedIsccPath ('/DAppVersion=' + $AppVersion) ('/DStageDir=' + $StageDir) ('/DOutputDir=' + $OutputDir) $InnoScriptPath
if ($LASTEXITCODE -ne 0) {
    throw 'Inno Setup compilation failed.'
}

Write-Host "Created Windows installer in: $OutputDir"
