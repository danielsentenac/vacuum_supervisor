package com.gluonapplication;

import java.util.Vector;

public class DataSetSensorO2 extends DataSet {

   public DataSetSensorO2(String name) {
      super();
      // O2 Rack Status
      list.addElement(new DataElement("ControllerCB",Type.LABEL_RACK_STATUS_STRING,"VAC_CB_O2_RackStatus"));
      list.addElement(new DataElement("ControllerNE",Type.LABEL_RACK_STATUS_STRING,"VAC_NE_O2_RackStatus"));
      list.addElement(new DataElement("ControllerWE",Type.LABEL_RACK_STATUS_STRING,"VAC_WE_O2_RackStatus"));
      // O2 Building Alarms
      list.addElement(new DataElement("AlarmCB",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_CB_O2_ALARM"));
      list.addElement(new DataElement("AlarmNE",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_NE_O2_ALARM"));
      list.addElement(new DataElement("AlarmWE",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_WE_O2_ALARM"));
      // O2 Sensor values
      // CB
      list.addElement(new DataElement("CBZoneA60",Type.LABEL_VALUE_2F_STRING,"VAC_CB_O2_ZONE_A_H60","%O²"));
      list.addElement(new DataElement("CBZoneA60Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_CB_O2_ZONE_A_H60_ST"));
      list.addElement(new DataElement("CBZoneA120",Type.LABEL_VALUE_2F_STRING,"VAC_CB_O2_ZONE_A_H120","%O²"));
      list.addElement(new DataElement("CBZoneA120Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_CB_O2_ZONE_A_H120_ST"));
      list.addElement(new DataElement("CBZoneB120",Type.LABEL_VALUE_2F_STRING,"VAC_CB_O2_ZONE_B_H120","%O²"));
      list.addElement(new DataElement("CBZoneB120Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_CB_O2_ZONE_B_H120_ST"));
      list.addElement(new DataElement("CBZoneB170",Type.LABEL_VALUE_2F_STRING,"VAC_CB_O2_ZONE_B_H170","%O²"));
      list.addElement(new DataElement("CBZoneB170Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_CB_O2_ZONE_B_H170_ST"));
      list.addElement(new DataElement("CBZoneC60",Type.LABEL_VALUE_2F_STRING,"VAC_CB_O2_ZONE_C_H60","%O²"));
      list.addElement(new DataElement("CBZoneC60Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_CB_O2_ZONE_C_H60_ST"));
      list.addElement(new DataElement("CBZoneC120",Type.LABEL_VALUE_2F_STRING,"VAC_CB_O2_ZONE_C_H120","%O²"));
      list.addElement(new DataElement("CBZoneC120Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_CB_O2_ZONE_C_H120_ST"));
      list.addElement(new DataElement("CBZoneD120",Type.LABEL_VALUE_2F_STRING,"VAC_CB_O2_ZONE_D_H120","%O²"));
      list.addElement(new DataElement("CBZoneD120Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_CB_O2_ZONE_D_H120_ST"));
      list.addElement(new DataElement("CBZoneD170",Type.LABEL_VALUE_2F_STRING,"VAC_CB_O2_ZONE_D_H170","%O²"));
      list.addElement(new DataElement("CBZoneD170Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_CB_O2_ZONE_D_H170_ST"));
      list.addElement(new DataElement("CBZoneE60",Type.LABEL_VALUE_2F_STRING,"VAC_CB_O2_ZONE_E_H60","%O²"));
      list.addElement(new DataElement("CBZoneE60Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_CB_O2_ZONE_E_H60_ST"));
      list.addElement(new DataElement("CBZoneE120",Type.LABEL_VALUE_2F_STRING,"VAC_CB_O2_ZONE_E_H120","%O²"));
      list.addElement(new DataElement("CBZoneE120Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_CB_O2_ZONE_E_H120_ST"));
      list.addElement(new DataElement("CBZoneF60",Type.LABEL_VALUE_2F_STRING,"VAC_CB_O2_ZONE_F_H60","%O²"));
      list.addElement(new DataElement("CBZoneF60Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_CB_O2_ZONE_F_H60_ST"));
      list.addElement(new DataElement("CBZoneF120",Type.LABEL_VALUE_2F_STRING,"VAC_CB_O2_ZONE_F_H120","%O²"));
      list.addElement(new DataElement("CBZoneF120Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_CB_O2_ZONE_F_H120_ST"));
      list.addElement(new DataElement("CBZoneG60",Type.LABEL_VALUE_2F_STRING,"VAC_CB_O2_ZONE_G_H60","%O²"));
      list.addElement(new DataElement("CBZoneG60Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_CB_O2_ZONE_G_H60_ST"));
      list.addElement(new DataElement("CBZoneG120",Type.LABEL_VALUE_2F_STRING,"VAC_CB_O2_ZONE_G_H120","%O²"));
      list.addElement(new DataElement("CBZoneG120Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_CB_O2_ZONE_G_H120_ST"));
      list.addElement(new DataElement("CBCleanRoom60",Type.LABEL_VALUE_2F_STRING,"VAC_CB_O2_CLEANROOM_DOWN","%O²"));
      list.addElement(new DataElement("CBCleanRoom60Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_CB_O2_CLEANROOM_DOWN_ST"));
      list.addElement(new DataElement("CBCleanRoom120",Type.LABEL_VALUE_2F_STRING,"VAC_CB_O2_CLEANROOM_UP","%O²"));
      list.addElement(new DataElement("CBCleanRoom120Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_CB_O2_CLEANROOM_UP_ST"));
      // NE
      list.addElement(new DataElement("NETowerDx60",Type.LABEL_VALUE_2F_STRING,"VAC_NE_O2_TOWER_DX_DOWN","%O²"));
      list.addElement(new DataElement("NETowerDx60Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_NE_O2_TOWER_DX_DOWN_ST"));
      list.addElement(new DataElement("NETowerDx120",Type.LABEL_VALUE_2F_STRING,"VAC_NE_O2_TOWER_DX_UP","%O²"));
      list.addElement(new DataElement("NETowerDx120Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_NE_O2_TOWER_DX_UP_ST"));
      list.addElement(new DataElement("NEBaseRoom60",Type.LABEL_VALUE_2F_STRING,"VAC_NE_O2_BASEROOM_DOWN","%O²"));
      list.addElement(new DataElement("NEBaseRoom60Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_NE_O2_BASEROOM_DOWN_ST"));
      list.addElement(new DataElement("NEBaseRoom120",Type.LABEL_VALUE_2F_STRING,"VAC_NE_O2_BASEROOM_UP","%O²"));
      list.addElement(new DataElement("NEBaseRoom120Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_NE_O2_BASEROOM_UP_ST"));
      list.addElement(new DataElement("NECleanRoom60",Type.LABEL_VALUE_2F_STRING,"VAC_NE_O2_CLEANROOM_DOWN","%O²"));
      list.addElement(new DataElement("NECleanRoom60Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_NE_O2_CLEANROOM_DOWN_ST"));
      list.addElement(new DataElement("NECleanRoom120",Type.LABEL_VALUE_2F_STRING,"VAC_NE_O2_CLEANROOM_UP","%O²"));
      list.addElement(new DataElement("NECleanRoom120Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_NE_O2_CLEANROOM_UP_ST"));
      list.addElement(new DataElement("NETowerSx60",Type.LABEL_VALUE_2F_STRING,"VAC_NE_O2_TOWER_SX_DOWN","%O²"));
      list.addElement(new DataElement("NETowerSx60Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_NE_O2_TOWER_SX_DOWN_ST"));
      list.addElement(new DataElement("NETowerSx120",Type.LABEL_VALUE_2F_STRING,"VAC_NE_O2_TOWER_SX_UP","%O²"));
      list.addElement(new DataElement("NETowerSx120Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_NE_O2_TOWER_SX_UP_ST"));
      list.addElement(new DataElement("NETunnel60",Type.LABEL_VALUE_2F_STRING,"VAC_NE_O2_TUNNEL_DOWN","%O²"));
      list.addElement(new DataElement("NETunnel60Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_NE_O2_TUNNEL_DOWN_ST"));
      list.addElement(new DataElement("NETunnel120",Type.LABEL_VALUE_2F_STRING,"VAC_NE_O2_TUNNEL_UP","%O²"));
      list.addElement(new DataElement("NETunnel120Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_NE_O2_TUNNEL_UP_ST"));
      list.addElement(new DataElement("NETunnelDoor60",Type.LABEL_VALUE_2F_STRING,"VAC_NE_O2_TUNNELDOOR_DOWN","%O²"));
      list.addElement(new DataElement("NETunnelDoor60Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_NE_O2_TUNNELDOOR_DOWN_ST"));
      list.addElement(new DataElement("NETunnelDoor120",Type.LABEL_VALUE_2F_STRING,"VAC_NE_O2_TUNNELDOOR_UP","%O²"));
      list.addElement(new DataElement("NETunnelDoor120Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_NE_O2_TUNNELDOOR_UP_ST"));
      // WE
      list.addElement(new DataElement("WETowerDx60",Type.LABEL_VALUE_2F_STRING,"VAC_WE_O2_TOWER_DX_DOWN","%O²"));
      list.addElement(new DataElement("WETowerDx60Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_WE_O2_TOWER_DX_DOWN_ST"));
      list.addElement(new DataElement("WETowerDx120",Type.LABEL_VALUE_2F_STRING,"VAC_WE_O2_TOWER_DX_UP","%O²"));
      list.addElement(new DataElement("WETowerDx120Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_WE_O2_TOWER_DX_UP_ST"));
      list.addElement(new DataElement("WEBaseRoom60",Type.LABEL_VALUE_2F_STRING,"VAC_WE_O2_BASEROOM_DOWN","%O²"));
      list.addElement(new DataElement("WEBaseRoom60Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_WE_O2_BASEROOM_DOWN_ST"));
      list.addElement(new DataElement("WEBaseRoom120",Type.LABEL_VALUE_2F_STRING,"VAC_WE_O2_BASEROOM_UP","%O²"));
      list.addElement(new DataElement("WEBaseRoom120Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_WE_O2_BASEROOM_UP_ST"));
      list.addElement(new DataElement("WECleanRoom60",Type.LABEL_VALUE_2F_STRING,"VAC_WE_O2_CLEANROOM_DOWN","%O²"));
      list.addElement(new DataElement("WECleanRoom60Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_WE_O2_CLEANROOM_DOWN_ST"));
      list.addElement(new DataElement("WECleanRoom120",Type.LABEL_VALUE_2F_STRING,"VAC_WE_O2_CLEANROOM_UP","%O²"));
      list.addElement(new DataElement("WECleanRoom120Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_WE_O2_CLEANROOM_UP_ST"));
      list.addElement(new DataElement("WETowerSx60",Type.LABEL_VALUE_2F_STRING,"VAC_WE_O2_TOWER_SX_DOWN","%O²"));
      list.addElement(new DataElement("WETowerSx60Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_WE_O2_TOWER_SX_DOWN_ST"));
      list.addElement(new DataElement("WETowerSx120",Type.LABEL_VALUE_2F_STRING,"VAC_WE_O2_TOWER_SX_UP","%O²"));
      list.addElement(new DataElement("WETowerSx120Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_WE_O2_TOWER_SX_UP_ST"));
      list.addElement(new DataElement("WETunnel60",Type.LABEL_VALUE_2F_STRING,"VAC_WE_O2_TUNNEL_DOWN","%O²"));
      list.addElement(new DataElement("WETunnel60Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_WE_O2_TUNNEL_DOWN_ST"));
      list.addElement(new DataElement("WETunnel120",Type.LABEL_VALUE_2F_STRING,"VAC_WE_O2_TUNNEL_UP","%O²"));
      list.addElement(new DataElement("WETunnel120Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_WE_O2_TUNNEL_UP_ST"));
      list.addElement(new DataElement("WETunnelDoor60",Type.LABEL_VALUE_2F_STRING,"VAC_WE_O2_TUNNELDOOR_DOWN","%O²"));
      list.addElement(new DataElement("WETunnelDoor60Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_WE_O2_TUNNELDOOR_DOWN_ST"));
      list.addElement(new DataElement("WETunnelDoor120",Type.LABEL_VALUE_2F_STRING,"VAC_WE_O2_TUNNELDOOR_UP","%O²"));
      list.addElement(new DataElement("WETunnelDoor120Status",Type.CIRCLE_O2SENSOR_STATUS_COLOR,"VAC_WE_O2_TUNNELDOOR_UP_ST"));
      
     

      // Init
      Init();
   }
}




