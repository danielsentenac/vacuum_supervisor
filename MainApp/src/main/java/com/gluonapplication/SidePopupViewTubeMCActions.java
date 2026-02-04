package com.gluonapplication;

import javafx.scene.control.Label;

public class SidePopupViewTubeMCActions extends SidePopupViewData  {

    public SidePopupViewTubeMCActions(String _fxml, String _name) {
       super(_fxml, _name);
       data = new DataSetTubeMCActions(name);
    }
}
