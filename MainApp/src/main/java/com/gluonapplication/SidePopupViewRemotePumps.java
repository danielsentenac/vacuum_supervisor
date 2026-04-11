package com.gluonapplication;


public class SidePopupViewRemotePumps extends SidePopupViewData  {

    public SidePopupViewRemotePumps(String _fxml, String _name) {
       super(_fxml, _name);
       data = new DataSetRemotePumpsFlags(name);
    }
}
