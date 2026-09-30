package com.gluonapplication;


public class DataSetTube900NStation extends DataSet {

   // SCADARPI rack TUBE900N (/virgoData/Vacuum/racks/TUBE900N.cfg)
   public DataSetTube900NStation(String name) {
      super();

      // Pressure Gauges (G31 = Maxigauge channel 6)
      list.addElement(new DataElement("PressureG31",Type.LABEL_VALUE_STRING,"VAC_" + name + "_MG_PR6","mbar"));

      // Status Gauges
      list.addElement(new DataElement("StatusG31",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_" + name + "_MG_PR6SST"));

      // Status Valves
      list.addElement(new DataElement("StatusV31",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_I2C_V31ST"));
      list.addElement(new DataElement("StatusV32",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_" + name + "_I2C_V32ST"));

      // Status Pumps (Agilent IPCMini)
      list.addElement(new DataElement("StatusP33",Type.RECTANGLE_IPC_PUMP_STATUS_COLOR,"VAC_" + name + "_IPC_P33ST"));

      // Init
      Init();
   }
}
