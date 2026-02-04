package com.gluonapplication;



public class DataSetTurbo extends DataSet {

   public DataSetTurbo(String name) {
      super();

      String[] attributes = name.split(":"); // Expect 2 attributes
      String channelPrefix = "VAC_" + attributes[0];
      System.out.println("Creating DataSetTurbo : " + channelPrefix);
      if (name.contains("LINKPR")) {
         // Status Turbo
         list.addElement(new DataElement("Status",Type.LABEL_TURBO_STATUS_STRING, "VAC_LINK_PR_P21ST"));
         // Status Standby
         list.addElement(new DataElement("StatusStandby",Type.LABEL_TURBO_STANDBY_STATUS_STRING, "VAC_LINK_PR_P21STYST"));
         // Status Temperature
         list.addElement(new DataElement("StatusTemp",Type.LABEL_TURBO_TEMP_STATUS_STRING, "VAC_LINK_PR_P21TPST"));
         // Status Temperature Box
         list.addElement(new DataElement("StatusTempBox",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING, "VAC_LINK_PR_P21BTPST"));
         // Status Box
         list.addElement(new DataElement("StatusBox",Type.LABEL_TURBO_BOX_STATUS_STRING, "VAC_LINK_PR_P21BERR"));
         // Actual Speed
         list.addElement(new DataElement("ActSpeed",Type.LABEL_VALUE_STRING, "VAC_LINK_PR_P21_SPEED","Hz"));
         // Final Speed
         list.addElement(new DataElement("FinalSpeed",Type.LABEL_VALUE_STRING, "VAC_LINK_PR_P21_FSPEED","Hz"));
         // Operating hours 
         list.addElement(new DataElement("OperatingTime",Type.LABEL_VALUE_STRING, "VAC_LINK_PR_P21HR","Hrs."));
         // Actual Power
         list.addElement(new DataElement("ActPower",Type.LABEL_VALUE_STRING, "VAC_LINK_PR_P21PWR","Watt"));
      }
      else if (name.contains("LINKSR")) {
         // Status Turbo
         list.addElement(new DataElement("Status",Type.LABEL_TURBO_STATUS_STRING, "VAC_LINK_SR_P21ST"));
         // Status Standby
         list.addElement(new DataElement("StatusStandby",Type.LABEL_TURBO_STANDBY_STATUS_STRING, "VAC_LINK_SR_P21STYST"));
         // Status Temperature
         list.addElement(new DataElement("StatusTemp",Type.LABEL_TURBO_TEMP_STATUS_STRING, "VAC_LINK_SR_P21TPST"));
         // Status Temperature Box
         list.addElement(new DataElement("StatusTempBox",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING, "VAC_LINK_SR_P21BTPST"));
         // Status Box
         list.addElement(new DataElement("StatusBox",Type.LABEL_TURBO_BOX_STATUS_STRING, "VAC_LINK_SR_P21BERR"));
         // Actual Speed
         list.addElement(new DataElement("ActSpeed",Type.LABEL_VALUE_STRING, "VAC_LINK_SR_P21_SPEED","Hz"));
         // Final Speed
         list.addElement(new DataElement("FinalSpeed",Type.LABEL_VALUE_STRING, "VAC_LINK_SR_P21_FSPEED","Hz"));
         // Operating hours 
         list.addElement(new DataElement("OperatingTime",Type.LABEL_VALUE_STRING, "VAC_LINK_SR_P21HR","Hrs."));
         // Actual Power
         list.addElement(new DataElement("ActPower",Type.LABEL_VALUE_STRING, "VAC_LINK_SR_P21PWR","Watt"));
      }
      else if (name.contains("CRYOLINKDET")) {
         // Status Turbo
         list.addElement(new DataElement("Status",Type.LABEL_TURBO_STATUS_STRING, "VAC_CRYOLINK_DET_P21ST"));
         // Status Standby
         list.addElement(new DataElement("StatusStandby",Type.LABEL_TURBO_STANDBY_STATUS_STRING, "VAC_CRYOLINK_DET_P21STYST"));
         // Status Temperature
         list.addElement(new DataElement("StatusTemp",Type.LABEL_VALUE_STRING, "VAC_CRYOLINK_DET_P21TPST"));
         // Status Temperature Box
         list.addElement(new DataElement("StatusTempBox",Type.LABEL_VALUE_STRING, "VAC_CRYOLINK_DET_P21BTPST"));
         // Status Box
         list.addElement(new DataElement("StatusBox",Type.LABEL_TURBO_BOX_2_STATUS_STRING, "VAC_CRYOLINK_DET_P21BERR"));
         // Actual Speed
         list.addElement(new DataElement("ActSpeed",Type.LABEL_VALUE_STRING, "VAC_CRYOLINK_DET_P21_SPEED","Hz"));
         // Final Speed
         list.addElement(new DataElement("FinalSpeed",Type.LABEL_VALUE_STRING, "VAC_CRYOLINK_DET_P21_FSPEED","Hz"));
         // Operating hours 
         list.addElement(new DataElement("OperatingTime",Type.LABEL_VALUE_STRING, "VAC_CRYOLINK_DET_P21HR","Hrs."));
         // Actual Power
         list.addElement(new DataElement("ActPower",Type.LABEL_VALUE_STRING, "VAC_CRYOLINK_DET_P21PWR","Watt"));
      }
      else if (name.contains("CRYOLINKIB")) {
         // Status Turbo
         list.addElement(new DataElement("Status",Type.LABEL_TURBO_STATUS_STRING, "VAC_CRYOLINK_IB_P21ST"));
         // Status Standby
         list.addElement(new DataElement("StatusStandby",Type.LABEL_TURBO_STANDBY_STATUS_STRING, "VAC_CRYOLINK_IB_P21STYST"));
         // Status Temperature
         list.addElement(new DataElement("StatusTemp",Type.LABEL_VALUE_STRING, "VAC_CRYOLINK_IB_P21TPST"));
         // Status Temperature Box
         list.addElement(new DataElement("StatusTempBox",Type.LABEL_VALUE_STRING, "VAC_CRYOLINK_IB_P21BTPST"));
         // Status Box
         list.addElement(new DataElement("StatusBox",Type.LABEL_TURBO_BOX_2_STATUS_STRING, "VAC_CRYOLINK_IB_P21BERR"));
         // Actual Speed
         list.addElement(new DataElement("ActSpeed",Type.LABEL_VALUE_STRING, "VAC_CRYOLINK_IB_P21_SPEED","Hz"));
         // Final Speed
         list.addElement(new DataElement("FinalSpeed",Type.LABEL_VALUE_STRING, "VAC_CRYOLINK_IB_P21_FSPEED","Hz"));
         // Operating hours 
         list.addElement(new DataElement("OperatingTime",Type.LABEL_VALUE_STRING, "VAC_CRYOLINK_IB_P21HR","Hrs."));
         // Actual Power
         list.addElement(new DataElement("ActPower",Type.LABEL_VALUE_STRING, "VAC_CRYOLINK_IB_P21PWR","Watt"));
      }
      else if (channelPrefix.contains("TOWER") ||
          channelPrefix.contains("TUBE")  ||
          channelPrefix.contains("CRYO")  ||
          channelPrefix.contains("SQZ") ||
          channelPrefix.contains("TILTMETER")  ) {
         // Status Turbo
         list.addElement(new DataElement("Status",Type.LABEL_TURBO_STATUS_STRING, 
                                         channelPrefix + TURBO_CHANNELS.get("Status" + attributes[1])));
         // Status Standby
         list.addElement(new DataElement("StatusStandby",Type.LABEL_TURBO_STANDBY_STATUS_STRING,
                                         channelPrefix + TURBO_CHANNELS.get("StatusStandby" + attributes[1])));
         // Status Temperature
         list.addElement(new DataElement("StatusTemp",Type.LABEL_TURBO_TEMP_STATUS_STRING,
                                         channelPrefix + TURBO_CHANNELS.get("StatusTemp" + attributes[1])));
         // Status Temperature Box
         list.addElement(new DataElement("StatusTempBox",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,
                                         channelPrefix + TURBO_CHANNELS.get("StatusTempBox" + attributes[1])));
         // Status Box
         if (channelPrefix.contains("TUBE") && channelPrefix.contains("LAL"))
            list.addElement(new DataElement("StatusBox",Type.LABEL_TURBO_BOX_STATUS_STRING,
                                         channelPrefix + TURBO_TUBE_LAL_CHANNELS.get("StatusBox" + attributes[1])));
         else
            list.addElement(new DataElement("StatusBox",Type.LABEL_TURBO_BOX_STATUS_STRING,
                                         channelPrefix + TURBO_CHANNELS.get("StatusBox" + attributes[1])));
         // Actual Speed
         list.addElement(new DataElement("ActSpeed",Type.LABEL_VALUE_STRING,
                                         channelPrefix + TURBO_CHANNELS.get("ActSpeed" + attributes[1]),"Hz"));
         // Final Speed
         list.addElement(new DataElement("FinalSpeed",Type.LABEL_VALUE_STRING,
                                         channelPrefix + TURBO_CHANNELS.get("FinalSpeed" + attributes[1]),"Hz"));
         // Operating hours 
         list.addElement(new DataElement("OperatingTime",Type.LABEL_VALUE_STRING,
                                         channelPrefix + TURBO_CHANNELS.get("OperatingTime" + attributes[1]),"Hrs."));
         // Actual Power
         if (channelPrefix.contains("TUBE") && channelPrefix.contains("LAL"))
            list.addElement(new DataElement("ActPower",Type.LABEL_VALUE_STRING,
                                         channelPrefix + TURBO_TUBE_LAL_CHANNELS.get("ActPower" + attributes[1]),"Watt"));
         else
            list.addElement(new DataElement("ActPower",Type.LABEL_VALUE_STRING,
                                         channelPrefix + TURBO_CHANNELS.get("ActPower" + attributes[1]),"Watt"));
      }
      else if (channelPrefix.contains("REMOTESCROLL")) {
         // Status Turbo
         list.addElement(new DataElement("Status",Type.LABEL_TURBO_STATUS_STRING, 
                                         channelPrefix + TURBOT_CHANNELS.get("Status" + attributes[1])));
         // Status Low Speed
         list.addElement(new DataElement("StatusLowSpeed",Type.LABEL_OFFON_STATUS_STRING, 
                                         channelPrefix + TURBOT_CHANNELS.get("StatusLowSpeed" + attributes[1])));
         // Status Normal Speed
         list.addElement(new DataElement("StatusNormalSpeed",Type.LABEL_OFFON_STATUS_STRING, 
                                         channelPrefix + TURBOT_CHANNELS.get("StatusNormalSpeed" + attributes[1])));
         // Status Ramp
         list.addElement(new DataElement("StatusRamp",Type.LABEL_OFFON_STATUS_STRING, 
                                         channelPrefix + TURBOT_CHANNELS.get("StatusRamp" + attributes[1])));
         // Status Box
         list.addElement(new DataElement("StatusBox",Type.LABEL_OKFAILURE_STATUS_STRING, 
                                         channelPrefix + TURBOT_CHANNELS.get("StatusBox" + attributes[1])));
      }
      
      // Init
      Init();
   }
}




