package com.gluonapplication;

import javafx.scene.control.Label;

public class LayerDry extends LayerData  {

    public LayerDry(String _fxml, String _name) {
       super(_fxml, _name);
       data = new DataSetDry(_name);
    }
}
