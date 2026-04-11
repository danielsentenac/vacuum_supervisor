package com.gluonapplication;



public class DataSetGlobal extends DataSet {

   public DataSetGlobal(String name) {
      super();
      
      // Status Virgo SQZ Valves
      list.addElement(new DataElement("StatusValveSqz300N",Type.SVGPATH_VALVE_STATUS_COLOR, "VAC_SQZ300N_VPST"));
      list.addElement(new DataElement("StatusValveSqz0N",Type.SVGPATH_VALVE_STATUS_COLOR, "VAC_SQZ0N_VPST"));
      list.addElement(new DataElement("StatusValveSqzDet2",Type.SVGPATH_VALVE_STATUS_COLOR, "VAC_SQZDET2_VPST"));
      list.addElement(new DataElement("StatusValveSqzDet1",Type.SVGPATH_VALVE_STATUS_COLOR, "VAC_SQZDET1_VPST"));
      
      // Status Virgo big Valves
      list.addElement(new DataElement("StatusValveBigNI",Type.SVGPATH_VALVE_STATUS_COLOR, "VAC_VALVEBIGNI_ST"));
      list.addElement(new DataElement("StatusValveBigNE",Type.SVGPATH_VALVE_STATUS_COLOR, "VAC_VALVEBIGNE_ST"));
      list.addElement(new DataElement("StatusValveBigWI",Type.SVGPATH_VALVE_STATUS_COLOR, "VAC_VALVEBIGWI_ST"));
      list.addElement(new DataElement("StatusValveBigWE",Type.SVGPATH_VALVE_STATUS_COLOR, "VAC_VALVEBIGWE_ST"));
      
      // Status Virgo Central Valves
      list.addElement(new DataElement("StatusValveCentralNS",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_VALVECENTRAL_VNSST"));
      list.addElement(new DataElement("StatusValveCentralSS",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_VALVECENTRAL_VSSST"));
      list.addElement(new DataElement("StatusValveCentralWS",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_VALVECENTRAL_VWSST"));
      list.addElement(new DataElement("StatusValveCentralPS",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_VALVECENTRAL_VPSST"));
      list.addElement(new DataElement("StatusValveCentralLI",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_VALVECENTRAL_VLIST"));
      
      // StatusCryoTrap Valves
      list.addElement(new DataElement("StatusValveCryoNI",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_CRYONI_VCRYOST"));
      list.addElement(new DataElement("StatusValveCryoWI",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_CRYOWI_VCRYOST"));
      list.addElement(new DataElement("StatusValveCryoNE",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_CRYONE_VCRYOST"));
      list.addElement(new DataElement("StatusValveCryoWE",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_CRYOWE_VCRYOST"));
      
      // Status CryoLink Valves
      list.addElement(new DataElement("StatusValveCryoLinkDETVs1",Type.SVGPATH_VALVE_2_STATUS_COLOR,"VAC_CRYOLINKDET_Vs1"));
      list.addElement(new DataElement("StatusValveCryoLinkDETVs2",Type.SVGPATH_VALVE_2_STATUS_COLOR,"VAC_CRYOLINKDET_Vs2"));
      list.addElement(new DataElement("StatusValveCryoLinkIBVs1",Type.SVGPATH_VALVE_2_STATUS_COLOR,"VAC_CRYOLINKIB_Vs1"));
      list.addElement(new DataElement("StatusValveCryoLinkIBVs2",Type.SVGPATH_VALVE_2_STATUS_COLOR,"VAC_CRYOLINKIB_Vs2"));
      
      // Pressures Tube Averages & G51 Det/IB & BS & NE & WE & Remote G3
      list.addElement(new DataElement("PressureTubeNorth",Type.LABEL_VALUE_2E_STRING,"VAC_AVERAGE_PR_TUBE_NORTH","mbar"));
      list.addElement(new DataElement("PressureTubeWest",Type.LABEL_VALUE_2E_STRING,"VAC_AVERAGE_PR_TUBE_WEST","mbar"));
      list.addElement(new DataElement("PressureDetG51",Type.LABEL_VALUE_2E_STRING,"VAC_TOWERDET_MG1_CH4","mbar"));
      list.addElement(new DataElement("PressureMCG51",Type.LABEL_VALUE_2E_STRING,"VAC_TOWERMC_MG1_CH4","mbar"));
      list.addElement(new DataElement("PressureIBG51",Type.LABEL_VALUE_2E_STRING,"VAC_TOWERIB_MG1_CH4","mbar"));
      list.addElement(new DataElement("PressureBSGd2",Type.LABEL_VALUE_2E_STRING,"VAC_TOWERBS_MG2_CH2","mbar"));
      list.addElement(new DataElement("PressureNEGd2",Type.LABEL_VALUE_2E_STRING,"VAC_TOWERNE_MG2_CH2","mbar"));
      list.addElement(new DataElement("PressureWEGd2",Type.LABEL_VALUE_2E_STRING,"VAC_TOWERWE_MG2_CH2","mbar"));
      list.addElement(new DataElement("PressureRemoteG3",Type.LABEL_VALUE_2E_STRING,"VAC_REMOTESCROLL_MG1_CH3","mbar"));
      
      
      // Levels & Temperature Exhaust Big CryoTraps
      list.addElement(new DataElement("LevelPsCryoNI",Type.LABEL_VALUE_2F_STRING,"VAC_LN2NI_LT01_PS_LEVEL","%"));
      list.addElement(new DataElement("LevelPsCryoNE",Type.LABEL_VALUE_2F_STRING,"VAC_LN2NE_LT01_PS_LEVEL","%"));
      list.addElement(new DataElement("LevelPsCryoWI",Type.LABEL_VALUE_2F_STRING,"VAC_LN2WI_LT01_PS_LEVEL","%"));
      list.addElement(new DataElement("LevelPsCryoWE",Type.LABEL_VALUE_2F_STRING,"VAC_LN2WE_LT01_PS_LEVEL","%"));
      list.addElement(new DataElement("LevelTexhaustCryoNI",Type.LABEL_VALUE_2F_STRING,"VAC_VALVEBIGNI_CRYO_TEMP","°C"));
      list.addElement(new DataElement("LevelTexhaustCryoNE",Type.LABEL_VALUE_2F_STRING,"VAC_VALVEBIGNE_CRYO_TEMP","°C"));
      list.addElement(new DataElement("LevelTexhaustCryoWI",Type.LABEL_VALUE_2F_STRING,"VAC_VALVEBIGWI_CRYO_TEMP","°C"));
      list.addElement(new DataElement("LevelTexhaustCryoWE",Type.LABEL_VALUE_2F_STRING,"VAC_VALVEBIGWE_CRYO_TEMP","°C"));
      
      // Status LN2 TANK Valves
      list.addElement(new DataElement("StatusValveLN2NE",Type.SVGPATH_VALVE_STATUS_COLOR, "VAC_VALVEBIGNE_LN2TANKVALVE"));
      list.addElement(new DataElement("StatusValveLN2NI",Type.SVGPATH_VALVE_STATUS_COLOR, "VAC_VALVEBIGNI_LN2TANKVALVE"));
      list.addElement(new DataElement("StatusValveLN2WE",Type.SVGPATH_VALVE_STATUS_COLOR, "VAC_VALVEBIGWE_LN2TANKVALVE"));
      list.addElement(new DataElement("StatusValveLN2WI",Type.SVGPATH_VALVE_STATUS_COLOR, "VAC_VALVEBIGNI_LN2TANKVALVE_WI"));

      // Pressure LN2 TANK 
      list.addElement(new DataElement("PressureLN2NE",Type.LABEL_VALUE_2F_STRING, "VAC_NE1_LN2_BAR","bar"));
      list.addElement(new DataElement("PressureLN2CB",Type.LABEL_VALUE_2F_STRING, "VAC_CB3_LN2_BAR","bar"));
      list.addElement(new DataElement("PressureLN2WE",Type.LABEL_VALUE_2F_STRING, "VAC_WE1_LN2_BAR","bar"));

      // Level LN2 TANK 
      list.addElement(new DataElement("LevelLN2NE",Type.LABEL_VALUE_2F_STRING, "VAC_NE1_LN2_LEVEL","m3"));
      list.addElement(new DataElement("LevelLN2CB",Type.LABEL_VALUE_2F_STRING, "VAC_CB3_LN2_LEVEL","m3"));
      list.addElement(new DataElement("LevelLN2WE",Type.LABEL_VALUE_2F_STRING, "VAC_WE1_LN2_LEVEL","m3"));

      // Status Level LN2 TANK
      list.addElement(new DataElement("StatusLevelLN2NE",Type.RECTANGLE_FILL_LEVEL, "VAC_NE1_LN2_LEVEL","",0,6));
      list.addElement(new DataElement("StatusLevelLN2CB",Type.RECTANGLE_FILL_LEVEL, "VAC_CB3_LN2_LEVEL","",0,25));
      list.addElement(new DataElement("StatusLevelLN2WE",Type.RECTANGLE_FILL_LEVEL, "VAC_WE1_LN2_LEVEL","",0,9));

      // RGA North
      /*list.addElement(new DataElement("RgaNE_2",Type.LABEL_VALUE_2E_STRING, "VAC_TUBE1200N_RGAGa5_002","mbar"));
      list.addElement(new DataElement("RgaNE_18",Type.LABEL_VALUE_2E_STRING, "VAC_TUBE1200N_RGAGa5_018","mbar"));
      list.addElement(new DataElement("RgaNE_28",Type.LABEL_VALUE_2E_STRING, "VAC_TUBE1200N_RGAGa5_028","mbar"));
      list.addElement(new DataElement("RgaNE_32",Type.LABEL_VALUE_2E_STRING, "VAC_TUBE1200N_RGAGa5_032","mbar"));
      list.addElement(new DataElement("RgaNE_44",Type.LABEL_VALUE_2E_STRING, "VAC_TUBE1200N_RGAGa5_044","mbar"));
      
      // RGA West
      list.addElement(new DataElement("RgaWE_2",Type.LABEL_VALUE_2E_STRING, "VAC_TUBE1200W_RGAGa5_002","mbar"));
      list.addElement(new DataElement("RgaWE_18",Type.LABEL_VALUE_2E_STRING, "VAC_TUBE1200W_RGAGa5_018","mbar"));
      list.addElement(new DataElement("RgaWE_28",Type.LABEL_VALUE_2E_STRING, "VAC_TUBE1200W_RGAGa5_028","mbar"));
      list.addElement(new DataElement("RgaWE_32",Type.LABEL_VALUE_2E_STRING, "VAC_TUBE1200W_RGAGa5_032","mbar"));
      list.addElement(new DataElement("RgaWE_44",Type.LABEL_VALUE_2E_STRING, "VAC_TUBE1200W_RGAGa5_044","mbar"));*/
      
      // RGA North
      list.addElement(new DataElement("RgaNE_2",Type.LABEL_VALUE_2E_STRING, "VAC_RGA1500N_RGAGe4_002","mbar"));
      list.addElement(new DataElement("RgaNE_18",Type.LABEL_VALUE_2E_STRING, "VAC_RGA1500N_RGAGe4_018","mbar"));
      list.addElement(new DataElement("RgaNE_28",Type.LABEL_VALUE_2E_STRING, "VAC_RGA1500N_RGAGe4_028","mbar"));
      list.addElement(new DataElement("RgaNE_32",Type.LABEL_VALUE_2E_STRING, "VAC_RGA1500N_RGAGe4_032","mbar"));
      list.addElement(new DataElement("RgaNE_44",Type.LABEL_VALUE_2E_STRING, "VAC_RGA1500N_RGAGe4_044","mbar"));
      
      // RGA West
      list.addElement(new DataElement("RgaWE_2",Type.LABEL_VALUE_2E_STRING, "VAC_RGA1500W_RGAGe4_002","mbar"));
      list.addElement(new DataElement("RgaWE_18",Type.LABEL_VALUE_2E_STRING, "VAC_RGA1500W_RGAGe4_018","mbar"));
      list.addElement(new DataElement("RgaWE_28",Type.LABEL_VALUE_2E_STRING, "VAC_RGA1500W_RGAGe4_028","mbar"));
      list.addElement(new DataElement("RgaWE_32",Type.LABEL_VALUE_2E_STRING, "VAC_RGA1500W_RGAGe4_032","mbar"));
      list.addElement(new DataElement("RgaWE_44",Type.LABEL_VALUE_2E_STRING, "VAC_RGA1500W_RGAGe4_044","mbar"));
      
      // RGA BS
      list.addElement(new DataElement("RgaBS_2",Type.LABEL_VALUE_2E_STRING, "VAC_TOWERBS_RGAGd4_002","mbar"));
      list.addElement(new DataElement("RgaBS_18",Type.LABEL_VALUE_2E_STRING, "VAC_TOWERBS_RGAGd4_018","mbar"));
      list.addElement(new DataElement("RgaBS_28",Type.LABEL_VALUE_2E_STRING, "VAC_TOWERBS_RGAGd4_028","mbar"));
      list.addElement(new DataElement("RgaBS_32",Type.LABEL_VALUE_2E_STRING, "VAC_TOWERBS_RGAGd4_032","mbar"));
      list.addElement(new DataElement("RgaBS_44",Type.LABEL_VALUE_2E_STRING, "VAC_TOWERBS_RGAGd4_044","mbar"));
      // Init
      Init();
   }
}




