package com.gluonapplication;

import javafx.scene.control.Label;

public class SidePopupViewCryoStation extends SidePopupViewData  {

    public SidePopupViewCryoStation(String _fxml, String _name) {
       super(_fxml, _name);
       data = new DataSetCryoStationFlags(name);
    }
}
