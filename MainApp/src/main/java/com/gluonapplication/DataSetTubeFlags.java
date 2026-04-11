package com.gluonapplication;


public class DataSetTubeFlags extends DataSet {

   public DataSetTubeFlags(String name) {
      super();


      // Temperatures
      if ( name.equals("TUBEW")) {
         // 600W
         list.addElement(new DataElement("Temp600WInt",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP600W_INT","°C"));
         list.addElement(new DataElement("Temp600WPos1",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP600W_POS1","°C"));
         list.addElement(new DataElement("Temp600WPos2",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP600W_POS2","°C"));
         list.addElement(new DataElement("Temp600WPos3",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP600W_POS3","°C"));
         list.addElement(new DataElement("Temp600WPos4",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP600W_POS4","°C"));
         list.addElement(new DataElement("Temp600WPos5",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP600W_POS5","°C"));
         list.addElement(new DataElement("Temp600WPos6",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP600W_POS6","°C"));
         list.addElement(new DataElement("Temp600WPos7",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP600W_POS7","°C"));
         list.addElement(new DataElement("Temp600WPos8",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP600W_POS8","°C"));
         // 1800W
         list.addElement(new DataElement("Temp1800WInt",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP1800W_INT","°C"));
         list.addElement(new DataElement("Temp1800WPos1",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP1800W_POS1","°C"));
         list.addElement(new DataElement("Temp1800WPos2",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP1800W_POS2","°C"));
         list.addElement(new DataElement("Temp1800WPos3",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP1800W_POS3","°C"));
         list.addElement(new DataElement("Temp1800WPos4",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP1800W_POS4","°C"));
         list.addElement(new DataElement("Temp1800WPos5",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP1800W_POS5","°C"));
         list.addElement(new DataElement("Temp1800WPos6",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP1800W_POS6","°C"));
         list.addElement(new DataElement("Temp1800WPos7",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP1800W_POS7","°C"));
         list.addElement(new DataElement("Temp1800WPos8",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP1800W_POS8","°C"));
         // 3000W
         list.addElement(new DataElement("Temp3000WInt",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP3000W_INT","°C"));
         list.addElement(new DataElement("Temp3000WPos1",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP3000W_POS1","°C"));
         list.addElement(new DataElement("Temp3000WPos2",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP3000W_POS2","°C"));
         list.addElement(new DataElement("Temp3000WPos3",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP3000W_POS3","°C"));
         list.addElement(new DataElement("Temp3000WPos4",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP3000W_POS4","°C"));
         list.addElement(new DataElement("Temp3000WPos5",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP3000W_POS5","°C"));
         list.addElement(new DataElement("Temp3000WPos6",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP3000W_POS6","°C"));
         list.addElement(new DataElement("Temp3000WPos7",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP3000W_POS7","°C"));
         list.addElement(new DataElement("Temp3000WPos8",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP3000W_POS8","°C"));
      }
      if ( name.equals("TUBEN")) {
         // 600N
         list.addElement(new DataElement("Temp600NInt",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP600N_INT","°C"));
         list.addElement(new DataElement("Temp600NPos1",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP600N_POS1","°C"));
         list.addElement(new DataElement("Temp600NPos2",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP600N_POS2","°C"));
         list.addElement(new DataElement("Temp600NPos3",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP600N_POS3","°C"));
         list.addElement(new DataElement("Temp600NPos4",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP600N_POS4","°C"));
         list.addElement(new DataElement("Temp600NPos5",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP600N_POS5","°C"));
         list.addElement(new DataElement("Temp600NPos6",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP600N_POS6","°C"));
         list.addElement(new DataElement("Temp600NPos7",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP600N_POS7","°C"));
         list.addElement(new DataElement("Temp600NPos8",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP600N_POS8","°C"));
         // 1800N
         list.addElement(new DataElement("Temp1800NInt",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP1800N_INT","°C"));
         list.addElement(new DataElement("Temp1800NPos1",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP1800N_POS1","°C"));
         list.addElement(new DataElement("Temp1800NPos2",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP1800N_POS2","°C"));
         list.addElement(new DataElement("Temp1800NPos3",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP1800N_POS3","°C"));
         list.addElement(new DataElement("Temp1800NPos4",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP1800N_POS4","°C"));
         list.addElement(new DataElement("Temp1800NPos5",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP1800N_POS5","°C"));
         list.addElement(new DataElement("Temp1800NPos6",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP1800N_POS6","°C"));
         list.addElement(new DataElement("Temp1800NPos7",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP1800N_POS7","°C"));
         list.addElement(new DataElement("Temp1800NPos8",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP1800N_POS8","°C"));
         // 3000N
         list.addElement(new DataElement("Temp3000NInt",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP3000N_INT","°C"));
         list.addElement(new DataElement("Temp3000NPos1",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP3000N_POS1","°C"));
         list.addElement(new DataElement("Temp3000NPos2",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP3000N_POS2","°C"));
         list.addElement(new DataElement("Temp3000NPos3",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP3000N_POS3","°C"));
         list.addElement(new DataElement("Temp3000NPos4",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP3000N_POS4","°C"));
         list.addElement(new DataElement("Temp3000NPos5",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP3000N_POS5","°C"));
         list.addElement(new DataElement("Temp3000NPos6",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP3000N_POS6","°C"));
         list.addElement(new DataElement("Temp3000NPos7",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP3000N_POS7","°C"));
         list.addElement(new DataElement("Temp3000NPos8",Type.LABEL_VALUE_2F_STRING, "VAC_TUBETEMP3000N_POS8","°C"));
      }
      // Init
      Init();
   }
}




