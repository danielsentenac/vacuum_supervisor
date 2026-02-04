package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ControllerTitane implements ControlTypes {

    @FXML
    private Label TitaneName;

    @FXML
    private Label Status;

    @FXML
    private Label ON;

    @FXML
    private Label OFF;

    @FXML
    private Label StatusFilament;

    @FXML
    private Label StatusController;

    @FXML
    private Label StatusRecover;

    @FXML
    private Label OperatingMode;

    @FXML
    private Label AbsorbedCurrent;

    @FXML
    private Label AbsorbedVoltage;

    @FXML
    private Label SublimationCurrent;

    @FXML
    private Label Autostart;

    @FXML
    private Label SublimationTime;

    @FXML
    private Label SublimationPeriod;

    @FXML
    private Label FilamentUsed;

    String style = "";

    String name = "";

    private ControlCommand master = ControlCommand.getInstance();

    @FXML
    public void initialize() {
       ViewData presentView = (ViewData) MobileApplication.getInstance().getView();
       name = presentView.name;
    }


    @FXML
    void OFF_Clicked(MouseEvent event) {
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         TITANE_COMMAND_CHANNELS.get(TitaneName.getText()), "2", 2000, true, "Authorize", true);  // OFF
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         TITANE_COMMAND_CHANNELS.get(TitaneName.getText()), "0", 0, false, "", false);   // RESET
    }

    @FXML
    void OFF_Pressed(MouseEvent event) {
       style = OFF.getStyle();
       OFF.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void OFF_Released(MouseEvent event) {
	OFF.setStyle(style);
    }
   
    @FXML
    void ON_Clicked(MouseEvent event) {
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         TITANE_COMMAND_CHANNELS.get(TitaneName.getText()), "1", 2000, true, "Authorize", true);  // ON
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         TITANE_COMMAND_CHANNELS.get(TitaneName.getText()), "0", 0, false, "", false);   // RESET
    }

    @FXML
    void ON_Pressed(MouseEvent event) {
       style = ON.getStyle();
       ON.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void ON_Released(MouseEvent event) {
       ON.setStyle(style);
    }

    @FXML
    void FilamentUsed_Clicked(MouseEvent event) {
       String status = master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         TITANE_COMMAND_CHANNELS.get(TitaneName.getText() + "FilamentUsed"), "", 2000, true, "Authorize", true);  // SET VALUE (TO BE ASKED)
       if (status != null)
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         TITANE_COMMAND_CHANNELS.get(TitaneName.getText() + "Param"), "1", 7000, false, "", false);  // VALIDATE PARAM
    }

    @FXML
    void FilamentUsed_Pressed(MouseEvent event) {
       style = FilamentUsed.getStyle();
       FilamentUsed.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void FilamentUsed_Released(MouseEvent event) {
	FilamentUsed.setStyle(style);
    }

    @FXML
    void SublimationCurrent_Clicked(MouseEvent event) {
       String status = master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         TITANE_COMMAND_CHANNELS.get(TitaneName.getText() + "SublimationCurrent"), "", 2000, true, "Authorize", true);  // SET VALUE (TO BE ASKED)
       if (status != null)
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         TITANE_COMMAND_CHANNELS.get(TitaneName.getText() + "Param"), "2", 7000, false, "", false);  // VALIDATE PARAM
    }

    @FXML
    void SublimationCurrent_Pressed(MouseEvent event) {
       style = SublimationCurrent.getStyle();
       SublimationCurrent.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void SublimationCurrent_Released(MouseEvent event) {
	SublimationCurrent.setStyle(style);
    }

    @FXML
    void SublimationTime_Clicked(MouseEvent event) {
       String status = master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         TITANE_COMMAND_CHANNELS.get(TitaneName.getText() + "SublimationTime"), "", 2000, true, "Authorize", true);  // SET VALUE (TO BE ASKED)
       if (status != null)
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         TITANE_COMMAND_CHANNELS.get(TitaneName.getText() + "Param"), "4", 7000, false, "", false);  // VALIDATE PARAM
    }

    @FXML
    void SublimationTime_Pressed(MouseEvent event) {
       style = SublimationTime.getStyle();
       SublimationTime.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void SublimationTime_Released(MouseEvent event) {
	SublimationTime.setStyle(style);
    }

     @FXML
    void SublimationPeriod_Clicked(MouseEvent event) {
       String status = master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         TITANE_COMMAND_CHANNELS.get(TitaneName.getText() + "SublimationPeriod"), "", 2000, true, "Authorize", true);  // SET VALUE (TO BE ASKED)
       if (status != null)
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         TITANE_COMMAND_CHANNELS.get(TitaneName.getText() + "Param"), "8", 7000, false, "", false);  // VALIDATE PARAM
    }

    @FXML
    void SublimationPeriod_Pressed(MouseEvent event) {
       style = SublimationPeriod.getStyle();
       SublimationPeriod.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void SublimationPeriod_Released(MouseEvent event) {
	SublimationPeriod.setStyle(style);
    }

}

