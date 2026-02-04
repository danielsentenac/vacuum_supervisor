package com.gluonapplication;

import java.util.Vector;

public class DataSetGlobalFlagsPlus extends DataSet {

   public DataSetGlobalFlagsPlus(String name) {
      super();
      // Pressures & status North Arm
      list.addElement(new DataElement("Pressure600N",Type.LABEL_VALUE_2E_STRING,"VAC_TUBELAL600N_Ga4","mbar"));
      list.addElement(new DataElement("StatusSensor600N",Type.CIRCLE_XGSGAUGE_STATUS_COLOR,"VAC_TUBELAL600N_Ga4ST"));
      list.addElement(new DataElement("Pressure1200N",Type.LABEL_VALUE_2E_STRING,"VAC_TUBELAL1200N_MG1_CH3","mbar"));
      list.addElement(new DataElement("StatusSensor1200N",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_TUBELAL1200N_MG1_CH3SST"));
      list.addElement(new DataElement("Pressure1800N",Type.LABEL_VALUE_2E_STRING,"VAC_TUBELAL1800N_Ga4","mbar"));
      list.addElement(new DataElement("StatusSensor1800N",Type.CIRCLE_XGSGAUGE_STATUS_COLOR,"VAC_TUBELAL1800N_Ga4ST"));
      list.addElement(new DataElement("Pressure2400N",Type.LABEL_VALUE_2E_STRING,"VAC_TUBELAL2400N_Ga4","mbar"));
      list.addElement(new DataElement("StatusSensor2400N",Type.CIRCLE_XGSGAUGE_STATUS_COLOR,"VAC_TUBELAL2400N_Ga4ST"));
      list.addElement(new DataElement("Pressure3000N",Type.LABEL_VALUE_2E_STRING,"VAC_TUBELAL3000N_MG1_CH6","mbar"));
      list.addElement(new DataElement("StatusSensor3000N",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_TUBELAL3000N_MG1_CH6SST"));
      list.addElement(new DataElement("PressureNE",Type.LABEL_VALUE_2E_STRING,"VAC_TOWERNE_MG2_CH2","mbar"));
      list.addElement(new DataElement("StatusSensorNE",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_TOWERNE_MG2_CH2SST"));

      // Pressures & status West Arm
      list.addElement(new DataElement("Pressure600W",Type.LABEL_VALUE_2E_STRING,"VAC_TUBELAL600W_Ga4","mbar"));
      list.addElement(new DataElement("StatusSensor600W",Type.CIRCLE_XGSGAUGE_STATUS_COLOR,"VAC_TUBELAL600W_Ga4ST"));
      list.addElement(new DataElement("Pressure1200W",Type.LABEL_VALUE_2E_STRING,"VAC_TUBELAL1200W_MG1_CH3","mbar"));
      list.addElement(new DataElement("StatusSensor1200W",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_TUBELAL1200W_MG1_CH3SST"));
      list.addElement(new DataElement("Pressure1800W",Type.LABEL_VALUE_2E_STRING,"VAC_TUBELAL1800W_Ga4","mbar"));
      list.addElement(new DataElement("StatusSensor1800W",Type.CIRCLE_XGSGAUGE_STATUS_COLOR,"VAC_TUBELAL1800W_Ga4ST"));
      list.addElement(new DataElement("Pressure2400W",Type.LABEL_VALUE_2E_STRING,"VAC_TUBELAL2400W_Ga4","mbar"));
      list.addElement(new DataElement("StatusSensor2400W",Type.CIRCLE_XGSGAUGE_STATUS_COLOR,"VAC_TUBELAL2400W_Ga4ST"));
      list.addElement(new DataElement("Pressure3000W",Type.LABEL_VALUE_2E_STRING,"VAC_TUBELAL3000W_MG1_CH6","mbar"));
      list.addElement(new DataElement("StatusSensor3000W",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_TUBELAL3000W_MG1_CH6SST"));
      list.addElement(new DataElement("PressureWE",Type.LABEL_VALUE_2E_STRING,"VAC_TOWERWE_MG2_CH2","mbar"));
      list.addElement(new DataElement("StatusSensorWE",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_TOWERWE_MG2_CH2SST"));

      // Pressures & status Central, MC, SQZ
      list.addElement(new DataElement("PressureBS",Type.LABEL_VALUE_2E_STRING,"VAC_TOWERBS_MG2_CH2","mbar"));
      list.addElement(new DataElement("StatusSensorBS",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_TOWERBS_MG2_CH2SST"));
      list.addElement(new DataElement("PressureBACKG5",Type.LABEL_VALUE_2E_STRING,"VAC_REMOTESCROLL_MG2_CH4","mbar"));
      list.addElement(new DataElement("StatusSensorBACKG5",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_REMOTESCROLL_MG2_CH4SST"));
      list.addElement(new DataElement("PressureMC",Type.LABEL_VALUE_2E_STRING,"VAC_TOWERMC_MG1_CH4","mbar"));
      list.addElement(new DataElement("StatusSensorMC",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_TOWERMC_MG1_CH4SST"));
      list.addElement(new DataElement("PressureSQB1",Type.LABEL_VALUE_2E_STRING,"VAC_SQZDET1_PR4","mbar"));
      list.addElement(new DataElement("StatusSensorSQB1",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_SQZDET1_PR4SST"));
      list.addElement(new DataElement("PressureFCLINE",Type.LABEL_VALUE_2E_STRING,"VAC_SQZ100N_PR6","mbar"));
      list.addElement(new DataElement("StatusSensorFCLINE",Type.CIRCLE_GAUGE_STATUS_COLOR,"VAC_SQZ100N_PR6SST"));
   
      // Temperatures Cryo Guard
      list.addElement(new DataElement("TemperatureCryoNI",Type.LABEL_VALUE_2F_STRING,"VAC_VALVEBIGNI_CRYO_TEMP","°C"));
      list.addElement(new DataElement("TemperatureCryoNE",Type.LABEL_VALUE_2F_STRING,"VAC_VALVEBIGNE_CRYO_TEMP","°C"));
      list.addElement(new DataElement("TemperatureCryoWI",Type.LABEL_VALUE_2F_STRING,"VAC_VALVEBIGWI_CRYO_TEMP","°C"));
      list.addElement(new DataElement("TemperatureCryoWE",Type.LABEL_VALUE_2F_STRING,"VAC_VALVEBIGWE_CRYO_TEMP","°C"));
      
      // Init
      Init();
   }
}




