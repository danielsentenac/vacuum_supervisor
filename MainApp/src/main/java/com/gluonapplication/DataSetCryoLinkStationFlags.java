package com.gluonapplication;

import java.util.Vector;

public class DataSetCryoLinkStationFlags extends DataSet {

   public DataSetCryoLinkStationFlags(String name) {
      super();

      // Communication Instruments & Pumping Rack
      if (name.contains("DET"))
         list.addElement(new DataElement("ComTurbo",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_CRYOLINK_DET_P21COMST"));
      else if (name.contains("IB"))
         list.addElement(new DataElement("ComTurbo",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_CRYOLINK_IB_P21COMST"));

      list.addElement(new DataElement("ComModule",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_CRYOLINK_M1_COMST"));
      list.addElement(new DataElement("ComMaxiGauge",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_CRYOLINK_MG_COMST"));
      list.addElement(new DataElement("ComRack",Type.LABEL_RACK_STATUS_STRING,"VAC_CRYOLINK_RackStatus"));
      list.addElement(new DataElement("CompressAir",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_CRYOLINK_COMPRESSAIRST"));

      // Inhibit valves
      if (name.contains("DET")) {
         list.addElement(new DataElement("InhibitVs1",Type.LABEL_INHIBIT_VALVE_2_STATUS_STRING,"VAC_CRYOLINKDET_Rules_ST",0));
         list.addElement(new DataElement("InhibitVs2",Type.LABEL_INHIBIT_VALVE_2_STATUS_STRING,"VAC_CRYOLINKDET_Rules_ST",1));
      }
      else if (name.contains("IB")) {
         list.addElement(new DataElement("InhibitVs1",Type.LABEL_INHIBIT_VALVE_2_STATUS_STRING,"VAC_CRYOLINKIB_Rules_ST",0));
         list.addElement(new DataElement("InhibitVs2",Type.LABEL_INHIBIT_VALVE_2_STATUS_STRING,"VAC_CRYOLINKIB_Rules_ST",1));
      }
      // Init
      Init();
   }
}




