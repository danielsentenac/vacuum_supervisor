package com.gluonapplication;

import javafx.scene.control.Label;

public class SidePopupViewTubeSqzStation extends SidePopupViewData  {

    public SidePopupViewTubeSqzStation(String _fxml, String _name) {
       super(_fxml, _name);
       data = new DataSetTubeSqzStationFlags(name);
    }
}
