package com.gluonapplication;

import javafx.scene.control.Label;

public class SidePopupViewTowerStation extends SidePopupViewData  {

    public SidePopupViewTowerStation(String _fxml, String _name) {
       super(_fxml, _name);
       data = new DataSetTowerStationFlags(name);
    }
}
