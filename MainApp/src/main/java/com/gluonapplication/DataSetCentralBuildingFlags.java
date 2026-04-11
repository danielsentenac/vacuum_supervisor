package com.gluonapplication;


public class DataSetCentralBuildingFlags extends DataSet {

   public DataSetCentralBuildingFlags(String name) {
      super();

      // Pressure Gauges
      list.addElement(new DataElement("PressureTowerBS",Type.LABEL_VALUE_2E_STRING,"VAC_TOWERBS_MG2_CH2","mbar"));
      list.addElement(new DataElement("StatusSensorBS",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_TOWERBS_MG2_CH2SST"));
      list.addElement(new DataElement("PressureTowerPR",Type.LABEL_VALUE_2E_STRING,"VAC_TOWERPR_MG2_CH2","mbar"));
      list.addElement(new DataElement("StatusSensorPR",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_TOWERPR_MG2_CH2SST"));
      list.addElement(new DataElement("PressureTowerNI",Type.LABEL_VALUE_2E_STRING,"VAC_TOWERNI_MG2_CH2","mbar"));
      list.addElement(new DataElement("StatusSensorNI",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_TOWERNI_MG2_CH2SST"));
      list.addElement(new DataElement("PressureTowerWI",Type.LABEL_VALUE_2E_STRING,"VAC_TOWERWI_MG2_CH2","mbar"));
      list.addElement(new DataElement("StatusSensorWI",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_TOWERWI_MG2_CH2SST"));
      list.addElement(new DataElement("PressureTowerSR",Type.LABEL_VALUE_2E_STRING,"VAC_TOWERSR_MG2_CH2","mbar"));
      list.addElement(new DataElement("StatusSensorSR",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_TOWERSR_MG2_CH2SST"));
      list.addElement(new DataElement("PressureTowerDET",Type.LABEL_VALUE_2E_STRING,"VAC_TOWERDET_MG1_CH4","mbar"));
      list.addElement(new DataElement("StatusSensorDET",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_TOWERDET_MG1_CH4SST"));
      list.addElement(new DataElement("PressureTowerIB",Type.LABEL_VALUE_2E_STRING,"VAC_TOWERIB_MG1_CH4","mbar"));
      list.addElement(new DataElement("StatusSensorIB",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_TOWERIB_MG1_CH4SST"));
      list.addElement(new DataElement("PressureMiniTowerPR",Type.LABEL_VALUE_2E_STRING,"VAC_TOWERPR_MG2_CH6","mbar"));
      list.addElement(new DataElement("PressureMiniTowerDET",Type.LABEL_VALUE_2E_STRING,"VAC_TOWERDET_MG1_CH6","mbar"));
      list.addElement(new DataElement("PressureMiniTowerIB",Type.LABEL_VALUE_2E_STRING,"VAC_TOWERIB_MG1_CH6","mbar"));
      list.addElement(new DataElement("PressureCryoWI",Type.LABEL_VALUE_2E_STRING,"VAC_CRYOWI_MG1_CH3","mbar"));
      list.addElement(new DataElement("StatusSensorCryoWI",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_CRYOWI_MG1_CH3SST"));
      list.addElement(new DataElement("PressureCryoNI",Type.LABEL_VALUE_2E_STRING,"VAC_CRYONI_MG1_CH3","mbar"));
      list.addElement(new DataElement("StatusSensorCryoNI",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_CRYONI_MG1_CH3SST"));
      list.addElement(new DataElement("PressureCryoLinkDET",Type.LABEL_VALUE_2E_STRING,"VAC_CRYOLINKDET_Gs4","mbar"));
      list.addElement(new DataElement("PressureCryoLinkIB",Type.LABEL_VALUE_2E_STRING,"VAC_CRYOLINKIB_Gs4","mbar"));     

      // BIG VALVE & CENTRAL & VENTING RACK STATUS
      list.addElement(new DataElement("BigValveNICom",Type.LABEL_RACK_STATUS_STRING,"VAC_VALVEBIGNI_RackStatus"));
      list.addElement(new DataElement("BigValveWICom",Type.LABEL_RACK_STATUS_STRING,"VAC_VALVEBIGWI_RackStatus"));
      list.addElement(new DataElement("BigValveNECom",Type.LABEL_RACK_STATUS_STRING,"VAC_VALVEBIGNE_RackStatus"));
      list.addElement(new DataElement("BigValveWECom",Type.LABEL_RACK_STATUS_STRING,"VAC_VALVEBIGWE_RackStatus"));
      list.addElement(new DataElement("ValveCentralCom",Type.LABEL_RACK_STATUS_STRING,"VAC_VALVECENTRAL_RackStatus"));
      list.addElement(new DataElement("VentingNICom",Type.LABEL_RACK_STATUS_STRING,"VAC_VENTINGVALVENI_RackStatus"));
      list.addElement(new DataElement("VentingWICom",Type.LABEL_RACK_STATUS_STRING,"VAC_VENTINGVALVEWI_RackStatus"));

      // UPS
      list.addElement(new DataElement("ComUpsMC1",Type.LABEL_RACK_STATUS_STRING, UPS_CHANNELS.get("TOWERMC1")));
      list.addElement(new DataElement("BatteryWorkUpsMC1",Type.LABEL_OKWORKING_STATUS_STRING, UPS_CHANNELS.get("TOWERMC1_BATTERY_WORK")));
      list.addElement(new DataElement("BatteryLowUpsMC1",Type.LABEL_OKLOW_STATUS_STRING, UPS_CHANNELS.get("TOWERMC1_BATTERY_LOW")));
      list.addElement(new DataElement("ComUpsMC2",Type.LABEL_RACK_STATUS_STRING, UPS_CHANNELS.get("TOWERMC2")));
      list.addElement(new DataElement("BatteryWorkUpsMC2",Type.LABEL_OKWORKING_STATUS_STRING, UPS_CHANNELS.get("TOWERMC2_BATTERY_WORK")));
      list.addElement(new DataElement("BatteryLowUpsMC2",Type.LABEL_OKLOW_STATUS_STRING, UPS_CHANNELS.get("TOWERMC2_BATTERY_LOW")));
      list.addElement(new DataElement("ComUps3",Type.LABEL_RACK_STATUS_STRING, UPS_CHANNELS.get("TB3")));
      list.addElement(new DataElement("BatteryWorkUps3",Type.LABEL_OKWORKING_STATUS_STRING, UPS_CHANNELS.get("TB3_BATTERY_WORK")));
      list.addElement(new DataElement("BatteryLowUps3",Type.LABEL_OKLOW_STATUS_STRING, UPS_CHANNELS.get("TB3_BATTERY_LOW")));
      

      // Init
      Init();
   }
}




