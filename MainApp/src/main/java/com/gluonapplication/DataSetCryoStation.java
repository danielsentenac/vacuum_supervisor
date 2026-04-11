package com.gluonapplication;


public class DataSetCryoStation extends DataSet {

   public DataSetCryoStation(String name) {
      super();

      // Pressure Gauges
      list.addElement(new DataElement("PressureG22",Type.LABEL_VALUE_STRING,"VAC_" + name + "_MG1_CH1","mbar"));
      list.addElement(new DataElement("PressureG31e",Type.LABEL_VALUE_STRING,"VAC_" + name + "_MG1_CH2","mbar"));
      list.addElement(new DataElement("PressureGe3",Type.LABEL_VALUE_STRING,"VAC_" + name + "_MG1_CH3","mbar"));
      list.addElement(new DataElement("PressureG31i",Type.LABEL_VALUE_STRING,"VAC_" + name + "_MG1_CH4","mbar"));
      list.addElement(new DataElement("PressureG21",Type.LABEL_VALUE_STRING,"VAC_" + name + "_MG2_CH1","mbar"));
      list.addElement(new DataElement("PressureGe1",Type.LABEL_VALUE_STRING,"VAC_" + name + "_MG2_CH2","mbar"));
      list.addElement(new DataElement("PressureGe2",Type.LABEL_VALUE_STRING,"VAC_" + name + "_MG2_CH3","mbar"));

      // Status Gauges
      list.addElement(new DataElement("StatusG22",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_MG1_CH1SST"));
      list.addElement(new DataElement("StatusG31e",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_MG1_CH2SST"));
      list.addElement(new DataElement("StatusGe3",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_MG1_CH3SST"));
      list.addElement(new DataElement("StatusG31i",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_MG1_CH4SST"));
      list.addElement(new DataElement("StatusG21",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_MG2_CH1SST"));
      list.addElement(new DataElement("StatusGe1",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_MG2_CH2SST"));
      list.addElement(new DataElement("StatusGe2",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_MG2_CH3SST"));

      // Status RGA
      list.addElement(new DataElement("StatusGe4",Type.CIRCLE_RGA_STATUS_COLOR,"VAC_" + name + "_RGAGe4_Control"));

      // Status Valves
      list.addElement(new DataElement("StatusV21",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V21ST"));
      list.addElement(new DataElement("StatusV22",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V22ST"));
      list.addElement(new DataElement("StatusV23",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V23ST"));
      list.addElement(new DataElement("StatusVCryo",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_VCRYOST"));
      list.addElement(new DataElement("StatusV1",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V1ST"));
      list.addElement(new DataElement("StatusVe1",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_VE1ST"));
      list.addElement(new DataElement("StatusVe2",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_VE2ST"));
      list.addElement(new DataElement("StatusV23",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V23ST"));
      list.addElement(new DataElement("StatusV31i",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V31IST"));
      list.addElement(new DataElement("StatusV31e",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V31EST"));
      list.addElement(new DataElement("StatusV32i",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V32IST"));
      list.addElement(new DataElement("StatusV32e",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V32EST"));
     
      // Status Pumps
      list.addElement(new DataElement("StatusP1",Type.RECTANGLE_PUMP_STATUS_COLOR,"VAC_" + name + "_P1ST"));
      list.addElement(new DataElement("StatusP2",Type.RECTANGLE_PUMP_STATUS_COLOR,"VAC_" + name + "_P2ST"));
      list.addElement(new DataElement("StatusP33i",Type.RECTANGLE_PUMP_STATUS_COLOR,"VAC_" + name + "_P33IST"));
      list.addElement(new DataElement("StatusP33e",Type.RECTANGLE_PUMP_STATUS_COLOR,"VAC_" + name + "_P33EST"));
      list.addElement(new DataElement("StatusP31i",Type.RECTANGLE_PUMP_STATUS_COLOR,"VAC_" + name + "_P31ICONTROLST"));
      list.addElement(new DataElement("StatusP32i",Type.RECTANGLE_PUMP_STATUS_COLOR,"VAC_" + name + "_P32ICONTROLST"));
      list.addElement(new DataElement("StatusP31e",Type.RECTANGLE_PUMP_STATUS_COLOR,"VAC_" + name + "_P31ECONTROLST"));
      list.addElement(new DataElement("StatusP32e",Type.RECTANGLE_PUMP_STATUS_COLOR,"VAC_" + name + "_P32ECONTROLST"));

      // Speed Pump
      list.addElement(new DataElement("SpeedP2",Type.LABEL_VALUE_STRING,"VAC_" + name + "_P2_SPEED","Hz"));
     
      // Cryo instruments
      name = name.replace("CRYO","LN2");
      list.addElement(new DataElement("TemperatureTT04",Type.LABEL_VALUE_2F_STRING,"VAC_" + name + "_TT04_CL_BOTMID","°C"));
      list.addElement(new DataElement("TemperatureTT05",Type.LABEL_VALUE_2F_STRING,"VAC_" + name + "_TT05_CL_MIDMID","°C"));
      list.addElement(new DataElement("TemperatureTT06",Type.LABEL_VALUE_2F_STRING,"VAC_" + name + "_TT06_CL_TOPMID","°C"));
      list.addElement(new DataElement("TemperatureTT07",Type.LABEL_VALUE_2F_STRING,"VAC_" + name + "_TT07_HEATER_OUT","°C"));
      list.addElement(new DataElement("PressurePT02",Type.LABEL_VALUE_2F_STRING,"VAC_" + name + "_PT02_CL_LEVEL","mbar"));
      list.addElement(new DataElement("PressurePT01",Type.LABEL_VALUE_2F_STRING,"VAC_" + name + "_PT01_GAS_OUTLET","mbar"));
      list.addElement(new DataElement("LevelCV01",Type.SVGPATH_FILL_LEVEL,"VAC_" + name + "_CV01","",0,100));
      list.addElement(new DataElement("LevelCV02",Type.SVGPATH_FILL_LEVEL,"VAC_" + name + "_CV02","",0,100));
      list.addElement(new DataElement("StatusLevelCryo",Type.ELLIPSE_FILL_LEVEL,"VAC_" + name + "_PT02_CL_LEVEL","",0,86.6));
      list.addElement(new DataElement("StatusLevelPS",Type.RECTANGLE_FILL_LEVEL,"VAC_" + name + "_LT01_PS_LEVEL","",0,100));
      list.addElement(new DataElement("LevelLT01",Type.LABEL_VALUE_2F_STRING,"VAC_" + name + "_LT01_PS_LEVEL","%"));

      // External data
      String valvebigname = name.replace("LN2","VALVEBIG") + "_CRYO_TEMP";
      list.addElement(new DataElement("TemperatureInput",Type.LABEL_VALUE_2F_STRING,"VAC_" + valvebigname,"°C"));

      // Init
      Init();
   }
}




