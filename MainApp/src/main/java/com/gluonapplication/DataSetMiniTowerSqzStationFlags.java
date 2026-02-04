package com.gluonapplication;


public class DataSetMiniTowerSqzStationFlags extends DataSet {

   public DataSetMiniTowerSqzStationFlags(String name) {
      super();

      // Communication Instruments
      list.addElement(new DataElement("ComRack",Type.LABEL_RACK_STATUS_STRING,"VAC_" + name + "_RackStatus"));
      list.addElement(new DataElement("ComTurbo",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_DCU_P21COMST"));
      list.addElement(new DataElement("ComMaxiGauge",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_MG_COMST"));
      list.addElement(new DataElement("CompressAir1",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_M1_COMPRESSAIRST"));
      list.addElement(new DataElement("CompressAir2",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_M2_COMPRESSAIRST"));
      list.addElement(new DataElement("ComModule1",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_M1_COMST"));
      list.addElement(new DataElement("ComModule2",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_M2_COMST"));
      list.addElement(new DataElement("ComModule3",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_M3_COMST"));
      list.addElement(new DataElement("ComTempMuxShield",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_TCMUX_COMST"));
      list.addElement(new DataElement("RackTemp",Type.LABEL_VALUE_2F_STRING,"VAC_" + name + "_RACK_TEMP","°C"));
      list.addElement(new DataElement("Temp0",Type.LABEL_VALUE_2F_STRING,"VAC_" + name + "_TEMP0","°C"));
      list.addElement(new DataElement("Temp1",Type.LABEL_VALUE_2F_STRING,"VAC_" + name + "_TEMP1","°C"));
      list.addElement(new DataElement("Temp2",Type.LABEL_VALUE_2F_STRING,"VAC_" + name + "_TEMP2","°C"));
      list.addElement(new DataElement("Temp3",Type.LABEL_VALUE_2F_STRING,"VAC_" + name + "_TEMP3","°C"));
      list.addElement(new DataElement("Temp4",Type.LABEL_VALUE_2F_STRING,"VAC_" + name + "_TEMP4","°C"));
      list.addElement(new DataElement("Temp5",Type.LABEL_VALUE_2F_STRING,"VAC_" + name + "_TEMP5","°C"));
      list.addElement(new DataElement("Temp6",Type.LABEL_VALUE_2F_STRING,"VAC_" + name + "_TEMP6","°C"));
      list.addElement(new DataElement("Temp7",Type.LABEL_VALUE_2F_STRING,"VAC_" + name + "_TEMP7","°C"));
      list.addElement(new DataElement("Temp8",Type.LABEL_VALUE_2F_STRING,"VAC_" + name + "_TEMP8","°C"));
      
      // UPS 
      list.addElement(new DataElement("ComUps",Type.LABEL_RACK_STATUS_STRING, UPS_CHANNELS.get(name)));
      list.addElement(new DataElement("BatteryWorkUps",Type.LABEL_OKWORKING_STATUS_STRING, UPS_CHANNELS.get(name+"_BATTERY_WORK")));
      list.addElement(new DataElement("BatteryLowUps",Type.LABEL_OKLOW_STATUS_STRING, UPS_CHANNELS.get(name+"_BATTERY_LOW")));
      
      // Init
      Init();
   }
}




