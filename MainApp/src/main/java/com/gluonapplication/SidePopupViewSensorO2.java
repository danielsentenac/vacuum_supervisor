package com.gluonapplication;

import javafx.scene.control.Label;

public class SidePopupViewSensorO2 extends SidePopupViewData  {

    public SidePopupViewSensorO2(String _fxml, String _name) {
       super(_fxml, _name);
       data = new DataSetSensorO2(name);
    }
}
