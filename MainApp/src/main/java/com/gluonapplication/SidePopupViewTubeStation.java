package com.gluonapplication;


public class SidePopupViewTubeStation extends SidePopupViewData  {

    public SidePopupViewTubeStation(String _fxml, String _name) {
       super(_fxml, _name);
       data = new DataSetTubeStationFlags(name);
    }
}
