# VACUUM Supervisor Client

VACUUM Supervisor is a Java client application used by operators to monitor and control distributed vacuum subsystems (tube sectors, towers, cryogenic links, remote pumps, gauges, and supervisor actions).

## Project Scope

This repository contains the supervisor client app, including:

- UI views and layers for station/subsystem dashboards (`View*`, `Layer*`, `SidePopupView*`)
- UI graphics/layout authored with Gluon Scene Builder and FXML resources (`MainApp/src/main/resources/*.fxml`)
- interaction and control logic (`Controller*`)
- data models and mappings for telemetry, flags, and commands (`DataSet*`, `DataElement`, `DataTypes`, `ControlCommand`)
- packaging/build configuration for desktop and mobile deployment

Out of scope for this repository:

- backend services and control-system servers
- site-specific online data infrastructure

## Technology

- Gluon platform and libraries (Charm / Glisten / Charm Down):  
  https://gluonhq.com/  
  https://gluonhq.com/products/mobile/
- JavaFXPorts mobile Gradle plugin (`org.javafxports:jfxmobile-plugin`):  
  https://github.com/javafxports/javafxmobile-plugin

## Build Examples

```bash
./gradlew :MainApp:run
./gradlew :MainApp:android
```

## Windows Installer

Preferred release path on Windows:

```powershell
powershell -ExecutionPolicy Bypass -File .\scripts\build_windows_setup.ps1 -JavaHome C:\path\to\jdk
```

If Inno Setup 6 is installed, this produces `build\windows-installer\output\VacuumSupervisorSetup-<version>.exe`.

The Linux helper `./scripts/build_windows_setup.sh` is an NSIS-based cross-build path. It requires an external Windows JavaFX JDK zip via `--jdk-zip` and a working local NSIS toolchain. Do not treat the checked-in `Windows_Install\VacuumSupervisorSetup-*.exe` as the authoritative release artifact; rebuild locally before shipping.


## Local Backend Override

For local testing against an internal backend host without changing the public-safe default:

```bash
VACUUM_SUPERVISOR_BACKEND_HOST=<internal-backend-host> ./gradlew :MainApp:run
```

The desktop client also accepts the JVM property `vacuum.supervisor.backend.host` when launched outside Gradle.
You can provide either a bare host such as `olserver135.virgo.infn.it` or a full URL; the client will extract the host and rebuild the service-specific endpoint paths.

To verify that no internal hostnames were accidentally committed:

```bash
./scripts/check_no_internal_hosts.sh
```

## Client Illustrations

### CB
![CB](https://raw.githubusercontent.com/danielsentenac/vacuum_supervisor/master/docs/img/CB.png)

### CRYO
![CRYO](https://raw.githubusercontent.com/danielsentenac/vacuum_supervisor/master/docs/img/CRYO.png)

### Global
![Global](https://raw.githubusercontent.com/danielsentenac/vacuum_supervisor/master/docs/img/Global.png)

### TOWER
![TOWER](https://raw.githubusercontent.com/danielsentenac/vacuum_supervisor/master/docs/img/TOWER.png)
