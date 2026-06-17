package com.gluonapplication;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * Controller for the Particle Counters side popup (PCOUNTER.fxml).
 *
 * Handles the Central Building clean-room air-conditioning noise commands.
 * The command is written to the CB particle-counter station (Modbus slave)
 * register VAC_PCOUNTERCB_M3_ACCMD: 1 = OFF, 2 = LOW NOISE, 3 = HIGH NOISE.
 * As with the other trigger commands (see ControllerDry) the value is pulsed
 * and then reset to 0. The current mode is published on VAC_PCOUNTERCB_M3_ACST
 * and shown live in the CBACStatus label by the DataSet update loop.
 */
public class ControllerParticleCounter implements ControlTypes {

    private static final String AC_SERVER  = "ModbusVac";
    private static final String AC_STATION = "VAC_PCOUNTERCB";
    private static final String AC_CHANNEL = "_M3_ACCMD";
    private static final String AC_LOW_NOISE  = "2";
    private static final String AC_HIGH_NOISE = "3";

    @FXML
    private Label ACLowNoise;

    @FXML
    private Label ACHighNoise;

    private String style = "";

    private void sendAcCommand(String value) {
       ControlCommand master = ControlCommand.getInstance();
       master.setCommand(AC_SERVER, "SETREGISTER", AC_STATION, AC_CHANNEL, value, 2000, true, "Authorize", true);
       master.setCommand(AC_SERVER, "SETREGISTER", AC_STATION, AC_CHANNEL, "0", 0, false, "", false);   // reset trigger
    }

    @FXML
    void ACLow_Clicked(MouseEvent event) {
       sendAcCommand(AC_LOW_NOISE);
    }

    @FXML
    void ACLow_Pressed(MouseEvent event) {
       style = ACLowNoise.getStyle();
       ACLowNoise.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void ACLow_Released(MouseEvent event) {
       ACLowNoise.setStyle(style);
    }

    @FXML
    void ACHigh_Clicked(MouseEvent event) {
       sendAcCommand(AC_HIGH_NOISE);
    }

    @FXML
    void ACHigh_Pressed(MouseEvent event) {
       style = ACHighNoise.getStyle();
       ACHighNoise.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void ACHigh_Released(MouseEvent event) {
       ACHighNoise.setStyle(style);
    }
}
