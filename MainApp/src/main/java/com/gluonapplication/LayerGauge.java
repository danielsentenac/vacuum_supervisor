package com.gluonapplication;

public class LayerGauge extends LayerData  {

    public LayerGauge(String _fxml, String _name) {
        super(_fxml, _name);
        data = new DataSetGauge(_name);
    }
}
