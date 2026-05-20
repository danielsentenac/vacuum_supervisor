package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import javafx.scene.control.Label;


public class SidePopupViewGlobal extends SidePopupViewData  {

    public SidePopupViewGlobal(String _fxml, String _name) {
       super(_fxml, _name);
       data = new DataSetGlobalFlags(name);
       wireSafetyFlagsButton("SafetyFlagsCB", "CBSAFETYFLAGS", "CB Safety Flags");
       wireSafetyFlagsButton("SafetyFlagsNE", "NESAFETYFLAGS", "NE Safety Flags");
       wireSafetyFlagsButton("SafetyFlagsWE", "WESAFETYFLAGS", "WE Safety Flags");
    }

    private void wireSafetyFlagsButton(String fxId, String fxml, String viewId) {
        if (pane == null) return;
        Label btn = (Label) pane.lookup("#" + fxId);
        if (btn != null) {
            btn.setOnMouseClicked(e -> showSafetyFlagsView(fxml, viewId));
        }
    }

    private void showSafetyFlagsView(String fxml, String viewId) {
        MobileApplication.getInstance().hideLayer(name);
        SafetyFlagsNavigation.show(fxml, viewId);
    }
}
