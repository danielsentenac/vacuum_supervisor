package com.gluonapplication;

import java.util.Vector;

public class DataSetGlobalFlags extends DataSet {

   public DataSetGlobalFlags(String name) {
      super();

      // Path Golden states
      list.addElement(new DataElement("GoldenStateBeamPath",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_BEAMPATH_GOLDENST"));
      list.addElement(new DataElement("GoldenStateSqzPath",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_SQZPATH_GOLDENST"));
      // Average Pressures
      list.addElement(new DataElement("PressureAverageN",Type.LABEL_VALUE_2E_STRING,"VAC_AVERAGE_PR_TUBE_NORTH","mbar"));
      list.addElement(new DataElement("PressureAverageW",Type.LABEL_VALUE_2E_STRING,"VAC_AVERAGE_PR_TUBE_WEST","mbar"));
      // Golden states
      list.addElement(new DataElement("GoldenStateValveCentral",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_VALVECENTRAL_GOLDENST"));
      list.addElement(new DataElement("GoldenStateTube300N",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_TUBE300N_GOLDENST"));
      list.addElement(new DataElement("GoldenStateTube600N",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_TUBELAL600N_GOLDENST"));
      list.addElement(new DataElement("GoldenStateTube1200N",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_TUBELAL1200N_GOLDENST"));
      list.addElement(new DataElement("GoldenStateTube1800N",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_TUBELAL1800N_GOLDENST"));
      list.addElement(new DataElement("GoldenStateTube2400N",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_TUBELAL2400N_GOLDENST"));
      list.addElement(new DataElement("GoldenStateTube3000N",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_TUBELAL3000N_GOLDENST"));
      list.addElement(new DataElement("GoldenStateTube300W",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_TUBE300W_GOLDENST"));
      list.addElement(new DataElement("GoldenStateTube600W",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_TUBELAL600W_GOLDENST"));
      list.addElement(new DataElement("GoldenStateTube1200W",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_TUBELAL1200W_GOLDENST"));
      list.addElement(new DataElement("GoldenStateTube1800W",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_TUBELAL1800W_GOLDENST"));
      list.addElement(new DataElement("GoldenStateTube2400W",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_TUBELAL2400W_GOLDENST"));
      list.addElement(new DataElement("GoldenStateTube3000W",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_TUBELAL3000W_GOLDENST"));
      list.addElement(new DataElement("GoldenStateSqzDet1",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_SQZDET1_GOLDENST"));
      list.addElement(new DataElement("GoldenStateSqzDet2",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_SQZDET2_GOLDENST"));
      list.addElement(new DataElement("GoldenStateSqz0N",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_SQZ0N_GOLDENST"));
      list.addElement(new DataElement("GoldenStateSqz100N",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_SQZ100N_GOLDENST"));
      list.addElement(new DataElement("GoldenStateSqz200N",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_SQZ200N_GOLDENST"));
      list.addElement(new DataElement("GoldenStateSqz300N",Type.LABEL_GOLDEN_STATUS_STRING,"VAC_SQZ300N_GOLDENST"));

      // Hls data
      list.addElement(new DataElement("HlsLonNE",Type.LABEL_VALUE_2F_STRING,"VAC_NE_HLS_LON","mm"));
      list.addElement(new DataElement("HlsTransNE",Type.LABEL_VALUE_2F_STRING,"VAC_NE_HLS_TRANS","mm"));
      list.addElement(new DataElement("HlsAltNE",Type.LABEL_VALUE_2F_STRING,"VAC_NE_HLS_ALT_MEAN","mm"));
      list.addElement(new DataElement("HlsLonWE",Type.LABEL_VALUE_2F_STRING,"VAC_WE_HLS_LON","mm"));
      list.addElement(new DataElement("HlsTransWE",Type.LABEL_VALUE_2F_STRING,"VAC_WE_HLS_TRANS","mm"));
      list.addElement(new DataElement("HlsAltWE",Type.LABEL_VALUE_2F_STRING,"VAC_WE_HLS_ALT_MEAN","mm"));
      // Init
      Init();
   }
}




