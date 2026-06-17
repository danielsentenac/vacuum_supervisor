package com.gluonapplication;


public class SidePopupViewParticleCounter extends SidePopupViewData  {

    public SidePopupViewParticleCounter(String _fxml, String _name) {
       super(_fxml, _name);
       data = new DataSetParticleCounter(name);
    }
}
