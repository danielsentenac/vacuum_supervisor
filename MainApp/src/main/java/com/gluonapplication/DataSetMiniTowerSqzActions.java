package com.gluonapplication;

import java.util.Vector;

public class DataSetMiniTowerSqzActions extends DataSet {

   public DataSetMiniTowerSqzActions(String name) {
      super();

      // Fan On-Off
      list.addElement(new DataElement("FanOnOff",Type.LABEL_ONOFF_2_STATUS_STRING,"VAC_" + name + "_RACK_FANST"));
      // Fan Speed
      list.addElement(new DataElement("FanSpeed",Type.LABEL_FANSPEED_STATUS_STRING,"VAC_" + name + "_RACK_FANSPEED"));
      // ByPass G22
      list.addElement(new DataElement("ByPassG22",Type.LABEL_ONOFF_3_STATUS_STRING,"VAC_" + name + "_M1_BYPASSST"));
      // ByPass GP
      list.addElement(new DataElement("ByPassGP",Type.LABEL_ONOFF_3_STATUS_STRING,"VAC_" + name + "_M2_BYPASSST"));
      // RGA Emult On-Off
      list.addElement(new DataElement("EmultOnOff",Type.LABEL_ONOFF_4_STATUS_STRING,"VAC_" + name + "_RGAGe4_EMISSION"));
      // RGA Start-Stop
      list.addElement(new DataElement("StartStop",Type.LABEL_ONOFF_4_STATUS_STRING,"VAC_" + name + "_RGAGe4_RUNNING"));
      // RGA Filament choice
      list.addElement(new DataElement("Filament",Type.LABEL_VALUE_STRING,"VAC_" + name + "_RGAGe4_FILAMENT"));

      // Init
      Init(); 
   }
}




