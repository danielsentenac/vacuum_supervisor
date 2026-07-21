package com.gluonapplication;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ControllerBeamShutterActions implements ControlTypes {

    @FXML
    private Label ViewName;

    @FXML
    private Label NIShutterOpen;

    @FXML
    private Label NIShutterClose;

    @FXML
    private Label WIShutterOpen;

    @FXML
    private Label WIShutterClose;

    private String style = "";

    // CO2 beam shutters on the WI/NI tower viewports:
    // NI = SHUTTERBEAM1, WI = SHUTTERBEAM2; command 1 = OPEN, 2 = CLOSE.
    private static final String NI_SHUTTER_STATION = "VAC_SHUTTERBEAM1";
    private static final String WI_SHUTTER_STATION = "VAC_SHUTTERBEAM2";

    private final ControlCommand master = ControlCommand.getInstance();

    private void sendShutterCommand(String station, String value) {
       master.setCommand("ModbusVac", "SETREGISTER", station,
               BEAMSHUTTERACTIONS_COMMAND_CHANNELS.get("ShutterCmd"),
               value, 2000, true, "Authorize", true);
    }

    @FXML
    void NIShutterOpen_Clicked(MouseEvent event) {
       sendShutterCommand(NI_SHUTTER_STATION, "1");
    }

    @FXML
    void NIShutterOpen_Pressed(MouseEvent event) {
       style = NIShutterOpen.getStyle();
       NIShutterOpen.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void NIShutterOpen_Released(MouseEvent event) {
       NIShutterOpen.setStyle(style);
    }

    @FXML
    void NIShutterClose_Clicked(MouseEvent event) {
       sendShutterCommand(NI_SHUTTER_STATION, "2");
    }

    @FXML
    void NIShutterClose_Pressed(MouseEvent event) {
       style = NIShutterClose.getStyle();
       NIShutterClose.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void NIShutterClose_Released(MouseEvent event) {
       NIShutterClose.setStyle(style);
    }

    @FXML
    void WIShutterOpen_Clicked(MouseEvent event) {
       sendShutterCommand(WI_SHUTTER_STATION, "1");
    }

    @FXML
    void WIShutterOpen_Pressed(MouseEvent event) {
       style = WIShutterOpen.getStyle();
       WIShutterOpen.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void WIShutterOpen_Released(MouseEvent event) {
       WIShutterOpen.setStyle(style);
    }

    @FXML
    void WIShutterClose_Clicked(MouseEvent event) {
       sendShutterCommand(WI_SHUTTER_STATION, "2");
    }

    @FXML
    void WIShutterClose_Pressed(MouseEvent event) {
       style = WIShutterClose.getStyle();
       WIShutterClose.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void WIShutterClose_Released(MouseEvent event) {
       WIShutterClose.setStyle(style);
    }
}
