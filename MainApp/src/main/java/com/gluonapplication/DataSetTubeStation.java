package com.gluonapplication;


public class DataSetTubeStation extends DataSet {

   public DataSetTubeStation(String name) {
      super();

      // Pressure Gauges
      list.addElement(new DataElement("PressureGa1",Type.LABEL_VALUE_STRING,"VAC_" + name + "_PR3","mbar"));
      list.addElement(new DataElement("PressureGa2",Type.LABEL_VALUE_STRING,"VAC_" + name + "_PR5","mbar"));
      list.addElement(new DataElement("PressureGa3",Type.LABEL_VALUE_STRING,"VAC_" + name + "_PR4","mbar"));
      list.addElement(new DataElement("PressureGa4",Type.LABEL_VALUE_STRING,"VAC_" + name + "_PR7","mbar"));
      list.addElement(new DataElement("PressureG21",Type.LABEL_VALUE_STRING,"VAC_" + name + "_PR2","mbar"));
      list.addElement(new DataElement("PressureG22",Type.LABEL_VALUE_STRING,"VAC_" + name + "_PR1","mbar"));
      list.addElement(new DataElement("PressureG31",Type.LABEL_VALUE_STRING,"VAC_" + name + "_PR6","mbar"));

      // Status Gauges
      list.addElement(new DataElement("StatusGa1",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_PR3SST"));
      list.addElement(new DataElement("StatusGa2",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_PR5SST"));
      list.addElement(new DataElement("StatusGa3",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_PR4SST"));
      list.addElement(new DataElement("StatusGa4",Type.CIRCLE_XGSGAUGE_STATUS_COLOR,"VAC_" + name + "_PR7ST"));
      list.addElement(new DataElement("StatusG21",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_PR2SST"));
      list.addElement(new DataElement("StatusG22",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_PR1SST"));
      list.addElement(new DataElement("StatusG31",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_PR6SST"));

      // Status RGA
      list.addElement(new DataElement("StatusGa5",Type.CIRCLE_RGA_STATUS_COLOR,"VAC_" + name + "_RGAGa5_Control"));

      // Status Valves
      list.addElement(new DataElement("StatusVa1",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_VA1ST"));
      list.addElement(new DataElement("StatusVa2",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_VA2ST"));
      list.addElement(new DataElement("StatusV21",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V21ST"));
      list.addElement(new DataElement("StatusV22",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V22ST"));
      list.addElement(new DataElement("StatusV23",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V23ST"));
      list.addElement(new DataElement("StatusV31",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V31ST"));
      list.addElement(new DataElement("StatusV32",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V32ST"));
      list.addElement(new DataElement("StatusV91",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V91ST"));
      list.addElement(new DataElement("StatusV11",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V11ST"));
      list.addElement(new DataElement("StatusV25",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V25ST"));
     
      // Status Pumps
      list.addElement(new DataElement("StatusP21",Type.RECTANGLE_PUMP_STATUS_COLOR,"VAC_" + name + "_P21ST"));
      list.addElement(new DataElement("StatusP22",Type.RECTANGLE_PUMP_STATUS_COLOR,"VAC_" + name + "_P22ST"));
      list.addElement(new DataElement("StatusP31",Type.RECTANGLE_PUMP_STATUS_COLOR,"VAC_" + name + "_P31ST"));
      list.addElement(new DataElement("StatusP32",Type.RECTANGLE_PUMP_STATUS_COLOR,"VAC_" + name + "_P32ST"));
      list.addElement(new DataElement("StatusP33",Type.RECTANGLE_PUMP_STATUS_COLOR,"VAC_" + name + "_P33ST"));   

      // Speed Pump
      list.addElement(new DataElement("SpeedP21",Type.LABEL_VALUE_STRING,"VAC_" + name + "_P21_SPEED","Hz"));

      // Init
      Init();
   }
}




