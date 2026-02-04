package com.gluonapplication;


public class SidePopupViewLinkStation extends SidePopupViewData  {

    public SidePopupViewLinkStation(String _fxml, String _name) {
       super(_fxml, _name);
       data = new DataSetLinkStationFlags(name);
    }
}
