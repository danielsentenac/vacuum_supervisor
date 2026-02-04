package com.gluonapplication;

import javafx.scene.control.Label;

public class SidePopupViewTubeSqzActions extends SidePopupViewData  {

    public SidePopupViewTubeSqzActions(String _fxml, String _name) {
       super(_fxml, _name);
       data = new DataSetTubeSqzActions(name);
    }
}
