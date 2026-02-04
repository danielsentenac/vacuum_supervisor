package com.gluonapplication;

import javafx.scene.control.Label;

public class SidePopupViewLinkActions extends SidePopupViewData  {

    public SidePopupViewLinkActions(String _fxml, String _name) {
       super(_fxml, _name);
       data = new DataSetLinkActions(name);
    }
}
