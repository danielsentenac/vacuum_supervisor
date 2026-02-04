package com.gluonapplication;


public class SidePopupViewCentralBuilding extends SidePopupViewData  {

    public SidePopupViewCentralBuilding(String _fxml, String _name) {
       super(_fxml, _name);
       data = new DataSetCentralBuildingFlags(name);
    }
}
