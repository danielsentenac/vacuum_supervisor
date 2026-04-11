package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ControllerValve implements ControlTypes {

    @FXML
    private Label ValveName;

    @FXML
    private Label Status;

    @FXML
    private Label OPEN;

    @FXML
    private Label CLOSE;

    String style = "";

    String name = "";

    DataSet data;

    private ControlCommand master = ControlCommand.getInstance();

    @FXML
    public void initialize() {
       ViewData presentView = (ViewData) MobileApplication.getInstance().getView();
       name = presentView.name;
       data = presentView.data;
    }

    @FXML
    void CLOSE_Clicked(MouseEvent event) {
       boolean cryolinkcase = false;
       if (name.contains("TUBEN") || name.contains("TUBEW") )
          name = ValveName.getText().split("_")[0];
       else if (name.equals("LINKPR")){
          name = name.replace("PR","");
          ValveName.setText("PR" + ValveName.getText());
       }
       else if (name.equals("LINKSR")) {
          name = name.replace("SR","");
          ValveName.setText("SR" + ValveName.getText());
       }
       else if (name.equals("CRYOLINKDET") && (ValveName.getText().contains("V21") || ValveName.getText().contains("V21"))) {
          name = name.replace("DET","");
          ValveName.setText("DET" + ValveName.getText());
       }
       else if (name.equals("CRYOLINKIB") && (ValveName.getText().contains("V21") || ValveName.getText().contains("V21"))) {
          name = name.replace("IB","");
          ValveName.setText("IB" + ValveName.getText());
       }
       else if (name.equals("NE") || name.equals("WE") )
          name = ValveName.getText().split("_")[0];
       else if (name.equals("CB")) {
          if (ValveName.getText().contains("CRYOLINK"))
             cryolinkcase = true;
          name = ValveName.getText().split("_")[0];
       }
       else if (ValveName.getText().contains("LN2TANKVALVE") && !ValveName.getText().contains("WI") )
          name = "VALVEBIG" + ValveName.getText().split("_")[0];
       else if (ValveName.getText().contains("LN2TANKVALVE_WI") )
          name = "VALVEBIGNI";
       else if (name.contains("CRYOLINK") && !name.contains("_DET") && !name.contains("_IB") )
          cryolinkcase = true;
       else if (name.equals("SQZDET2") && ValveName.getText().equals("Vrem")) // Special case Vrem between SQZDET1 & SQZDET2
          name = "SQZDET1";
       
       System.out.println("CLOSE:" + name + " " + ValveName.getText());
       if ( cryolinkcase == false ) {
             master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         VALVE_COMMAND_CHANNELS.get(ValveName.getText()), "2", 2000, true, "Authorize", true);  // CLOSE
             if ( !ValveName.getText().contains("LN2TANKVALVE")) // Exception TANK VALVES requires NO RESET
                master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         VALVE_COMMAND_CHANNELS.get(ValveName.getText()), "0", 0, false, "", false);   // RESET
       }
       else { // CRYOLINK case = true
          System.out.println("ControllerValve:: cryolink case = true");
          // Get Z_10_DOUT channel
          DataElement z_10_dout = data.getDataElement(name + "_Z_10_DOUT");
          System.out.println("ControllerValve:: get channel from name " + name + "_Z_10_DOUT " + z_10_dout);
          if (z_10_dout != null) {
             try { 
                System.out.println("Z_10_DOUT NAME:" + z_10_dout.name + " " + z_10_dout.svrName);
                System.out.println("Z_10_DOUT VALUE:" + z_10_dout.svrValue);
                int Z_10_DOUT_VALUE = Integer.parseInt(z_10_dout.svrValue);
                byte tmp = (byte)(Z_10_DOUT_VALUE & 0xFF);
                System.out.println(String.format("%8s", Integer.toBinaryString(tmp & 0xFF)).replace(' ', '0'));
                byte res = 0;
                if ( ValveName.getText().contains("Vs1") )
                  res = setBit(tmp,0,false);
                else if ( ValveName.getText().contains("Vs2") )
                  res = setBit(tmp,1,false);
                else if ( ValveName.getText().contains("CV2") )
                  res = setBit(tmp,2,false);
                else if ( ValveName.getText().contains("CV1") )
                  res = setBit(tmp,3,false);
                int cmd = (int) res;
                System.out.println(String.format("%8s", Integer.toBinaryString(res & 0xFF)).replace(' ', '0'));
                master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         VALVE_COMMAND_CHANNELS.get(name), Integer.toString(cmd), 2000, true, "Authorize", true);  // CLOSE
             }
             catch (NumberFormatException ne) {ne.printStackTrace();}
          }
       }
    }

    @FXML
    void CLOSE_Pressed(MouseEvent event) {
       style = CLOSE.getStyle();
       CLOSE.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void CLOSE_Released(MouseEvent event) {
	CLOSE.setStyle(style);
    }

    @FXML
    void OPEN_Clicked(MouseEvent event) {
       boolean cryolinkcase = false;
       System.out.println("OPEN VALVE name: " + name + " " + ValveName.getText());
       if (name.contains("TUBEN") || name.contains("TUBEW"))
          name = ValveName.getText().split("_")[0];
       else if (name.equals("LINKPR")){
          name = name.replace("PR","");
          ValveName.setText("PR" + ValveName.getText());
       }
       else if (name.equals("LINKSR")) {
          name = name.replace("SR","");
          ValveName.setText("SR" + ValveName.getText());
       }
       else if (name.equals("CRYOLINKDET") && (ValveName.getText().contains("V21") || ValveName.getText().contains("V21"))) {
          name = name.replace("DET","");
          ValveName.setText("DET" + ValveName.getText());
       }
       else if (name.equals("CRYOLINKIB") && (ValveName.getText().contains("V21") || ValveName.getText().contains("V21"))) {
          name = name.replace("IB","");
          ValveName.setText("IB" + ValveName.getText());
       }
       else if (name.equals("NE") || name.equals("WE") )
          name = ValveName.getText().split("_")[0];
       else if (name.equals("CB")) {
          if (ValveName.getText().contains("CRYOLINK") )
             cryolinkcase = true;
          name = ValveName.getText().split("_")[0];
       }
       else if (ValveName.getText().contains("LN2TANKVALVE") && !ValveName.getText().contains("WI") )
          name = "VALVEBIG" + ValveName.getText().split("_")[0];
       else if (ValveName.getText().contains("LN2TANKVALVE_WI") )
          name = "VALVEBIGNI";
       else if (name.contains("CRYOLINK") && !name.contains("_DET") && !name.contains("_IB") )
          cryolinkcase = true;
       else if (name.equals("SQZDET2") && ValveName.getText().equals("Vrem")) // Special case Vrem between SQZDET1 & SQZDET2
          name = "SQZDET1";
     
       System.out.println("OPEN:" + name + " " + ValveName.getText());
       if ( cryolinkcase == false ) {
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         VALVE_COMMAND_CHANNELS.get(ValveName.getText()), "1", 2000, true, "Authorize", true);  // OPEN
          if ( !ValveName.getText().contains("LN2TANKVALVE")) // Exception TANK VALVES requires NO RESET
          master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         VALVE_COMMAND_CHANNELS.get(ValveName.getText()), "0", 0, false, "", false);   // RESET
       }
       else {
          // Get Z_10_DOUT channel
          DataElement z_10_dout = data.getDataElement(name + "_Z_10_DOUT");
          if (z_10_dout != null) {
             try {
                System.out.println("Z_10_DOUT NAME:" + z_10_dout.name + " " + z_10_dout.svrName);
                System.out.println("Z_10_DOUT VALUE:" + z_10_dout.svrValue);
                int Z_10_DOUT_VALUE = Integer.parseInt(z_10_dout.svrValue);
                byte tmp = (byte)(Z_10_DOUT_VALUE & 0xFF);
                System.out.println(String.format("%8s", Integer.toBinaryString(tmp & 0xFF)).replace(' ', '0'));
                byte res = 0;
                if ( ValveName.getText().contains("Vs1") )
                  res = setBit(tmp,0,true);
                else if ( ValveName.getText().contains("Vs2") )
                  res = setBit(tmp,1,true);
                else if ( ValveName.getText().contains("CV2") )
                  res = setBit(tmp,2,true);
                else if ( ValveName.getText().contains("CV1") )
                  res = setBit(tmp,3,true);
                int cmd = (int) res;
                System.out.println(String.format("%8s", Integer.toBinaryString(res & 0xFF)).replace(' ', '0'));
                master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         VALVE_COMMAND_CHANNELS.get(name), Integer.toString(cmd), 2000, true, "Authorize", true);  // OPEN
             }
             catch (NumberFormatException ne) {}
          }
       }
    }

    @FXML
    void OPEN_Pressed(MouseEvent event) {
       style = OPEN.getStyle();
       OPEN.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void OPEN_Released(MouseEvent event) {
       OPEN.setStyle(style);
    }
   
    //Util functions

    public final static byte setBit(byte _byte, int bitPosition, boolean bitValue) { 
       if (bitValue)
          return (byte) (_byte | (1 << bitPosition));
       return (byte) (_byte & ~(1 << bitPosition));
    }

    public final static int getBit(int n, int k) {
       return (n >> k) & 1;
    }
}

