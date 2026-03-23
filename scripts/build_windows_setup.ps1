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
$IosIconSetDir = Join-Path $RepoRoot 'MainApp\src\ios\assets\Assets.xcassets\AppIcon.appiconset'
$IosIconPngSource = Join-Path $RepoRoot 'MainApp\src\ios\assets\Assets.xcassets\AppIcon.appiconset\Gluon-app-store-icon-1024@1x.png'
$AndroidIconPngSource = Join-Path $RepoRoot 'MainApp\src\android\res\mipmap-xxxhdpi\ic_launcher.png'
$StageDir = Join-Path $StageRoot 'stage'
$OutputDir = Join-Path $StageRoot 'output'
$AppStageDir = Join-Path $StageDir 'app'
$RuntimeStageDir = Join-Path $StageDir 'runtime'
$IconPngStagePath = Join-Path $StageDir 'vacuum-supervisor.png'
$IconIcoStagePath = Join-Path $StageDir 'vacuum-supervisor-shortcut.ico'
$WrapperStagePath = Join-Path $StageDir 'vacuum-supervisor.cmd'
$WrapperVbsStagePath = Join-Path $StageDir 'vacuum-supervisor.vbs'
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

function Resolve-RuntimeHome {
    param(
        [string]$JavaHomePath
    )

    $EmbeddedJrePath = Join-Path $JavaHomePath 'jre'
    $EmbeddedJreJava = Join-Path $EmbeddedJrePath 'bin\java.exe'
    if (Test-Path -LiteralPath $EmbeddedJreJava) {
        return (Resolve-Path -LiteralPath $EmbeddedJrePath).Path
    }

    return $JavaHomePath
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

function Resolve-IconPngSource {
    $Candidates = @(
        $IosIconPngSource,
        $AndroidIconPngSource
    )

    foreach ($Candidate in $Candidates) {
        if (Test-Path -LiteralPath $Candidate) {
            return (Resolve-Path -LiteralPath $Candidate).Path
        }
    }

    throw 'A source PNG icon was not found for the Windows installer.'
}

function Write-PortableIcon {
    param(
        [string]$FallbackPngPath,
        [string]$IcoPath
    )

    Add-Type -AssemblyName System.Drawing
    $Stream = New-Object System.IO.MemoryStream
    $Writer = New-Object System.IO.BinaryWriter($Stream)
    $Sizes = @(16, 20, 24, 32, 40, 48, 64, 96, 128, 256)
    $SizeSpecificSources = @{
        16  = Join-Path $IosIconSetDir 'Gluon-ipad-notifications-icon-20@1x.png'
        20  = Join-Path $IosIconSetDir 'Gluon-ipad-notifications-icon-20@1x.png'
        24  = Join-Path $IosIconSetDir 'Gluon-ipad-settings-icon-29@1x.png'
        32  = Join-Path $IosIconSetDir 'Gluon-ipad-spotlight-icon-40@1x.png'
        40  = Join-Path $IosIconSetDir 'Gluon-ipad-spotlight-icon-40@1x.png'
        48  = Join-Path $IosIconSetDir 'Gluon-ipad-settings-icon-29@2x.png'
        64  = Join-Path $IosIconSetDir 'Gluon-ipad-app-icon-76@1x.png'
        96  = Join-Path $IosIconSetDir 'Gluon-iphone-app-icon-60@2x.png'
        128 = Join-Path $IosIconSetDir 'Gluon-ipad-app-icon-76@2x.png'
        256 = Join-Path $IosIconSetDir 'Gluon-app-store-icon-1024@1x.png'
    }
    $Entries = @()

    try {
        $Writer.Write([UInt16]0)
        $Writer.Write([UInt16]1)
        $Writer.Write([UInt16]$Sizes.Count)

        foreach ($Size in $Sizes) {
            $SourcePath = $FallbackPngPath
            if ($SizeSpecificSources.ContainsKey($Size) -and (Test-Path -LiteralPath $SizeSpecificSources[$Size])) {
                $SourcePath = $SizeSpecificSources[$Size]
            }

            $Bitmap = New-Object System.Drawing.Bitmap($SourcePath)
            $SizedBitmap = New-Object System.Drawing.Bitmap($Size, $Size, [System.Drawing.Imaging.PixelFormat]::Format32bppArgb)
            $Graphics = [System.Drawing.Graphics]::FromImage($SizedBitmap)
            $PngStream = New-Object System.IO.MemoryStream

            try {
                $Graphics.Clear([System.Drawing.Color]::Transparent)
                $Graphics.InterpolationMode = [System.Drawing.Drawing2D.InterpolationMode]::HighQualityBicubic
                $Graphics.PixelOffsetMode = [System.Drawing.Drawing2D.PixelOffsetMode]::HighQuality
                $Graphics.SmoothingMode = [System.Drawing.Drawing2D.SmoothingMode]::HighQuality
                $Graphics.CompositingQuality = [System.Drawing.Drawing2D.CompositingQuality]::HighQuality
                $Graphics.DrawImage($Bitmap, 0, 0, $Size, $Size)
                $SizedBitmap.Save($PngStream, [System.Drawing.Imaging.ImageFormat]::Png)
                $Entries += [PSCustomObject]@{
                    Size  = $Size
                    Bytes = $PngStream.ToArray()
                }
            }
            finally {
                $Bitmap.Dispose()
                $PngStream.Dispose()
                $Graphics.Dispose()
                $SizedBitmap.Dispose()
            }
        }

        $Offset = 6 + (16 * $Entries.Count)
        foreach ($Entry in $Entries) {
            $Dimension = if ($Entry.Size -ge 256) { [byte]0 } else { [byte]$Entry.Size }

            $Writer.Write([byte]$Dimension)
            $Writer.Write([byte]$Dimension)
            $Writer.Write([byte]0)
            $Writer.Write([byte]0)
            $Writer.Write([UInt16]1)
            $Writer.Write([UInt16]32)
            $Writer.Write([UInt32]$Entry.Bytes.Length)
            $Writer.Write([UInt32]$Offset)
            $Offset += $Entry.Bytes.Length
        }

        foreach ($Entry in $Entries) {
            $Writer.Write($Entry.Bytes)
        }

        [System.IO.File]::WriteAllBytes($IcoPath, $Stream.ToArray())
    }
    finally {
        $Writer.Dispose()
        $Stream.Dispose()
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
$ResolvedRuntimeHome = Resolve-RuntimeHome -JavaHomePath $ResolvedJavaHome
$AppVersion = Get-AppVersion
$IconPngSource = Resolve-IconPngSource
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
Get-ChildItem -LiteralPath $ResolvedRuntimeHome -Force | Copy-Item -Destination $RuntimeStageDir -Recurse -Force
Copy-Item -LiteralPath $IconPngSource -Destination $IconPngStagePath -Force
Write-PortableIcon -FallbackPngPath $IconPngStagePath -IcoPath $IconIcoStagePath

# The app no longer uses JavaFX WebView, Media, or SWT integration.
$UnusedRuntimeFiles = @(
    (Join-Path $RuntimeStageDir 'bin\jfxwebkit.dll'),
    (Join-Path $RuntimeStageDir 'bin\jfxmedia.dll'),
    (Join-Path $RuntimeStageDir 'bin\gstreamer-lite.dll'),
    (Join-Path $RuntimeStageDir 'bin\fxplugins.dll'),
    (Join-Path $RuntimeStageDir 'lib\jfxswt.jar')
)
foreach ($UnusedRuntimeFile in $UnusedRuntimeFiles) {
    if (Test-Path -LiteralPath $UnusedRuntimeFile) {
        Remove-Item -LiteralPath $UnusedRuntimeFile -Force
    }
}

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

$WrapperVbsContent = @"
Set shell = CreateObject("WScript.Shell")
Set fso = CreateObject("Scripting.FileSystemObject")

scriptDir = fso.GetParentFolderName(WScript.ScriptFullName)
cmdPath = scriptDir & "\vacuum-supervisor.cmd"
command = "cmd.exe /c " & QuoteArg(cmdPath)

For i = 0 To WScript.Arguments.Count - 1
  command = command & " " & QuoteArg(WScript.Arguments(i))
Next

shell.Run command, 0, False

Function QuoteArg(value)
  QuoteArg = """" & Replace(value, """", """""") & """"
End Function
"@
[System.IO.File]::WriteAllText($WrapperVbsStagePath, $WrapperVbsContent, [System.Text.Encoding]::ASCII)

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
