package com.gluonapplication;

import java.util.Vector;

public class DataSetTowerBenchStation extends DataSet {

   public DataSetTowerBenchStation(String name) {
      super();
      // Pressure Gauges
      list.addElement(new DataElement("PressureG41",Type.LABEL_VALUE_STRING,"VAC_" + name + "_MG1_CH1","mbar"));
      list.addElement(new DataElement("PressureGc1",Type.LABEL_VALUE_STRING,"VAC_" + name + "_MG1_CH2","mbar"));
      list.addElement(new DataElement("PressureGc2",Type.LABEL_VALUE_STRING,"VAC_" + name + "_MG1_CH3","mbar"));
      list.addElement(new DataElement("PressureG51",Type.LABEL_VALUE_STRING,"VAC_" + name + "_MG1_CH4","mbar"));
      list.addElement(new DataElement("PressureG61",Type.LABEL_VALUE_STRING,"VAC_" + name + "_MG1_CH5","mbar"));
      list.addElement(new DataElement("PressureGc3",Type.LABEL_VALUE_STRING,"VAC_" + name + "_GC3","mbar"));

      // Status Gauges
      list.addElement(new DataElement("StatusG41",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_MG1_CH1SST"));
      list.addElement(new DataElement("StatusGc1",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_MG1_CH2SST"));
      list.addElement(new DataElement("StatusGc2",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_MG1_CH3SST"));
      list.addElement(new DataElement("StatusG51",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_MG1_CH4SST"));
      list.addElement(new DataElement("StatusG61",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_MG1_CH5SST"));
      list.addElement(new DataElement("StatusGc3",Type.CIRCLE_ITRGAUGE_STATUS_COLOR,"VAC_" + name + "_GC3EST"));

      // Status RGA
      list.addElement(new DataElement("StatusGc4",Type.CIRCLE_RGA_STATUS_COLOR,"VAC_" + name + "_RGAGc4_Control"));

      // Status Valves
      list.addElement(new DataElement("StatusVc1",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_Vc1ST"));
      list.addElement(new DataElement("StatusVc2",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_Vc2ST"));
      list.addElement(new DataElement("StatusV41",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V41ST"));
      list.addElement(new DataElement("StatusV42",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V42ST"));
      list.addElement(new DataElement("StatusV51",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V51ST"));
      list.addElement(new DataElement("StatusV52",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V52ST"));
      list.addElement(new DataElement("StatusV53",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V53ST"));
      list.addElement(new DataElement("StatusV91",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V91ST"));
      list.addElement(new DataElement("StatusV92",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_V92ST"));
     
      // Status Pumps
      list.addElement(new DataElement("StatusP41",Type.RECTANGLE_PUMP_STATUS_COLOR,"VAC_" + name + "_P41ST"));
      list.addElement(new DataElement("StatusP61",Type.RECTANGLE_PUMP_STATUS_COLOR,"VAC_" + name + "_P61ST"));
      list.addElement(new DataElement("StatusP51",Type.RECTANGLE_PUMP_STATUS_COLOR,"VAC_" + name + "_P51ST"));

      // Speed Pump
      list.addElement(new DataElement("SpeedP51",Type.LABEL_VALUE_STRING,"VAC_" + name + "_P51_SPEED","Hz"));


      // Venting
      if (name.equals("TOWERIB")) {
         list.addElement(new DataElement("Flow",Type.LABEL_VALUE_STRING,"VAC_CB1_TOIB_AIRFLOW","L/s"));
         list.addElement(new DataElement("Temperature",Type.LABEL_VALUE_STRING,"VAC_CB1_TOIB_TEMPERATURE","°C"));
         list.addElement(new DataElement("Humidity",Type.LABEL_VALUE_STRING,"VAC_CB1_TOIB_HUMIDITY","%RH"));
         list.addElement(new DataElement("Venting",Type.RECTANGLE_VENTING_STATUS_COLOR,"VAC_CB1_TOIB_AIRFLOW"));
         list.addElement(new DataElement("RemotePumpingStatus",Type.RECTANGLE_REMOTE_PUMPING_STATUS_COLOR,"VAC_REMOTESCROLL_VIBST"));
      }
      if (name.equals("TOWERDET")) {
         list.addElement(new DataElement("Flow",Type.LABEL_VALUE_STRING,"VAC_CB2_TODET_AIRFLOW","L/s"));
         list.addElement(new DataElement("Temperature",Type.LABEL_VALUE_STRING,"VAC_CB2_TODET_TEMPERATURE","°C"));
         list.addElement(new DataElement("Humidity",Type.LABEL_VALUE_STRING,"VAC_CB2_TODET_HUMIDITY","%RH"));
         list.addElement(new DataElement("Venting",Type.RECTANGLE_VENTING_STATUS_COLOR,"VAC_CB2_TODET_AIRFLOW"));
         list.addElement(new DataElement("RemotePumpingStatus",Type.RECTANGLE_REMOTE_PUMPING_STATUS_COLOR,"VAC_REMOTESCROLL_VDTST"));

         // Status RGA Hiden Det put on LINK rack
         list.addElement(new DataElement("StatusGc4",Type.CIRCLE_RGA_2_STATUS_COLOR,"VAC_LINK_DET_RGAGc4_RUNNING"));
      }
      
      // Init
      Init();
   }
}




