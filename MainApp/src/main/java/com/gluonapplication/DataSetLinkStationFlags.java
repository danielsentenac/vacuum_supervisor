package com.gluonapplication;


public class DataSetLinkStationFlags extends DataSet {

   public DataSetLinkStationFlags(String name) {
      super();

      if (name.contains("PR")) {
         // Communication Instruments
         list.addElement(new DataElement("ComTurbo",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_LINK_PR_P21COMST"));
         list.addElement(new DataElement("CompressAir",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_LINK_PR_COMPRESSAIRST"));
         list.addElement(new DataElement("ComModuleLink",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_LINK_PR_COMST"));
      }
      else if (name.contains("SR")) {
         // Communication Instruments
         list.addElement(new DataElement("ComTurbo",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_LINK_SR_P21COMST"));
         list.addElement(new DataElement("CompressAir",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_LINK_SR_COMPRESSAIRST"));
         list.addElement(new DataElement("ComModuleLink",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_LINK_SR_COMST"));
      }
      list.addElement(new DataElement("ComRack",Type.LABEL_RACK_STATUS_STRING,"VAC_LINK_RackStatus"));
      list.addElement(new DataElement("ComMaxiGauge",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_LINK_MG_COMST"));
      list.addElement(new DataElement("ComModuleRack",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_LINK_RACK_COMST"));
      list.addElement(new DataElement("ComTempMuxShield",Type.LABEL_OKFAILURE_STATUS_STRING,"VAC_LINK_TCMUX_COMST"));
      list.addElement(new DataElement("RackTemp",Type.LABEL_VALUE_2F_STRING,"VAC_LINK_RACK_TEMP","°C"));
      list.addElement(new DataElement("Temp0",Type.LABEL_VALUE_2F_STRING,"VAC_LINK_TEMP0","°C"));
      list.addElement(new DataElement("Temp1",Type.LABEL_VALUE_2F_STRING,"VAC_LINK_TEMP1","°C"));
      list.addElement(new DataElement("Temp2",Type.LABEL_VALUE_2F_STRING,"VAC_LINK_TEMP2","°C"));
      list.addElement(new DataElement("Temp3",Type.LABEL_VALUE_2F_STRING,"VAC_LINK_TEMP3","°C"));
      list.addElement(new DataElement("Temp4",Type.LABEL_VALUE_2F_STRING,"VAC_LINK_TEMP4","°C"));
      list.addElement(new DataElement("Temp5",Type.LABEL_VALUE_2F_STRING,"VAC_LINK_TEMP5","°C"));
      list.addElement(new DataElement("Temp6",Type.LABEL_VALUE_2F_STRING,"VAC_LINK_TEMP6","°C"));
      list.addElement(new DataElement("Temp7",Type.LABEL_VALUE_2F_STRING,"VAC_LINK_TEMP7","°C"));
      list.addElement(new DataElement("Temp8",Type.LABEL_VALUE_2F_STRING,"VAC_LINK_TEMP8","°C"));
     
      // Init
      Init();
   }
}




