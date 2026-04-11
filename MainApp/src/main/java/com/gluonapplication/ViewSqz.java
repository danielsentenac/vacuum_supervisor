package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.gluonhq.charm.glisten.control.AppBar;

public class ViewSqz extends ViewData  {

    private String fxml;
    private String name;

    public ViewSqz(String _fxml, String _name) {
        super(_fxml, _name);
        fxml = _fxml;
        name = _name;
        data = new DataSetSqz(name);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setStyle("-fx-font-size: 13");
        appBar.setTitleText(name + " View");
        appBar.setNavIcon(MaterialDesignIcon.ARROW_BACK.button(e -> {
           ViewData previousView = (ViewData) MobileApplication.getInstance().getView();
           MobileApplication.getInstance().switchToPreviousView();
           ViewData presentView = (ViewData) MobileApplication.getInstance().getView();
           System.out.println("Switch to " + presentView.name + " View");
        }));
        appBar.getActionItems().addAll(MaterialDesignIcon.KEYBOARD_ARROW_UP.button(e -> {
           System.out.println("Clicked to GLOBAL View");
           Main main = (Main) MobileApplication.getInstance();
           ViewData previousView = (ViewData) MobileApplication.getInstance().getView();
           main.switchView(MobileApplication.HOME_VIEW);
           ViewData presentView = (ViewData) main.getView();
        }));
    }
}
