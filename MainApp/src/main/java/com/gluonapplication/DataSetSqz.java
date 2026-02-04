package com.gluonapplication;

import java.util.Vector;

public class DataSetSqz extends DataSet {

   public DataSetSqz(String name) {
      super();

         // Pressure & status Gauges
         list.addElement(new DataElement("PressureSqz300N",Type.LABEL_VALUE_STRING,"VAC_SQZ300N_PR2","mbar"));
         list.addElement(new DataElement("StatusSensorSqz300N",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_SQZ300N_PR2SST"));
         list.addElement(new DataElement("PressureSqz200N",Type.LABEL_VALUE_STRING,"VAC_SQZ200N_PR2","mbar"));
         list.addElement(new DataElement("StatusSensorSqz200N",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_SQZ200N_PR2SST"));
         list.addElement(new DataElement("PressureSqz100N",Type.LABEL_VALUE_STRING,"VAC_SQZ100N_PR2","mbar"));
         list.addElement(new DataElement("StatusSensorSqz100N",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_SQZ100N_PR2SST"));
         list.addElement(new DataElement("PressureSqz0N",Type.LABEL_VALUE_STRING,"VAC_SQZ0N_PR2","mbar"));
         list.addElement(new DataElement("StatusSensorSqz0N",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_SQZ0N_PR2SST"));
         list.addElement(new DataElement("PressureSqzDET2",Type.LABEL_VALUE_STRING,"VAC_SQZDET2_PR2","mbar"));
         list.addElement(new DataElement("StatusSensorSqzDET2",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_SQZDET2_PR2SST"));
         list.addElement(new DataElement("PressureSqzDET1",Type.LABEL_VALUE_STRING,"VAC_SQZDET1_PR2","mbar"));
         list.addElement(new DataElement("StatusSensorSqzDET1",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_SQZDET1_PR2SST"));
         list.addElement(new DataElement("PressureGMid",Type.LABEL_VALUE_STRING,"VAC_SQZ100N_PR6","mbar"));

         // Status Gauge
         list.addElement(new DataElement("StatusGMid",Type.CIRCLE_GAUGE_STATUS_COLOR, "VAC_SQZ100N_PR6SST"));

         // Valves Status
         list.addElement(new DataElement("StatusVPSqz300N",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_SQZ300N_VPST"));
         list.addElement(new DataElement("StatusV21Sqz200N",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_SQZ200N_V21ST"));
         list.addElement(new DataElement("StatusV21Sqz100N",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_SQZ100N_V21ST"));
         list.addElement(new DataElement("StatusVPSqz0N",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_SQZ0N_VPST"));
         list.addElement(new DataElement("StatusVPSqzDET2",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_SQZDET2_VPST"));
         list.addElement(new DataElement("StatusVPSqzDET1",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_SQZDET1_VPST"));
         
         // Rack Status
         list.addElement(new DataElement("StationSqz300N",Type.LABEL_RACK_STATUS_COLOR,"VAC_SQZ300N_RackStatus"));
         list.addElement(new DataElement("StationSqz200N",Type.LABEL_RACK_STATUS_COLOR,"VAC_SQZ200N_RackStatus"));
         list.addElement(new DataElement("StationSqz100N",Type.LABEL_RACK_STATUS_COLOR,"VAC_SQZ100N_RackStatus"));
         list.addElement(new DataElement("StationSqz0N",Type.LABEL_RACK_STATUS_COLOR,"VAC_SQZ0N_RackStatus"));
         list.addElement(new DataElement("StationSqzDET2",Type.LABEL_RACK_STATUS_COLOR,"VAC_SQZDET2_RackStatus"));
         list.addElement(new DataElement("StationSqzDET1",Type.LABEL_RACK_STATUS_COLOR,"VAC_SQZDET1_RackStatus"));
    
      // Init
      Init();
   }
}




