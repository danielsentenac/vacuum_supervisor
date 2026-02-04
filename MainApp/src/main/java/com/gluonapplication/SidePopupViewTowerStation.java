package com.gluonapplication;


public class SidePopupViewTowerStation extends SidePopupViewData  {

    public SidePopupViewTowerStation(String _fxml, String _name) {
       super(_fxml, _name);
       data = new DataSetTowerStationFlags(name);
    }
}
