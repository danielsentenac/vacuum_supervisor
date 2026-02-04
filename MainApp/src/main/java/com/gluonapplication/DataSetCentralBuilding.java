package com.gluonapplication;

import java.util.Vector;

public class DataSetCentralBuilding extends DataSet {

   public DataSetCentralBuilding(String name) {
      super();

      // Valves Status
      // Cryo Valves
      list.addElement(new DataElement("StatusVCryoNI",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_CRYONI_VCRYOST"));
      list.addElement(new DataElement("StatusVCryoWI",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_CRYOWI_VCRYOST"));
      // Big Valves
      list.addElement(new DataElement("StatusVNI",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_VALVEBIGNI_ST"));
      list.addElement(new DataElement("StatusVWI",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_VALVEBIGWI_ST"));
      // Central Valves
      list.addElement(new DataElement("StatusValveNS",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_VALVECENTRAL_VNSST"));
      list.addElement(new DataElement("StatusValveSS",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_VALVECENTRAL_VSSST"));
      list.addElement(new DataElement("StatusValveWS",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_VALVECENTRAL_VWSST"));
      list.addElement(new DataElement("StatusValvePS",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_VALVECENTRAL_VPSST"));
      list.addElement(new DataElement("StatusValveLI",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_VALVECENTRAL_VLIST"));
      // Small Cryo Valves
      list.addElement(new DataElement("StatusVS1CryoDET",Type.SVGPATH_VALVE_2_STATUS_COLOR,"VAC_CRYOLINKDET_Vs1"));
      list.addElement(new DataElement("StatusVS2CryoDET",Type.SVGPATH_VALVE_2_STATUS_COLOR,"VAC_CRYOLINKDET_Vs2"));
      list.addElement(new DataElement("StatusVS1CryoIB",Type.SVGPATH_VALVE_2_STATUS_COLOR,"VAC_CRYOLINKIB_Vs1"));
      list.addElement(new DataElement("StatusVS2CryoIB",Type.SVGPATH_VALVE_2_STATUS_COLOR,"VAC_CRYOLINKIB_Vs2"));
      // SQZ Valves
      list.addElement(new DataElement("StatusVPSqzDET1",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_SQZDET1_VPST"));
      list.addElement(new DataElement("StatusVPSqzDET2",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_SQZDET2_VPST"));
      // TUBEMC Valve
      list.addElement(new DataElement("StatusVMC",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_TUBEMC_V21ST"));
      // External data
      // To manage CRYOLINK valves
      list.addElement(new DataElement("CRYOLINKDET_Z_10_DOUT",Type.LABEL_VALUE_STRING, "VAC_CRYOLINKDET_Z_10_DOUT"));
      list.addElement(new DataElement("CRYOLINKIB_Z_10_DOUT",Type.LABEL_VALUE_STRING, "VAC_CRYOLINKIB_Z_10_DOUT"));

      // Rack Status
      // Towers
      list.addElement(new DataElement("TowerWI",Type.LABEL_RACK_STATUS_COLOR,"VAC_TOWERWI_RackStatus"));
      list.addElement(new DataElement("TowerNI",Type.LABEL_RACK_STATUS_COLOR,"VAC_TOWERNI_RackStatus"));
      list.addElement(new DataElement("TowerBS",Type.LABEL_RACK_STATUS_COLOR,"VAC_TOWERBS_RackStatus"));
      list.addElement(new DataElement("TowerPR",Type.LABEL_RACK_STATUS_COLOR,"VAC_TOWERPR_RackStatus"));
      list.addElement(new DataElement("TowerSR",Type.LABEL_RACK_STATUS_COLOR,"VAC_TOWERSR_RackStatus"));
      list.addElement(new DataElement("TowerDET",Type.LABEL_RACK_STATUS_COLOR,"VAC_TOWERDET_RackStatus"));
      list.addElement(new DataElement("TowerIB",Type.LABEL_RACK_STATUS_COLOR,"VAC_TOWERIB_RackStatus"));
      list.addElement(new DataElement("TowerMC",Type.LABEL_RACK_STATUS_COLOR,"VAC_TOWERMC_RackStatus"));
      list.addElement(new DataElement("LinkPR",Type.LABEL_RACK_STATUS_COLOR,"VAC_LINK_RackStatus"));// Same rack for both PR & SR
      list.addElement(new DataElement("LinkSR",Type.LABEL_RACK_STATUS_COLOR,"VAC_LINK_RackStatus"));// Same rack for both PR & SR
      // Cryo
      list.addElement(new DataElement("CryoWI",Type.LABEL_RACK_STATUS_COLOR,"VAC_CRYOWI_RackStatus"));
      list.addElement(new DataElement("CryoNI",Type.LABEL_RACK_STATUS_COLOR,"VAC_CRYONI_RackStatus"));
      // Small Cryo
      list.addElement(new DataElement("CryoLinkDET",Type.LABEL_RACK_STATUS_COLOR,"VAC_CRYOLINKDET_RackStatus"));
      list.addElement(new DataElement("CryoLinkIB",Type.LABEL_RACK_STATUS_COLOR,"VAC_CRYOLINKIB_RackStatus"));
      // RemotePumps
      list.addElement(new DataElement("RemotePumps",Type.LABEL_RACK_STATUS_COLOR,"VAC_REMOTESCROLL_RackStatus"));
      // SQZ
      list.addElement(new DataElement("MiniTowerSqzDET1",Type.LABEL_RACK_STATUS_COLOR,"VAC_SQZDET1_RackStatus"));
      list.addElement(new DataElement("MiniTowerSqzDET2",Type.LABEL_RACK_STATUS_COLOR,"VAC_SQZDET2_RackStatus"));
      // TUBEMC 
      list.addElement(new DataElement("StationMC",Type.LABEL_RACK_STATUS_COLOR,"VAC_TUBEMC_RackStatus"));
      // Venting System Valves
      list.addElement(new DataElement("StatusNIVENT1",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_VENTINGVALVENI_1ST"));
      list.addElement(new DataElement("StatusNIVENT2",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_VENTINGVALVENI_2ST"));
      list.addElement(new DataElement("StatusWIVENT1",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_VENTINGVALVEWI_1ST"));
      list.addElement(new DataElement("StatusWIVENT2",Type.SVGPATH_VALVE_STATUS_COLOR,"VAC_VENTINGVALVEWI_2ST"));
    
      // Init
      Init();  
   }
}




