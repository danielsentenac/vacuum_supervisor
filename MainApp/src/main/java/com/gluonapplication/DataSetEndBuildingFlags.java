package com.gluonapplication;

import java.util.Vector;

public class DataSetEndBuildingFlags extends DataSet {

   public DataSetEndBuildingFlags(String name) {
      super();

      if ( name.equals("WE")) {
         // Rack Status
         list.addElement(new DataElement("StatusRackTower",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_TOWERWE_RackStatus"));
         list.addElement(new DataElement("StatusRackCryoPump",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_CRYOWE_RackStatus"));
         list.addElement(new DataElement("StatusRackCryo",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_LN2WE_RackStatus"));

         // CompressAir
         list.addElement(new DataElement("CompressAirTower",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_TOWERNE_AIRP"));
         list.addElement(new DataElement("CompressAirCryo",Type.LABEL_FAILUREOK_STATUS_STRING,"VAC_CRYONE_COMPRESSAIRST"));
      }
      else if ( name.equals("NE")) {
         // Rack Status
         list.addElement(new DataElement("StatusRackTower",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_TOWERNE_RackStatus"));
         list.addElement(new DataElement("StatusRackCryoPump",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_CRYONE_RackStatus"));
         list.addElement(new DataElement("StatusRackCryo",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_LN2NE_RackStatus"));

         // CompressAir
         list.addElement(new DataElement("CompressAirTower",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_TOWERNE_AIRP"));
         list.addElement(new DataElement("CompressAirCryo",Type.LABEL_FAILUREOK_STATUS_STRING,"VAC_CRYONE_COMPRESSAIRST"));
      }
      // UPS
      list.addElement(new DataElement("ComUps1",Type.LABEL_RACK_STATUS_STRING, UPS_CHANNELS.get(name+ "1")));
      list.addElement(new DataElement("BatteryWorkUps1",Type.LABEL_OKWORKING_STATUS_STRING, UPS_CHANNELS.get(name+"1_BATTERY_WORK")));
      list.addElement(new DataElement("BatteryLowUps1",Type.LABEL_OKLOW_STATUS_STRING, UPS_CHANNELS.get(name+"1_BATTERY_LOW")));
      list.addElement(new DataElement("ComUps2",Type.LABEL_RACK_STATUS_STRING, UPS_CHANNELS.get(name+ "2")));
      list.addElement(new DataElement("BatteryWorkUps2",Type.LABEL_OKWORKING_STATUS_STRING, UPS_CHANNELS.get(name+"2_BATTERY_WORK")));
      list.addElement(new DataElement("BatteryLowUps2",Type.LABEL_OKLOW_STATUS_STRING, UPS_CHANNELS.get(name+"2_BATTERY_LOW")));

      // Init
      Init();
   }
}




