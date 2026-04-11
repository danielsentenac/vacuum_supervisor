package com.gluonapplication;


public class LayerValve extends LayerData  {

    public LayerValve(String _fxml, String _name) {
       super(_fxml, _name);
       data = new DataSetValve(_name);
    }
}
