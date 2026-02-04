package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ControllerMiniTowerSqzActions implements ControlTypes {

    @FXML
    private Label ViewName;

    @FXML
    private Label FanOnOff;

    @FXML
    private Label FanSpeed;

    @FXML
    private Label ByPassGP;

    @FXML
    private Label ByPassG22;

    @FXML
    private Label EmultOnOff;

    @FXML
    private Label StartStop;

    @FXML
    private Label Filament;
    

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
                            MINITOWERSQZACTIONS_COMMAND_CHANNELS.get("FanOnOff"), "1", 2000, true, "Authorize", true);  // ON
       else if ( FanOnOff.getText().equals("ON") )
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            MINITOWERSQZACTIONS_COMMAND_CHANNELS.get("FanOnOff"), "2", 2000, true, "Authorize", true);  // OFF
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
                         MINITOWERSQZACTIONS_COMMAND_CHANNELS.get("FanSpeed"), "2", 2000, true, "Authorize", true);  // LOW
       else if ( FanSpeed.getText().equals("LOW") )
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         MINITOWERSQZACTIONS_COMMAND_CHANNELS.get("FanSpeed"), "1", 2000, true, "Authorize", true);  // NORMAL
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
    void ByPassG22_Clicked(MouseEvent event) {
       if ( ByPassG22.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            MINITOWERSQZACTIONS_COMMAND_CHANNELS.get("ByPassG22"), "1", 2000, true, "Authorize", true);  // ON
       else if ( ByPassG22.getText().equals("ON") )
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            MINITOWERSQZACTIONS_COMMAND_CHANNELS.get("ByPassG22"), "2", 2000, true, "Authorize", true);  // OFF
    }

    @FXML
    void ByPassG22_Pressed(MouseEvent event) {
       style = ByPassG22.getStyle();
       ByPassG22.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void ByPassG22_Released(MouseEvent event) {
       ByPassG22.setStyle(style);
    }    

    @FXML
    void ByPassGP_Clicked(MouseEvent event) {
       if ( ByPassGP.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            MINITOWERSQZACTIONS_COMMAND_CHANNELS.get("ByPassGP"), "1", 2000, true, "Authorize", true);  // ON
       else if ( ByPassGP.getText().equals("ON") )
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            MINITOWERSQZACTIONS_COMMAND_CHANNELS.get("ByPassGP"), "2", 2000, true, "Authorize", true);  // OFF
    }

    @FXML
    void ByPassGP_Pressed(MouseEvent event) {
       style = ByPassGP.getStyle();
       ByPassGP.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void ByPassGP_Released(MouseEvent event) {
       ByPassGP.setStyle(style);
    }

    @FXML
    void EmultOnOff_Clicked(MouseEvent event) {
       if ( EmultOnOff.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            MINITOWERSQZACTIONS_COMMAND_CHANNELS.get("EmultOnOff"), "1", 2000, true, "Authorize", true);  // ON
       else if ( EmultOnOff.getText().equals("ON") )
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            MINITOWERSQZACTIONS_COMMAND_CHANNELS.get("EmultOnOff"), "2", 2000, true, "Authorize", true);  // OFF
    }

    @FXML
    void EmultOnOff_Pressed(MouseEvent event) {
       style = EmultOnOff.getStyle();
       EmultOnOff.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void EmultOnOff_Released(MouseEvent event) {
       EmultOnOff.setStyle(style);
    }

    @FXML
    void StartStop_Clicked(MouseEvent event) {
       if ( StartStop.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            MINITOWERSQZACTIONS_COMMAND_CHANNELS.get("StartStop"), "1", 2000, true, "Authorize", true);  // ON
       else if ( StartStop.getText().equals("ON") )
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            MINITOWERSQZACTIONS_COMMAND_CHANNELS.get("StartStop"), "2", 2000, true, "Authorize", true);  // OFF
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

    @FXML
    void Filament_Clicked(MouseEvent event) {
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                          MINITOWERSQZACTIONS_COMMAND_CHANNELS.get("Filament"), "", 2000, true, "Authorize", true);  // SET VALUE (TO BE ASKED)
    }

    @FXML
    void Filament_Pressed(MouseEvent event) {
       style = Filament.getStyle();
       Filament.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Filament_Released(MouseEvent event) {
       Filament.setStyle(style);
    }
}

