package com.gluonapplication;


public class SidePopupViewCryoActions extends SidePopupViewData  {

    public SidePopupViewCryoActions(String _fxml, String _name) {
       super(_fxml, _name);
       data = new DataSetCryoActions(name);
    }
}
