package com.gluonapplication;


public class SidePopupViewGlobalPlus extends SidePopupViewData  {

    public SidePopupViewGlobalPlus(String _fxml, String _name) {
       super(_fxml, _name);
       data = new DataSetGlobalFlagsPlus(name);
    }
}
