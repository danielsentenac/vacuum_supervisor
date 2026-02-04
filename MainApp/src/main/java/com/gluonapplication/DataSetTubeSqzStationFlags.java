package com.gluonapplication;

import java.util.Vector;

public class DataSetTubeSqzStationFlags extends DataSet {

   public DataSetTubeSqzStationFlags(String name) {
      super();

      // Communication Instruments
      list.addElement(new DataElement("ComTurbo",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_P21COMST"));
      list.addElement(new DataElement("ComMaxiGauge",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_MAXIGAUGECOMST"));
      list.addElement(new DataElement("CompressAir",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_COMPRESSAIRST"));
      list.addElement(new DataElement("RackTemp",Type.LABEL_VALUE_2F_STRING,"VAC_" + name + "_RACK_TEMP","°C"));
      list.addElement(new DataElement("ComModule",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_RACKCOMST"));
      list.addElement(new DataElement("ComRack",Type.LABEL_RACK_STATUS_STRING,"VAC_" + name + "_RackStatus"));
      
      // UPS 
      list.addElement(new DataElement("ComUps",Type.LABEL_RACK_STATUS_STRING, UPS_CHANNELS.get(name)));
      list.addElement(new DataElement("BatteryWorkUps",Type.LABEL_OKWORKING_STATUS_STRING, UPS_CHANNELS.get(name+"_BATTERY_WORK")));
      list.addElement(new DataElement("BatteryLowUps",Type.LABEL_OKLOW_STATUS_STRING, UPS_CHANNELS.get(name+"_BATTERY_LOW")));
      
      // Init
      Init();
   }
}




