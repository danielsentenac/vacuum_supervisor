package com.gluonapplication;

import java.util.Vector;

public class DataSetCryoActions extends DataSet {

   public DataSetCryoActions(String name) {
      super();

      // Communication Instruments
      name = name.replace("CRYO","LN2");
      list.addElement(new DataElement("StartStop",Type.LABEL_OFFACTIVE_STATUS_STRING,"VAC_" + name + "_SWITCH_TO_OP"));
      list.addElement(new DataElement("PIDdisable",Type.LABEL_OFFACTIVE_STATUS_STRING,"VAC_" + name + "_DISABLE_LEVELCTRL"));
      list.addElement(new DataElement("Reset",Type.LABEL_OFFACTIVE_STATUS_STRING,"VAC_" + name + "_RESET_ERROR_INTLCK"));
      list.addElement(new DataElement("PIDenabled",Type.LABEL_OFFACTIVE_STATUS_STRING,"VAC_" + name + "_PIDCTRL_ALLOWED"));
      list.addElement(new DataElement("PIDrunning",Type.LABEL_OFFACTIVE_STATUS_STRING,"VAC_" + name + "_LEVELPID_RUNNING"));
      list.addElement(new DataElement("PSStatus",Type.LABEL_CRYO_STATUS_STRING,"VAC_" + name + "_PS_CTRLSTATE"));
      list.addElement(new DataElement("CryoStatus",Type.LABEL_CRYO_STATUS_STRING,"VAC_" + name + "_CL_CTRLSTATE"));
     
      // Init
      Init();
   }
}




