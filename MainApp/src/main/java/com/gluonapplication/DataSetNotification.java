package com.gluonapplication;

import java.util.Vector;


public class DataSetNotification extends DataSet {

   public DataSetNotification(String name) {
      super();
      if (name.equals("Compress Air Alert")) {
         // TOWER
         list.addElement(new DataElement("COMPRESSAIR:TOWERBS",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_TOWERBS_AIRP"));
         list.addElement(new DataElement("COMPRESSAIR:TOWERPR",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_TOWERPR_AIRP"));
         list.addElement(new DataElement("COMPRESSAIR:TOWERNI",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_TOWERNI_AIRP"));
         list.addElement(new DataElement("COMPRESSAIR:TOWERWI",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_TOWERWI_AIRP"));
         list.addElement(new DataElement("COMPRESSAIR:TOWERSR",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_TOWERSR_AIRP"));
         list.addElement(new DataElement("COMPRESSAIR:TOWERNE",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_TOWERNE_AIRP"));
         list.addElement(new DataElement("COMPRESSAIR:TOWERWE",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_TOWERWE_AIRP"));
         list.addElement(new DataElement("COMPRESSAIR:TOWERDET",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_TOWERDET_AIRP"));
         list.addElement(new DataElement("COMPRESSAIR:TOWERIB",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_TOWERIB_AIRP"));
         list.addElement(new DataElement("COMPRESSAIR:TOWERMC",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_TOWERMC_AIRP"));
         // CRYO
         list.addElement(new DataElement("COMPRESSAIR:CRYONI",Type.LABEL_FAILUREOK_STATUS_STRING,"VAC_CRYONI_COMPRESSAIRST"));
         list.addElement(new DataElement("COMPRESSAIR:CRYOWI",Type.LABEL_FAILUREOK_STATUS_STRING,"VAC_CRYOWI_COMPRESSAIRST"));
         list.addElement(new DataElement("COMPRESSAIR:CRYONE",Type.LABEL_FAILUREOK_STATUS_STRING,"VAC_CRYONE_COMPRESSAIRST"));
         list.addElement(new DataElement("COMPRESSAIR:CRYOWE",Type.LABEL_FAILUREOK_STATUS_STRING,"VAC_CRYOWE_COMPRESSAIRST"));
         // TUBE
         list.addElement(new DataElement("COMPRESSAIR:600N",Type.LABEL_FAILUREOK_STATUS_STRING,"VAC_TUBELAL600N_AIRP"));
         list.addElement(new DataElement("COMPRESSAIR:1200N",Type.LABEL_FAILUREOK_STATUS_STRING,"VAC_TUBELAL1200N_AIRP"));
         list.addElement(new DataElement("COMPRESSAIR:2400N",Type.LABEL_FAILUREOK_STATUS_STRING,"VAC_TUBELAL2400N_AIRP"));
         list.addElement(new DataElement("COMPRESSAIR:3000N",Type.LABEL_FAILUREOK_STATUS_STRING,"VAC_TUBELAL3000N_AIRP"));
         list.addElement(new DataElement("COMPRESSAIR:600W",Type.LABEL_FAILUREOK_STATUS_STRING,"VAC_TUBELAL600W_AIRP"));
         list.addElement(new DataElement("COMPRESSAIR:1200W",Type.LABEL_FAILUREOK_STATUS_STRING,"VAC_TUBELAL1200W_AIRP"));
         list.addElement(new DataElement("COMPRESSAIR:2400W",Type.LABEL_FAILUREOK_STATUS_STRING,"VAC_TUBELAL2400W_AIRP"));
         list.addElement(new DataElement("COMPRESSAIR:3000W",Type.LABEL_FAILUREOK_STATUS_STRING,"VAC_TUBELAL3000W_AIRP"));
         // SQZ
         list.addElement(new DataElement("COMPRESSAIR:SQZ100N",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_SQZ100N_COMPRESSAIRST"));
         list.addElement(new DataElement("COMPRESSAIR:SQZ200N",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_SQZ200N_COMPRESSAIRST"));
         list.addElement(new DataElement("COMPRESSAIR:SQZ0N",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_SQZ0N_COMPRESSAIRST"));
         list.addElement(new DataElement("COMPRESSAIR:SQZ300N",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_SQZ300N_COMPRESSAIRST"));
         list.addElement(new DataElement("COMPRESSAIR:SQZDET1",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_SQZDET1_COMPRESSAIRST"));
         list.addElement(new DataElement("COMPRESSAIR:SQZDET2",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_SQZDET2_COMPRESSAIRST"));
         // LINK
         list.addElement(new DataElement("COMPRESSAIR:LINKPR",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_LINK_PR_COMPRESSAIRST"));
         list.addElement(new DataElement("COMPRESSAIR:LINKSR",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_LINK_SR_COMPRESSAIRST"));
         // CRYO LINK
         list.addElement(new DataElement("COMPRESSAIR:CRYOLINK(DET/IB)",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_CRYOLINK_COMPRESSAIRST"));
      }
      if (name.equals("TurboBox Alert")) {
         // TOWER Turbo Pumps Notification Channels
         list.addElement(new DataElement("TOWERBS P51",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_TOWERBS_P51BERR"));
         list.addElement(new DataElement("TOWERBS P71",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_TOWERBS_P71BERR"));
         list.addElement(new DataElement("TOWERPR P51",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_TOWERPR_P51BERR"));
         list.addElement(new DataElement("TOWERPR P71",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_TOWERPR_P71BERR"));
         list.addElement(new DataElement("TOWERNI P51",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_TOWERNI_P51BERR"));
         list.addElement(new DataElement("TOWERNI P71",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_TOWERNI_P71BERR"));
         list.addElement(new DataElement("TOWERWI P51",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_TOWERWI_P51BERR"));
         list.addElement(new DataElement("TOWERWI P71",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_TOWERWI_P71BERR"));
         list.addElement(new DataElement("TOWERSR P51",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_TOWERSR_P51BERR"));
         list.addElement(new DataElement("TOWERSR P71",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_TOWERSR_P71BERR"));
         list.addElement(new DataElement("TOWERNE P51",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_TOWERNE_P51BERR"));
         list.addElement(new DataElement("TOWERNE P71",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_TOWERNE_P71BERR"));
         list.addElement(new DataElement("TOWERWE P51",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_TOWERWE_P51BERR"));
         list.addElement(new DataElement("TOWERWE P71",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_TOWERWE_P71BERR"));
         list.addElement(new DataElement("TOWERDET P51",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_TOWERDET_P51BERR"));
         list.addElement(new DataElement("TOWERIB P51",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_TOWERIB_P51BERR"));
         list.addElement(new DataElement("TOWERMC P51",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_TOWERMC_P51BERR"));
         // CRYO Turbo Pumps Notification Channels
         list.addElement(new DataElement("CRYONI P2",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_CRYONI_P2BERR"));
         list.addElement(new DataElement("CRYOWI P2",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_CRYOWI_P2BERR"));
         list.addElement(new DataElement("CRYONE P2",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_CRYONE_P2BERR"));
         list.addElement(new DataElement("CRYOWE P2",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_CRYOWE_P2BERR"));
         // Tube Stations Turbo Pumps Notification Channels
         list.addElement(new DataElement("3000W P21",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_TUBELAL3000W_P21ERR"));
         list.addElement(new DataElement("2400W P21",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_TUBELAL2400W_P21ERR"));
         list.addElement(new DataElement("1800W P21",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_TUBELAL1800W_P21ERR"));
         list.addElement(new DataElement("1200W P21",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_TUBELAL1200W_P21ERR"));
         list.addElement(new DataElement("600W P21",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_TUBELAL600W_P21ERR"));
         list.addElement(new DataElement("3000N P21",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_TUBELAL3000N_P21ERR"));
         list.addElement(new DataElement("2400N P21",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_TUBELAL2400N_P21ERR"));
         list.addElement(new DataElement("1800N P21",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_TUBELAL1800N_P21ERR"));
         list.addElement(new DataElement("1200N P21",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_TUBELAL1200N_P21ERR"));
         list.addElement(new DataElement("600N P21",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_TUBELAL600N_P21ERR"));
         // SQZ Stations Turbo Pumps Notification Channels
         list.addElement(new DataElement("SQZ0N P21",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_SQZ0N_P21BERR"));
         list.addElement(new DataElement("SQZ100N P21",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_SQZ100N_P21BERR"));
         list.addElement(new DataElement("SQZ200N P21",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_SQZ200N_P21BERR"));
         list.addElement(new DataElement("SQZ300N P21",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_SQZ300N_P21BERR"));
         list.addElement(new DataElement("SQZDET1 P21",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_SQZ1DET1_P21BERR"));
         list.addElement(new DataElement("SQZDET2 P21",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_SQZDET2_P21BERR"));
         // LINK Turbo Pumps Notification Channels
         list.addElement(new DataElement("LINKPR P21",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_LINK_PR_P21BERR"));
         list.addElement(new DataElement("LINKSR P21",Type.LABEL_TURBO_BOX_STATUS_STRING,"VAC_LINK_SR_P21BERR"));
         // CRYO LINK Turbo Pumps Notification Channels
         list.addElement(new DataElement("CRYOLINKDET P21",Type.LABEL_TURBO_BOX_2_STATUS_STRING,"VAC_CRYOLINK_DET_P21BERR"));
         list.addElement(new DataElement("CRYOLINKIB P21",Type.LABEL_TURBO_BOX_2_STATUS_STRING,"VAC_CRYOLINK_IB_P21BERR"));
      }
      if (name.equals("TurboTemp Alert")) {
         // TOWER Turbo Pumps Notification Channels
         list.addElement(new DataElement("TOWERBS P51",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_TOWERBS_P51TPST"));
         list.addElement(new DataElement("TOWERBS P71",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_TOWERBS_P71TPST"));
         list.addElement(new DataElement("TOWERPR P51",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_TOWERPR_P51TPST"));
         list.addElement(new DataElement("TOWERPR P71",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_TOWERPR_P71TPST"));
         list.addElement(new DataElement("TOWERNI P51",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_TOWERNI_P51TPST"));
         list.addElement(new DataElement("TOWERNI P71",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_TOWERNI_P71TPST"));
         list.addElement(new DataElement("TOWERWI P51",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_TOWERWI_P51TPST"));
         list.addElement(new DataElement("TOWERWI P71",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_TOWERWI_P71TPST"));
         list.addElement(new DataElement("TOWERSR P51",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_TOWERSR_P51TPST"));
         list.addElement(new DataElement("TOWERSR P71",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_TOWERSR_P71TPST"));
         list.addElement(new DataElement("TOWERNE P51",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_TOWERNE_P51TPST"));
         list.addElement(new DataElement("TOWERNE P71",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_TOWERNE_P71TPST"));
         list.addElement(new DataElement("TOWERWE P51",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_TOWERWE_P51TPST"));
         list.addElement(new DataElement("TOWERWE P71",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_TOWERWE_P71TPST"));
         list.addElement(new DataElement("TOWERDET P51",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_TOWERDET_P51TPST"));
         list.addElement(new DataElement("TOWERIB P51",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_TOWERIB_P51TPST"));
         list.addElement(new DataElement("TOWERMC P51",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_TOWERMC_P51TPST"));
         // CRYO Turbo Pumps Notification Channels
         list.addElement(new DataElement("CRYONI P2",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_CRYONI_P2TPST"));
         list.addElement(new DataElement("CRYOWI P2",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_CRYOWI_P2TPST"));
         list.addElement(new DataElement("CRYONE P2",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_CRYONE_P2TPST"));
         list.addElement(new DataElement("CRYOWE P2",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_CRYOWE_P2TPST"));
         // Tube Stations Turbo Pumps Notification Channels
         list.addElement(new DataElement("3000W P21",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_TUBELAL3000W_P21TPST"));
         list.addElement(new DataElement("2400W P21",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_TUBELAL2400W_P21TPST"));
         list.addElement(new DataElement("1800W P21",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_TUBELAL1800W_P21TPST"));
         list.addElement(new DataElement("1200W P21",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_TUBELAL1200W_P21TPST"));
         list.addElement(new DataElement("600W P21" ,Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_TUBELAL600W_P21TPST"));
         list.addElement(new DataElement("3000N_P21",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_TUBELAL3000N_P21TPST"));
         list.addElement(new DataElement("2400N P21",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_TUBELAL2400N_P21TPST"));
         list.addElement(new DataElement("1800N P21",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_TUBELAL1800N_P21TPST"));
         list.addElement(new DataElement("1200N P21",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_TUBELAL1200N_P21TPST"));
         list.addElement(new DataElement("600N P21",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_TUBELAL600N_P21TPST"));
         // SQZ Stations Turbo Pumps Notification Channels
         list.addElement(new DataElement("SQZ0N P21",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_SQZ0N_P21TPST"));
         list.addElement(new DataElement("SQZ100N P21",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_SQZ100N_P21TPST"));
         list.addElement(new DataElement("SQZ200N P21",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_SQZ200N_P21TPST"));
         list.addElement(new DataElement("SQZ300N P21",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_SQZ300N_P21TPST"));
         list.addElement(new DataElement("SQZDET1 P21",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_SQZ1DET1_P21TPST"));
         list.addElement(new DataElement("SQZDET2 P21",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_SQZDET2_P21TPST"));
         // LINK Turbo Pumps Notification Channels
         list.addElement(new DataElement("LINKPR P21",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_LINK_PR_P21TPST"));
         list.addElement(new DataElement("LINKSR P21",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_LINK_SR_P21TPST"));
         // CRYO LINK Turbo Pumps Notification Channels
         list.addElement(new DataElement("CRYOLINKDET P21",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_CRYOLINK_DET_P21TPST"));
         list.addElement(new DataElement("CRYOLINKIB P21",Type.LABEL_TURBO_TEMP_STATUS_STRING,"VAC_CRYOLINK_IB_P21TPST"));
      }
      if (name.equals("TurboBoxTemp Alert")) {
         // TOWER Turbo Pumps Notification Channels
         list.addElement(new DataElement("TOWERBS P51",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_TOWERBS_P51BTPST"));
         list.addElement(new DataElement("TOWERBS P71",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_TOWERBS_P71BTPST"));
         list.addElement(new DataElement("TOWERPR P51",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_TOWERPR_P51BTPST"));
         list.addElement(new DataElement("TOWERPR P71",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_TOWERPR_P71BTPST"));
         list.addElement(new DataElement("TOWERNI P51",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_TOWERNI_P51BTPST"));
         list.addElement(new DataElement("TOWERNI P71",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_TOWERNI_P71BTPST"));
         list.addElement(new DataElement("TOWERWI P51",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_TOWERWI_P51BTPST"));
         list.addElement(new DataElement("TOWERWI P71",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_TOWERWI_P71BTPST"));
         list.addElement(new DataElement("TOWERSR P51",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_TOWERSR_P51BTPST"));
         list.addElement(new DataElement("TOWERSR P71",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_TOWERSR_P71BTPST"));
         list.addElement(new DataElement("TOWERNE P51",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_TOWERNE_P51BTPST"));
         list.addElement(new DataElement("TOWERNE P71",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_TOWERNE_P71BTPST"));
         list.addElement(new DataElement("TOWERWE P51",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_TOWERWE_P51BTPST"));
         list.addElement(new DataElement("TOWERWE P71",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_TOWERWE_P71BTPST"));
         list.addElement(new DataElement("TOWERDET P51",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_TOWERDET_P51BTPST"));
         list.addElement(new DataElement("TOWERIB P51",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_TOWERIB_P51BTPST"));
         list.addElement(new DataElement("TOWERMC P51",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_TOWERMC_P51BTPST"));
         // CRYO Turbo Pumps Notification Channels
         list.addElement(new DataElement("CRYONI P2",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_CRYONI_P2BTPST"));
         list.addElement(new DataElement("CRYOWI P2",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_CRYOWI_P2BTPST"));
         list.addElement(new DataElement("CRYONE P2",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_CRYONE_P2BTPST"));
         list.addElement(new DataElement("CRYOWE P2",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_CRYOWE_P2BTPST"));
         // Tube Stations Turbo Pumps Notification Channels
         list.addElement(new DataElement("3000W P21",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_TUBELAL3000W_P21BTPST"));
         list.addElement(new DataElement("2400W P21",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_TUBELAL2400W_P21BTPST"));
         list.addElement(new DataElement("1800W P21",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_TUBELAL1800W_P21BTPST"));
         list.addElement(new DataElement("1200W P21",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_TUBELAL1200W_P21BTPST"));
         list.addElement(new DataElement("600W P21",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_TUBELAL600W_P21BTPST"));
         list.addElement(new DataElement("3000N P21",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_TUBELAL3000N_P21BTPST"));
         list.addElement(new DataElement("2400N P21",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_TUBELAL2400N_P21BTPST"));
         list.addElement(new DataElement("1800N P21",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_TUBELAL1800N_P21BTPST"));
         list.addElement(new DataElement("1200N P21",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_TUBELAL1200N_P21BTPST"));
         list.addElement(new DataElement("600N P21",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_TUBELAL600N_P21BTPST"));
         list.addElement(new DataElement("TUBEMC P21",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_TUBEMC_P21BTPST"));
         // SQZ Stations Turbo Pumps Notification Channels
         list.addElement(new DataElement("SQZ0N P21",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_SQZ0N_P21BTPST"));
         list.addElement(new DataElement("SQZ100N P21",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_SQZ100N_P21BTPST"));
         list.addElement(new DataElement("SQZ200N P21",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_SQZ200N_P21BTPST"));
         list.addElement(new DataElement("SQZ300N P21",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_SQZ300N_P21BTPST"));
         list.addElement(new DataElement("SQZDET1 P21",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_SQZ1DET1_P21BTPST"));
         list.addElement(new DataElement("SQZDET2 P21",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_SQZDET2_P21BTPST")); 
         // LINK Turbo Pumps Notification Channels
         list.addElement(new DataElement("LINKPR P21",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_LINK_PR_P21BTPST"));
         list.addElement(new DataElement("LINKSR P21",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_LINK_SR_P21BTPST"));
         // CRYO LINK Turbo Pumps Notification Channels
         list.addElement(new DataElement("CRYOLINKDET P21",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_CRYOLINK_DET_P21BTPST"));
         list.addElement(new DataElement("CRYOLINKIB P21",Type.LABEL_TURBO_TEMP_BOX_STATUS_STRING,"VAC_CRYOLINK_IB_P21BTPST"));
      }
      if (name.equals("TurboPower Alert")) {
         // TOWER Turbo Pumps Notification Channels
         list.addElement(new DataElement("TOWERBS P51",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_TOWERBS_P51W",0,50));
         list.addElement(new DataElement("TOWERNE P51",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_TOWERNE_P51W",0,50));
         list.addElement(new DataElement("TOWERNI P51",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_TOWERNI_P51W",0,50));
         list.addElement(new DataElement("TOWERWE P51",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_TOWERWE_P51W",0,50));
         list.addElement(new DataElement("TOWERWI P51",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_TOWERWI_P51W",0,50));
         list.addElement(new DataElement("TOWERSR P51",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_TOWERSR_P51W",0,50));
         list.addElement(new DataElement("TOWERPR P51",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_TOWERPR_P51W",0,50));
         list.addElement(new DataElement("TOWERBS P71",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_TOWERBS_P71W",0,50));
         list.addElement(new DataElement("TOWERNE P71",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_TOWERNE_P71W",0,50));
         list.addElement(new DataElement("TOWERNI P71",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_TOWERNI_P71W",0,50));
         list.addElement(new DataElement("TOWERWE P71",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_TOWERWE_P71W",0,50));
         list.addElement(new DataElement("TOWERWI P71",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_TOWERWI_P71W",0,50));
         list.addElement(new DataElement("TOWERNI P71",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_TOWERNI_P71W",0,50));
         list.addElement(new DataElement("TOWERSR P71",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_TOWERSR_P71W",0,50));
         list.addElement(new DataElement("TOWERPR P71",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_TOWERPR_P71W",0,50));
         list.addElement(new DataElement("TOWERDET P51",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_TOWERDET_P51W",0,50));
         list.addElement(new DataElement("TOWERIB P51",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_TOWERIB_P51W",0,50));
         list.addElement(new DataElement("TOWERMC P51",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_TOWERMC_P51W",0,50));
         // TUBE LAL Turbo Pumps Notification Channels
         list.addElement(new DataElement("TUBE600W P21",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_TUBELAL600W_P21W",0,80));
         list.addElement(new DataElement("TUBE1200W P21",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_TUBELAL1200W_P21W",0,80));
         list.addElement(new DataElement("TUBE2400W P21",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_TUBELAL2400W_P21W",0,80));
         list.addElement(new DataElement("TUBE600N P21",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_TUBELAL600N_P21W",0,80));
         list.addElement(new DataElement("TUBE1200N P21",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_TUBELAL1200N_P21W",0,80));
         list.addElement(new DataElement("TUBE2400N P21",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_TUBELAL2400N_P21W",0,80));
         // TUBE MC Turbo Pumps Notification Channels
         list.addElement(new DataElement("TUBEMC P21",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_TUBEMC_P21W",0,80));
         // TUBE EGO Turbo Pumps Notification Channels
         list.addElement(new DataElement("TUBE3000W P21",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_TUBELAL3000W_P21PW",0,80));
         list.addElement(new DataElement("TUBE600N P21",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_TUBELAL600N_P21PW",0,80));
         list.addElement(new DataElement("TUBE3000N P21",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_TUBELAL3000N_P21PW",0,80));
         // CRYO Turbo Pumps Notification Channels
         list.addElement(new DataElement("CRYONI P2",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_CRYONI_P2W",0,80));
         list.addElement(new DataElement("CRYOWI P2",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_CRYOWI_P2W",0,80));
         list.addElement(new DataElement("CRYONE P2",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_CRYONE_P2W",0,80));
         list.addElement(new DataElement("CRYOWE P2",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_CRYOWE_P2W",0,80));
         // SQZ Turbo Pumps Notification Channels
         list.addElement(new DataElement("SQZDET1 P21",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_SQZDET1_P21PWR",0,80));
         list.addElement(new DataElement("SQZDET2 P21",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_SQZDET2_P21PWR",0,80));
         list.addElement(new DataElement("SQZ300N P21",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_SQZ300N_P21PWR",0,80));
         list.addElement(new DataElement("SQZ0N P21",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_SQZ0N_P21PWR",0,80));
         list.addElement(new DataElement("SQZ100N P21",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_SQZ100N_P21PWR",0,80));
         list.addElement(new DataElement("SQZ200N P21",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_SQZ200N_P21PWR",0,80));
         // LINK Turbo Pumps Notification Channels
         list.addElement(new DataElement("LINKPR P21",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_LINK_PR_P21PWR",0,80));
         list.addElement(new DataElement("LINKSR P21",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_LINK_SR_P21PWR",0,80));
         // CRYO LINK Turbo Pumps Notification Channels
         list.addElement(new DataElement("CRYOLINKDET P21",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_CRYOLINK_DET_P21PWR",0,80));
         list.addElement(new DataElement("CRYOLINKIB P21",Type.LABEL_TURBO_POWER_STATUS_STRING,"VAC_CRYOLINK_IB_P21PWR",0,80));
      }
      if (name.equals("Golden Alert")) {
         // Tube  Golden Status Channels
         list.addElement(new DataElement("300N",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_TUBE300N_GOLDENST"));
         list.addElement(new DataElement("600N",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_TUBELAL600N_GOLDENST"));
         list.addElement(new DataElement("1200N",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_TUBELAL1200N_GOLDENST"));
         list.addElement(new DataElement("1800N",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_TUBELAL1800N_GOLDENST"));
         list.addElement(new DataElement("2400N",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_TUBELAL2400N_GOLDENST"));
         list.addElement(new DataElement("3000N",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_TUBELAL3000N_GOLDENST"));
         list.addElement(new DataElement("300W",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_TUBE300W_GOLDENST"));
         list.addElement(new DataElement("600W",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_TUBELAL600W_GOLDENST"));
         list.addElement(new DataElement("1200W",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_TUBELAL1200W_GOLDENST"));
         list.addElement(new DataElement("1800W",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_TUBELAL1800W_GOLDENST"));
         list.addElement(new DataElement("2400W",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_TUBELAL2400W_GOLDENST"));
         list.addElement(new DataElement("3000W",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_TUBELAL3000W_GOLDENST"));
         // Sqz Golden Status Channels
          list.addElement(new DataElement("SQZ 300N",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_SQZ300N_GOLDENST"));
          list.addElement(new DataElement("SQZ DET1",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_SQZDET1_GOLDENST"));
          list.addElement(new DataElement("SQZ DET2",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_SQZDET2_GOLDENST"));
          list.addElement(new DataElement("SQZ 0N",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_SQZ0N_GOLDENST"));
          list.addElement(new DataElement("SQZ 100N",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_SQZ100N_GOLDENST"));
          list.addElement(new DataElement("SQZ 200N",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_SQZ200N_GOLDENST"));
         // Safe  Golden Status Channels
         list.addElement(new DataElement("SAFE CENTRAL",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_SAFE_CENTRAL_GOLDENST"));
         list.addElement(new DataElement("SAFE TOWERNE",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_SAFE_TOWERNE_GOLDENST"));
         list.addElement(new DataElement("SAFE TOWERWE",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_SAFE_TOWERWE_GOLDENST"));
         list.addElement(new DataElement("SAFE TUBE NORTH",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_SAFE_TUBE_NORTH_GOLDENST"));
         list.addElement(new DataElement("SAFE TUBE WEST",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_SAFE_TUBE_WEST_GOLDENST"));
         // Buildings  Golden Status Channels
         list.addElement(new DataElement("VALVECENTRAL",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_VALVECENTRAL_GOLDENST"));
         // Beam Path Golden Status Channels
         list.addElement(new DataElement("BEAM PATH",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_BEAMPATH_GOLDENST"));
         list.addElement(new DataElement("SQZ PATH",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_SQZPATH_GOLDENST"));
      }
      if (name.equals("Rack Alert")) {
         //list.addElement(new DataElement(" TUBE300N",Type.LABEL_RACK_STATUS_STRING,"VAC_TUBE300N_RackStatus"));
         list.addElement(new DataElement("600N",Type.LABEL_RACK_STATUS_STRING,"VAC_TUBELAL600N_RackStatus"));
         list.addElement(new DataElement("1200N",Type.LABEL_RACK_STATUS_STRING,"VAC_TUBELAL1200N_RackStatus"));
         list.addElement(new DataElement("1800N",Type.LABEL_RACK_STATUS_STRING,"VAC_TUBELAL1800N_RackStatus"));
         list.addElement(new DataElement("2400N",Type.LABEL_RACK_STATUS_STRING,"VAC_TUBELAL2400N_RackStatus"));
         list.addElement(new DataElement("3000N",Type.LABEL_RACK_STATUS_STRING,"VAC_TUBELAL3000N_RackStatus"));
         //list.addElement(new DataElement("VAC_TUBE300W",Type.LABEL_RACK_STATUS_STRING,"VAC_TUBE300W_RackStatus"));
         list.addElement(new DataElement("600W",Type.LABEL_RACK_STATUS_STRING,"VAC_TUBELAL600W_RackStatus"));
         list.addElement(new DataElement("1200W",Type.LABEL_RACK_STATUS_STRING,"VAC_TUBELAL1200W_RackStatus"));
         list.addElement(new DataElement("1800W",Type.LABEL_RACK_STATUS_STRING,"VAC_TUBELAL1800W_RackStatus"));
         list.addElement(new DataElement("2400W",Type.LABEL_RACK_STATUS_STRING,"VAC_TUBELAL2400W_RackStatus"));
         list.addElement(new DataElement("3000W",Type.LABEL_RACK_STATUS_STRING,"VAC_TUBELAL3000W_RackStatus"));
         list.addElement(new DataElement("SQZ0N",Type.LABEL_RACK_STATUS_STRING,"VAC_SQZ0N_RackStatus"));
         list.addElement(new DataElement("SQZ100N",Type.LABEL_RACK_STATUS_STRING,"VAC_SQZ100N_RackStatus"));
         list.addElement(new DataElement("SQZ200N",Type.LABEL_RACK_STATUS_STRING,"VAC_SQZ200N_RackStatus"));
         list.addElement(new DataElement("SQZ300N",Type.LABEL_RACK_STATUS_STRING,"VAC_SQZ300N_RackStatus"));
         list.addElement(new DataElement("SQZDET1",Type.LABEL_RACK_STATUS_STRING,"VAC_SQZDET1_RackStatus"));
         list.addElement(new DataElement("SQZDET2",Type.LABEL_RACK_STATUS_STRING,"VAC_SQZDET2_RackStatus"));
         list.addElement(new DataElement("TOWERBS",Type.LABEL_RACK_STATUS_STRING,"VAC_TOWERBS_RackStatus"));
         list.addElement(new DataElement("TOWERPR",Type.LABEL_RACK_STATUS_STRING,"VAC_TOWERPR_RackStatus"));
         list.addElement(new DataElement("TOWERWI",Type.LABEL_RACK_STATUS_STRING,"VAC_TOWERWI_RackStatus"));
         list.addElement(new DataElement("TOWERWE",Type.LABEL_RACK_STATUS_STRING,"VAC_TOWERWE_RackStatus"));
         list.addElement(new DataElement("TOWERNI",Type.LABEL_RACK_STATUS_STRING,"VAC_TOWERNI_RackStatus"));
         list.addElement(new DataElement("TOWERNE",Type.LABEL_RACK_STATUS_STRING,"VAC_TOWERNE_RackStatus"));
         list.addElement(new DataElement("TOWERDET",Type.LABEL_RACK_STATUS_STRING,"VAC_TOWERDET_RackStatus"));
         list.addElement(new DataElement("TOWERSR",Type.LABEL_RACK_STATUS_STRING,"VAC_TOWERSR_RackStatus"));
         list.addElement(new DataElement("TOWERMC",Type.LABEL_RACK_STATUS_STRING,"VAC_TOWERMC_RackStatus"));
         list.addElement(new DataElement("TOWERIB",Type.LABEL_RACK_STATUS_STRING,"VAC_TOWERIB_RackStatus"));
         //list.addElement(new DataElement("VAC_TUBE0W",Type.LABEL_RACK_STATUS_STRING,"VAC_TUBE0W_RackStatus"));
         list.addElement(new DataElement("TUBEMC",Type.LABEL_RACK_STATUS_STRING,"VAC_TUBEMC_RackStatus"));
         list.addElement(new DataElement("LN2WE",Type.LABEL_RACK_STATUS_STRING,"VAC_LN2WE_RackStatus"));
         list.addElement(new DataElement("CRYOWE",Type.LABEL_RACK_STATUS_STRING,"VAC_CRYOWE_RackStatus"));
         list.addElement(new DataElement("LN2NE",Type.LABEL_RACK_STATUS_STRING,"VAC_LN2NE_RackStatus"));
         list.addElement(new DataElement("CRYONE",Type.LABEL_RACK_STATUS_STRING,"VAC_CRYONE_RackStatus"));
         list.addElement(new DataElement("LN2WI",Type.LABEL_RACK_STATUS_STRING,"VAC_LN2WI_RackStatus"));
         list.addElement(new DataElement("CRYOWI",Type.LABEL_RACK_STATUS_STRING,"VAC_CRYOWI_RackStatus"));
         list.addElement(new DataElement("LN2NI",Type.LABEL_RACK_STATUS_STRING,"VAC_LN2NI_RackStatus"));
         list.addElement(new DataElement("CRYONI",Type.LABEL_RACK_STATUS_STRING,"VAC_CRYONI_RackStatus"));
         list.addElement(new DataElement("CRYOLINKDET",Type.LABEL_RACK_STATUS_STRING,"VAC_CRYOLINKDET_RackStatus"));
         list.addElement(new DataElement("CRYOLINKIB",Type.LABEL_RACK_STATUS_STRING,"VAC_CRYOLINKIB_RackStatus"));
         list.addElement(new DataElement("CRYOLINK",Type.LABEL_RACK_STATUS_STRING,"VAC_CRYOLINK_RackStatus"));
         list.addElement(new DataElement("LINK",Type.LABEL_RACK_STATUS_STRING,"VAC_LINK_RackStatus"));
         list.addElement(new DataElement("VALVECENTRAL",Type.LABEL_RACK_STATUS_STRING,"VAC_VALVECENTRAL_RackStatus"));
         list.addElement(new DataElement("VENTINGVALVENI",Type.LABEL_RACK_STATUS_STRING,"VAC_VENTINGVALVENI_RackStatus"));
         list.addElement(new DataElement("VENTINGVALVEWI",Type.LABEL_RACK_STATUS_STRING,"VAC_VENTINGVALVEWI_RackStatus"));
         list.addElement(new DataElement("REMOTESCROLL",Type.LABEL_RACK_STATUS_STRING,"VAC_REMOTESCROLL_RackStatus"));
         list.addElement(new DataElement("VALVEBIGNE",Type.LABEL_RACK_STATUS_STRING,"VAC_VALVEBIGNE_RackStatus"));
         list.addElement(new DataElement("VALVEBIGNI",Type.LABEL_RACK_STATUS_STRING,"VAC_VALVEBIGNI_RackStatus"));
         list.addElement(new DataElement("VALVEBIGWE",Type.LABEL_RACK_STATUS_STRING,"VAC_VALVEBIGWE_RackStatus"));
         list.addElement(new DataElement("VALVEBIGWI",Type.LABEL_RACK_STATUS_STRING,"VAC_VALVEBIGWI_RackStatus"));
         // UPS Machines
         list.addElement(new DataElement("WE UPS1",Type.LABEL_RACK_STATUS_STRING,"INF_WE_UPS1_COM_ST"));
         list.addElement(new DataElement("WE UPS2",Type.LABEL_RACK_STATUS_STRING,"INF_WE_UPS2_COM_ST"));
         list.addElement(new DataElement("NE UPS1",Type.LABEL_RACK_STATUS_STRING,"INF_NE_UPS1_COM_ST"));
         list.addElement(new DataElement("NE UPS2",Type.LABEL_RACK_STATUS_STRING,"INF_NE_UPS2_COM_ST"));
         list.addElement(new DataElement("MC UPS1",Type.LABEL_RACK_STATUS_STRING,"INF_MC_UPS1_COM_ST"));
         list.addElement(new DataElement("MC UPS2",Type.LABEL_RACK_STATUS_STRING,"INF_MC_UPS2_COM_ST"));
         list.addElement(new DataElement("600W UPS",Type.LABEL_RACK_STATUS_STRING,"INF_W600_UPS_COM_ST"));
         list.addElement(new DataElement("1200W UPS",Type.LABEL_RACK_STATUS_STRING,"INF_W1200_UPS_COM_ST"));
         list.addElement(new DataElement("1800W UPS",Type.LABEL_RACK_STATUS_STRING,"INF_W1800_UPS_COM_ST"));
         list.addElement(new DataElement("2400W UPS",Type.LABEL_RACK_STATUS_STRING,"INF_W2400_UPS_COM_ST"));
         list.addElement(new DataElement("600N UPS",Type.LABEL_RACK_STATUS_STRING,"INF_N600_UPS_COM_ST"));
         list.addElement(new DataElement("1200N UPS",Type.LABEL_RACK_STATUS_STRING,"INF_N1200_UPS_COM_ST"));
         list.addElement(new DataElement("1800N UPS",Type.LABEL_RACK_STATUS_STRING,"INF_N1800_UPS_COM_ST"));
         list.addElement(new DataElement("2400N UPS",Type.LABEL_RACK_STATUS_STRING,"INF_N2400_UPS_COM_ST"));
         list.addElement(new DataElement("330N UPS",Type.LABEL_RACK_STATUS_STRING,"INF_N330_UPS_COM_ST"));
         list.addElement(new DataElement("230N UPS",Type.LABEL_RACK_STATUS_STRING,"INF_N230_UPS_COM_ST"));
         list.addElement(new DataElement("180N UPS",Type.LABEL_RACK_STATUS_STRING,"INF_N180_UPS_COM_ST"));
         list.addElement(new DataElement("130N UPS",Type.LABEL_RACK_STATUS_STRING,"INF_N130_UPS_COM_ST"));
         list.addElement(new DataElement("65N UPS",Type.LABEL_RACK_STATUS_STRING,"INF_N65_UPS_COM_ST"));
         list.addElement(new DataElement("TB UPS",Type.LABEL_RACK_STATUS_STRING,"INF_TB_UPS3_COM_ST"));
         // Controller O2
         list.addElement(new DataElement("O2 CB",Type.LABEL_RACK_STATUS_STRING,"VAC_CB_O2_RackStatus"));
         list.addElement(new DataElement("O2 NE",Type.LABEL_RACK_STATUS_STRING,"VAC_NE_O2_RackStatus"));
         list.addElement(new DataElement("O2 WE",Type.LABEL_RACK_STATUS_STRING,"VAC_WE_O2_RackStatus"));
      }
      if (name.equals("Valve Alert")) {
         // TUBE VALVES
         list.addElement(new DataElement("V21 300N",Type.LABEL_VALVE_STATUS_STRING,"VAC_TUBE300N_V21ST"));
         list.addElement(new DataElement("V21 600N",Type.LABEL_VALVE_STATUS_STRING,"VAC_TUBELAL600N_V21ST"));
         list.addElement(new DataElement("V21 1200N",Type.LABEL_VALVE_STATUS_STRING,"VAC_TUBELAL1200N_V21ST"));
         list.addElement(new DataElement("V21 1800N",Type.LABEL_VALVE_STATUS_STRING,"VAC_TUBELAL1800N_V21ST"));
         list.addElement(new DataElement("V21 2400N",Type.LABEL_VALVE_STATUS_STRING,"VAC_TUBELAL2400N_V21ST"));
         list.addElement(new DataElement("V21 3000N",Type.LABEL_VALVE_STATUS_STRING,"VAC_TUBELAL3000N_V21ST"));
         list.addElement(new DataElement("V21 300W",Type.LABEL_VALVE_STATUS_STRING,"VAC_TUBE300W_V21ST"));
         list.addElement(new DataElement("V21 600W",Type.LABEL_VALVE_STATUS_STRING,"VAC_TUBELAL600W_V21ST"));
         list.addElement(new DataElement("V21 1200W",Type.LABEL_VALVE_STATUS_STRING,"VAC_TUBELAL1200W_V21ST"));
         list.addElement(new DataElement("V21 1800W",Type.LABEL_VALVE_STATUS_STRING,"VAC_TUBELAL1800W_V21ST"));
         list.addElement(new DataElement("V21 2400W",Type.LABEL_VALVE_STATUS_STRING,"VAC_TUBELAL2400W_V21ST"));
         list.addElement(new DataElement("V21 3000W",Type.LABEL_VALVE_STATUS_STRING,"VAC_TUBELAL3000W_V21ST"));
         list.addElement(new DataElement("V21 SQZ0N",Type.LABEL_VALVE_STATUS_STRING,"VAC_SQZ0N_V21ST"));
         list.addElement(new DataElement("V21 SQZ100N",Type.LABEL_VALVE_STATUS_STRING,"VAC_SQZ100N_V21ST"));
         list.addElement(new DataElement("V21 SQZ200N",Type.LABEL_VALVE_STATUS_STRING,"VAC_SQZ200N_V21ST"));
         list.addElement(new DataElement("V21 SQZ300N",Type.LABEL_VALVE_STATUS_STRING,"VAC_SQZ300N_V21ST"));
         list.addElement(new DataElement("V21 SQZDET1",Type.LABEL_VALVE_STATUS_STRING,"VAC_SQZDET1_V21ST"));
         list.addElement(new DataElement("V21 SQZDET2",Type.LABEL_VALVE_STATUS_STRING,"VAC_SQZDET2_V21ST"));
         list.addElement(new DataElement("V22 300N",Type.LABEL_VALVE_STATUS_STRING,"VAC_TUBE300N_V22ST"));
         list.addElement(new DataElement("V22 600N",Type.LABEL_VALVE_STATUS_STRING,"VAC_TUBELAL600N_V22ST"));
         list.addElement(new DataElement("V22 1200N",Type.LABEL_VALVE_STATUS_STRING,"VAC_TUBELAL1200N_V22ST"));
         list.addElement(new DataElement("V22 1800N",Type.LABEL_VALVE_STATUS_STRING,"VAC_TUBELAL1800N_V22ST"));
         list.addElement(new DataElement("V22 2400N",Type.LABEL_VALVE_STATUS_STRING,"VAC_TUBELAL2400N_V22ST"));
         list.addElement(new DataElement("V22 3000N",Type.LABEL_VALVE_STATUS_STRING,"VAC_TUBELAL3000N_V22ST"));
         list.addElement(new DataElement("V22 300W",Type.LABEL_VALVE_STATUS_STRING,"VAC_TUBE300W_V22ST"));
         list.addElement(new DataElement("V22 600W",Type.LABEL_VALVE_STATUS_STRING,"VAC_TUBELAL600W_V22ST"));
         list.addElement(new DataElement("V22 1200W",Type.LABEL_VALVE_STATUS_STRING,"VAC_TUBELAL1200W_V22ST"));
         list.addElement(new DataElement("V22 1800W",Type.LABEL_VALVE_STATUS_STRING,"VAC_TUBELAL1800W_V22ST"));
         list.addElement(new DataElement("V22 2400W",Type.LABEL_VALVE_STATUS_STRING,"VAC_TUBELAL2400W_V22ST"));
         list.addElement(new DataElement("V22 3000W",Type.LABEL_VALVE_STATUS_STRING,"VAC_TUBELAL3000W_V22ST"));
         list.addElement(new DataElement("V22 SQZ0N",Type.LABEL_VALVE_STATUS_STRING,"VAC_SQZ0N_V22ST"));
         list.addElement(new DataElement("V22 SQZ100N",Type.LABEL_VALVE_STATUS_STRING,"VAC_SQZ100N_V22ST"));
         list.addElement(new DataElement("V22 SQZ200N",Type.LABEL_VALVE_STATUS_STRING,"VAC_SQZ200N_V22ST"));
         list.addElement(new DataElement("V22 SQZ300N",Type.LABEL_VALVE_STATUS_STRING,"VAC_SQZ300N_V22ST"));
         list.addElement(new DataElement("V22 SQZDET1",Type.LABEL_VALVE_STATUS_STRING,"VAC_SQZDET1_V22ST"));
         list.addElement(new DataElement("V22 SQZDET2",Type.LABEL_VALVE_STATUS_STRING,"VAC_SQZDET2_V22ST"));
         // TOWER VALVES
         list.addElement(new DataElement("V51 TOWERBS",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERBS_V51ST"));
         list.addElement(new DataElement("V51 TOWERPR",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERPR_V51ST"));
         list.addElement(new DataElement("V51 TOWERNI",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERNI_V51ST"));
         list.addElement(new DataElement("V51 TOWERWI",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERWI_V51ST"));
         list.addElement(new DataElement("V51 TOWERSR",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERSR_V51ST"));
         list.addElement(new DataElement("V51 TOWERNE",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERNE_V51ST"));
         list.addElement(new DataElement("V51 TOWERWE",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERWE_V51ST"));
         list.addElement(new DataElement("V51 TOWERIB",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERIB_V51ST"));
         list.addElement(new DataElement("V51 TOWERDET",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERDET_V51ST"));
         list.addElement(new DataElement("V52 TOWERBS",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERBS_V52ST"));
         list.addElement(new DataElement("V52 TOWERPR",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERPR_V52ST"));
         list.addElement(new DataElement("V52 TOWERNI",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERNI_V52ST"));
         list.addElement(new DataElement("V52 TOWERWI",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERWI_V52ST"));
         list.addElement(new DataElement("V52 TOWERSR",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERSR_V52ST"));
         list.addElement(new DataElement("V52 TOWERNE",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERNE_V52ST"));
         list.addElement(new DataElement("V52 TOWERWE",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERWE_V52ST"));
         list.addElement(new DataElement("V52 TOWERIB",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERIB_V52ST"));
         list.addElement(new DataElement("V52 TOWERDET",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERDET_V52ST"));
         list.addElement(new DataElement("V53 TOWERBS",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERBS_V53ST"));
         list.addElement(new DataElement("V53 TOWERPR",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERPR_V53ST"));
         list.addElement(new DataElement("V53 TOWERNI",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERNI_V53ST"));
         list.addElement(new DataElement("V53 TOWERWI",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERWI_V53ST"));
         list.addElement(new DataElement("V53 TOWERSR",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERSR_V53ST"));
         list.addElement(new DataElement("V53 TOWERNE",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERNE_V53ST"));
         list.addElement(new DataElement("V53 TOWERWE",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERWE_V53ST"));
         list.addElement(new DataElement("V53 TOWERIB",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERIB_V53ST"));
         list.addElement(new DataElement("V53 TOWERDET",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERDET_V53ST"));
         list.addElement(new DataElement("V71 TOWERBS",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERBS_V71ST"));
         list.addElement(new DataElement("V71 TOWERPR",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERPR_V71ST"));
         list.addElement(new DataElement("V71 TOWERNI",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERNI_V71ST"));
         list.addElement(new DataElement("V71 TOWERWI",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERWI_V71ST"));
         list.addElement(new DataElement("V71 TOWERSR",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERSR_V71ST"));
         list.addElement(new DataElement("V71 TOWERNE",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERNE_V71ST"));
         list.addElement(new DataElement("V71 TOWERWE",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERWE_V71ST"));
         list.addElement(new DataElement("V72 TOWERBS",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERBS_V72ST"));
         list.addElement(new DataElement("V72 TOWERPR",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERPR_V72ST"));
         list.addElement(new DataElement("V72 TOWERNI",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERNI_V72ST"));
         list.addElement(new DataElement("V72 TOWERWI",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERWI_V72ST"));
         list.addElement(new DataElement("V72 TOWERSR",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERSR_V72ST"));
         list.addElement(new DataElement("V72 TOWERNE",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERNE_V72ST"));
         list.addElement(new DataElement("V72 TOWERWE",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERWE_V72ST"));
         list.addElement(new DataElement("V41 TOWERBS",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERBS_V41ST"));
         list.addElement(new DataElement("V41 TOWERPR",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERPR_V41ST"));
         list.addElement(new DataElement("V41 TOWERNI",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERNI_V41ST"));
         list.addElement(new DataElement("V41 TOWERWI",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERWI_V41ST"));
         list.addElement(new DataElement("V41 TOWERSR",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERSR_V41ST"));
         list.addElement(new DataElement("V41 TOWERNE",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERNE_V41ST"));
         list.addElement(new DataElement("V41 TOWERWE",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERWE_V41ST"));
         list.addElement(new DataElement("V41 TOWERIB",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERIB_V41ST"));
         list.addElement(new DataElement("V41 TOWERDET",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERDET_V41ST"));
         list.addElement(new DataElement("V42 TOWERBS",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERBS_V42ST"));
         list.addElement(new DataElement("V42 TOWERPR",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERPR_V42ST"));
         list.addElement(new DataElement("V42 TOWERNI",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERNI_V42ST"));
         list.addElement(new DataElement("V42 TOWERWI",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERWI_V42ST"));
         list.addElement(new DataElement("V42 TOWERSR",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERSR_V42ST"));
         list.addElement(new DataElement("V42 TOWERNE",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERNE_V42ST"));
         list.addElement(new DataElement("V42 TOWERWE",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERWE_V42ST"));
         list.addElement(new DataElement("V43 TOWERBS",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERBS_V43ST"));
         list.addElement(new DataElement("V43 TOWERPR",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERPR_V43ST"));
         list.addElement(new DataElement("V43 TOWERNI",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERNI_V43ST"));
         list.addElement(new DataElement("V43 TOWERWI",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERWI_V43ST"));
         list.addElement(new DataElement("V43 TOWERSR",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERSR_V43ST"));
         list.addElement(new DataElement("V43 TOWERNE",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERNE_V43ST"));
         list.addElement(new DataElement("V43 TOWERWE",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERWE_V43ST"));
         list.addElement(new DataElement("V74 TOWERBS",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERBS_V74ST"));
         list.addElement(new DataElement("V74 TOWERPR",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERPR_V74ST"));
         list.addElement(new DataElement("V74 TOWERNI",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERNI_V74ST"));
         list.addElement(new DataElement("V74 TOWERWI",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERWI_V74ST"));
         list.addElement(new DataElement("V74 TOWERSR",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERSR_V74ST"));
         list.addElement(new DataElement("V74 TOWERNE",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERNE_V74ST"));
         list.addElement(new DataElement("V74 TOWERWE",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERWE_V74ST"));
         list.addElement(new DataElement("V75 TOWERBS",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERBS_V75ST"));
         list.addElement(new DataElement("V75 TOWERPR",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERPR_V75ST"));
         list.addElement(new DataElement("V75 TOWERNI",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERNI_V75ST"));
         list.addElement(new DataElement("V75 TOWERWI",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERWI_V75ST"));
         list.addElement(new DataElement("V75 TOWERSR",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERSR_V75ST"));
         list.addElement(new DataElement("V75 TOWERNE",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERNE_V75ST"));
         list.addElement(new DataElement("V75 TOWERWE",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERWE_V75ST"));
         // CRYO VALVES
         list.addElement(new DataElement("V21 CRYONE",Type.LABEL_VALVE_STATUS_STRING,"VAC_CRYONE_V21ST"));
         list.addElement(new DataElement("V21 CRYOWE",Type.LABEL_VALVE_STATUS_STRING,"VAC_CRYOWE_V21ST"));
         list.addElement(new DataElement("V21 CRYONI",Type.LABEL_VALVE_STATUS_STRING,"VAC_CRYONI_V21ST"));
         list.addElement(new DataElement("V21 CRYOWI",Type.LABEL_VALVE_STATUS_STRING,"VAC_CRYOWI_V21ST"));
         list.addElement(new DataElement("V22 CRYONE",Type.LABEL_VALVE_STATUS_STRING,"VAC_CRYONE_V22ST"));
         list.addElement(new DataElement("V22 CRYOWE",Type.LABEL_VALVE_STATUS_STRING,"VAC_CRYOWE_V22ST"));
         list.addElement(new DataElement("V22 CRYONI",Type.LABEL_VALVE_STATUS_STRING,"VAC_CRYONI_V22ST"));
         list.addElement(new DataElement("V22 CRYOWI",Type.LABEL_VALVE_STATUS_STRING,"VAC_CRYOWI_V22ST"));
         list.addElement(new DataElement("VCRYO CRYONE",Type.LABEL_VALVE_STATUS_STRING,"VAC_CRYONE_VCRYOST"));
         list.addElement(new DataElement("VCRYO CRYOWE",Type.LABEL_VALVE_STATUS_STRING,"VAC_CRYOWE_VCRYOST"));
         list.addElement(new DataElement("VCRYO CRYONI",Type.LABEL_VALVE_STATUS_STRING,"VAC_CRYONI_VCRYOST"));
         list.addElement(new DataElement("VCRYO CRYOWI",Type.LABEL_VALVE_STATUS_STRING,"VAC_CRYOWI_VCRYOST"));
         // CRYOLINK VALVES
         list.addElement(new DataElement("Vs1 CRYOLINKIB",Type.LABEL_VALVE_STATUS_STRING,"VAC_CRYOLINKIB_Vs1"));
         list.addElement(new DataElement("Vs1 CRYOLINKDET",Type.LABEL_VALVE_STATUS_STRING,"VAC_CRYOLINKDET_Vs1"));
         list.addElement(new DataElement("Vs2 CRYOLINKIB",Type.LABEL_VALVE_STATUS_STRING,"VAC_CRYOLINKIB_Vs2"));
         list.addElement(new DataElement("Vs2 CRYOLINKDET",Type.LABEL_VALVE_STATUS_STRING,"VAC_CRYOLINKDET_Vs2"));
         // LINKS
         list.addElement(new DataElement("V21 LINKPR",Type.LABEL_VALVE_STATUS_STRING,"VAC_LINKPR_V21ST"));
         list.addElement(new DataElement("V21 LINKSR",Type.LABEL_VALVE_STATUS_STRING,"VAC_LINKSR_V21ST"));
         list.addElement(new DataElement("V22 LINKPR",Type.LABEL_VALVE_STATUS_STRING,"VAC_LINKPR_V22ST"));
         list.addElement(new DataElement("V22 LINKSR",Type.LABEL_VALVE_STATUS_STRING,"VAC_LINKSR_V22ST"));
         // BIG VALVES
         list.addElement(new DataElement("VALVEBIGWI",Type.LABEL_VALVE_STATUS_STRING,"VAC_VALVEBIGWI_ST"));
         list.addElement(new DataElement("VALVEBIGNI",Type.LABEL_VALVE_STATUS_STRING,"VAC_VALVEBIGNI_ST"));
         list.addElement(new DataElement("VALVEBIGWE",Type.LABEL_VALVE_STATUS_STRING,"VAC_VALVEBIGWE_ST"));
         list.addElement(new DataElement("VALVEBIGNE",Type.LABEL_VALVE_STATUS_STRING,"VAC_VALVEBIGNE_ST"));
         // REMOTE PUMPING
         list.addElement(new DataElement("VBS REMOTESCROLL",Type.LABEL_VALVE_STATUS_STRING,"VAC_REMOTESCROLL_VBSST"));
         list.addElement(new DataElement("VSR REMOTESCROLL",Type.LABEL_VALVE_STATUS_STRING,"VAC_REMOTESCROLL_VSRST"));
         list.addElement(new DataElement("VPR REMOTESCROLL",Type.LABEL_VALVE_STATUS_STRING,"VAC_REMOTESCROLL_VPRST"));
         list.addElement(new DataElement("VNI REMOTESCROLL",Type.LABEL_VALVE_STATUS_STRING,"VAC_REMOTESCROLL_VNIST"));
         list.addElement(new DataElement("VWI REMOTESCROLL",Type.LABEL_VALVE_STATUS_STRING,"VAC_REMOTESCROLL_VWIST"));
         list.addElement(new DataElement("VDT REMOTESCROLL",Type.LABEL_VALVE_STATUS_STRING,"VAC_REMOTESCROLL_VDTST"));
         list.addElement(new DataElement("VIB REMOTESCROLL",Type.LABEL_VALVE_STATUS_STRING,"VAC_REMOTESCROLL_VIBST"));
         list.addElement(new DataElement("VLP REMOTESCROLL",Type.LABEL_VALVE_STATUS_STRING,"VAC_REMOTESCROLL_VLPST"));
         list.addElement(new DataElement("VLS REMOTESCROLL",Type.LABEL_VALVE_STATUS_STRING,"VAC_REMOTESCROLL_VLSST"));
         list.addElement(new DataElement("V1 REMOTESCROLL",Type.LABEL_VALVE_STATUS_STRING,"VAC_REMOTESCROLL_V1ST"));
         list.addElement(new DataElement("V2 REMOTESCROLL",Type.LABEL_VALVE_STATUS_STRING,"VAC_REMOTESCROLL_V2ST"));
         // VENTING
         list.addElement(new DataElement("V92 TOWERBS",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERBS_V92ST"));
         list.addElement(new DataElement("V92 TOWERPR",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERPR_V92ST"));
         list.addElement(new DataElement("V92 TOWERNI",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERNI_V92ST"));
         list.addElement(new DataElement("V92 TOWERWI",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERWI_V92ST"));
         list.addElement(new DataElement("V92 TOWERSR",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERSR_V92ST"));
         list.addElement(new DataElement("V92 TOWERNE",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERNE_V92ST"));
         list.addElement(new DataElement("V92 TOWERWE",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERWE_V92ST"));
         list.addElement(new DataElement("V92 TOWERIB",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERIB_V92ST"));
         list.addElement(new DataElement("V92 TOWERDET",Type.LABEL_VALVE_STATUS_STRING,"VAC_TOWERDET_V92ST"));
      }
      if (name.equals("UPS Alert")) {
         // UPS ALARMS
         list.addElement(new DataElement("UPS1:WE",Type.LABEL_FAILUREOK_STATUS_STRING,"INF_WE_UPS1_NORMAL_FUNC_ST"));
         list.addElement(new DataElement("UPS2:WE",Type.LABEL_FAILUREOK_STATUS_STRING,"INF_WE_UPS2_NORMAL_FUNC_ST"));
         list.addElement(new DataElement("UPS1:NE",Type.LABEL_FAILUREOK_STATUS_STRING,"INF_NE_UPS1_NORMAL_FUNC_ST"));
         list.addElement(new DataElement("UPS2:NE",Type.LABEL_FAILUREOK_STATUS_STRING,"INF_NE_UPS2_NORMAL_FUNC_ST"));
         list.addElement(new DataElement("UPS1:MC",Type.LABEL_FAILUREOK_STATUS_STRING,"INF_MC_UPS1_NORMAL_FUNC_ST"));
         list.addElement(new DataElement("UPS2:MC",Type.LABEL_FAILUREOK_STATUS_STRING,"INF_MC_UPS2_NORMAL_FUNC_ST"));
         list.addElement(new DataElement("UPS:600W",Type.LABEL_FAILUREOK_STATUS_STRING,"INF_W600_UPS_NORMAL_FUNC_ST"));
         list.addElement(new DataElement("UPS:1200W",Type.LABEL_FAILUREOK_STATUS_STRING,"INF_W1200_UPS_NORMAL_FUNC_ST"));
         list.addElement(new DataElement("UPS:1800W",Type.LABEL_FAILUREOK_STATUS_STRING,"INF_W1800_UPS_NORMAL_FUNC_ST"));
         list.addElement(new DataElement("UPS:2400W",Type.LABEL_FAILUREOK_STATUS_STRING,"INF_W2400_UPS_NORMAL_FUNC_ST"));
         list.addElement(new DataElement("UPS:600N",Type.LABEL_FAILUREOK_STATUS_STRING,"INF_N600_UPS_NORMAL_FUNC_ST"));
         list.addElement(new DataElement("UPS:1200N",Type.LABEL_FAILUREOK_STATUS_STRING,"INF_N1200_UPS_NORMAL_FUNC_ST"));
         list.addElement(new DataElement("UPS:1800N",Type.LABEL_FAILUREOK_STATUS_STRING,"INF_N1800_UPS_NORMAL_FUNC_ST"));
         list.addElement(new DataElement("UPS:2400N",Type.LABEL_FAILUREOK_STATUS_STRING,"INF_N2400_UPS_NORMAL_FUNC_ST"));
         list.addElement(new DataElement("UPS:SQZDET2",Type.LABEL_FAILUREOK_STATUS_STRING,"INF_N65_UPS_NORMAL_FUNC_ST"));
         list.addElement(new DataElement("UPS:SQZ0N",Type.LABEL_FAILUREOK_STATUS_STRING,"INF_N130_UPS_NORMAL_FUNC_ST"));
         list.addElement(new DataElement("UPS:SQZ100N",Type.LABEL_FAILUREOK_STATUS_STRING,"INF_N180_UPS_NORMAL_FUNC_ST"));
         list.addElement(new DataElement("UPS:SQZ200N",Type.LABEL_FAILUREOK_STATUS_STRING,"INF_N230_UPS_NORMAL_FUNC_ST"));
         list.addElement(new DataElement("UPS:SQZ300N",Type.LABEL_FAILUREOK_STATUS_STRING,"INF_N330_UPS_NORMAL_FUNC_ST"));
         list.addElement(new DataElement("UPS:TB",Type.LABEL_FAILUREOK_STATUS_STRING,"INF_TB_UPS3_NORMAL_FUNC_ST"));
      }
      if (name.equals("O2 Sensor Alert")) {
         // O2 Sensor ALARMS
         list.addElement(new DataElement("SENSOR O2: CB",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_CB_O2_ALARM"));
         list.addElement(new DataElement("SENSOR O2: NE",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_NE_O2_ALARM"));
         list.addElement(new DataElement("SENSOR O2: WE",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_WE_O2_ALARM"));
      }
      
      // Init
      Init();
      
   }
}




