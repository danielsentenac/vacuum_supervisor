package com.gluonapplication;


public class DataSetTubeMCStationFlags extends DataSet {

   public DataSetTubeMCStationFlags(String name) {
      super();

      // Communication Instruments
      list.addElement(new DataElement("ComTurbo",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_P21COMST"));
      list.addElement(new DataElement("ComMaxiGauge",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_MAXIGAUGECOMST"));
      list.addElement(new DataElement("CompressAir",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_COMPRESSAIRST"));
      list.addElement(new DataElement("RackTemp",Type.LABEL_VALUE_2F_STRING,"VAC_" + name + "_RACK_TEMP","°C"));
      list.addElement(new DataElement("ComModule",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_RACKCOMST"));
      list.addElement(new DataElement("ComRack",Type.LABEL_RACK_STATUS_STRING,"VAC_" + name + "_RackStatus"));
      
      
      // Init
      Init();
   }
}




