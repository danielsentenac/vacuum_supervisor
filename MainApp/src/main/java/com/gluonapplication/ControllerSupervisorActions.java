package com.gluonapplication;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class ControllerSupervisorActions implements ControlTypes {

    @FXML
    private BorderPane pane;

    @FXML
    private Label ViewName;

    @FXML
    private Label SafeNorthArm;

    @FXML
    private Label SafeWestArm;

    @FXML
    private Label SafeCentral;

    @FXML
    private Label SafeNorthEnd;

    @FXML
    private Label SafeWestEnd;

    @FXML
    private Label PrimaryPumpingBS;

    @FXML
    private Label PrimaryPumpingNI;

    @FXML
    private Label PrimaryPumpingWI;

    @FXML
    private Label PrimaryPumpingNE;

    @FXML
    private Label PrimaryPumpingWE;

    @FXML
    private Label PrimaryPumpingPR;

    @FXML
    private Label PrimaryPumpingSR;

    @FXML
    private Label PrimaryPumpingDET;

    @FXML
    private Label PrimaryPumpingIB;

    @FXML
    private Label PrimaryPumpingMC;

    @FXML
    private Label RemotePumpingBS;

    @FXML
    private Label RemotePumpingNI;

    @FXML
    private Label RemotePumpingWI;

    @FXML
    private Label RemotePumpingPR;

    @FXML
    private Label RemotePumpingDET;

    @FXML
    private Label RemotePumpingIB;

    @FXML
    private Label LN2TankNI;

    @FXML
    private Label LN2TankWI;

    @FXML
    private Label LN2TankNE;

    @FXML
    private Label LN2TankWE;

    @FXML
    private Label LN2TankNI_2;

    @FXML
    private Label LN2TankWI_2;

    @FXML
    private Label LN2TankNE_2;

    @FXML
    private Label LN2TankWE_2;

    @FXML
    private Label RemotePumpingSR;

    @FXML
    private Label EmergencyCB;

    @FXML
    private Label EmergencyNE;

    @FXML
    private Label EmergencyWE;

    String style = "";

    private ControlCommand master = ControlCommand.getInstance();

    @FXML
    void EmergencyCB_Clicked(MouseEvent event) {
       if ( EmergencyCB.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETEMERGENCYVALVECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("EmergencyCB"), 
                            "1", 500, true, "PrivilegeAccess", true); // OFF
       else if ( EmergencyCB.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETEMERGENCYVALVECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("EmergencyCB"), 
                            "0", 500, true, "PrivilegeAccess", true); // ACTIVE
    }

    @FXML
    void EmergencyCB_Pressed(MouseEvent event) {
       style = EmergencyCB.getStyle();
       System.out.println("Pressed:" + style);
       EmergencyCB.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void EmergencyCB_Released(MouseEvent event) {
       System.out.println("Releaeed:" + style);
       EmergencyCB.setStyle(style);
    }

    @FXML
    void EmergencyNE_Clicked(MouseEvent event) {
      if ( EmergencyNE.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETEMERGENCYVALVECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("EmergencyNE"), 
                            "1", 500, true, "PrivilegeAccess", true); // OFF
       else if ( EmergencyNE.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETEMERGENCYVALVECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("EmergencyNE"), 
                            "0", 500, true, "PrivilegeAccess", true); // ACTIVE
    }

    @FXML
    void EmergencyNE_Pressed(MouseEvent event) {
       style = EmergencyNE.getStyle();
       EmergencyNE.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void EmergencyNE_Released(MouseEvent event) {
       EmergencyNE.setStyle(style);
    }

    @FXML
    void EmergencyWE_Clicked(MouseEvent event) {
      if ( EmergencyWE.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETEMERGENCYVALVECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("EmergencyWE"), 
                            "1", 500, true, "PrivilegeAccess", true); // OFF
       else if ( EmergencyWE.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETEMERGENCYVALVECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("EmergencyWE"), 
                            "0", 500, true, "PrivilegeAccess", true); // ACTIVE
    }

    @FXML
    void EmergencyWE_Pressed(MouseEvent event) {
       style = EmergencyWE.getStyle();
       EmergencyWE.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void EmergencyWE_Released(MouseEvent event) {
       EmergencyWE.setStyle(style);
    }

    @FXML
    void LN2TankNI_Clicked(MouseEvent event) {
       if ( LN2TankNI.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("LN2TankNI"), 
                            "1", 500, true, "Authorize", true); // OFF
       else if ( LN2TankNI.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("LN2TankNI"), 
                            "0", 500, true, "Authorize", true); // ACTIVE
    }

    @FXML
    void LN2TankNI_Pressed(MouseEvent event) {
       style = LN2TankNI.getStyle();
       LN2TankNI.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void LN2TankNI_Released(MouseEvent event) {
       LN2TankNI.setStyle(style);
    }

    @FXML
    void LN2TankNE_Clicked(MouseEvent event) {
       if ( LN2TankNE.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("LN2TankNE"), 
                            "1", 500, true, "Authorize", true); // OFF
       else if ( LN2TankNE.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("LN2TankNE"), 
                            "0", 500, true, "Authorize", true); // ACTIVE
    }

    @FXML
    void LN2TankNE_Pressed(MouseEvent event) {
       style = LN2TankNE.getStyle();
       LN2TankNE.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void LN2TankNE_Released(MouseEvent event) {
       LN2TankNE.setStyle(style);
    }

    @FXML
    void LN2TankWE_Clicked(MouseEvent event) {
       if ( LN2TankWE.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("LN2TankWE"), 
                            "1", 500, true, "Authorize", true); // OFF
       else if ( LN2TankWE.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("LN2TankWE"), 
                            "0", 500, true, "Authorize", true); // ACTIVE
    }

    @FXML
    void LN2TankWE_Pressed(MouseEvent event) {
       style = LN2TankWE.getStyle();
       LN2TankWE.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void LN2TankWE_Released(MouseEvent event) {
       LN2TankWE.setStyle(style);
    }

    @FXML
    void LN2TankWI_Clicked(MouseEvent event) {
       if ( LN2TankWI.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("LN2TankWI"), 
                            "1", 500, true, "Authorize", true); // OFF
       else if ( LN2TankWI.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("LN2TankWI"), 
                            "0", 500, true, "Authorize", true); // ACTIVE
    }

    @FXML
    void LN2TankWI_Pressed(MouseEvent event) {
       style = LN2TankWI.getStyle();
       LN2TankWI.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void LN2TankWI_Released(MouseEvent event) {
       LN2TankWI.setStyle(style);
    }

    @FXML
    void LN2TankNI_2_Clicked(MouseEvent event) {
       if ( LN2TankNI_2.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("LN2TankNI_2"), 
                            "1", 500, true, "Authorize", true); // OFF
       else if ( LN2TankNI_2.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("LN2TankNI_2"), 
                            "0", 500, true, "Authorize", true); // ACTIVE
    }

    @FXML
    void LN2TankNI_2_Pressed(MouseEvent event) {
       style = LN2TankNI_2.getStyle();
       LN2TankNI_2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void LN2TankNI_2_Released(MouseEvent event) {
       LN2TankNI_2.setStyle(style);
    }

    @FXML
    void LN2TankWI_2_Clicked(MouseEvent event) {
       if ( LN2TankWI_2.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("LN2TankWI_2"), 
                            "1", 500, true, "Authorize", true); // OFF
       else if ( LN2TankWI_2.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("LN2TankWI_2"), 
                            "0", 500, true, "Authorize", true); // ACTIVE
    }

    @FXML
    void LN2TankWI_2_Pressed(MouseEvent event) {
       style = LN2TankWI_2.getStyle();
       LN2TankWI_2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void LN2TankWI_2_Released(MouseEvent event) {
       LN2TankWI_2.setStyle(style);
    }

    @FXML
    void LN2TankNE_2_Clicked(MouseEvent event) {
       if ( LN2TankNE_2.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("LN2TankNE_2"), 
                            "1", 500, true, "Authorize", true); // OFF
       else if ( LN2TankNE_2.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("LN2TankNE_2"), 
                            "0", 500, true, "Authorize", true); // ACTIVE
    }

    @FXML
    void LN2TankNE_2_Pressed(MouseEvent event) {
       style = LN2TankNE_2.getStyle();
       LN2TankNE_2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void LN2TankNE_2_Released(MouseEvent event) {
       LN2TankNE_2.setStyle(style);
    }

    @FXML
    void LN2TankWE_2_Clicked(MouseEvent event) {
       if ( LN2TankWE_2.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("LN2TankWE_2"), 
                            "1", 500, true, "Authorize", true); // OFF
       else if ( LN2TankWE_2.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("LN2TankWE_2"), 
                            "0", 500, true, "Authorize", true); // ACTIVE
    }

    @FXML
    void LN2TankWE_2_Pressed(MouseEvent event) {
       style = LN2TankWE_2.getStyle();
       LN2TankWE_2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void LN2TankWE_2_Released(MouseEvent event) {
       LN2TankWE_2.setStyle(style);
    }
    @FXML
    void PrimaryPumpingBS_Clicked(MouseEvent event) {
       if ( PrimaryPumpingBS.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("PrimaryPumpingBS"), 
                            "1", 500, true, "Authorize", true); // OFF
       else if ( PrimaryPumpingBS.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("PrimaryPumpingBS"), 
                            "0", 500, true, "Authorize", true); // ACTIVE
    }

    @FXML
    void PrimaryPumpingBS_Pressed(MouseEvent event) {
       style = PrimaryPumpingBS.getStyle();
       PrimaryPumpingBS.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PrimaryPumpingBS_Released(MouseEvent event) {
       PrimaryPumpingBS.setStyle(style);
    }

    @FXML
    void PrimaryPumpingDET_Clicked(MouseEvent event) {
       if ( PrimaryPumpingDET.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("PrimaryPumpingDET"), 
                            "1", 500, true, "Authorize", true); // OFF
       else if ( PrimaryPumpingDET.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("PrimaryPumpingDET"), 
                            "0", 500, true, "Authorize", true); // ACTIVE
    }

    @FXML
    void PrimaryPumpingDET_Pressed(MouseEvent event) {
       style = PrimaryPumpingDET.getStyle();
       PrimaryPumpingDET.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PrimaryPumpingDET_Released(MouseEvent event) {
       PrimaryPumpingDET.setStyle(style);
    }

    @FXML
    void PrimaryPumpingIB_Clicked(MouseEvent event) {
       if ( PrimaryPumpingIB.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("PrimaryPumpingIB"), 
                            "1", 500, true, "Authorize", true); // OFF
       else if ( PrimaryPumpingIB.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("PrimaryPumpingIB"), 
                            "0", 500, true, "Authorize", true); // ACTIVE
    }

    @FXML
    void PrimaryPumpingIB_Pressed(MouseEvent event) {
       style = PrimaryPumpingIB.getStyle();
       PrimaryPumpingIB.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PrimaryPumpingIB_Released(MouseEvent event) {
       PrimaryPumpingIB.setStyle(style);
    }

    @FXML
    void PrimaryPumpingMC_Clicked(MouseEvent event) {
       if ( PrimaryPumpingMC.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("PrimaryPumpingMC"), 
                            "1", 500, true, "Authorize", true); // OFF
       else if ( PrimaryPumpingMC.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("PrimaryPumpingMC"), 
                            "0", 500, true, "Authorize", true); // ACTIVE
    }

    @FXML
    void PrimaryPumpingMC_Pressed(MouseEvent event) {
       style = PrimaryPumpingMC.getStyle();
       PrimaryPumpingMC.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PrimaryPumpingMC_Released(MouseEvent event) {
       PrimaryPumpingMC.setStyle(style);
    }

    @FXML
    void PrimaryPumpingNE_Clicked(MouseEvent event) {
       if ( PrimaryPumpingNE.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("PrimaryPumpingNE"), 
                            "1", 500, true, "Authorize", true); // OFF
       else if ( PrimaryPumpingNE.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("PrimaryPumpingNE"), 
                            "0", 500, true, "Authorize", true); // ACTIVE
    }

    @FXML
    void PrimaryPumpingNE_Pressed(MouseEvent event) {
       style = PrimaryPumpingNE.getStyle();
       PrimaryPumpingNE.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PrimaryPumpingNE_Released(MouseEvent event) {
       PrimaryPumpingNE.setStyle(style);
    }

    @FXML
    void PrimaryPumpingNI_Clicked(MouseEvent event) {
       if ( PrimaryPumpingNI.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("PrimaryPumpingNI"), 
                            "1", 500, true, "Authorize", true); // OFF
       else if ( PrimaryPumpingNI.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("PrimaryPumpingNI"), 
                            "0", 500, true, "Authorize", true); // ACTIVE
    }

    @FXML
    void PrimaryPumpingNI_Pressed(MouseEvent event) {
       style = PrimaryPumpingNI.getStyle();
       PrimaryPumpingNI.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PrimaryPumpingNI_Released(MouseEvent event) {
       PrimaryPumpingNI.setStyle(style);
    }

    @FXML
    void PrimaryPumpingPR_Clicked(MouseEvent event) {
       if ( PrimaryPumpingPR.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("PrimaryPumpingPR"), 
                            "1", 500, true, "Authorize", true); // OFF
       else if ( PrimaryPumpingPR.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("PrimaryPumpingPR"), 
                            "0", 500, true, "Authorize", true); // ACTIVE
    }

    @FXML
    void PrimaryPumpingPR_Pressed(MouseEvent event) {
       style = PrimaryPumpingPR.getStyle();
       PrimaryPumpingPR.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PrimaryPumpingPR_Released(MouseEvent event) {
       PrimaryPumpingPR.setStyle(style);
    }

    @FXML
    void PrimaryPumpingSR_Clicked(MouseEvent event) {
       if ( PrimaryPumpingSR.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("PrimaryPumpingSR"), 
                            "1", 500, true, "Authorize", true); // OFF
       else if ( PrimaryPumpingSR.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("PrimaryPumpingSR"), 
                            "0", 500, true, "Authorize", true); // ACTIVE
    }

    @FXML
    void PrimaryPumpingSR_Pressed(MouseEvent event) {
       style = PrimaryPumpingSR.getStyle();
       PrimaryPumpingSR.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PrimaryPumpingSR_Released(MouseEvent event) {
       PrimaryPumpingSR.setStyle(style);
    }

    @FXML
    void PrimaryPumpingWE_Clicked(MouseEvent event) {
       if ( PrimaryPumpingWE.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("PrimaryPumpingWE"), 
                            "1", 500, true, "Authorize", true); // OFF
       else if ( PrimaryPumpingWE.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("PrimaryPumpingWE"), 
                            "0", 500, true, "Authorize", true); // ACTIVE
    }

    @FXML
    void PrimaryPumpingWE_Pressed(MouseEvent event) {
       style = PrimaryPumpingWE.getStyle();
       PrimaryPumpingWE.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PrimaryPumpingWE_Released(MouseEvent event) {
       PrimaryPumpingWE.setStyle(style);
    }

    @FXML
    void PrimaryPumpingWI_Clicked(MouseEvent event) {
       if ( PrimaryPumpingWI.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("PrimaryPumpingWI"), 
                            "1", 500, true, "Authorize", true); // OFF
       else if ( PrimaryPumpingWI.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("PrimaryPumpingWI"), 
                            "0", 500, true, "Authorize", true); // ACTIVE
    }

    @FXML
    void PrimaryPumpingWI_Pressed(MouseEvent event) {
       style = PrimaryPumpingWI.getStyle();
       PrimaryPumpingWI.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PrimaryPumpingWI_Released(MouseEvent event) {
       PrimaryPumpingWI.setStyle(style);
    }

    @FXML
    void RemotePumpingBS_Clicked(MouseEvent event) {
       if ( RemotePumpingBS.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETVALVETURBOSAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("RemotePumpingBS"), 
                            "1", 500, true, "Authorize", true); // OFF
       else if ( RemotePumpingBS.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETVALVETURBOSAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("RemotePumpingBS"), 
                            "0", 500, true, "Authorize", true); // ACTIVE
    }

    @FXML
    void RemotePumpingBS_Pressed(MouseEvent event) {
       style = RemotePumpingBS.getStyle();
       RemotePumpingBS.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void RemotePumpingBS_Released(MouseEvent event) {
       RemotePumpingBS.setStyle(style);
    }

    @FXML
    void RemotePumpingDET_Clicked(MouseEvent event) {
       if ( RemotePumpingDET.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETVALVETURBOSAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("RemotePumpingDET"), 
                            "1", 500, true, "Authorize", true); // OFF
       else if ( RemotePumpingDET.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETVALVETURBOSAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("RemotePumpingDET"), 
                            "0", 500, true, "Authorize", true); // ACTIVE
    }

    @FXML
    void RemotePumpingDET_Pressed(MouseEvent event) {
       style = RemotePumpingDET.getStyle();
       RemotePumpingDET.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void RemotePumpingDET_Released(MouseEvent event) {
       RemotePumpingDET.setStyle(style);
    }

    @FXML
    void RemotePumpingIB_Clicked(MouseEvent event) {
       if ( RemotePumpingIB.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETVALVETURBOSAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("RemotePumpingIB"), 
                            "1", 500, true, "Authorize", true); // OFF
       else if ( RemotePumpingIB.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETVALVETURBOSAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("RemotePumpingIB"), 
                            "0", 500, true, "Authorize", true); // ACTIVE
    }

    @FXML
    void RemotePumpingIB_Pressed(MouseEvent event) {
       style = RemotePumpingIB.getStyle();
       RemotePumpingIB.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void RemotePumpingIB_Released(MouseEvent event) {
       RemotePumpingIB.setStyle(style);
    }

    @FXML
    void RemotePumpingNI_Clicked(MouseEvent event) {
       if ( RemotePumpingNI.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETVALVETURBOSAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("RemotePumpingNI"), 
                            "1", 500, true, "Authorize", true); // OFF
       else if ( RemotePumpingNI.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETVALVETURBOSAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("RemotePumpingNI"), 
                            "0", 500, true, "Authorize", true); // ACTIVE
    }

    @FXML
    void RemotePumpingNI_Pressed(MouseEvent event) {
       style = RemotePumpingNI.getStyle();
       RemotePumpingNI.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void RemotePumpingNI_Released(MouseEvent event) {
       RemotePumpingNI.setStyle(style);
    }

    @FXML
    void RemotePumpingPR_Clicked(MouseEvent event) {
       if ( RemotePumpingPR.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETVALVETURBOSAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("RemotePumpingPR"), 
                            "1", 500, true, "Authorize", true); // OFF
       else if ( RemotePumpingPR.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETVALVETURBOSAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("RemotePumpingPR"), 
                            "0", 500, true, "Authorize", true); // ACTIVE
    }

    @FXML
    void RemotePumpingPR_Pressed(MouseEvent event) {
       style = RemotePumpingPR.getStyle();
       RemotePumpingPR.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void RemotePumpingPR_Released(MouseEvent event) {
       RemotePumpingPR.setStyle(style);
    }

    @FXML
    void RemotePumpingSR_Clicked(MouseEvent event) {
       if ( RemotePumpingSR.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETVALVETURBOSAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("RemotePumpingSR"), 
                            "1", 500, true, "Authorize", true); // OFF
       else if ( RemotePumpingSR.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETVALVETURBOSAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("RemotePumpingSR"), 
                            "0", 500, true, "Authorize", true); // ACTIVE
    }

    @FXML
    void RemotePumpingSR_Pressed(MouseEvent event) {
       style = RemotePumpingSR.getStyle();
       RemotePumpingSR.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void RemotePumpingSR_Released(MouseEvent event) {
       RemotePumpingSR.setStyle(style);
    }

    @FXML
    void RemotePumpingWI_Clicked(MouseEvent event) {
       if ( RemotePumpingWI.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETVALVETURBOSAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("RemotePumpingWI"), 
                            "1", 500, true, "Authorize", true); // OFF
       else if ( RemotePumpingWI.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETVALVETURBOSAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("RemotePumpingWI"), 
                            "0", 500, true, "Authorize", true); // ACTIVE
    }

    @FXML
    void RemotePumpingWI_Pressed(MouseEvent event) {
       style = RemotePumpingWI.getStyle();
       RemotePumpingWI.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void RemotePumpingWI_Released(MouseEvent event) {
       RemotePumpingWI.setStyle(style);
    }

    @FXML
    void SafeCentral_Clicked(MouseEvent event) {
       if ( SafeCentral.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("SafeCentral"), 
                            "1", 500, true, "Authorize", true); // OFF
       else if ( SafeCentral.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("SafeCentral"), 
                            "0", 500, true, "Authorize", true); // ACTIVE
    }

    @FXML
    void SafeCentral_Pressed(MouseEvent event) {
       style = SafeCentral.getStyle();
       SafeCentral.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void SafeCentral_Released(MouseEvent event) {
       SafeCentral.setStyle(style);
    }

    @FXML
    void SafeNorthArm_Clicked(MouseEvent event) {
       if ( SafeNorthArm.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("SafeNorthArm"), 
                            "1", 500, true, "Authorize", true); // OFF
       else if ( SafeNorthArm.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("SafeNorthArm"), 
                            "0", 500, true, "Authorize", true); // ACTIVE
    }

    @FXML
    void SafeNorthArm_Pressed(MouseEvent event) {
       style = SafeNorthArm.getStyle();
       SafeNorthArm.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void SafeNorthArm_Released(MouseEvent event) {
       SafeNorthArm.setStyle(style);
    }

    @FXML
    void SafeNorthEnd_Clicked(MouseEvent event) {
       if ( SafeNorthEnd.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("SafeNorthEnd"), 
                            "1", 500, true, "Authorize", true); // OFF
       else if ( SafeNorthEnd.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("SafeNorthEnd"), 
                            "0", 500, true, "Authorize", true); // ACTIVE
    }

    @FXML
    void SafeNorthEnd_Pressed(MouseEvent event) {
       style = SafeNorthEnd.getStyle();
       SafeNorthEnd.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void SafeNorthEnd_Released(MouseEvent event) {
       SafeNorthEnd.setStyle(style);
    }

    @FXML
    void SafeWestArm_Clicked(MouseEvent event) {
      if ( SafeWestArm.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("SafeWestArm"), 
                            "1", 500, true, "Authorize", true); // OFF
       else if ( SafeWestArm.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("SafeWestArm"), 
                            "0", 500, true, "Authorize", true); // ACTIVE
    }

    @FXML
    void SafeWestArm_Pressed(MouseEvent event) {
       style = SafeWestArm.getStyle();
       SafeWestArm.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void SafeWestArm_Released(MouseEvent event) {
       SafeWestArm.setStyle(style);
    }

    @FXML
    void SafeWestEnd_Clicked(MouseEvent event) {
       if ( SafeWestEnd.getText().equals("ACTIVE") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("SafeWestEnd"), 
                            "1", 500, true, "Authorize", true); // OFF
       else if ( SafeWestEnd.getText().equals("OFF") )
          master.setCommand("ModbusVac", "SETVALVEGAUGESAFECHANNEL", "", SUPERVISORACTIONS_COMMAND_CHANNELS.get("SafeWestEnd"), 
                            "0", 500, true, "Authorize", true); // ACTIVE
    }

    @FXML
    void SafeWestEnd_Pressed(MouseEvent event) {
       style = SafeWestEnd.getStyle();
       SafeWestEnd.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void SafeWestEnd_Released(MouseEvent event) {
       SafeWestEnd.setStyle(style);
    }

}

