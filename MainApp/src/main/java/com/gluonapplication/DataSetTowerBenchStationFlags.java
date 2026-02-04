package com.gluonapplication;

import java.util.Vector;

public class DataSetTowerBenchStationFlags extends DataSet {

   public DataSetTowerBenchStationFlags(String name) {
      super();

      // Communication Instruments
      list.addElement(new DataElement("ComRack",Type.LABEL_RACK_STATUS_STRING,"VAC_" + name + "_RackStatus"));
      list.addElement(new DataElement("ComTurboP51",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_ALARMCOMP51TURBOPUMP"));
      list.addElement(new DataElement("ComMaxiGauge1",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_ALARMCOMMAXIGAUGE1"));
      list.addElement(new DataElement("ComITRGauge1",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_ALARMCOMITR1"));
      list.addElement(new DataElement("CompressAir",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_AIRP"));
      list.addElement(new DataElement("CompressAirRelay",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_AIRPR"));
     
      // Inhibit Valves
      list.addElement(new DataElement("InhibitV92",Type.LABEL_INHIBIT_VALVE_STATUS_STRING,"VAC_" + name + "_INHIBITV92OPENST"));
      list.addElement(new DataElement("InhibitV51",Type.LABEL_INHIBIT_VALVE_STATUS_STRING,"VAC_" + name + "_INHIBITV51OPENST"));

      // Tower status
      if (name.equals("TOWERIB")) {
         list.addElement(new DataElement("Venting",Type.LABEL_VENTING_STATUS_STRING,"VAC_CB1_TOIB_AIRFLOW"));
         list.addElement(new DataElement("RemotePumping",Type.LABEL_REMOTE_PUMPING_STATUS_STRING,"VAC_REMOTESCROLL_VIBST"));
      }
      if (name.equals("TOWERDET")) {
         list.addElement(new DataElement("Venting",Type.LABEL_VENTING_STATUS_STRING,"VAC_CB2_TODET_AIRFLOW"));
         list.addElement(new DataElement("RemotePumping",Type.LABEL_REMOTE_PUMPING_STATUS_STRING,"VAC_REMOTESCROLL_VDTST"));
      }
      if (name.equals("TOWERMC")) {
         list.addElement(new DataElement("Venting",Type.LABEL_VENTING_STATUS_STRING,"---"));
         list.addElement(new DataElement("RemotePumping",Type.LABEL_REMOTE_PUMPING_STATUS_STRING,"---"));
      }
      list.addElement(new DataElement("Operation",Type.LABEL_OPERATION_STATUS_STRING,"VAC_" + name + "_MG1_CH2"));

      // Init
      Init();
   }
}




