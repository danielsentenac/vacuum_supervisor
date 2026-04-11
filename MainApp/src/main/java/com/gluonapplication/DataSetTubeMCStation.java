package com.gluonapplication;


public class DataSetTubeMCStation extends DataSet {

   public DataSetTubeMCStation(String name) {
      super();

      // Pressure Gauges
      list.addElement(new DataElement("PressureG21",Type.LABEL_VALUE_STRING,"VAC_" + name + "_PR2","mbar"));
      list.addElement(new DataElement("PressureG22",Type.LABEL_VALUE_STRING,"VAC_" + name + "_PR1","mbar"));

      // Status Gauges
      list.addElement(new DataElement("StatusG21",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_PR2SST"));
      list.addElement(new DataElement("StatusG22",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_PR1SST"));


      // Status Valves
      list.addElement(new DataElement("StatusV21",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V21ST"));
      list.addElement(new DataElement("StatusV22",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V22ST"));
      list.addElement(new DataElement("StatusV23",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V23ST"));
     
      // Status Pumps
      list.addElement(new DataElement("StatusP21",Type.RECTANGLE_PUMP_STATUS_COLOR,"VAC_" + name + "_P21ST"));
      list.addElement(new DataElement("StatusP22",Type.RECTANGLE_PUMP_STATUS_COLOR,"VAC_" + name + "_P22ST"));

      // Speed Pump
      list.addElement(new DataElement("SpeedP21",Type.LABEL_VALUE_STRING,"VAC_" + name + "_P21_SPEED","Hz"));

      // Remote Pumping
      list.addElement(new DataElement("RemotePumpingStatus",Type.RECTANGLE_REMOTE_PUMPING_STATUS_COLOR,"VAC_REMOTESCROLL_VMCST"));
      // Init
      Init();
   }
}




