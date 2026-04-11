package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ControllerTubeSqzActions implements ControlTypes {

    @FXML
    private Label ViewName;

    @FXML
    private Label FanOnOff;

    @FXML
    private Label FanSpeed;
    

    private String style = "";

    String name = "";

    private ControlCommand master = ControlCommand.getInstance();

    @FXML
    public void initialize() {
       ViewData presentView = (ViewData) MobileApplication.getInstance().getView();
       name = presentView.name.replace("Actions","");
    }

    @FXML
    void FanOnOff_Clicked(MouseEvent event) {
       if ( FanOnOff.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            TUBESQZACTIONS_COMMAND_CHANNELS.get("FanOnOff"), "1", 2000, true, "Authorize", true);  // ON
       else if ( FanOnOff.getText().equals("ON") )
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            TUBESQZACTIONS_COMMAND_CHANNELS.get("FanOnOff"), "2", 2000, true, "Authorize", true);  // OFF
    }

    @FXML
    void FanOnOff_Pressed(MouseEvent event) {
       style = FanOnOff.getStyle();
       FanOnOff.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void FanOnOff_Released(MouseEvent event) {
       FanOnOff.setStyle(style);
    }

    @FXML
    void FanSpeed_Clicked(MouseEvent event) {
       if ( FanSpeed.getText().equals("NORMAL") )
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                      TUBESQZACTIONS_COMMAND_CHANNELS.get("FanSpeed"), "2", 2000, true, "Authorize", true);  // LOW
       else if ( FanSpeed.getText().equals("LOW") )
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                      TUBESQZACTIONS_COMMAND_CHANNELS.get("FanSpeed"), "1", 2000, true, "Authorize", true);  // NORMAL
    }

    @FXML
    void FanSpeed_Pressed(MouseEvent event) {
       style = FanSpeed.getStyle();
       FanSpeed.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void FanSpeed_Released(MouseEvent event) {
       FanSpeed.setStyle(style);
    }
}

