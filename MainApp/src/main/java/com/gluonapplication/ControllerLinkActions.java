package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.input.MouseEvent;

public class ControllerLinkActions implements ControlTypes {

    @FXML
    private Label ViewName;

    @FXML
    private Label FanOnOff;

    @FXML
    private Label FanSpeed;

    @FXML
    private Label ByPassRemote;
    

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
       if (name.contains("PR")) {
          if ( FanOnOff.getText().equals("OFF") )
             master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name.replace("PR",""), 
                            LINKACTIONS_COMMAND_CHANNELS.get("FanOnOff"), "1", 2000, true, "Authorize", true);  // ON
          else if ( FanOnOff.getText().equals("ON") )
             master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name.replace("PR",""), 
                            LINKACTIONS_COMMAND_CHANNELS.get("FanOnOff"), "2", 2000, true, "Authorize", true);  // OFF
       }
       else if (name.contains("SR")) {
          if ( FanOnOff.getText().equals("OFF") )
             master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name.replace("SR",""), 
                            LINKACTIONS_COMMAND_CHANNELS.get("FanOnOff"), "1", 2000, true, "Authorize", true);  // ON
          else if ( FanOnOff.getText().equals("ON") )
             master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name.replace("SR",""), 
                            LINKACTIONS_COMMAND_CHANNELS.get("FanOnOff"), "2", 2000, true, "Authorize", true);  // OFF
       }
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
       if (name.contains("PR")) {
          if ( FanSpeed.getText().equals("NORMAL") )
             master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name.replace("SR",""), 
                         LINKACTIONS_COMMAND_CHANNELS.get("FanSpeed"), "2", 2000, true, "Authorize", true);  // LOW
          else if ( FanSpeed.getText().equals("LOW") )
             master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name.replace("SR",""), 
                         LINKACTIONS_COMMAND_CHANNELS.get("FanSpeed"), "1", 2000, true, "Authorize", true);  // NORMAL
       }
       else if (name.contains("SR")) {
          if ( FanSpeed.getText().equals("NORMAL") )
             master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name.replace("SR",""), 
                         LINKACTIONS_COMMAND_CHANNELS.get("FanSpeed"), "2", 2000, true, "Authorize", true);  // LOW
          else if ( FanSpeed.getText().equals("LOW") )
             master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name.replace("SR",""), 
                         LINKACTIONS_COMMAND_CHANNELS.get("FanSpeed"), "1", 2000, true, "Authorize", true);  // NORMAL
       }
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

    @FXML
    void ByPassRemote_Clicked(MouseEvent event) {
       if (name.contains("PR")) {
          if ( ByPassRemote.getText().equals("OFF") )
             master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name.replace("PR",""), 
                               LINKACTIONS_COMMAND_CHANNELS.get("ByPassRemotePR"), "1", 2000, true, "Authorize", true);  // ON
          else if ( ByPassRemote.getText().equals("ON") )
             master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name.replace("PR",""), 
                               LINKACTIONS_COMMAND_CHANNELS.get("ByPassRemotePR"), "2", 2000, true, "Authorize", true);  // OFF
       }
       else if (name.contains("SR")) {
          if ( ByPassRemote.getText().equals("OFF") )
             master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name.replace("SR",""), 
                               LINKACTIONS_COMMAND_CHANNELS.get("ByPassRemoteSR"), "1", 2000, true, "Authorize", true);  // ON
          else if ( ByPassRemote.getText().equals("ON") )
             master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name.replace("SR",""), 
                               LINKACTIONS_COMMAND_CHANNELS.get("ByPassRemoteSR"), "2", 2000, true, "Authorize", true);  // OFF
       }
    }

    @FXML
    void ByPassRemote_Pressed(MouseEvent event) {
       style = ByPassRemote.getStyle();
       ByPassRemote.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void ByPassRemote_Released(MouseEvent event) {
       ByPassRemote.setStyle(style);
    }

   
}

