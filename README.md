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
./gradlew :MainApp:runDesktop
./gradlew :MainApp:android
```

## API Documentation

- Published API reference (GitHub Pages): https://danielsentenac.github.io/vacuum_supervisor/api/index.html

## Client Illustrations

### CB
![CB](https://raw.githubusercontent.com/danielsentenac/vacuum_supervisor/master/docs/img/CB.png)

### CRYO
![CRYO](https://raw.githubusercontent.com/danielsentenac/vacuum_supervisor/master/docs/img/CRYO.png)

### Global
![Global](https://raw.githubusercontent.com/danielsentenac/vacuum_supervisor/master/docs/img/Global.png)

### TOWER
![TOWER](https://raw.githubusercontent.com/danielsentenac/vacuum_supervisor/master/docs/img/TOWER.png)
