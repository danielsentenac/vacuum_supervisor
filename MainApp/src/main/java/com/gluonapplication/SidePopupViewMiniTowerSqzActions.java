package com.gluonapplication;

import javafx.scene.control.Label;

public class SidePopupViewMiniTowerSqzActions extends SidePopupViewData  {

    public SidePopupViewMiniTowerSqzActions(String _fxml, String _name) {
       super(_fxml, _name);
       data = new DataSetMiniTowerSqzActions(name);
    }
}
