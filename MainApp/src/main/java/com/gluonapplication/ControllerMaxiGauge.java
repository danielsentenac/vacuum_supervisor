package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;


public class ControllerMaxiGauge implements ControlTypes {

    @FXML
    private Label Pressure;

    @FXML
    private Label GaugeName;

    @FXML
    private Label StatusSensor;

    @FXML
    private Label ON;

    @FXML
    private Label OFF;

    @FXML
    private Label StatusPressure;

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
       if (name.contains("LAL")) {
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            GAUGE_LAL_COMMAND_CHANNELS.get(GaugeName.getText()), "2", 5000, true, "Authorize", true); // ON
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            GAUGE_LAL_COMMAND_CHANNELS.get(GaugeName.getText()), "0", 0, false, "", false);  // RESET
       }
       else if (name.contains("SQZ") ||
                name.contains("TILTMETER")) {
          // Special case GMid
          if (GaugeName.getText().equals("GMid")) {
	     master.setCommand("ModbusVac", "SETREGISTER", "VAC_SQZ100N", 
                            GAUGE_SQZ_COMMAND_CHANNELS.get(GaugeName.getText()), "2", 5000, true, "Authorize", true); // OFF
             master.setCommand("ModbusVac", "SETREGISTER", "VAC_SQZ100N", 
                            GAUGE_SQZ_COMMAND_CHANNELS.get(GaugeName.getText()), "0", 0, false, "", false);  // RESET
          }
          else {
             master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            GAUGE_SQZ_COMMAND_CHANNELS.get(GaugeName.getText()), "2", 5000, true, "Authorize", true); // OFF
             master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            GAUGE_SQZ_COMMAND_CHANNELS.get(GaugeName.getText()), "0", 0, false, "", false);  // RESET
          }
       }
       else if (name.equals("LINKPR")) {
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name.replace("PR",""), 
                         GAUGE_LINKPR_COMMAND_CHANNELS.get(GaugeName.getText()), "2", 5000, true, "Authorize", true); // OFF
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name.replace("PR",""), 
                         GAUGE_LINKPR_COMMAND_CHANNELS.get(GaugeName.getText()), "0", 0, false, "", false);  // RESET
       }
       else if (name.equals("LINKSR")) {
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name.replace("SR",""), 
                         GAUGE_LINKSR_COMMAND_CHANNELS.get(GaugeName.getText()), "2", 5000, true, "Authorize", true); // OFF
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name.replace("SR",""), 
                         GAUGE_LINKSR_COMMAND_CHANNELS.get(GaugeName.getText()), "0", 0, false, "", false);  // RESET
       }
       else if (name.equals("CRYOLINKDET")) {
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name.replace("DET",""), 
                         GAUGE_CRYOLINKDET_COMMAND_CHANNELS.get(GaugeName.getText()), "2", 5000, true, "Authorize", true); // OFF
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name.replace("DET",""), 
                         GAUGE_CRYOLINKDET_COMMAND_CHANNELS.get(GaugeName.getText()), "0", 0, false, "", false);  // RESET
       }
       else if (name.equals("CRYOLINKIB")) {
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name.replace("IB",""), 
                         GAUGE_CRYOLINKIB_COMMAND_CHANNELS.get(GaugeName.getText()), "2", 5000, true, "Authorize", true); // OFF
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name.replace("IB",""), 
                         GAUGE_CRYOLINKIB_COMMAND_CHANNELS.get(GaugeName.getText()), "0", 0, false, "", false);  // RESET
       }
       else if ((name.contains("TOWERIB") || name.contains("TOWERDET")) && GaugeName.getText().equals("G51") ) { // G51 for TOWER BENCH case
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         GAUGE_COMMAND_CHANNELS.get("G51B"), "2", 5000, true, "Authorize", true); // OFF
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         GAUGE_COMMAND_CHANNELS.get("G51B"), "0", 0, false, "", false);  // RESET
       }
       else if ((name.contains("CRYON") || name.contains("CRYOW")) && (GaugeName.getText().equals("G21") || GaugeName.getText().equals("G22")) ) { // G21/G22 for big CRYO cases
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         GAUGE_COMMAND_CHANNELS.get("CRYO_" + GaugeName.getText()), "2", 5000, true, "Authorize", true); // OFF
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         GAUGE_COMMAND_CHANNELS.get("CRYO_" + GaugeName.getText()), "0", 0, false, "", false);  // RESET
       }
       else {
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         GAUGE_COMMAND_CHANNELS.get(GaugeName.getText()), "2", 5000, true, "Authorize", true); // OFF
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         GAUGE_COMMAND_CHANNELS.get(GaugeName.getText()), "0", 0, false, "", false);  // RESET
       }
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
       if (name.contains("LAL")) {
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            GAUGE_LAL_COMMAND_CHANNELS.get(GaugeName.getText()), "1", 5000, true, "Authorize", true); // ON
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            GAUGE_LAL_COMMAND_CHANNELS.get(GaugeName.getText()), "0", 0, false, "", false);  // RESET
       }
       else if (name.contains("SQZ") || name.contains("TILTMETER")) {
          // Special case GMid
          if (GaugeName.getText().equals("GMid")) {
	     master.setCommand("ModbusVac", "SETREGISTER", "VAC_SQZ100N", 
                            GAUGE_SQZ_COMMAND_CHANNELS.get(GaugeName.getText()), "1", 5000, true, "Authorize", true); // ON
             master.setCommand("ModbusVac", "SETREGISTER", "VAC_SQZ100N", 
                            GAUGE_SQZ_COMMAND_CHANNELS.get(GaugeName.getText()), "0", 0, false, "", false);  // RESET
          }
          else {
             master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            GAUGE_SQZ_COMMAND_CHANNELS.get(GaugeName.getText()), "1", 5000, true, "Authorize", true); // ON
             master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            GAUGE_SQZ_COMMAND_CHANNELS.get(GaugeName.getText()), "0", 0, false, "", false);  // RESET
          }
       }
       else if (name.equals("LINKPR")) {
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name.replace("PR",""), 
                         GAUGE_LINKPR_COMMAND_CHANNELS.get(GaugeName.getText()), "1", 5000, true, "Authorize", true); // ON
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name.replace("PR",""), 
                         GAUGE_LINKPR_COMMAND_CHANNELS.get(GaugeName.getText()), "0", 0, false, "", false);  // RESET
       }
       else if (name.equals("LINKSR")) {
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name.replace("SR",""), 
                         GAUGE_LINKSR_COMMAND_CHANNELS.get(GaugeName.getText()), "1", 5000, true, "Authorize", true); // ON
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name.replace("SR",""), 
                         GAUGE_LINKSR_COMMAND_CHANNELS.get(GaugeName.getText()), "0", 0, false, "", false);  // RESET
       }
       else if (name.equals("CRYOLINKDET")) {
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name.replace("DET",""), 
                         GAUGE_CRYOLINKDET_COMMAND_CHANNELS.get(GaugeName.getText()), "1", 5000, true, "Authorize", true); // ON
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name.replace("DET",""), 
                         GAUGE_CRYOLINKDET_COMMAND_CHANNELS.get(GaugeName.getText()), "0", 0, false, "", false);  // RESET
       }
       else if (name.equals("CRYOLINKIB")) {
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name.replace("IB",""), 
                         GAUGE_CRYOLINKIB_COMMAND_CHANNELS.get(GaugeName.getText()), "1", 5000, true, "Authorize", true); // ON
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name.replace("IB",""), 
                         GAUGE_CRYOLINKIB_COMMAND_CHANNELS.get(GaugeName.getText()), "0", 0, false, "", false);  // RESET
       }
       else if ((name.contains("TOWERIB") || name.contains("TOWERDET")) && GaugeName.getText().equals("G51") ) { // G51 for TOWER BENCH case
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         GAUGE_COMMAND_CHANNELS.get("G51B"), "1", 5000, true, "Authorize", true); // ON
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         GAUGE_COMMAND_CHANNELS.get("G51B"), "0", 0, false, "", false);  // RESET
       }
       else if ((name.contains("CRYON") || name.contains("CRYOW")) && (GaugeName.getText().equals("G21") || GaugeName.getText().equals("G22")) ) { // G21/G22 for big CRYO cases
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         GAUGE_COMMAND_CHANNELS.get("CRYO_" + GaugeName.getText()), "1", 5000, true, "Authorize", true); // OFF
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         GAUGE_COMMAND_CHANNELS.get("CRYO_" + GaugeName.getText()), "0", 0, false, "", false);  // RESET
       }
       else {
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            GAUGE_COMMAND_CHANNELS.get(GaugeName.getText()), "1", 5000, true, "Authorize", true); // ON
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                            GAUGE_COMMAND_CHANNELS.get(GaugeName.getText()), "0", 0, false, "", false);  // RESET
       } 
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
    void Pressure_Clicked(MouseEvent event) {

    }

    @FXML
    void Pressure_Pressed(MouseEvent event) {

    }

    @FXML
    void Pressure_Released(MouseEvent event) {

    }
}

