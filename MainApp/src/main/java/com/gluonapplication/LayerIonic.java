package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;

public class LayerIonic extends LayerData  {

    public LayerIonic(String _fxml, String _name) {
       super(_fxml, _name);
       data = new DataSetIonic(_name);
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
        (MobileApplication.getInstance().getGlassPane().getHeight()- 550)/2,300, 300);
    }
}
