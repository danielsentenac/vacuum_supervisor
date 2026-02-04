package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ControllerTurboT implements ControlTypes {

    @FXML
    private Label TurboName;

    @FXML
    private Label Status;

    @FXML
    private Label ON;

    @FXML
    private Label OFF;

    @FXML
    private Label StatusLowSpeed;

    @FXML
    private Label StatusNormalSpeed;

    @FXML
    private Label StatusBox;

    @FXML
    private Label StatusRamp;

    @FXML
    private Label STYON;

    @FXML
    private Label STYOFF;

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
                         TURBO_COMMAND_CHANNELS.get(TurboName.getText()), "2", 2000, true, "Authorize", true);  // OFF
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         TURBO_COMMAND_CHANNELS.get(TurboName.getText()), "0", 0, false, "", false);   // RESET
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
                         TURBO_COMMAND_CHANNELS.get(TurboName.getText()), "1", 2000, true, "Authorize", true);  // ON
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         TURBO_COMMAND_CHANNELS.get(TurboName.getText()), "0", 0, false, "", false);   // RESET
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
    void STYOFF_Clicked(MouseEvent event) {
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         TURBO_COMMAND_CHANNELS.get(TurboName.getText() + "Sty"), "2", 2000, true, "Authorize", true);  // OFF
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         TURBO_COMMAND_CHANNELS.get(TurboName.getText() + "Sty"), "0", 0, false, "", false);   // RESET
    }

    @FXML
    void STYOFF_Pressed(MouseEvent event) {
       style = STYOFF.getStyle();
       STYOFF.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void STYOFF_Released(MouseEvent event) {
       STYOFF.setStyle(style);
    }

    @FXML
    void STYON_Clicked(MouseEvent event) {
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         TURBO_COMMAND_CHANNELS.get(TurboName.getText() + "Sty"), "1", 2000, true, "Authorize", true);  // ON
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         TURBO_COMMAND_CHANNELS.get(TurboName.getText() + "Sty"), "0", 0, false, "", false);   // RESET
    }

    @FXML
    void STYON_Pressed(MouseEvent event) {
       style = STYON.getStyle();
       STYON.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void STYON_Released(MouseEvent event) {
       STYON.setStyle(style);
    }
}


