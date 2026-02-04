package com.gluonapplication;

import java.util.Vector;

public class DataSetRemotePumps extends DataSet {

   public DataSetRemotePumps(String name) {
      super();
      System.out.println(name);
      // Pressure Gauges
      list.addElement(new DataElement("PressureG1",Type.LABEL_VALUE_STRING,"VAC_" + name + "_MG1_CH1","mbar"));
      list.addElement(new DataElement("PressureG2",Type.LABEL_VALUE_STRING,"VAC_" + name + "_MG1_CH2","mbar"));
      list.addElement(new DataElement("PressureG3",Type.LABEL_VALUE_STRING,"VAC_" + name + "_MG1_CH3","mbar"));
      list.addElement(new DataElement("PressureG4",Type.LABEL_VALUE_STRING,"VAC_" + name + "_MG2_CH3","mbar"));
      list.addElement(new DataElement("PressureG5",Type.LABEL_VALUE_STRING,"VAC_" + name + "_MG2_CH4","mbar"));
      list.addElement(new DataElement("PressureGpr",Type.LABEL_VALUE_STRING,"VAC_" + name + "_MG3_CH2","mbar"));
      list.addElement(new DataElement("PressureGbs",Type.LABEL_VALUE_STRING,"VAC_" + name + "_MG3_CH4","mbar"));
      list.addElement(new DataElement("PressureGls",Type.LABEL_VALUE_STRING,"VAC_" + name + "_MG1_CH6","mbar"));
      list.addElement(new DataElement("PressureGlp",Type.LABEL_VALUE_STRING,"VAC_" + name + "_MG3_CH3","mbar"));
      list.addElement(new DataElement("PressureGsr",Type.LABEL_VALUE_STRING,"VAC_" + name + "_MG1_CH5","mbar"));
      list.addElement(new DataElement("PressureGni",Type.LABEL_VALUE_STRING,"VAC_" + name + "_MG2_CH1","mbar"));
      list.addElement(new DataElement("PressureGwi",Type.LABEL_VALUE_STRING,"VAC_" + name + "_MG3_CH5","mbar"));
      list.addElement(new DataElement("PressureGib",Type.LABEL_VALUE_STRING,"VAC_" + name + "_MG3_CH1","mbar"));
      list.addElement(new DataElement("PressureGdt",Type.LABEL_VALUE_STRING,"VAC_" + name + "_MG1_CH4","mbar"));
      list.addElement(new DataElement("PressureGmc",Type.LABEL_VALUE_STRING,"VAC_" + name + "_MG2_CH5","mbar"));
      list.addElement(new DataElement("PressureGs1",Type.LABEL_VALUE_STRING,"VAC_" + name + "_MG2_CH2","mbar"));
      list.addElement(new DataElement("PressureGs2",Type.LABEL_VALUE_STRING,"VAC_" + name + "_MG2_CH6","mbar"));

      // Status Gauges
      list.addElement(new DataElement("StatusG1",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_MG1_CH1SST"));
      list.addElement(new DataElement("StatusG2",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_MG1_CH2SST"));
      list.addElement(new DataElement("StatusG3",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_MG1_CH3SST"));
      list.addElement(new DataElement("StatusG4",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_MG2_CH3SST"));
      list.addElement(new DataElement("StatusG5",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_MG2_CH4SST"));
      list.addElement(new DataElement("StatusGpr",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_MG3_CH2SST"));
      list.addElement(new DataElement("StatusGbs",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_MG3_CH4SST"));
      list.addElement(new DataElement("StatusGls",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_MG1_CH6SST"));
      list.addElement(new DataElement("StatusGlp",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_MG3_CH3SST"));
      list.addElement(new DataElement("StatusGsr",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_MG1_CH5SST"));
      list.addElement(new DataElement("StatusGni",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_MG2_CH1SST"));
      list.addElement(new DataElement("StatusGwi",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_MG3_CH5SST"));
      list.addElement(new DataElement("StatusGib",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_MG3_CH1SST"));
      list.addElement(new DataElement("StatusGdt",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_MG1_CH4SST"));
      list.addElement(new DataElement("StatusGmc",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_MG2_CH5SST"));
      list.addElement(new DataElement("StatusGs1",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_MG2_CH2SST"));
      list.addElement(new DataElement("StatusGs2",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_MG2_CH6SST"));

      // Status Valves
      list.addElement(new DataElement("StatusV1",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V1ST"));
      list.addElement(new DataElement("StatusV2",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V2ST"));
      list.addElement(new DataElement("StatusVpr",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_VPRST"));
      list.addElement(new DataElement("StatusVls",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_VLSST"));
      list.addElement(new DataElement("StatusVbs",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_VBSST"));
      list.addElement(new DataElement("StatusVlp",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_VLPST"));
      list.addElement(new DataElement("StatusVsr",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_VSRST"));
      list.addElement(new DataElement("StatusVni",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_VNIST"));
      list.addElement(new DataElement("StatusVwi",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_VWIST"));
      list.addElement(new DataElement("StatusVib",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_VIBST"));
      list.addElement(new DataElement("StatusVdt",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_VDTST"));
      list.addElement(new DataElement("StatusVmc",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_VMCST"));
      list.addElement(new DataElement("StatusVs1",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_VS1ST"));
      list.addElement(new DataElement("StatusVs2",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_VS2ST"));
      list.addElement(new DataElement("StatusVs3",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_VS3ST"));
      list.addElement(new DataElement("StatusVb",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_VBST"));

      // Status Pumps
      list.addElement(new DataElement("StatusTP1",Type.RECTANGLE_PUMP_STATUS_COLOR,"VAC_" + name + "_TP1ST"));
      list.addElement(new DataElement("StatusTP2",Type.RECTANGLE_PUMP_STATUS_COLOR,"VAC_" + name + "_TP2ST"));
      list.addElement(new DataElement("StatusP1",Type.RECTANGLE_PUMP_STATUS_COLOR,"VAC_" + name + "_PR1ST"));
      list.addElement(new DataElement("StatusP2",Type.RECTANGLE_PUMP_STATUS_COLOR,"VAC_" + name + "_PR2ST"));

      // Init
      Init();
   }
}




