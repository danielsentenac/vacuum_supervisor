package com.gluonapplication;



public class DataSetDry extends DataSet {

   public DataSetDry(String name) {
      super();

      String[] attributes = name.split(":"); // Expect 2 attributes
      String channelPrefix = "VAC_" + attributes[0];
      // Status Dry
      if (name.contains("LINKPR"))
         list.addElement(new DataElement("Status",Type.LABEL_DRY_STATUS_STRING, "VAC_LINK_PR_P22ST"));
      else if (name.contains("LINKSR"))
         list.addElement(new DataElement("Status",Type.LABEL_DRY_STATUS_STRING, "VAC_LINK_SR_P22ST"));
      else if (name.contains("CRYOLINKDET"))
         list.addElement(new DataElement("Status",Type.LABEL_DRY_STATUS_STRING, "VAC_CRYOLINK_DET_P22ST"));
      else if (name.contains("CRYOLINKIB"))
         list.addElement(new DataElement("Status",Type.LABEL_DRY_STATUS_STRING, "VAC_CRYOLINK_IB_P22ST"));
      else
      list.addElement(new DataElement("Status",Type.LABEL_DRY_STATUS_STRING,
                                         channelPrefix + DRY_CHANNELS.get("Status" + attributes[1])));     
      
      // Init
      Init();
   }
}




