package com.gluonapplication;

public class DataSetVenting1 extends DataSet {

   public DataSetVenting1(String name) {
      super();

      String prefix = "VAC_" + name;

      // Gauges
      list.addElement(new DataElement("PressureG1", Type.LABEL_VALUE_2E_STRING, prefix + "_MG_PR1", "mbar"));
      list.addElement(new DataElement("PressureG2", Type.LABEL_VALUE_2E_STRING, prefix + "_MG_PR2", "mbar"));
      list.addElement(new DataElement("StatusG1", Type.CIRCLE_GAUGE_STATUS_COLOR, prefix + "_MG_PR1SST"));
      list.addElement(new DataElement("StatusG2", Type.CIRCLE_GAUGE_STATUS_COLOR, prefix + "_MG_PR2SST"));

      // MKS flow controllers
      list.addElement(new DataElement("FlowMKS2000", Type.LABEL_VALUE_2F_STRING, prefix + "_MKS2000_FLOW", "sccm"));
      list.addElement(new DataElement("FlowMKS50000", Type.LABEL_VALUE_2F_STRING, prefix + "_MKS50000_FLOW", "sccm"));

      // Valve statuses
      list.addElement(new DataElement("StatusVBypass", Type.SVGPATH_VALVE_STATUS_COLOR, prefix + "_M1_VBYPASSST"));
      list.addElement(new DataElement("StatusVRP", Type.SVGPATH_VALVE_STATUS_COLOR, prefix + "_M1_VRPST"));
      list.addElement(new DataElement("StatusVDryer", Type.SVGPATH_VALVE_STATUS_COLOR, prefix + "_M1_VDRYERST"));
      list.addElement(new DataElement("StatusV1", Type.SVGPATH_VALVE_STATUS_COLOR, prefix + "_M1_V1ST"));
      list.addElement(new DataElement("StatusVMain", Type.SVGPATH_VALVE_STATUS_COLOR, prefix + "_M1_VENTST"));
      list.addElement(new DataElement("StatusVSoft", Type.SVGPATH_VALVE_STATUS_COLOR, prefix + "_M1_VENTST"));

      // Pump status
      list.addElement(new DataElement("StatusP1", Type.RECTANGLE_PUMP_STATUS_COLOR, prefix + "_M1_P1ST"));

      // Init
      Init();
   }
}
