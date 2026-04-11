package com.gluonapplication;


public class DataSetTube extends DataSet {

   public DataSetTube(String name) {
      super();

      if ( name.equals("TUBEW")) {
         // Pressure & status Gauges
         list.addElement(new DataElement("Pressure3000W",Type.LABEL_VALUE_STRING,"VAC_TUBELAL3000W_Ga4","mbar"));
         list.addElement(new DataElement("StatusSensor3000W",Type.CIRCLE_XGSGAUGE_STATUS_COLOR,"VAC_TUBELAL3000W_Ga4ST"));
         list.addElement(new DataElement("Pressure2400W",Type.LABEL_VALUE_STRING,"VAC_TUBELAL2400W_Ga4","mbar"));
         list.addElement(new DataElement("StatusSensor2400W",Type.CIRCLE_XGSGAUGE_STATUS_COLOR,"VAC_TUBELAL2400W_Ga4ST"));
         list.addElement(new DataElement("Pressure1800W",Type.LABEL_VALUE_STRING,"VAC_TUBELAL1800W_Ga4","mbar"));
         list.addElement(new DataElement("StatusSensor1800W",Type.CIRCLE_XGSGAUGE_STATUS_COLOR,"VAC_TUBELAL1800W_Ga4ST"));
         list.addElement(new DataElement("Pressure1200W",Type.LABEL_VALUE_STRING,"VAC_TUBELAL1200W_Ga4","mbar"));
         list.addElement(new DataElement("StatusSensor1200W",Type.CIRCLE_XGSGAUGE_STATUS_COLOR,"VAC_TUBELAL1200W_Ga4ST"));
         list.addElement(new DataElement("Pressure600W",Type.LABEL_VALUE_STRING,"VAC_TUBELAL600W_Ga4","mbar"));
         list.addElement(new DataElement("StatusSensor600W",Type.CIRCLE_XGSGAUGE_STATUS_COLOR,"VAC_TUBELAL600W_Ga4ST"));
         list.addElement(new DataElement("Pressure300W",Type.LABEL_VALUE_STRING,"VAC_TUBE300W_PR7","mbar"));
         list.addElement(new DataElement("StatusSensor300W",Type.CIRCLE_XGSGAUGE_STATUS_COLOR,"VAC_TUBE300W_PR7SST"));
         list.addElement(new DataElement("Pressure2100W",Type.LABEL_VALUE_STRING,"VAC_TUBE2100W_PR7","mbar"));

         // Valves Status
         list.addElement(new DataElement("StatusV3000W",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_TUBELAL3000W_V21ST"));
         list.addElement(new DataElement("StatusV2400W",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_TUBELAL2400W_V21ST"));
         list.addElement(new DataElement("StatusV1800W",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_TUBELAL1800W_V21ST"));
         list.addElement(new DataElement("StatusV1200W",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_TUBELAL1200W_V21ST"));
         list.addElement(new DataElement("StatusV600W",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_TUBELAL600W_V21ST"));
         list.addElement(new DataElement("StatusV300W",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_TUBE300W_V21ST"));
         list.addElement(new DataElement("StatusVWI",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_VALVEBIGWI_ST"));
         list.addElement(new DataElement("StatusVWE",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_VALVEBIGWE_ST"));
         list.addElement(new DataElement("StatusV3000W1",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_TUBELAL3000W_V31ST"));
         list.addElement(new DataElement("StatusV2400W1",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_TUBELAL2400W_V31ST"));
         list.addElement(new DataElement("StatusV1800W1",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_TUBELAL1800W_V31ST"));
         list.addElement(new DataElement("StatusV1200W1",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_TUBELAL1200W_V31ST"));
         list.addElement(new DataElement("StatusV600W1",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_TUBELAL600W_V31ST"));
         list.addElement(new DataElement("StatusV300W1",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_TUBE300W_V31ST"));

         // RGA Status
         list.addElement(new DataElement("StatusGe4_1500W",Type.CIRCLE_RGA_2_STATUS_COLOR,"VAC_RGA1500W_RGAGe4_RUNNING"));
         
         
         // Rack Status
         list.addElement(new DataElement("Station3000W",Type.LABEL_RACK_STATUS_COLOR,"VAC_TUBELAL3000W_RackStatus"));
         list.addElement(new DataElement("Station2400W",Type.LABEL_RACK_STATUS_COLOR,"VAC_TUBELAL2400W_RackStatus"));
         list.addElement(new DataElement("Station1800W",Type.LABEL_RACK_STATUS_COLOR,"VAC_TUBELAL1800W_RackStatus"));
         list.addElement(new DataElement("Station1200W",Type.LABEL_RACK_STATUS_COLOR,"VAC_TUBELAL1200W_RackStatus"));
         list.addElement(new DataElement("Station600W",Type.LABEL_RACK_STATUS_COLOR,"VAC_TUBELAL600W_RackStatus"));
         list.addElement(new DataElement("Station300W",Type.LABEL_RACK_STATUS_COLOR,"VAC_TUBE300W_RackStatus"));
      }
      else if ( name.equals("TUBEN")) {
         // Pressure Gauges
         list.addElement(new DataElement("Pressure3000N",Type.LABEL_VALUE_STRING,"VAC_TUBELAL3000N_Ga4","mbar"));
         list.addElement(new DataElement("StatusSensor3000N",Type.CIRCLE_XGSGAUGE_STATUS_COLOR,"VAC_TUBELAL3000N_Ga4ST"));
         list.addElement(new DataElement("Pressure2400N",Type.LABEL_VALUE_STRING,"VAC_TUBELAL2400N_Ga4","mbar"));
         list.addElement(new DataElement("StatusSensor2400N",Type.CIRCLE_XGSGAUGE_STATUS_COLOR,"VAC_TUBELAL2400N_Ga4ST"));
         list.addElement(new DataElement("Pressure1800N",Type.LABEL_VALUE_STRING,"VAC_TUBELAL1800N_Ga4","mbar"));
         list.addElement(new DataElement("StatusSensor1800N",Type.CIRCLE_XGSGAUGE_STATUS_COLOR,"VAC_TUBELAL1800N_Ga4ST"));
         list.addElement(new DataElement("Pressure1200N",Type.LABEL_VALUE_STRING,"VAC_TUBELAL1200N_Ga4","mbar"));
         list.addElement(new DataElement("StatusSensor1200N",Type.CIRCLE_XGSGAUGE_STATUS_COLOR,"VAC_TUBELAL1200N_Ga4ST"));
         list.addElement(new DataElement("Pressure600N",Type.LABEL_VALUE_STRING,"VAC_TUBELAL600N_Ga4","mbar"));
         list.addElement(new DataElement("StatusSensor600N",Type.CIRCLE_XGSGAUGE_STATUS_COLOR,"VAC_TUBELAL600N_Ga4ST"));
         list.addElement(new DataElement("Pressure300N",Type.LABEL_VALUE_STRING,"VAC_TUBE300N_PR7","mbar"));
         list.addElement(new DataElement("StatusSensor300N",Type.CIRCLE_XGSGAUGE_STATUS_COLOR,"VAC_TUBE300W_PR7SST"));

         // Valves Status
         list.addElement(new DataElement("StatusV3000N",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_TUBELAL3000N_V21ST"));
         list.addElement(new DataElement("StatusV2400N",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_TUBELAL2400N_V21ST"));
         list.addElement(new DataElement("StatusV1800N",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_TUBELAL1800N_V21ST"));
         list.addElement(new DataElement("StatusV1200N",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_TUBELAL1200N_V21ST"));
         list.addElement(new DataElement("StatusV600N",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_TUBELAL600N_V21ST"));
         list.addElement(new DataElement("StatusV300N",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_TUBE300N_V21ST"));
         list.addElement(new DataElement("StatusVNI",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_VALVEBIGNI_ST"));
         list.addElement(new DataElement("StatusVNE",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_VALVEBIGNE_ST"));
         list.addElement(new DataElement("StatusV3000N1",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_TUBELAL3000N_V31ST"));
         list.addElement(new DataElement("StatusV2400N1",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_TUBELAL2400N_V31ST"));
         list.addElement(new DataElement("StatusV1800N1",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_TUBELAL1800N_V31ST"));
         list.addElement(new DataElement("StatusV1200N1",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_TUBELAL1200N_V31ST"));
         list.addElement(new DataElement("StatusV600N1",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_TUBELAL600N_V31ST"));
         list.addElement(new DataElement("StatusV300N1",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_TUBE300N_V31ST"));

         // RGA Status
         list.addElement(new DataElement("StatusGe4_1500N",Type.CIRCLE_RGA_2_STATUS_COLOR,"VAC_RGA1500N_RGAGe4_RUNNING"));
         list.addElement(new DataElement("StatusGc4_1500N",Type.CIRCLE_RGA_2_STATUS_COLOR,"VAC_RGA1500N_RGAGc4_RUNNING"));
         
         // Rack Status
         list.addElement(new DataElement("Station3000N",Type.LABEL_RACK_STATUS_COLOR,"VAC_TUBELAL3000N_RackStatus"));
         list.addElement(new DataElement("Station2400N",Type.LABEL_RACK_STATUS_COLOR,"VAC_TUBELAL2400N_RackStatus"));
         list.addElement(new DataElement("Station1800N",Type.LABEL_RACK_STATUS_COLOR,"VAC_TUBELAL1800N_RackStatus"));
         list.addElement(new DataElement("Station1200N",Type.LABEL_RACK_STATUS_COLOR,"VAC_TUBELAL1200N_RackStatus"));
         list.addElement(new DataElement("Station600N",Type.LABEL_RACK_STATUS_COLOR,"VAC_TUBELAL600N_RackStatus"));
         list.addElement(new DataElement("Station300N",Type.LABEL_RACK_STATUS_COLOR,"VAC_TUBE300N_RackStatus"));
      }
   
      // Init
      Init();
   }
}




