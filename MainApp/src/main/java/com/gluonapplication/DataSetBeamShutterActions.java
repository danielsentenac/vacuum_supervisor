package com.gluonapplication;

public class DataSetBeamShutterActions extends DataSet {

   public DataSetBeamShutterActions(String name) {
      super();

      // CO2 beam shutter status on the WI/NI tower viewports:
      // NI = SHUTTERBEAM1, WI = SHUTTERBEAM2.
      list.addElement(new DataElement("NIShutterStatus", Type.LABEL_SHUTTERBEAM_STATUS_STRING, "VAC_SHUTTERBEAM1_ST"));
      list.addElement(new DataElement("WIShutterStatus", Type.LABEL_SHUTTERBEAM_STATUS_STRING, "VAC_SHUTTERBEAM2_ST"));

      Init();
   }
}
