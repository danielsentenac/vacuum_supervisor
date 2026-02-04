package com.gluonapplication;

import javafx.scene.control.Label;

public class SidePopupViewTubeLalStation extends SidePopupViewData  {

    public SidePopupViewTubeLalStation(String _fxml, String _name) {
       super(_fxml, _name);
       data = new DataSetTubeLalStationFlags(name);
    }
}
