package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ControllerCryoActions implements ControlTypes {

    @FXML
    private Label ViewName;

    @FXML
    private Label PIDenabled;

    @FXML
    private Label PIDrunning;

    @FXML
    private Label PSStatus;

    @FXML
    private Label CryoStatus;

    @FXML
    private Label StartStop;

    @FXML
    private Label Reset;

    @FXML
    private Label PIDdisable;

    String style = "";

    String name = "";

    private ControlCommand master = ControlCommand.getInstance();

    @FXML
    public void initialize() {
       ViewData presentView = (ViewData) MobileApplication.getInstance().getView();
       name = presentView.name.replace("Actions","");
    }

    @FXML
    void PIDdisable_Clicked(MouseEvent event) {
       if ( PIDdisable.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_LN2" + name.replace("CRYO",""), 
                         CRYOACTIONS_COMMAND_CHANNELS.get("PIDdisable"), "1", 2000, true, "Authorize", true);  // ACTIVE
       else if ( PIDdisable.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_LN2" + name.replace("CRYO",""), 
                         CRYOACTIONS_COMMAND_CHANNELS.get("PIDdisable"), "0", 2000, true, "Authorize", true);  // OFF
          
    }

    @FXML
    void PIDdisable_Pressed(MouseEvent event) {
       style = PIDdisable.getStyle();
       PIDdisable.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PIDdisable_Released(MouseEvent event) {
	PIDdisable.setStyle(style);
    }

    @FXML
    void Reset_Clicked(MouseEvent event) {
       if ( Reset.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_LN2" + name.replace("CRYO",""), 
                         CRYOACTIONS_COMMAND_CHANNELS.get("Reset"), "1", 2000, true, "Authorize", true);  // ACTIVE
       else if ( Reset.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_LN2" + name.replace("CRYO",""), 
                         CRYOACTIONS_COMMAND_CHANNELS.get("Reset"), "0", 2000, true, "Authorize", true);  // OFF
    }

    @FXML
    void Reset_Pressed(MouseEvent event) {
       style = Reset.getStyle();
       Reset.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Reset_Released(MouseEvent event) {
	Reset.setStyle(style);
    }

    @FXML
    void StartStop_Clicked(MouseEvent event) {
       if ( StartStop.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_LN2" + name.replace("CRYO",""), 
                         CRYOACTIONS_COMMAND_CHANNELS.get("StartStop"), "1", 2000, true, "Authorize", true);  // ACTIVE
       else if ( StartStop.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_LN2" + name.replace("CRYO",""), 
                         CRYOACTIONS_COMMAND_CHANNELS.get("StartStop"), "0", 2000, true, "Authorize", true);  // OFF
    }

    @FXML
    void StartStop_Pressed(MouseEvent event) {
       style = StartStop.getStyle();
       StartStop.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void StartStop_Released(MouseEvent event) {
	StartStop.setStyle(style);
    }
}

