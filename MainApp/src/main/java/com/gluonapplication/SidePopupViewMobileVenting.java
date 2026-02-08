package com.gluonapplication;


public class SidePopupViewMobileVenting extends SidePopupViewData {

    public SidePopupViewMobileVenting(String _fxml, String _name) {
        super(_fxml, _name);
        data = new DataSetMobileVentingFlags(name);
    }
}
