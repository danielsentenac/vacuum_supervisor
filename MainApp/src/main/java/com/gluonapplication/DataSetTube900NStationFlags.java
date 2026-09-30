package com.gluonapplication;


public class DataSetTube900NStationFlags extends DataSet {

   public DataSetTube900NStationFlags(String name) {
      super();

      // Rack Status / Communication Instruments
      list.addElement(new DataElement("ComRack",Type.LABEL_RACK_STATUS_STRING,"VAC_" + name + "_RackStatus"));
      list.addElement(new DataElement("ComMaxiGauge",Type.LABEL_RACK_STATUS_STRING,"VAC_" + name + "_MG_COMST"));
      list.addElement(new DataElement("ComIonicP33",Type.LABEL_RACK_STATUS_STRING,"VAC_" + name + "_IPC_P33COMST"));
      list.addElement(new DataElement("ComValves",Type.LABEL_RACK_STATUS_STRING,"VAC_" + name + "_I2C_COMST"));

      // UPS 
      list.addElement(new DataElement("ComUps",Type.LABEL_RACK_STATUS_STRING, UPS_CHANNELS.get(name)));
      list.addElement(new DataElement("BatteryWorkUps",Type.LABEL_OKWORKING_STATUS_STRING, UPS_CHANNELS.get(name+"_BATTERY_WORK")));
      list.addElement(new DataElement("BatteryLowUps",Type.LABEL_OKLOW_STATUS_STRING, UPS_CHANNELS.get(name+"_BATTERY_LOW")));

      // Init
      Init();
   }
}
