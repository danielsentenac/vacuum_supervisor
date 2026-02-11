package com.gluonapplication;

public class DataSetMobileVentingActions extends DataSet {

   public DataSetMobileVentingActions(String name) {
      super();

      String prefix = "VAC_" + name;

      // Commands state
      list.addElement(new DataElement("OpExecute", Type.LABEL_OFFACTIVE_STATUS_STRING, prefix + "_OP_EXECUTE_CMD"));
      list.addElement(new DataElement("OpStop", Type.LABEL_OFFACTIVE_STATUS_STRING, prefix + "_OP_STOP_CMD"));
      // Current operation step
      list.addElement(new DataElement("OpStep", Type.LABEL_VALUE_STRING, prefix + "_OP_STEP"));

      // Init
      Init();
   }
}
