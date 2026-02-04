package com.gluonapplication;

import javafx.scene.control.Label;

public class SidePopupViewCryoLinkStation extends SidePopupViewData  {

    public SidePopupViewCryoLinkStation(String _fxml, String _name) {
       super(_fxml, _name);
       data = new DataSetCryoLinkStationFlags(name);
    }
}
