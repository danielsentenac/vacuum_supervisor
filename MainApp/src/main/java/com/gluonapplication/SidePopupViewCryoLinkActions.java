package com.gluonapplication;

import javafx.scene.control.Label;

public class SidePopupViewCryoLinkActions extends SidePopupViewData  {

    public SidePopupViewCryoLinkActions(String _fxml, String _name) {
       super(_fxml, _name);
       data = new DataSetCryoLinkActions(name);
    }
}
