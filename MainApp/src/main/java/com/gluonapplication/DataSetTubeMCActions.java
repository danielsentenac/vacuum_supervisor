package com.gluonapplication;

import java.util.Vector;

public class DataSetTubeMCActions extends DataSet {

   public DataSetTubeMCActions(String name) {
      super();
      
      // Fan ON/OFF
      list.addElement(new DataElement("FanOnOff",Type.LABEL_ONOFF_2_STATUS_STRING, "VAC_" + name + "_RACK_FANST"));
      // Fan SPEED
      list.addElement(new DataElement("FanSpeed",Type.LABEL_FANSPEED_STATUS_STRING, "VAC_" + name + "_RACK_FANSPEED"));

      // Init
      Init();
   }
}




