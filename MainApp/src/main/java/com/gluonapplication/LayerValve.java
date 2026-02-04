package com.gluonapplication;

import javafx.scene.control.Label;

public class LayerValve extends LayerData  {

    public LayerValve(String _fxml, String _name) {
       super(_fxml, _name);
       data = new DataSetValve(_name);
    }
}
