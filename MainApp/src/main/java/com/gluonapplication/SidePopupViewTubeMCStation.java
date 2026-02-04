package com.gluonapplication;

import javafx.scene.control.Label;

public class SidePopupViewTubeMCStation extends SidePopupViewData  {

    public SidePopupViewTubeMCStation(String _fxml, String _name) {
       super(_fxml, _name);
       data = new DataSetTubeMCStationFlags(name);
    }
}
