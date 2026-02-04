package com.gluonapplication;

import java.util.Vector;

public class DataSetCryoStationFlags extends DataSet {

   public DataSetCryoStationFlags(String name) {
      super();

      // Communication Instruments
      System.out.println("name = " + name);
      list.addElement(new DataElement("ComRack",Type.LABEL_RACK_STATUS_STRING,"VAC_" + name + "_RackStatus"));
      list.addElement(new DataElement("ComTurboP2",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_ALARMTM700COM"));
      list.addElement(new DataElement("ComIonic",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_ALARMIONICCOM"));
      list.addElement(new DataElement("ComMaxiGauge1",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_ALARMMG1RS232"));
      list.addElement(new DataElement("ComMaxiGauge2",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_ALARMMG2RS232"));
      list.addElement(new DataElement("ComTitaneP31i",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_ALARMTI1COM"));
      list.addElement(new DataElement("ComTitaneP32i",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_ALARMTI2COM"));
      list.addElement(new DataElement("ComTitaneP31e",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_ALARMTI3COM"));
      list.addElement(new DataElement("ComTitaneP32e",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_ALARMTI4COM"));
      list.addElement(new DataElement("CompressAir",Type.LABEL_FAILUREOK_STATUS_STRING,"VAC_" + name + "_COMPRESSAIRST"));
      list.addElement(new DataElement("CompressAirRelay",Type.LABEL_FAILUREOK_STATUS_STRING,"VAC_" + name + "_COMPRESSAIRRELAYST"));

      // Cryo 
       list.addElement(new DataElement("ComCryo",Type.LABEL_RACK_STATUS_STRING,"VAC_" + name.replace("CRYO","LN2") + "_RackStatus"));
     
      // Init
      Init();
   }
}




