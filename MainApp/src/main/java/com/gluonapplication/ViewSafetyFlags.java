package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.layout.layer.SidePopupView;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;


public class ViewSafetyFlags extends ViewData {

    public ViewSafetyFlags(String _fxml, String _name) {
        super(_fxml, _name);
        switch (_fxml) {
            case "CBSAFETYFLAGS":
                data = new DataSetCBSafety(name);
                break;
            case "NESAFETYFLAGS":
                data = new DataSetNESafety(name);
                break;
            case "WESAFETYFLAGS":
                data = new DataSetWESafety(name);
                break;
            default:
                data = new DataSet();
                data.Init();
                break;
        }
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setStyle("-fx-font-size: 13");
        appBar.setTitleText(name);
        appBar.setNavIcon(MaterialDesignIcon.ARROW_BACK.button(e -> {
            MobileApplication.getInstance().switchToPreviousView();
        }));
        if (fxml.equals("CBSAFETYFLAGS")) {
            appBar.getActionItems().addAll(MaterialDesignIcon.CONTROL_POINT.button(e -> {
                CreateAndShowBeamShutterSidePopupView("BEAMSHUTTERACTIONS", name + "BeamShutterActions");
                setMouseTransparent(false);
            }));
        }
        appBar.getActionItems().addAll(MaterialDesignIcon.KEYBOARD_ARROW_UP.button(e -> {
            Main main = (Main) MobileApplication.getInstance();
            main.switchView(MobileApplication.HOME_VIEW);
        }));
    }

    void CreateAndShowBeamShutterSidePopupView(String fxml, String name) {
        if (!MobileApplication.getInstance().isLayerPresent(name)) {
            SidePopupViewData content = new SidePopupViewBeamShutterActions(fxml, name);
            Label viewName = (Label) content.pane.lookup("#ViewName");
            if (viewName != null) {
                viewName.setText("Viewport Beam Shutters");
            }
            try {
                new Thread(content).start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            ScrollPane scrollpane = createSidePopupScrollPane(content.pane);
            SidePopupView sidePopupView = new SidePopupView(scrollpane);
            bindSidePopupLifecycle(sidePopupView, content);
            MobileApplication.getInstance().addLayerFactory(name, () -> {
                return sidePopupView;
            });
        }
        MobileApplication.getInstance().showLayer(name);
    }
}
