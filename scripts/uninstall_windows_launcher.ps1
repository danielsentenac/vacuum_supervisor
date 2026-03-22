[CmdletBinding()]
param(
    [string]$InstallDir = (Join-Path $env:LOCALAPPDATA 'VacuumSupervisor')
)

$ErrorActionPreference = 'Stop'

$AppName = 'Vacuum Supervisor'
$UriScheme = 'vacuum-supervisor'
$ProtocolRoot = 'HKCU:\Software\Classes\' + $UriScheme
$StartMenuPrograms = [Environment]::GetFolderPath('Programs')
$DesktopDirectory = [Environment]::GetFolderPath('Desktop')
$StartMenuShortcut = Join-Path $StartMenuPrograms ($AppName + '.lnk')
$DesktopShortcut = Join-Path $DesktopDirectory ($AppName + '.lnk')

if (Test-Path -LiteralPath $ProtocolRoot) {
    Remove-Item -LiteralPath $ProtocolRoot -Recurse -Force
}

if (Test-Path -LiteralPath $StartMenuShortcut) {
    Remove-Item -LiteralPath $StartMenuShortcut -Force
}

if (Test-Path -LiteralPath $DesktopShortcut) {
    Remove-Item -LiteralPath $DesktopShortcut -Force
}

if (Test-Path -LiteralPath $InstallDir) {
    Remove-Item -LiteralPath $InstallDir -Recurse -Force
}

Write-Host "Removed protocol registration: $UriScheme://"
Write-Host "Removed shortcuts for $AppName"
Write-Host "Removed install directory: $InstallDir"
