package com.gluonapplication;


public class DataSetSupervisorActionsFlags extends DataSet {

   public DataSetSupervisorActionsFlags(String name) {
      super();
      // Supervisor Flags
      list.addElement(new DataElement("EmergencyCB",Type.LABEL_SAFE_STATUS_STRING,"VAC_SAFE_EMERGENCY_VALVE_CB"));
      list.addElement(new DataElement("EmergencyNE",Type.LABEL_SAFE_STATUS_STRING,"VAC_SAFE_EMERGENCY_VALVE_NE"));
      list.addElement(new DataElement("EmergencyWE",Type.LABEL_SAFE_STATUS_STRING,"VAC_SAFE_EMERGENCY_VALVE_WE"));
      list.addElement(new DataElement("SafeNorthArm",Type.LABEL_SAFE_STATUS_STRING,"VAC_SAFE_TUBE_NORTH"));
      list.addElement(new DataElement("SafeWestArm",Type.LABEL_SAFE_STATUS_STRING,"VAC_SAFE_TUBE_WEST"));
      list.addElement(new DataElement("SafeCentral",Type.LABEL_SAFE_STATUS_STRING,"VAC_SAFE_CENTRAL"));
      list.addElement(new DataElement("SafeNorthEnd",Type.LABEL_SAFE_STATUS_STRING,"VAC_SAFE_TOWERNE"));
      list.addElement(new DataElement("SafeWestEnd",Type.LABEL_SAFE_STATUS_STRING,"VAC_SAFE_TOWERWE"));
      list.addElement(new DataElement("PrimaryPumpingBS",Type.LABEL_SAFE_STATUS_STRING,"VAC_SAFE_PRIMARY_TOWERBS"));
      list.addElement(new DataElement("PrimaryPumpingNI",Type.LABEL_SAFE_STATUS_STRING,"VAC_SAFE_PRIMARY_TOWERNI"));
      list.addElement(new DataElement("PrimaryPumpingWI",Type.LABEL_SAFE_STATUS_STRING,"VAC_SAFE_PRIMARY_TOWERWI"));
      list.addElement(new DataElement("PrimaryPumpingNE",Type.LABEL_SAFE_STATUS_STRING,"VAC_SAFE_PRIMARY_TOWERNE"));
      list.addElement(new DataElement("PrimaryPumpingWE",Type.LABEL_SAFE_STATUS_STRING,"VAC_SAFE_PRIMARY_TOWERWE"));
      list.addElement(new DataElement("PrimaryPumpingPR",Type.LABEL_SAFE_STATUS_STRING,"VAC_SAFE_PRIMARY_TOWERPR"));
      list.addElement(new DataElement("PrimaryPumpingSR",Type.LABEL_SAFE_STATUS_STRING,"VAC_SAFE_PRIMARY_TOWERSR"));
      list.addElement(new DataElement("PrimaryPumpingDET",Type.LABEL_SAFE_STATUS_STRING,"VAC_SAFE_PRIMARY_TOWERDET"));
      list.addElement(new DataElement("PrimaryPumpingIB",Type.LABEL_SAFE_STATUS_STRING,"VAC_SAFE_PRIMARY_TOWERIB"));
      list.addElement(new DataElement("PrimaryPumpingMC",Type.LABEL_SAFE_STATUS_STRING,"VAC_SAFE_PRIMARY_TOWERMC"));
      list.addElement(new DataElement("RemotePumpingBS",Type.LABEL_SAFE_STATUS_STRING,"VAC_SAFE_REMOTE_TOWERBS"));
      list.addElement(new DataElement("RemotePumpingNI",Type.LABEL_SAFE_STATUS_STRING,"VAC_SAFE_REMOTE_TOWERNI"));
      list.addElement(new DataElement("RemotePumpingWI",Type.LABEL_SAFE_STATUS_STRING,"VAC_SAFE_REMOTE_TOWERWI"));
      list.addElement(new DataElement("RemotePumpingPR",Type.LABEL_SAFE_STATUS_STRING,"VAC_SAFE_REMOTE_TOWERPR"));
      list.addElement(new DataElement("RemotePumpingSR",Type.LABEL_SAFE_STATUS_STRING,"VAC_SAFE_REMOTE_TOWERSR"));
      list.addElement(new DataElement("RemotePumpingDET",Type.LABEL_SAFE_STATUS_STRING,"VAC_SAFE_REMOTE_TOWERDET"));
      list.addElement(new DataElement("RemotePumpingIB",Type.LABEL_SAFE_STATUS_STRING,"VAC_SAFE_REMOTE_TOWERIB"));
      list.addElement(new DataElement("LN2TankNI",Type.LABEL_SAFE_STATUS_STRING,"VAC_SAFE_LN2TANKVALVE_NI"));
      list.addElement(new DataElement("LN2TankWI",Type.LABEL_SAFE_STATUS_STRING,"VAC_SAFE_LN2TANKVALVE_WI"));
      list.addElement(new DataElement("LN2TankNE",Type.LABEL_SAFE_STATUS_STRING,"VAC_SAFE_LN2TANKVALVE_NE"));
      list.addElement(new DataElement("LN2TankWE",Type.LABEL_SAFE_STATUS_STRING,"VAC_SAFE_LN2TANKVALVE_WE"));
      list.addElement(new DataElement("LN2TankNI_2",Type.LABEL_SAFE_STATUS_STRING,"VAC_SAFE_LN2TANKVALVE_NI_2"));
      list.addElement(new DataElement("LN2TankWI_2",Type.LABEL_SAFE_STATUS_STRING,"VAC_SAFE_LN2TANKVALVE_WI_2"));
      list.addElement(new DataElement("LN2TankNE_2",Type.LABEL_SAFE_STATUS_STRING,"VAC_SAFE_LN2TANKVALVE_NE_2"));
      list.addElement(new DataElement("LN2TankWE_2",Type.LABEL_SAFE_STATUS_STRING,"VAC_SAFE_LN2TANKVALVE_WE_2"));
      list.addElement(new DataElement("SafeNorthArmGolden",Type.CIRCLE_GOLDEN_STATUS_COLOR,"VAC_SAFE_TUBE_NORTH_GOLDENST"));
      list.addElement(new DataElement("SafeWestArmGolden",Type.CIRCLE_GOLDEN_STATUS_COLOR,"VAC_SAFE_TUBE_WEST_GOLDENST"));
      list.addElement(new DataElement("SafeNorthEndGolden",Type.CIRCLE_GOLDEN_STATUS_COLOR,"VAC_SAFE_TOWERNE_GOLDENST"));
      list.addElement(new DataElement("SafeWestEndGolden",Type.CIRCLE_GOLDEN_STATUS_COLOR,"VAC_SAFE_TOWERWE_GOLDENST"));
      list.addElement(new DataElement("SafeCentralGolden",Type.CIRCLE_GOLDEN_STATUS_COLOR,"VAC_SAFE_CENTRAL_GOLDENST"));

      // Init
      Init();
   }
}




