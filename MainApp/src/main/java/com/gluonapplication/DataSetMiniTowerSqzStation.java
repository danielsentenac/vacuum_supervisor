package com.gluonapplication;

import java.util.Vector;

public class DataSetMiniTowerSqzStation extends DataSet {

   public DataSetMiniTowerSqzStation(String name) {
      super();

      // Pressure Gauges
      list.addElement(new DataElement("PressureGe1",Type.LABEL_VALUE_STRING,"VAC_" + name + "_PR3","mbar"));
      list.addElement(new DataElement("PressureGe2",Type.LABEL_VALUE_STRING,"VAC_" + name + "_PR5","mbar"));
      list.addElement(new DataElement("PressureGe3",Type.LABEL_VALUE_STRING,"VAC_" + name + "_PR4","mbar"));
      list.addElement(new DataElement("PressureG21",Type.LABEL_VALUE_STRING,"VAC_" + name + "_PR2","mbar"));
      list.addElement(new DataElement("PressureG22",Type.LABEL_VALUE_STRING,"VAC_" + name + "_PR1","mbar"));
      list.addElement(new DataElement("PressureGP",Type.LABEL_VALUE_STRING,"VAC_" + name + "_PR6","mbar"));

      // Status Gauges
      list.addElement(new DataElement("StatusGe1",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_PR3SST"));
      list.addElement(new DataElement("StatusGe2",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_PR5SST"));
      list.addElement(new DataElement("StatusGe3",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_PR4SST"));
      list.addElement(new DataElement("StatusG21",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_PR2SST"));
      list.addElement(new DataElement("StatusG22",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_PR1SST"));
      list.addElement(new DataElement("StatusGP",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_PR6SST"));


      // Status RGA
      list.addElement(new DataElement("StatusGe4",Type.CIRCLE_RGA_STATUS_COLOR,"VAC_" + name + "_RGAGe4_Control"));

      // Status Valves
      list.addElement(new DataElement("StatusVe1",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_VE1ST"));
      list.addElement(new DataElement("StatusVe2",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_VE2ST"));
      list.addElement(new DataElement("StatusV1",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V1ST"));
      list.addElement(new DataElement("StatusV21",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V21ST"));
      list.addElement(new DataElement("StatusV22",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V22ST"));
      list.addElement(new DataElement("StatusV23",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V23ST"));
      list.addElement(new DataElement("StatusV24",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V24ST")); // VENT VALVE
      list.addElement(new DataElement("StatusV25",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V24ST")); // SOFT VENT VALVE
      list.addElement(new DataElement("StatusVP",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_VPST"));
      if ( name.equals("SQZDET2")) // SQZDET1 spare valve connected to SQZDET2 station (VREM)
         list.addElement(new DataElement("StatusVrem",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + "SQZDET1" + "_VSPAREST"));
      else
         list.addElement(new DataElement("StatusVrem",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_VSPAREST"));
     
      // Status Pumps
      list.addElement(new DataElement("StatusP21",Type.RECTANGLE_PUMP_STATUS_COLOR,"VAC_" + name + "_P21ST"));
      list.addElement(new DataElement("StatusP22",Type.RECTANGLE_PUMP_STATUS_COLOR,"VAC_" + name + "_P22ST"));

      // Speed Pump
      list.addElement(new DataElement("SpeedP21",Type.LABEL_VALUE_STRING,"VAC_" + name + "_P21_SPEED","Hz"));

      // Status RGA
      list.addElement(new DataElement("StatusGe4",Type.CIRCLE_RGA_2_STATUS_COLOR,"VAC_" + name + "_RGAGe4_RUNNING"));

      // Init
      Init();
   }
}




