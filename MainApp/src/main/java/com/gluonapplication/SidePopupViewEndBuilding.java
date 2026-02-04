package com.gluonapplication;

import javafx.scene.control.Label;

public class SidePopupViewEndBuilding extends SidePopupViewData  {

    public SidePopupViewEndBuilding(String _fxml, String _name) {
       super(_fxml, _name);
       data = new DataSetEndBuildingFlags(name);
    }
}
