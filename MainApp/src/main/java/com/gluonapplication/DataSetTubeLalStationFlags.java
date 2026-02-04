package com.gluonapplication;

import java.util.Vector;

public class DataSetTubeLalStationFlags extends DataSet {

   public DataSetTubeLalStationFlags(String name) {
      super();

      // Communication Instruments
      list.addElement(new DataElement("ComTurbo",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_ALARMCOMP21TURBOPUMP"));
      list.addElement(new DataElement("ComMaxiGauge",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_ALARMCOMMAXIGAUGE"));
      list.addElement(new DataElement("ComXGSGauge",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_ALARMCOMXGS600"));
      list.addElement(new DataElement("ComTitaneP31",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_ALARMCOMP31TITANEPUMP"));
      list.addElement(new DataElement("ComTitaneP32",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_ALARMCOMP32TITANEPUMP"));
      list.addElement(new DataElement("ComIonicP23",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_ALARMCOMP23IONICPUMP"));
      list.addElement(new DataElement("ComIonicP33",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_ALARMCOMP33IONICPUMP"));
      list.addElement(new DataElement("CompressAir",Type.LABEL_FAILUREOK_STATUS_STRING,"VAC_" + name + "_AIRP"));
      list.addElement(new DataElement("PressureAir",Type.LABEL_VALUE_STRING,"VAC_" + name + "_AIRPRESSURE1","mbar"));
      list.addElement(new DataElement("PressureAirSpare",Type.LABEL_VALUE_STRING,"VAC_" + name + "_AIRPRESSURE2","mbar"));
      list.addElement(new DataElement("UPSBattery",Type.LABEL_OFFACTIVE_STATUS_STRING,"VAC_" + name + "_UPSBATTERYST"));
      list.addElement(new DataElement("UPSBatteryLow",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_UPSBATTERYLOWST"));
      list.addElement(new DataElement("FanStatus",Type.LABEL_OFFON_STATUS_STRING,"VAC_" + name + "_FANST"));
      list.addElement(new DataElement("RackTemp",Type.LABEL_VALUE_STRING,"VAC_" + name + "_RACKTEMP1","°C"));
      list.addElement(new DataElement("RackTempSpare",Type.LABEL_VALUE_STRING,"VAC_" + name + "_RACKTEMP2","°C"));
      list.addElement(new DataElement("ComRack",Type.LABEL_RACK_STATUS_STRING,"VAC_" + name + "_RackStatus"));

      // UPS 
      list.addElement(new DataElement("ComUps",Type.LABEL_RACK_STATUS_STRING, UPS_CHANNELS.get(name)));
      list.addElement(new DataElement("BatteryWorkUps",Type.LABEL_OKWORKING_STATUS_STRING, UPS_CHANNELS.get(name+"_BATTERY_WORK")));
      list.addElement(new DataElement("BatteryLowUps",Type.LABEL_OKLOW_STATUS_STRING, UPS_CHANNELS.get(name+"_BATTERY_LOW")));
     
      // Init
      Init();
   }
}




