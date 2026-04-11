package com.gluonapplication;


public class SidePopupViewTube extends SidePopupViewData  {

    public SidePopupViewTube(String _fxml, String _name) {
       super(_fxml, _name);
       data = new DataSetTubeFlags(name);
    }
}
