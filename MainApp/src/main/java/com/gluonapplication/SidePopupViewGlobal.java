package com.gluonapplication;

import javafx.scene.control.Label;

public class SidePopupViewGlobal extends SidePopupViewData  {

    public SidePopupViewGlobal(String _fxml, String _name) {
       super(_fxml, _name);
       data = new DataSetGlobalFlags(name);
    }
}
