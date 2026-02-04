package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.collections.ObservableList;
import com.gluonhq.charm.glisten.layout.Layer;
import com.gluonhq.charm.glisten.mvc.View;
import java.util.Vector;
import com.gluonhq.charm.glisten.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

public class ControllerIonic implements ControlTypes {

    @FXML
    private Label IonicName;

    @FXML
    private Label Status;

    @FXML
    private Label ON;

    @FXML
    private Label OFF;

    @FXML
    private Label ProtectCurrent;

    @FXML
    private Label SecondStepVoltage;

    @FXML
    private Label FirstStepCurrent;

    @FXML
    private Label SecondStepCurrent;

    @FXML
    private Label AbsorbedCurrent;

    @FXML
    private Label AbsorbedVoltage;

    @FXML
    private Label MaxVoltage;

    @FXML
    private Label FirstStepVoltage;

    @FXML
    private Label MaxCurrent;

    @FXML
    private Label MaxPower;

    @FXML
    private Label Pressure;

    @FXML
    private Label StatusComm;

    @FXML
    private Label OperatingMode;

    @FXML
    private Label VoltageMode;


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
                         IONIC_COMMAND_CHANNELS.get(IonicName.getText()), "2", 2000, true, "Authorize", true);  // OFF
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         IONIC_COMMAND_CHANNELS.get(IonicName.getText()), "0", 0, false, "", false);   // RESET
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
                         IONIC_COMMAND_CHANNELS.get(IonicName.getText()), "1", 2000, true, "Authorize", true);  // ON
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         IONIC_COMMAND_CHANNELS.get(IonicName.getText()), "0", 0, false, "", false);   // RESET
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
    void OperatingMode_Clicked(MouseEvent event) {
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         IONIC_COMMAND_CHANNELS.get(IonicName.getText() + "OperatingMode"), "", 2000, true, "Authorize", true);  // SET VALUE (TO BE ASKED)
    }

    @FXML
    void OperatingMode_Pressed(MouseEvent event) {
       style = OperatingMode.getStyle();
       OperatingMode.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void OperatingMode_Released(MouseEvent event) {
	OperatingMode.setStyle(style);
    }

    @FXML
    void VoltageMode_Clicked(MouseEvent event) {
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         IONIC_COMMAND_CHANNELS.get(IonicName.getText() + "VoltageMode"), "", 2000, true, "Authorize", true);  // SET VALUE (TO BE ASKED)
    }

    @FXML
    void VoltageMode_Pressed(MouseEvent event) {
       style = VoltageMode.getStyle();
       VoltageMode.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void VoltageMode_Released(MouseEvent event) {
	VoltageMode.setStyle(style);
    }

    @FXML
    void FirstStepCurrent_Clicked(MouseEvent event) {
       String status = master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         IONIC_COMMAND_CHANNELS.get(IonicName.getText() + "FirstStepCurrent"), "", 2000, true, "Authorize", true);  // SET VALUE (TO BE ASKED)
       if (status != null)
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         IONIC_COMMAND_CHANNELS.get(IonicName.getText() + "Param"), "64", 7000, false, "", false);  // VALIDATE PARAM
    }

    @FXML
    void FirstStepCurrent_Pressed(MouseEvent event) {
       style = FirstStepCurrent.getStyle();
       FirstStepCurrent.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void FirstStepCurrent_Released(MouseEvent event) {
	FirstStepCurrent.setStyle(style);
    }

    @FXML
    void FirstStepVoltage_Clicked(MouseEvent event) {
       String status = master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         IONIC_COMMAND_CHANNELS.get(IonicName.getText() + "FirstStepVoltage"), "", 2000, true, "Authorize", true);  // SET VALUE (TO BE ASKED)
       if (status != null)
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         IONIC_COMMAND_CHANNELS.get(IonicName.getText() + "Param"), "16", 7000, false, "", false);  // VALIDATE PARAM
    }

    @FXML
    void FirstStepVoltage_Pressed(MouseEvent event) {
       style = FirstStepVoltage.getStyle();
       FirstStepVoltage.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void FirstStepVoltage_Released(MouseEvent event) {
	FirstStepVoltage.setStyle(style);
    }

    @FXML
    void MaxCurrent_Clicked(MouseEvent event) {
       String status = master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         IONIC_COMMAND_CHANNELS.get(IonicName.getText() + "MaxCurrent"), "", 2000, true, "Authorize", true);  // SET VALUE (TO BE ASKED)
       if (status != null)
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         IONIC_COMMAND_CHANNELS.get(IonicName.getText() + "Param"), "2", 7000, false, "", false);  // VALIDATE PARAM
    }

    @FXML
    void MaxCurrent_Pressed(MouseEvent event) {
       style = MaxCurrent.getStyle();
       MaxCurrent.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void MaxCurrent_Released(MouseEvent event) {
	MaxCurrent.setStyle(style);
    }

    @FXML
    void MaxPower_Clicked(MouseEvent event) {
       String status = master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         IONIC_COMMAND_CHANNELS.get(IonicName.getText() + "MaxPower"), "", 2000, true, "Authorize", true);  // SET VALUE (TO BE ASKED)
       if (status != null)
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         IONIC_COMMAND_CHANNELS.get(IonicName.getText() + "Param"), "8", 7000, false, "", false);  // VALIDATE PARAM
    }

    @FXML
    void MaxPower_Pressed(MouseEvent event) {
       style = MaxPower.getStyle();
       MaxPower.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void MaxPower_Released(MouseEvent event) {
	MaxPower.setStyle(style);
    }

    @FXML
    void MaxVoltage_Clicked(MouseEvent event) {
       String status = master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         IONIC_COMMAND_CHANNELS.get(IonicName.getText() + "MaxVoltage"), "", 2000, true, "Authorize", true);  // SET VALUE (TO BE ASKED)
       if (status != null)
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         IONIC_COMMAND_CHANNELS.get(IonicName.getText() + "Param"), "4", 7000, false, "", false);  // VALIDATE PARAM
    }

    @FXML
    void MaxVoltage_Pressed(MouseEvent event) {
       style = MaxVoltage.getStyle();
       MaxVoltage.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void MaxVoltage_Released(MouseEvent event) {
	MaxVoltage.setStyle(style);
    }

    @FXML
    void ProtectCurrent_Clicked(MouseEvent event) {
       String status = master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         IONIC_COMMAND_CHANNELS.get(IonicName.getText() + "ProtectCurrent"), "", 2000, true, "Authorize", true);  // SET VALUE (TO BE ASKED)
       if (status != null)
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         IONIC_COMMAND_CHANNELS.get(IonicName.getText() + "Param"), "1", 7000, false, "", false);  // VALIDATE PARAM
    }

    @FXML
    void ProtectCurrent_Pressed(MouseEvent event) {
       style = ProtectCurrent.getStyle();
       ProtectCurrent.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void ProtectCurrent_Released(MouseEvent event) {
	ProtectCurrent.setStyle(style);
    }

    @FXML
    void SecondStepCurrent_Clicked(MouseEvent event) {
       String status = master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         IONIC_COMMAND_CHANNELS.get(IonicName.getText() + "SecondStepCurrent"), "", 2000, true, "Authorize", true);  // SET VALUE (TO BE ASKED)
       if (status != null)
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         IONIC_COMMAND_CHANNELS.get(IonicName.getText() + "Param"), "128", 7000, false, "", false);  // VALIDATE PARAM
    }

    @FXML
    void SecondStepCurrent_Pressed(MouseEvent event) {
       style = SecondStepCurrent.getStyle();
       SecondStepCurrent.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void SecondStepCurrent_Released(MouseEvent event) {
	SecondStepCurrent.setStyle(style);
    }

    @FXML
    void SecondStepVoltage_Clicked(MouseEvent event) {
       String status = master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         IONIC_COMMAND_CHANNELS.get(IonicName.getText() + "SecondStepVoltage"), "", 2000, true, "Authorize", true);  // SET VALUE (TO BE ASKED)
       if (status != null)
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         IONIC_COMMAND_CHANNELS.get(IonicName.getText() + "Param"), "32", 7000, false, "", false);  // VALIDATE PARAM
    }

    @FXML
    void SecondStepVoltage_Pressed(MouseEvent event) {
       style = SecondStepVoltage.getStyle();
       SecondStepVoltage.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void SecondStepVoltage_Released(MouseEvent event) {
	SecondStepVoltage.setStyle(style);
    }
    
}

