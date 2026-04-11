package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;

public class LayerTitane extends LayerData  {

    public LayerTitane(String _fxml, String _name) {
       super(_fxml, _name);
       data = new DataSetTitane(_name);
    }

    @Override
    public void layoutChildren() {
        super.layoutChildren();
        backgroundPane.setVisible(isShowing());
        if (!isShowing()) {
            return;
        }
        backgroundPane.resize(300, 300);
        resizeRelocate((MobileApplication.getInstance().getGlassPane().getWidth() - 300)/2,
        (MobileApplication.getInstance().getGlassPane().getHeight()- 400)/2,300, 300);
    }
}
