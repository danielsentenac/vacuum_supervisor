package com.gluonapplication;

import javafx.scene.control.Label;

public class SidePopupViewTowerBenchStation extends SidePopupViewData  {

    public SidePopupViewTowerBenchStation(String _fxml, String _name) {
       super(_fxml, _name);
       data = new DataSetTowerBenchStationFlags(name);
    }
}
