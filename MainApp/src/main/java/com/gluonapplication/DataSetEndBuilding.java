package com.gluonapplication;

import java.util.Vector;

public class DataSetEndBuilding extends DataSet {

   public DataSetEndBuilding(String name) {
      super();

      if ( name.equals("WE")) {

         // Pressure & status Gauges
         list.addElement(new DataElement("PressureTower",Type.LABEL_VALUE_STRING,"VAC_TOWERWE_MG2_CH2","mbar"));
         list.addElement(new DataElement("StatusSensorTower",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_TOWERWE_MG2_CH2SST"));
         list.addElement(new DataElement("PressureMiniTower",Type.LABEL_VALUE_STRING,"VAC_TOWERWE_MG2_CH6","mbar"));
         list.addElement(new DataElement("PressureCryo",Type.LABEL_VALUE_STRING,"VAC_CRYOWE_MG1_CH3","mbar"));
         list.addElement(new DataElement("StatusSensorCryo",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_CRYOWE_MG1_CH3SST"));

         // Valves Status
         list.addElement(new DataElement("StatusVCryoWE",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_CRYOWE_VCRYOST"));
         list.addElement(new DataElement("StatusVWE",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_VALVEBIGWE_ST"));

         // Rack Status
         list.addElement(new DataElement("TowerWE",Type.LABEL_RACK_STATUS_COLOR,"VAC_TOWERWE_RackStatus"));
         list.addElement(new DataElement("CryoWE",Type.LABEL_RACK_STATUS_COLOR,"VAC_CRYOWE_RackStatus"));
      }
      else if ( name.equals("NE")) {

         // Pressure Gauges
         list.addElement(new DataElement("PressureTower",Type.LABEL_VALUE_STRING,"VAC_TOWERNE_GD3","mbar"));
         list.addElement(new DataElement("StatusSensorTower",Type.CIRCLE_XGSGAUGE_STATUS_COLOR,"VAC_TOWERNE_GD3EST"));
         list.addElement(new DataElement("PressureMiniTower",Type.LABEL_VALUE_STRING,"VAC_TOWERNE_MG2_CH6","mbar"));
         list.addElement(new DataElement("PressureCryo",Type.LABEL_VALUE_STRING,"VAC_CRYONE_MG1_CH3","mbar"));
         list.addElement(new DataElement("StatusSensorCryo",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_CRYONE_MG1_CH3SST"));

         // Valves Status
         list.addElement(new DataElement("StatusVCryoNE",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_CRYONE_VCRYOST"));
         list.addElement(new DataElement("StatusVNE",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_VALVEBIGNE_ST"));

         // Rack Status
         list.addElement(new DataElement("TowerNE",Type.LABEL_RACK_STATUS_COLOR,"VAC_TOWERNE_RackStatus"));
         list.addElement(new DataElement("CryoNE",Type.LABEL_RACK_STATUS_COLOR,"VAC_CRYONE_RackStatus"));
         list.addElement(new DataElement("Tiltmeter",Type.LABEL_RACK_STATUS_COLOR,"VAC_TILTMETER_RackStatus"));
      }
      // Init
      Init();
   }
}




