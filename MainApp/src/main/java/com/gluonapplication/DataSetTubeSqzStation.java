package com.gluonapplication;

import java.util.Vector;

public class DataSetTubeSqzStation extends DataSet {

   public DataSetTubeSqzStation(String name) {
      super();

      // Pressure Gauges
      list.addElement(new DataElement("PressureGa1",Type.LABEL_VALUE_STRING,"VAC_" + name + "_PR3","mbar"));
      list.addElement(new DataElement("PressureGa2",Type.LABEL_VALUE_STRING,"VAC_" + name + "_PR5","mbar"));
      list.addElement(new DataElement("PressureGa3",Type.LABEL_VALUE_STRING,"VAC_" + name + "_PR4","mbar"));
      list.addElement(new DataElement("PressureG21",Type.LABEL_VALUE_STRING,"VAC_" + name + "_PR2","mbar"));
      list.addElement(new DataElement("PressureG22",Type.LABEL_VALUE_STRING,"VAC_" + name + "_PR1","mbar"));

      // Status Gauges
      list.addElement(new DataElement("StatusGa1",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_PR3SST"));
      list.addElement(new DataElement("StatusGa2",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_PR5SST"));
      list.addElement(new DataElement("StatusGa3",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_PR4SST"));
      list.addElement(new DataElement("StatusG21",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_PR2SST"));
      list.addElement(new DataElement("StatusG22",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_PR1SST"));


      // Status Valves
      list.addElement(new DataElement("StatusVa1",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_VA1ST"));
      list.addElement(new DataElement("StatusVa2",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_VA2ST"));
      list.addElement(new DataElement("StatusV21",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V21ST"));
      list.addElement(new DataElement("StatusV22",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V22ST"));
      list.addElement(new DataElement("StatusV23",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V23ST"));
     
      // Status Pumps
      list.addElement(new DataElement("StatusP21",Type.RECTANGLE_PUMP_STATUS_COLOR,"VAC_" + name + "_P21ST"));
      list.addElement(new DataElement("StatusP22",Type.RECTANGLE_PUMP_STATUS_COLOR,"VAC_" + name + "_P22ST"));

      // Speed Pump
      list.addElement(new DataElement("SpeedP21",Type.LABEL_VALUE_STRING,"VAC_" + name + "_P21_SPEED","Hz"));

      // Init
      Init();
   }
}




