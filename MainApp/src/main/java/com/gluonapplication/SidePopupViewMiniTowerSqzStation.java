package com.gluonapplication;

import javafx.scene.control.Label;

public class SidePopupViewMiniTowerSqzStation extends SidePopupViewData  {

    public SidePopupViewMiniTowerSqzStation(String _fxml, String _name) {
       super(_fxml, _name);
       data = new DataSetMiniTowerSqzStationFlags(name);
    }
}
