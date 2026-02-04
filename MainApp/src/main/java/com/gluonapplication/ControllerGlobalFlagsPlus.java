package com.gluonapplication;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import javafx.scene.shape.Circle;

public class ControllerGlobalFlagsPlus implements ControlTypes {

    @FXML
    private Label ViewName;

    @FXML
    private Label Pressure600N;

    @FXML
    private Label Pressure1200N;

    @FXML
    private Label Pressure1800N;

    @FXML
    private Label Pressure2400N;

    @FXML
    private Label Pressure3000N;

    @FXML
    private Label PressureNE;

    @FXML
    private Label ViewName111;

    @FXML
    private Label Pressure1200W;

    @FXML
    private Label Pressure1800W;

    @FXML
    private Label Pressure2400W;

    @FXML
    private Label Pressure600W;

    @FXML
    private Label Pressure3000W;

    @FXML
    private Label PressureWE;

    @FXML
    private Label ViewName1111;

    @FXML
    private Label PressureBACKG5;

    @FXML
    private Label PressureMC;

    @FXML
    private Label PressureSQB1;

    @FXML
    private Label PressureBS;

    @FXML
    private Label ViewName11111;

    @FXML
    private Label PressureFCLINE;

    @FXML
    private Label TemperatureCryoNI;

    @FXML
    private Label TemperatureCryoWI;

    @FXML
    private Label TemperatureCryoNE;

    @FXML
    private Label TemperatureCryoWE;

    @FXML
    private Label ViewName1112;

    @FXML
    private Circle StatusSensor600N;

    @FXML
    private Circle StatusSensor1200N;

    @FXML
    private Circle StatusSensor1800N;

    @FXML
    private Circle StatusSensor2400N;

    @FXML
    private Circle StatusSensor3000N;

    @FXML
    private Circle StatusSensorNE;

    @FXML
    private Circle StatusSensor600W;

    @FXML
    private Circle StatusSensor1200W;

    @FXML
    private Circle StatusSensor1800W;

    @FXML
    private Circle StatusSensor2400W;

    @FXML
    private Circle StatusSensor3000W;

    @FXML
    private Circle StatusSensorWE;

    @FXML
    private Circle StatusSensorBS;

    @FXML
    private Circle StatusSensorBACKG5;

    @FXML
    private Circle StatusSensorMC;

    @FXML
    private Circle StatusSensorSQB1;

    @FXML
    private Circle StatusSensorFCLINE;

    @FXML
    private Label ResetNI;

    @FXML
    private Label ResetWI;

    @FXML
    private Label ResetNE;

    @FXML
    private Label ResetWE;
    
    String style = "";

    private ControlCommand master = ControlCommand.getInstance();

    @FXML
    void ResetNE_Clicked(MouseEvent event) {
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_VALVEBIGNE", "_RESETARD", "1", 500, true, "Authorize", true); // RESET
    }

    @FXML
    void ResetNE_Pressed(MouseEvent event) {
       style = ResetNE.getStyle();
       ResetNE.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void ResetNE_Released(MouseEvent event) {
       ResetNE.setStyle(style);
    }

    @FXML
    void ResetNI_Clicked(MouseEvent event) {
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_VALVEBIGNI", "_RESETARD", "1", 500, true, "Authorize", true); // RESET
    }

    @FXML
    void ResetNI_Pressed(MouseEvent event) {
       style = ResetNI.getStyle();
       ResetNI.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void ResetNI_Released(MouseEvent event) {
       ResetNI.setStyle(style);
    }

    @FXML
    void ResetWE_Clicked(MouseEvent event) {
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_VALVEBIGWE", "_RESETARD", "1", 500, true, "Authorize", true); // RESET
    }

    @FXML
    void ResetWE_Pressed(MouseEvent event) {
       style = ResetWE.getStyle();
       ResetWE.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void ResetWE_Released(MouseEvent event) {
       ResetWE.setStyle(style);
    }

    @FXML
    void ResetWI_Clicked(MouseEvent event) {
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_VALVEBIGWI", "_RESETARD", "1", 500, true, "Authorize", true); // RESET
    }

    @FXML
    void ResetWI_Pressed(MouseEvent event) {
       style = ResetWI.getStyle();
       ResetWI.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void ResetWI_Released(MouseEvent event) {
       ResetWI.setStyle(style);
    }

}

