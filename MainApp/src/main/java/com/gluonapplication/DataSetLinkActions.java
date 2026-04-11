package com.gluonapplication;


public class DataSetLinkActions extends DataSet {

   public DataSetLinkActions(String name) {
      super();

      if (name.contains("PR"))
         // ByPass Remote PR
         list.addElement(new DataElement("ByPassRemote",Type.LABEL_ONOFF_3_STATUS_STRING,"VAC_LINK_PR_BYPASSST"));
      else if (name.contains("SR"))
         // ByPass Remote SR
         list.addElement(new DataElement("ByPassRemote",Type.LABEL_ONOFF_3_STATUS_STRING,"VAC_LINK_SR_BYPASSST"));
      
      // Fan ON/OFF
      list.addElement(new DataElement("FanOnOff",Type.LABEL_ONOFF_2_STATUS_STRING,"VAC_LINK_RACK_FANST"));
      // Fan SPEED
      list.addElement(new DataElement("FanSpeed",Type.LABEL_FANSPEED_STATUS_STRING,"VAC_LINK_RACK_FANSPEED"));

      // Init
      Init();
   }
}




