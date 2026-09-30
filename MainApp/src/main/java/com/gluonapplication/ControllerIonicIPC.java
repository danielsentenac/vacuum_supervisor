package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

// Agilent IPCMini popup (SCADARPI racks). Modes (control, protect, voltage) are read only:
// the rack Modbus slave only accepts writes on triggers and READ_AND_WRITE_VALUE registers.
public class ControllerIonicIPC implements ControlTypes {

    @FXML
    private Label IonicName;

    @FXML
    private Label Status;

    @FXML
    private Label ON;

    @FXML
    private Label OFF;

    @FXML
    private Label StatusComm;

    @FXML
    private Label StatusError;

    @FXML
    private Label RemoteMode;

    @FXML
    private Label ProtectMode;

    @FXML
    private Label VoltageMode;

    @FXML
    private Label Pressure;

    @FXML
    private Label AbsorbedCurrent;

    @FXML
    private Label AbsorbedVoltage;

    @FXML
    private Label ProtectCurrent;

    @FXML
    private Label TargetVoltage;

    @FXML
    private Label MaxPower;

    @FXML
    private Label SetPoint;

    @FXML
    private Label TempPower;

    @FXML
    private Label TempController;

    @FXML
    private Label PumpType;


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
       master.setCommand(RPITUBE_COMMAND_SERVER, "SETREGISTER", "VAC_" + name,
                         IONIC_IPC_COMMAND_CHANNELS.get(IonicName.getText()), "2", 2000, true, "Authorize", true);  // OFF
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
       master.setCommand(RPITUBE_COMMAND_SERVER, "SETREGISTER", "VAC_" + name,
                         IONIC_IPC_COMMAND_CHANNELS.get(IonicName.getText()), "1", 2000, true, "Authorize", true);  // ON
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
    void ProtectCurrent_Clicked(MouseEvent event) {
       master.setCommand(RPITUBE_COMMAND_SERVER, "SETREGISTER", "VAC_" + name,
                         IONIC_IPC_COMMAND_CHANNELS.get(IonicName.getText() + "ProtectCurrent"), "", 2000, true, "Authorize", true);  // SET VALUE (TO BE ASKED)
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
    void TargetVoltage_Clicked(MouseEvent event) {
       master.setCommand(RPITUBE_COMMAND_SERVER, "SETREGISTER", "VAC_" + name,
                         IONIC_IPC_COMMAND_CHANNELS.get(IonicName.getText() + "TargetVoltage"), "", 2000, true, "Authorize", true);  // SET VALUE (TO BE ASKED)
    }

    @FXML
    void TargetVoltage_Pressed(MouseEvent event) {
       style = TargetVoltage.getStyle();
       TargetVoltage.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void TargetVoltage_Released(MouseEvent event) {
	TargetVoltage.setStyle(style);
    }

    @FXML
    void MaxPower_Clicked(MouseEvent event) {
       master.setCommand(RPITUBE_COMMAND_SERVER, "SETREGISTER", "VAC_" + name,
                         IONIC_IPC_COMMAND_CHANNELS.get(IonicName.getText() + "MaxPower"), "", 2000, true, "Authorize", true);  // SET VALUE (TO BE ASKED)
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

}
