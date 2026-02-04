package com.gluonapplication;


public class DataSetTubeSqzActions extends DataSet {

   public DataSetTubeSqzActions(String name) {
      super();
      
      // Fan ON/OFF
      list.addElement(new DataElement("FanOnOff",Type.LABEL_ONOFF_2_STATUS_STRING, "VAC_" + name + "_RACK_FANST"));
      // Fan SPEED
      list.addElement(new DataElement("FanSpeed",Type.LABEL_FANSPEED_STATUS_STRING, "VAC_" + name + "_RACK_FANSPEED"));

      // Init
      Init();
   }
}




