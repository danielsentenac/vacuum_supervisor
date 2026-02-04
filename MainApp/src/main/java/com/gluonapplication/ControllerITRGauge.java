package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;

public class ControllerITRGauge implements ControlTypes {

    @FXML
    private Label Pressure;

    @FXML
    private Label GaugeName;

    @FXML
    private Label StatusSensor;

    @FXML
    private Label StatusEmission;

    @FXML
    private Label StatusDegas;

    @FXML
    private Label EMULTON;

    @FXML
    private Label EMULTOFF;

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
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         GAUGE_COMMAND_CHANNELS.get(GaugeName.getText() + "Degas"), "2", 5000, true, "Authorize", true); // OFF
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         GAUGE_COMMAND_CHANNELS.get(GaugeName.getText() + "Degas"), "0", 0, false, "",  false);  // RESET
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
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         GAUGE_COMMAND_CHANNELS.get(GaugeName.getText() + "Degas"), "1", 5000, true, "Authorize", true); // OFF
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         GAUGE_COMMAND_CHANNELS.get(GaugeName.getText() + "Degas"), "0", 0, false, "", false);  // RESET
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
    void EMULTOFF_Clicked(MouseEvent event) {
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         GAUGE_COMMAND_CHANNELS.get(GaugeName.getText() + "Emult"), "2", 5000, true, "Authorize", true); // OFF
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         GAUGE_COMMAND_CHANNELS.get(GaugeName.getText() + "Emult"), "0", 0, false, "", false);  // RESET
    }

    @FXML
    void EMULTOFF_Pressed(MouseEvent event) {
       style = EMULTOFF.getStyle();
       EMULTOFF.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void EMULTOFF_Released(MouseEvent event) {
      EMULTOFF.setStyle(style);
    }

    @FXML
    void EMULTON_Clicked(MouseEvent event) {
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         GAUGE_COMMAND_CHANNELS.get(GaugeName.getText() + "Emult"), "1", 5000, true, "Authorize", true); // OFF
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         GAUGE_COMMAND_CHANNELS.get(GaugeName.getText() + "Emult"), "0", 0, false, "", false);  // RESET
    }

    @FXML
    void EMULTON_Pressed(MouseEvent event) {
       style = EMULTON.getStyle();
       EMULTON.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void EMULTON_Released(MouseEvent event) {
      EMULTON.setStyle(style);
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

