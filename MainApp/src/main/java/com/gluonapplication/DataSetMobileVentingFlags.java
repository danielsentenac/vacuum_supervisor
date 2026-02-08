package com.gluonapplication;


public class DataSetMobileVentingFlags extends DataSet {

    public DataSetMobileVentingFlags(String name) {
        super();

        // Rack Status / Communication
        list.addElement(new DataElement("ComMKS2000", Type.LABEL_RACK_STATUS_STRING, "VAC_" + name + "_MKS2000_COMST"));
        list.addElement(new DataElement("ComMKS50000", Type.LABEL_RACK_STATUS_STRING, "VAC_" + name + "_MKS50000_COMST"));
        list.addElement(new DataElement("ComControllino", Type.LABEL_RACK_STATUS_STRING, "VAC_" + name + "_M1_COMST"));
        list.addElement(new DataElement("ComMaxiGauge", Type.LABEL_RACK_STATUS_STRING, "VAC_" + name + "_MG_COMST"));

        // Init
        Init();
    }
}
