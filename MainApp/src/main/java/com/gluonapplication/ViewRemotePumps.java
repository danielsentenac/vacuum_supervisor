package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.layout.layer.SidePopupView;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;

public class ViewRemotePumps extends ViewData  {

    private String fxml;
    private String name;

    public ViewRemotePumps(String _fxml, String _name) {
        super(_fxml, _name);
        fxml = _fxml;
        name = _name;
        data = new DataSetRemotePumps(name);
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
        appBar.getActionItems().addAll(MaterialDesignIcon.FLAG.button(e -> {
           CreateAndShowSidePopupView("REMOTEPUMPSFLAGS", name);
           setMouseTransparent(false);
        }));
        appBar.getActionItems().addAll(MaterialDesignIcon.KEYBOARD_ARROW_UP.button(e -> {
           System.out.println("Clicked to GLOBAL View");
           Main main = (Main) MobileApplication.getInstance();
           ViewData previousView = (ViewData) MobileApplication.getInstance().getView();
           main.switchView(MobileApplication.HOME_VIEW);
           ViewData presentView = (ViewData) main.getView();
        }));
    }

    void CreateAndShowSidePopupView(String fxml, String name) {
       if ( !MobileApplication.getInstance().isLayerPresent(name) ) {
          SidePopupViewData content = new SidePopupViewRemotePumps(fxml, name);
          Label viewName = (Label) content.pane.lookup("#ViewName");
          viewName.setText(name + " Flags");
          try { 
             new Thread(content).start(); 
          }
          catch (Exception e) {
             e.printStackTrace();
          }
          ScrollPane scrollpane = new ScrollPane(content.pane);
          scrollpane.setStyle("-fx-background-color: transparent;");
          SidePopupView sidePopupView = new SidePopupView(scrollpane);
          sidePopupView.setOnHidden(e -> {content.isSuspended = true;});
          sidePopupView.setOnShowing(e -> {content.isSuspended = false;});
          MobileApplication.getInstance().addLayerFactory(name, () -> { return sidePopupView;});
       }
       MobileApplication.getInstance().showLayer(name);
   }
}
