package com.gluonapplication;


public class DataSetLinkStation extends DataSet {

   public DataSetLinkStation(String name) {
      super();

      if (name.contains("PR")) {
         // Pressure Gauges
         list.addElement(new DataElement("PressureG21",Type.LABEL_VALUE_STRING,"VAC_LINK_PR3","mbar"));
         list.addElement(new DataElement("PressureG22",Type.LABEL_VALUE_STRING,"VAC_LINK_PR1","mbar"));

         // Status Gauges
         list.addElement(new DataElement("StatusG21",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_LINK_PR3SST"));
         list.addElement(new DataElement("StatusG22",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_LINK_PR1SST"));

         // Status Valves
         list.addElement(new DataElement("StatusV21",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_LINK_PR_V21ST"));
         list.addElement(new DataElement("StatusV22",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_LINK_PR_V22ST"));
         list.addElement(new DataElement("StatusV23",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_LINK_PR_V23ST"));
     
         // Status Pumps
         list.addElement(new DataElement("StatusP21",Type.RECTANGLE_PUMP_STATUS_COLOR,"VAC_LINK_PR_P21ST"));
         list.addElement(new DataElement("StatusP22",Type.RECTANGLE_PUMP_STATUS_COLOR,"VAC_LINK_PR_P22ST"));

         // Speed Pump
         list.addElement(new DataElement("SpeedP21",Type.LABEL_VALUE_STRING,"VAC_LINK_PR_P21_SPEED","Hz"));

         //Remote Pumping
         list.addElement(new DataElement("RemotePumpingStatus",Type.RECTANGLE_REMOTE_PUMPING_STATUS_COLOR,"VAC_REMOTESCROLL_VLPST"));
         
         // Status RGA
         list.addElement(new DataElement("StatusGe4",Type.CIRCLE_RGA_2_STATUS_COLOR,"VAC_LINK_PR_RGAGe4_RUNNING"));
      }
      else if (name.contains("SR")) {
         // Pressure Gauges
         list.addElement(new DataElement("PressureG21",Type.LABEL_VALUE_STRING,"VAC_LINK_PR4","mbar"));
         list.addElement(new DataElement("PressureG22",Type.LABEL_VALUE_STRING,"VAC_LINK_PR2","mbar"));

         // Status Gauges
         list.addElement(new DataElement("StatusG21",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_LINK_PR4SST"));
         list.addElement(new DataElement("StatusG22",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_LINK_PR2SST"));

         // Status Valves
         list.addElement(new DataElement("StatusV21",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_LINK_SR_V21ST"));
         list.addElement(new DataElement("StatusV22",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_LINK_SR_V22ST"));
         list.addElement(new DataElement("StatusV23",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_LINK_SR_V23ST"));
     
         // Status Pumps
         list.addElement(new DataElement("StatusP21",Type.RECTANGLE_PUMP_STATUS_COLOR,"VAC_LINK_SR_P21ST"));
         list.addElement(new DataElement("StatusP22",Type.RECTANGLE_PUMP_STATUS_COLOR,"VAC_LINK_SR_P22ST"));

         // Speed Pump
         list.addElement(new DataElement("SpeedP21",Type.LABEL_VALUE_STRING,"VAC_LINK_SR_P21_SPEED","Hz"));

         //Remote Pumping
         list.addElement(new DataElement("RemotePumpingStatus",Type.RECTANGLE_REMOTE_PUMPING_STATUS_COLOR,"VAC_REMOTESCROLL_VLSST"));
      }

      // Init
      Init();
   }
}




