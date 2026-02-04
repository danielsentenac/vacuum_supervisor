package com.gluonapplication;


public class DataSetRemotePumpsFlags extends DataSet {

   public DataSetRemotePumpsFlags(String name) {
      super();

      // Communication Instruments & Data
      list.addElement(new DataElement("ComMaxiGauge1",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_ALARMCOMMAXIGAUGE1"));
      list.addElement(new DataElement("ComMaxiGauge2",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_ALARMCOMMAXIGAUGE2"));
      list.addElement(new DataElement("ComMaxiGauge3",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_ALARMCOMMAXIGAUGE2"));
      list.addElement(new DataElement("G1Threshold",Type.LABEL_VALUE_2F_STRING,"VAC_" + name + "_G1THRST"));
      list.addElement(new DataElement("G2Threshold",Type.LABEL_VALUE_2F_STRING,"VAC_" + name + "_G2THRST"));
      list.addElement(new DataElement("CompressAir",Type.LABEL_FAILUREOK_STATUS_STRING,"VAC_" + name + "_COMPRESSAIRST"));
      list.addElement(new DataElement("CompressAirRelay",Type.LABEL_FAILUREOK_STATUS_STRING,"VAC_" + name + "_COMPRESSAIRRELAYST"));
      list.addElement(new DataElement("ComRack",Type.LABEL_RACK_STATUS_STRING,"VAC_" + name + "_RackStatus"));

      // Inhibit Valves
       list.addElement(new DataElement("InhibitV1",Type.LABEL_INHIBIT_VALVE_STATUS_STRING,"VAC_" + name + "_INHIBITV1OPENST"));
      list.addElement(new DataElement("InhibitV2",Type.LABEL_INHIBIT_VALVE_STATUS_STRING,"VAC_" + name + "_INHIBITV2OPENST"));

      // Init
      Init();
   }
}




