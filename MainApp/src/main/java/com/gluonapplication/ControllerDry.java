package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ControllerDry implements ControlTypes {

    @FXML
    private Label DryName;

    @FXML
    private Label Status;

    @FXML
    private Label ON;

    @FXML
    private Label OFF;

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
       if (name.equals("LINKPR")){
          name = name.replace("PR","");
          DryName.setText("PR" + DryName.getText());
       }
       else if (name.equals("LINKSR")) {
          name = name.replace("SR","");
          DryName.setText("SR" + DryName.getText());
       }
       else if (name.equals("CRYOLINKDET")) {
          name = name.replace("DET","");
          DryName.setText("DET" + DryName.getText());
       }
       else if (name.equals("CRYOLINKIB")) {
          name = name.replace("IB","");
          DryName.setText("IB" + DryName.getText());
       }
       System.out.println("OFF:" + name + " " + DryName.getText());
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         DRY_COMMAND_CHANNELS.get(DryName.getText()), "2", 2000, true, "Authorize", true);  // OFF
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         DRY_COMMAND_CHANNELS.get(DryName.getText()), "0", 0, false, "", false);   // RESET
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
       if (name.equals("LINKPR")){
          name = name.replace("PR","");
          DryName.setText("PR" + DryName.getText());
       }
       else if (name.equals("LINKSR")) {
          name = name.replace("SR","");
          DryName.setText("SR" + DryName.getText());
       }
       else if (name.equals("CRYOLINKDET")) {
          name = name.replace("DET","");
          DryName.setText("DET" + DryName.getText());
       }
       else if (name.equals("CRYOLINKIB")) {
          name = name.replace("IB","");
          DryName.setText("IB" + DryName.getText());
       }
       System.out.println("ON:" + name + " " + DryName.getText());
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         DRY_COMMAND_CHANNELS.get(DryName.getText()), "1", 2000, true, "Authorize", true);  // ON
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         DRY_COMMAND_CHANNELS.get(DryName.getText()), "0", 0, false, "", false);   // RESET
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
}

