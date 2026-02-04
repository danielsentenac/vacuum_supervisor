package com.gluonapplication;

import java.util.Vector;

public class DataSetCryoLinkStation extends DataSet {

   public DataSetCryoLinkStation(String name) {
      super();

      // Pressure Gauges
      list.addElement(new DataElement("PressureGs1",Type.LABEL_VALUE_STRING,"VAC_" + name + "_Gs1","mbar"));
      list.addElement(new DataElement("PressureGs2",Type.LABEL_VALUE_STRING,"VAC_" + name + "_Gs2","mbar"));
      list.addElement(new DataElement("PressureGs3",Type.LABEL_VALUE_STRING,"VAC_" + name + "_Gs3","mbar"));
      list.addElement(new DataElement("PressureGs4",Type.LABEL_VALUE_STRING,"VAC_" + name + "_Gs4","mbar"));
      list.addElement(new DataElement("PressureGs5",Type.LABEL_VALUE_STRING,"VAC_" + name + "_Gs5","mbar"));
      if (name.equals("CRYOLINKDET")) {
         list.addElement(new DataElement("PressureG21",Type.LABEL_VALUE_STRING,"VAC_" + name.replace("DET","_DET") + "_?","mbar"));
         list.addElement(new DataElement("PressureG22",Type.LABEL_VALUE_STRING,"VAC_" + name.replace("DET","_DET") + "_PR1","mbar"));
      }
      else if (name.equals("CRYOLINKIB")) {
         list.addElement(new DataElement("PressureG21",Type.LABEL_VALUE_STRING,"VAC_" + name.replace("IB","_IB") + "_?","mbar"));
         list.addElement(new DataElement("PressureG22",Type.LABEL_VALUE_STRING,"VAC_" + name.replace("IB","_IB") + "_PR2","mbar"));
      }
      // Status Gauges
      list.addElement(new DataElement("StatusGs1",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + ""));
      list.addElement(new DataElement("StatusGs2",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + ""));
      list.addElement(new DataElement("StatusGs3",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + ""));
      list.addElement(new DataElement("StatusGs4",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + ""));
      list.addElement(new DataElement("StatusGs5",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + ""));
      if (name.equals("CRYOLINKDET")) {
         list.addElement(new DataElement("StatusG21",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name.replace("DET","_DET") + "_?"));
         list.addElement(new DataElement("StatusG22",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name.replace("DET","_DET") + "_PR1ST"));
      }
      else if (name.equals("CRYOLINKIB")) {
         list.addElement(new DataElement("StatusG21",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name.replace("IB","_IB") + "_?"));
         list.addElement(new DataElement("StatusG22",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name.replace("IB","_IB") + "_PR2ST"));
      }
     
      // Status RGA
      list.addElement(new DataElement("StatusGs6",Type.CIRCLE_RGA_STATUS_COLOR,"VAC_" + name + ""));

      // Status Valves
      list.addElement(new DataElement("StatusVs1",Type.SVGPATH_VALVE_2_STATUS_COLOR,"VAC_" + name + "_Vs1"));
      list.addElement(new DataElement("StatusVs2",Type.SVGPATH_VALVE_2_STATUS_COLOR,"VAC_" + name + "_Vs2"));
      list.addElement(new DataElement("StatusVs3",Type.SVGPATH_VALVE_2_STATUS_COLOR,"VAC_" + name + "_Vs3"));
      if (name.equals("CRYOLINKDET")) {
         list.addElement(new DataElement("StatusV21",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name.replace("DET","_DET") + "_V21ST"));
         list.addElement(new DataElement("StatusV22",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name.replace("DET","_DET") + "_V22ST"));
      }
      else if (name.equals("CRYOLINKIB")) {
         list.addElement(new DataElement("StatusV21",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name.replace("IB","_IB") + "_V21ST"));
         list.addElement(new DataElement("StatusV22",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name.replace("IB","_IB") + "_V22ST"));
      }
     
      // Status LN2 Valves
      list.addElement(new DataElement("StatusCV1",Type.SVGPATH_VALVE_3_STATUS_COLOR,"VAC_" + name + "_Z_10_DOUT",3));
      list.addElement(new DataElement("StatusCV2",Type.SVGPATH_VALVE_3_STATUS_COLOR,"VAC_" + name + "_Z_10_DOUT",2));
     
      // Status Pumps
      if (name.equals("CRYOLINKDET")) {
         list.addElement(new DataElement("StatusP21",Type.RECTANGLE_PUMP_STATUS_COLOR,"VAC_" + name.replace("DET","_DET") + "_P21ST"));
         list.addElement(new DataElement("StatusP22",Type.RECTANGLE_PUMP_STATUS_COLOR,"VAC_" + name.replace("DET","_DET") + "_P22ST"));
         list.addElement(new DataElement("SpeedP21",Type.LABEL_VALUE_STRING,"VAC_" + name.replace("DET","_DET") + "_P21_SPEED","Hz"));
      }
      else if (name.equals("CRYOLINKIB")) {
         list.addElement(new DataElement("StatusP21",Type.RECTANGLE_PUMP_STATUS_COLOR,"VAC_" + name.replace("IB","_IB") + "_P21ST"));
         list.addElement(new DataElement("StatusP22",Type.RECTANGLE_PUMP_STATUS_COLOR,"VAC_" + name.replace("IB","_IB") + "_P22ST"));
         list.addElement(new DataElement("SpeedP21",Type.LABEL_VALUE_STRING,"VAC_" + name.replace("IB","_IB") + "_P21_SPEED","Hz"));
      }
     
      // Cryo instruments
      list.addElement(new DataElement("TemperatureTF",Type.LABEL_VALUE_2F_STRING,"VAC_" + name + "_TF","K"));
      list.addElement(new DataElement("TemperatureTN",Type.LABEL_VALUE_2F_STRING,"VAC_" + name + "_TN","K"));
      list.addElement(new DataElement("TemperatureTL",Type.LABEL_VALUE_2F_STRING,"VAC_" + name + "_TL","K"));
      list.addElement(new DataElement("TemperatureT1",Type.LABEL_VALUE_2F_STRING,"VAC_" + name + "_T1","K"));
      list.addElement(new DataElement("TemperatureT2",Type.LABEL_VALUE_2F_STRING,"VAC_" + name + "_T2","K"));
      list.addElement(new DataElement("TemperatureT3",Type.LABEL_VALUE_2F_STRING,"VAC_" + name + "_T3","K"));
      list.addElement(new DataElement("TemperatureT4",Type.LABEL_VALUE_2F_STRING,"VAC_" + name + "_T4","K"));
      list.addElement(new DataElement("TemperatureT5",Type.LABEL_VALUE_2F_STRING,"VAC_" + name + "_T5","K"));
      list.addElement(new DataElement("TemperatureT6",Type.LABEL_VALUE_2F_STRING,"VAC_" + name + "_T6","K"));
      list.addElement(new DataElement("TemperatureT7",Type.LABEL_VALUE_2F_STRING,"VAC_" + name + "_T7","K"));
      list.addElement(new DataElement("TemperatureT8",Type.LABEL_VALUE_2F_STRING,"VAC_" + name + "_T8","K"));
      list.addElement(new DataElement("TemperatureT12",Type.LABEL_VALUE_2F_STRING,"VAC_" + name + "_T12","K"));
      list.addElement(new DataElement("StatusLevel",Type.ELLIPSE_FILL_LEVEL,"VAC_" + name + "_LEVEL","",0,350));
      list.addElement(new DataElement("Level",Type.LABEL_VALUE_2F_STRING,"VAC_" + name + "_LEVEL"));

      // Extra channel needed to set bit  0/1/2/3 for Vs1/Vs2/CV2/CV1
      list.addElement(new DataElement(name + "_Z_10_DOUT",Type.LABEL_VALUE_STRING,"VAC_" + name + "_Z_10_DOUT"));

      // Init
      Init();
   }
}




