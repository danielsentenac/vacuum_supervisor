package com.gluonapplication;

import java.util.Vector;

public class DataSetCryoLinkActions extends DataSet {

   public DataSetCryoLinkActions(String name) {
      super();

      // Refill Mode
      list.addElement(new DataElement("RefillMode",Type.LABEL_REFILL_MODE_STATUS_STRING,"VAC_" + name + "_CV1"));
     
      // Init
      Init();
   }
}




