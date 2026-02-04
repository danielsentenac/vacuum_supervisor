package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;

public class ControllerXGSGauge implements ControlTypes {

    @FXML
    private Label Pressure;

    @FXML
    private Label GaugeName;

    @FXML
    private Label StatusSensor;

    @FXML
    private Label StatusFilament;

    @FXML
    private Label StatusDegas;

    @FXML
    private Label FIL1ON;

    @FXML
    private Label FIL1OFF;

    @FXML
    private Label FIL2ON;

    @FXML
    private Label FIL2OFF;

    @FXML
    private Label DEGASON;

    @FXML
    private Label DEGASOFF;

    String style = "";

    String name = "";

    private ControlCommand master = ControlCommand.getInstance();

    @FXML
    public void initialize() {
       ViewData presentView = (ViewData) MobileApplication.getInstance().getView();
       name = presentView.name;
    }

    @FXML
    void DEGASOFF_Clicked(MouseEvent event) {
       if (!name.contains("LAL")) {
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            GAUGE_COMMAND_CHANNELS.get(GaugeName.getText() + "Degas"), "2", 5000, true, "Authorize", true); // OFF
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            GAUGE_COMMAND_CHANNELS.get(GaugeName.getText() + "Degas"), "0", 0, false, "", false);  // RESET
       }
       else {
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            GAUGE_LAL_COMMAND_CHANNELS.get(GaugeName.getText() + "Degas"), "2", 5000, true, "Authorize", true); // OFF
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            GAUGE_LAL_COMMAND_CHANNELS.get(GaugeName.getText() + "Degas"), "0", 0, false, "", false);  // RESET
       }
    }

    @FXML
    void DEGASOFF_Pressed(MouseEvent event) {
       style = DEGASOFF.getStyle();
       DEGASOFF.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void DEGASOFF_Released(MouseEvent event) {
      DEGASOFF.setStyle(style);
    }

    @FXML
    void DEGASON_Clicked(MouseEvent event) {
       if (!name.contains("LAL")) {
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            GAUGE_COMMAND_CHANNELS.get(GaugeName.getText() + "Degas"), "1", 5000, true, "Authorize", true); // ON
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            GAUGE_COMMAND_CHANNELS.get(GaugeName.getText() + "Degas"), "0", 0, false, "", false);  // RESET
       }
       else {
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            GAUGE_LAL_COMMAND_CHANNELS.get(GaugeName.getText() + "Degas"), "1", 5000, true, "Authorize", true); // ON
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            GAUGE_LAL_COMMAND_CHANNELS.get(GaugeName.getText() + "Degas"), "0", 0, false, "", false);  // RESET
       }
    }

    @FXML
    void DEGASON_Pressed(MouseEvent event) {
       style = DEGASON.getStyle();
       DEGASON.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void DEGASON_Released(MouseEvent event) {
      DEGASON.setStyle(style);
    }

    @FXML
    void FIL1OFF_Clicked(MouseEvent event) {
       if (!name.contains("LAL")) {
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            GAUGE_COMMAND_CHANNELS.get(GaugeName.getText() + "Fil1"), "2", 5000, true, "Authorize", true); // OFF
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            GAUGE_COMMAND_CHANNELS.get(GaugeName.getText() + "Fil1"), "0", 0, false, "", false);  // RESET
       }
       else {
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            GAUGE_LAL_COMMAND_CHANNELS.get(GaugeName.getText() + "Fil1"), "3", 5000, true, "Authorize", true); // OFF
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            GAUGE_LAL_COMMAND_CHANNELS.get(GaugeName.getText() + "Fil1"), "0", 0, false, "", false);  // RESET
       }
    }

    @FXML
    void FIL1OFF_Pressed(MouseEvent event) {
       style = FIL1OFF.getStyle();
       FIL1OFF.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void FIL1OFF_Released(MouseEvent event) {
      FIL1OFF.setStyle(style);
    }

    @FXML
    void FIL1ON_Clicked(MouseEvent event) {
       if (!name.contains("LAL")) {
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            GAUGE_COMMAND_CHANNELS.get(GaugeName.getText() + "Fil1"), "1", 5000, true, "Authorize", true); // ON
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            GAUGE_COMMAND_CHANNELS.get(GaugeName.getText() + "Fil1"), "0", 0, false, "", false);  // RESET
       }
       else {
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            GAUGE_LAL_COMMAND_CHANNELS.get(GaugeName.getText() + "Fil1"), "1", 5000, true, "Authorize", true); // ON
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            GAUGE_LAL_COMMAND_CHANNELS.get(GaugeName.getText() + "Fil1"), "0", 0, false, "", false);  // RESET
       }
    }

    @FXML
    void FIL1ON_Pressed(MouseEvent event) {
       style = FIL1ON.getStyle();
       FIL1ON.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void FIL1ON_Released(MouseEvent event) {
      FIL1ON.setStyle(style);
    }

    @FXML
    void FIL2OFF_Clicked(MouseEvent event) {
       if (!name.contains("LAL")) {
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            GAUGE_COMMAND_CHANNELS.get(GaugeName.getText() + "Fil2"), "2", 5000, true, "Authorize", true); // OFF
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            GAUGE_COMMAND_CHANNELS.get(GaugeName.getText() + "Fil2"), "0", 0, false, "", false);  // RESET
       }
       else {
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            GAUGE_LAL_COMMAND_CHANNELS.get(GaugeName.getText() + "Fil2"), "3", 5000, true, "Authorize", true); // OFF
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            GAUGE_LAL_COMMAND_CHANNELS.get(GaugeName.getText() + "Fil2"), "0", 0, false, "", false);  // RESET
       }
    }

    @FXML
    void FIL2OFF_Pressed(MouseEvent event) {
       style = FIL2OFF.getStyle();
       FIL2OFF.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void FIL2OFF_Released(MouseEvent event) {
      FIL2OFF.setStyle(style);
    }

    @FXML
    void FIL2ON_Clicked(MouseEvent event) {
       if (!name.contains("LAL")) {
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            GAUGE_COMMAND_CHANNELS.get(GaugeName.getText() + "Fil2"), "1", 5000, true, "Authorize", true); // ON
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            GAUGE_COMMAND_CHANNELS.get(GaugeName.getText() + "Fil2"), "0", 0, false, "", false);  // RESET
       }
       else {
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            GAUGE_LAL_COMMAND_CHANNELS.get(GaugeName.getText() + "Fil2"), "2", 5000, true, "Authorize", true); // ON
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            GAUGE_LAL_COMMAND_CHANNELS.get(GaugeName.getText() + "Fil2"), "0", 0, false, "", false);  // RESET
       }
    }

    @FXML
    void FIL2ON_Pressed(MouseEvent event) {
       style = FIL2ON.getStyle();
       FIL2ON.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void FIL2ON_Released(MouseEvent event) {
       FIL2ON.setStyle(style);
    }

    @FXML
    void Pressure_Clicked(MouseEvent event) {

    }

    @FXML
    void Pressure_Pressed(MouseEvent event) {

    }

    @FXML
    void Pressure_Released(MouseEvent event) {

    }
}

