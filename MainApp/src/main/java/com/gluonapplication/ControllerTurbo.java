package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ControllerTurbo implements ControlTypes {

    @FXML
    private Label TurboName;

    @FXML
    private Label Status;

    @FXML
    private Label ON;

    @FXML
    private Label OFF;

    @FXML
    private Label STYON;

    @FXML
    private Label STYOFF;

    @FXML
    private Label StatusStandby;

    @FXML
    private Label StatusTemp;

    @FXML
    private Label StatusTempBox;

    @FXML
    private Label StatusBox;

    @FXML
    private Label ActSpeed;

    @FXML
    private Label FinalSpeed;

    @FXML
    private Label OperatingTime;

    @FXML
    private Label ActPower;

    String style = "";

    String name = "";
    
    String MyTurboName = "";

    private ControlCommand master = ControlCommand.getInstance();

    @FXML
    public void initialize() {
       ViewData presentView = (ViewData) MobileApplication.getInstance().getView();
       name = presentView.name;
    }

    @FXML
    void OFF_Clicked(MouseEvent event) {
       System.out.println("OFF_Clicked name = " + name);
       MyTurboName =  TurboName.getText();
       if (name.equals("LINKPR")){
          name = name.replace("PR","");
          MyTurboName = "PR" + TurboName.getText();
       }
       else if (name.equals("LINKSR")) {
          name = name.replace("SR","");
          MyTurboName = "SR" + TurboName.getText();
       }
       else if (name.equals("CRYOLINKDET")) {
          name = name.replace("DET","");
          MyTurboName = "DET" + TurboName.getText();
       }
       else if (name.equals("CRYOLINKIB")) {
          name = name.replace("IB","");
          MyTurboName = "IB" + TurboName.getText();
       }
       
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         TURBO_COMMAND_CHANNELS.get(MyTurboName), "2", 2000, true, "Authorize", true);  // OFF
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         TURBO_COMMAND_CHANNELS.get(MyTurboName), "0", 0, false, "", false);   // RESET
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
       MyTurboName =  TurboName.getText();
       if (name.equals("LINKPR")){
          name = name.replace("PR","");
          MyTurboName = "PR" + TurboName.getText();
       }
       else if (name.equals("LINKSR")) {
          name = name.replace("SR","");
          MyTurboName = "SR" + TurboName.getText();
       }
       else if (name.equals("CRYOLINKDET")) {
          name = name.replace("DET","");
          MyTurboName = "DET" + TurboName.getText();
       }
       else if (name.equals("CRYOLINKIB")) {
          name = name.replace("IB","");
          MyTurboName = "IB" + TurboName.getText();
       }
       
       System.out.println(TURBO_COMMAND_CHANNELS.get(MyTurboName));
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         TURBO_COMMAND_CHANNELS.get(MyTurboName), "1", 2000, true, "Authorize", true);  // ON
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         TURBO_COMMAND_CHANNELS.get(MyTurboName), "0", 0, false, "", false);   // RESET
      
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
       MyTurboName =  TurboName.getText();
       if (name.equals("LINKPR")){
          name = name.replace("PR","");
          MyTurboName = "PR" + TurboName.getText();
       }
       else if (name.equals("LINKSR")) {
          name = name.replace("SR","");
          MyTurboName = "SR" + TurboName.getText();
       }
       else if (name.equals("CRYOLINKDET")) {
          name = name.replace("DET","");
          MyTurboName = "DET" + TurboName.getText();
       }
       else if (name.equals("CRYOLINKIB")) {
          name = name.replace("IB","");
          MyTurboName = "IB" + TurboName.getText();
       }
       
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         TURBO_COMMAND_CHANNELS.get(MyTurboName + "Sty"), "2", 2000, true, "Authorize", true);  // OFF
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         TURBO_COMMAND_CHANNELS.get(MyTurboName + "Sty"), "0", 0, false, "", false);   // RESET
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
       MyTurboName =  TurboName.getText();
       if (name.equals("LINKPR")){
          name = name.replace("PR","");
          MyTurboName = "PR" + TurboName.getText();
       }
       else if (name.equals("LINKSR")) {
          name = name.replace("SR","");
          MyTurboName = "SR" + TurboName.getText();
       }
       else if (name.equals("CRYOLINKDET")) {
          name = name.replace("DET","");
          MyTurboName = "DET" + TurboName.getText();
       }
       else if (name.equals("CRYOLINKIB")) {
          name = name.replace("IB","");
          MyTurboName = "IB" + TurboName.getText();
       }
       
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         TURBO_COMMAND_CHANNELS.get(MyTurboName + "Sty"), "1", 2000, true, "Authorize", true);  // ON
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         TURBO_COMMAND_CHANNELS.get(MyTurboName + "Sty"), "0", 0, false, "", false);   // RESET
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

