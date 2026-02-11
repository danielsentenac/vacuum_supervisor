package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.gluonhq.charm.glisten.layout.layer.SidePopupView;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;

public class ViewGlobal extends ViewData {

    private String name;
    private String attribute;
    public ViewGlobal(String _fxml, String _name) {
        super(_fxml, _name);
        fxml = _fxml;
        name = _name; 
        data = new DataSetGlobal(name);
    }
  
    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setStyle("-fx-font-size: 13");
        appBar.setTitleText("Global View");
        appBar.getActionItems().addAll(MaterialDesignIcon.CONTROL_POINT.button(e -> {
           CreateAndShowSupervisorActionsSidePopupView("SUPERVISORACTIONS", "SUPERVISOR ACTIONS");
           setMouseTransparent(false);
        }));
        appBar.getActionItems().addAll(MaterialDesignIcon.INFO.button(e -> {
           CreateAndShowSensorO2SidePopupView("SENSORO2", "SENSOR O2");
           setMouseTransparent(false);
        }));
        appBar.getActionItems().addAll(MaterialDesignIcon.FLAG.button(e -> {
           CreateAndShowGlobalSidePopupView("GLOBALFLAGS", "Global Flags");
           setMouseTransparent(false);
        }));
        appBar.getActionItems().addAll(MaterialDesignIcon.BOOKMARK.button(e -> {
           CreateAndShowGlobalPlusSidePopupView("GLOBALFLAGSPLUS", "Global Flags Plus");
           setMouseTransparent(false);
        }));
    }
    
    void CreateAndShowSensorO2SidePopupView(String fxml, String name) {
       if ( !MobileApplication.getInstance().isLayerPresent(name) ) {
          SidePopupViewData content = new SidePopupViewSensorO2(fxml, name);
          Label viewName = (Label) content.pane.lookup("#ViewName");
          viewName.setText(name + " Flags");
          try { 
             new Thread(content).start(); 
          }
          catch (Exception e) {
             e.printStackTrace();
          }
          ScrollPane scrollpane = createSidePopupScrollPane(content.pane);
          SidePopupView sidePopupView = new SidePopupView(scrollpane);
          bindSidePopupLifecycle(sidePopupView, content);
          MobileApplication.getInstance().addLayerFactory(name, () -> { return sidePopupView;});
       }
       MobileApplication.getInstance().showLayer(name);
   }

    void CreateAndShowSupervisorActionsSidePopupView(String fxml, String name) {
       if ( !MobileApplication.getInstance().isLayerPresent(name) ) {
          SidePopupViewData content = new SidePopupViewSupervisorActions(fxml, name);
          Label viewName = (Label) content.pane.lookup("#ViewName");
          viewName.setText(name);
          try { 
             new Thread(content).start(); 
          }
          catch (Exception e) {
             e.printStackTrace();
          }
          ScrollPane scrollpane = createSidePopupScrollPane(content.pane);
          SidePopupView sidePopupView = new SidePopupView(scrollpane);
          bindSidePopupLifecycle(sidePopupView, content);
          MobileApplication.getInstance().addLayerFactory(name, () -> { return sidePopupView;});
       }
       MobileApplication.getInstance().showLayer(name);
   }

   void CreateAndShowGlobalSidePopupView(String fxml, String name) {
       if ( !MobileApplication.getInstance().isLayerPresent(name) ) {
          SidePopupViewData content = new SidePopupViewGlobal(fxml, name);
          Label viewName = (Label) content.pane.lookup("#ViewName");
          viewName.setText(name);
          try { 
             new Thread(content).start(); 
          }
          catch (Exception e) {
             e.printStackTrace();
          }
          ScrollPane scrollpane = createSidePopupScrollPane(content.pane);
          SidePopupView sidePopupView = new SidePopupView(scrollpane);
          bindSidePopupLifecycle(sidePopupView, content);
          MobileApplication.getInstance().addLayerFactory(name, () -> { return sidePopupView;});
       }
       MobileApplication.getInstance().showLayer(name);
   }
   
   void CreateAndShowGlobalPlusSidePopupView(String fxml, String name) {
       if ( !MobileApplication.getInstance().isLayerPresent(name) ) {
          SidePopupViewData content = new SidePopupViewGlobalPlus(fxml, name);
          Label viewName = (Label) content.pane.lookup("#ViewName");
          viewName.setText(name);
          try { 
             new Thread(content).start(); 
          }
          catch (Exception e) {
             e.printStackTrace();
          }
          ScrollPane scrollpane = createSidePopupScrollPane(content.pane);
          SidePopupView sidePopupView = new SidePopupView(scrollpane);
          bindSidePopupLifecycle(sidePopupView, content);
          MobileApplication.getInstance().addLayerFactory(name, () -> { return sidePopupView;});
       }
       MobileApplication.getInstance().showLayer(name);
   }
}
