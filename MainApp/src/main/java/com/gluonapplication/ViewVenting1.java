package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.layout.layer.SidePopupView;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;

public class ViewVenting1 extends ViewData {

    private final String fxml;
    private final String name;

    public ViewVenting1(String _fxml, String _name) {
        super(_fxml, _name);
        fxml = _fxml;
        name = _name;
        data = new DataSetVenting1(name);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setStyle("-fx-font-size: 13");
        appBar.setTitleText(name + " View");
        appBar.setNavIcon(MaterialDesignIcon.ARROW_BACK.button(e -> {
            MobileApplication.getInstance().switchToPreviousView();
        }));
        appBar.getActionItems().addAll(MaterialDesignIcon.CONTROL_POINT.button(e -> {
            CreateAndShowActionsSidePopupView("VENTING1ACTIONS", name + "Actions");
            setMouseTransparent(false);
        }));
        appBar.getActionItems().addAll(MaterialDesignIcon.FLAG.button(e -> {
            CreateAndShowSidePopupView("VENTING1FLAGS", name);
            setMouseTransparent(false);
        }));
        appBar.getActionItems().addAll(MaterialDesignIcon.KEYBOARD_ARROW_UP.button(e -> {
            Main main = (Main) MobileApplication.getInstance();
            main.switchView(MobileApplication.HOME_VIEW);
        }));
    }

    void CreateAndShowSidePopupView(String fxml, String name) {
        if (!MobileApplication.getInstance().isLayerPresent(name)) {
            SidePopupViewData content = new SidePopupViewVenting1(fxml, name);
            Label viewName = (Label) content.pane.lookup("#ViewName");
            viewName.setText(name + " Flags");
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

    void CreateAndShowActionsSidePopupView(String fxml, String name) {
        if (!MobileApplication.getInstance().isLayerPresent(name)) {
            SidePopupViewData content = new SidePopupViewVenting1Actions(fxml, name.replace("Actions", ""));
            Label viewName = (Label) content.pane.lookup("#ViewName");
            if (viewName != null) {
                viewName.setText(name.replace("Actions", "") + " Operations");
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
