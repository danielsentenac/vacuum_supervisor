package com.gluonapplication;


public class DataSetTowerStationFlags extends DataSet {

   public DataSetTowerStationFlags(String name) {
      super();

      // Communication Instruments
      list.addElement(new DataElement("ComRack",Type.LABEL_RACK_STATUS_STRING,"VAC_" + name + "_RackStatus"));
      list.addElement(new DataElement("ComTurboP51",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_ALARMCOMP51TURBOPUMP"));
      list.addElement(new DataElement("ComTurboP71",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_ALARMCOMP71TURBOPUMP"));
      list.addElement(new DataElement("ComIonic",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_ALARMCOMIONICPUMP"));
      list.addElement(new DataElement("ComMaxiGauge1",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_ALARMCOMMAXIGAUGE1"));
      list.addElement(new DataElement("ComMaxiGauge2",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_ALARMCOMMAXIGAUGE2"));
      list.addElement(new DataElement("ComITRGauge1",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_ALARMCOMITR1"));
      list.addElement(new DataElement("ComITRGauge2",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_ALARMCOMITR2"));
      list.addElement(new DataElement("CompressAir",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_AIRP"));
      list.addElement(new DataElement("CompressAirRelay",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_" + name + "_AIRPR"));

      // Inhibit Valves
      list.addElement(new DataElement("InhibitV92",Type.LABEL_INHIBIT_VALVE_STATUS_STRING,"VAC_" + name + "_INHIBITV92OPENST"));
      list.addElement(new DataElement("InhibitV72",Type.LABEL_INHIBIT_VALVE_STATUS_STRING,"VAC_" + name + "_INHIBITV72OPENST"));
      list.addElement(new DataElement("InhibitV51",Type.LABEL_INHIBIT_VALVE_STATUS_STRING,"VAC_" + name + "_INHIBITV51OPENST"));
      list.addElement(new DataElement("InhibitV71",Type.LABEL_INHIBIT_VALVE_STATUS_STRING,"VAC_" + name + "_INHIBITV71OPENST"));

      // Tower status
      if (name.equals("TOWERBS")) {
         list.addElement(new DataElement("Venting",Type.LABEL_VENTING_STATUS_STRING,"VAC_CB2_TOBS_AIRFLOW"));
         list.addElement(new DataElement("RemotePumping",Type.LABEL_REMOTE_PUMPING_STATUS_STRING,"VAC_REMOTESCROLL_VBSST"));
      }
      if (name.equals("TOWERNI")) {
         list.addElement(new DataElement("Venting",Type.LABEL_VENTING_STATUS_STRING,"VAC_CB2_TONI_AIRFLOW"));
         list.addElement(new DataElement("RemotePumping",Type.LABEL_REMOTE_PUMPING_STATUS_STRING,"VAC_REMOTESCROLL_VNIST"));
      }
      if (name.equals("TOWERSR")) {
         list.addElement(new DataElement("Venting",Type.LABEL_VENTING_STATUS_STRING,"VAC_CB2_TOSR_AIRFLOW"));
         list.addElement(new DataElement("RemotePumping",Type.LABEL_REMOTE_PUMPING_STATUS_STRING,"VAC_REMOTESCROLL_VSRST"));
      }
      if (name.equals("TOWERPR")) {
         list.addElement(new DataElement("Venting",Type.LABEL_VENTING_STATUS_STRING,"VAC_CB1_TOPR_AIRFLOW"));
         list.addElement(new DataElement("RemotePumping",Type.LABEL_REMOTE_PUMPING_STATUS_STRING,"VAC_REMOTESCROLL_VPRST"));
      }
      if (name.equals("TOWERWI")) {
         list.addElement(new DataElement("Venting",Type.LABEL_VENTING_STATUS_STRING,"VAC_CB1_TOWI_AIRFLOW"));
         list.addElement(new DataElement("RemotePumping",Type.LABEL_REMOTE_PUMPING_STATUS_STRING,"VAC_REMOTESCROLL_VWIST"));
      }
      if (name.equals("TOWERNE")) {
         list.addElement(new DataElement("Venting",Type.LABEL_VENTING_STATUS_STRING,"---"));
         list.addElement(new DataElement("RemotePumping",Type.LABEL_REMOTE_PUMPING_STATUS_STRING,"---"));
      }
      if (name.equals("TOWERWE")) {
         list.addElement(new DataElement("Venting",Type.LABEL_VENTING_STATUS_STRING,"---"));
         list.addElement(new DataElement("RemotePumping",Type.LABEL_REMOTE_PUMPING_STATUS_STRING,"---"));
      }

      list.addElement(new DataElement("Operation",Type.LABEL_OPERATION_STATUS_STRING,"VAC_" + name + "_MG1_CH4"));
     
      // Init
      Init();
   }
}




