package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import javafx.fxml.FXML;
import javafx.scene.shape.SVGPath;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import com.gluonhq.charm.glisten.mvc.View;
import javafx.scene.input.ZoomEvent;

public class ControllerWE extends ControlLayer implements ControlTypes {

    @FXML
    private Label CryoWE;

    @FXML
    private Label TowerWE;

    @FXML
    private Label MiniTowerWE;

    @FXML
    private Group VCryoWE;

    @FXML
    private SVGPath StatusVCryoWE;

    @FXML
    private Group VWE;

    @FXML
    private SVGPath StatusVWE;

    @FXML
    private Rectangle TUBEW; 

    String style = "";

    @FXML
    void TUBEW_Clicked(MouseEvent event) {
       System.out.println("Clicked to TUBEW View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.tubeW == null) {
          main.tubeW = new ViewTube("TUBEW", "TUBEW");
          MobileApplication.getInstance().addViewFactory("TUBEW", () -> { return main.tubeW;});
          new Thread(main.tubeW).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("TUBEW");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void TUBEW_Pressed(MouseEvent event) {
       style = TUBEW.getStyle();
       TUBEW.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void TUBEW_Released(MouseEvent event) {
       TUBEW.setStyle(style);
    }

    @FXML
    void CryoWE_Clicked(MouseEvent event) {
       System.out.println("Switch to CryoWE View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.cryoWE == null) {
          main.cryoWE = new ViewCryoStation("CRYOSTATION", "CRYOWE");
          main.addViewFactory("CRYOWE", () -> { return main.cryoWE;});
          new Thread(main.cryoWE).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("CRYOWE");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void CryoWE_Pressed(MouseEvent event) {
       style = CryoWE.getStyle();
       CryoWE.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void CryoWE_Released(MouseEvent event) {
       CryoWE.setStyle(style);
    }

    @FXML
    void MiniTowerWE_Clicked(MouseEvent event) {

    }

    @FXML
    void MiniTowerWE_Pressed(MouseEvent event) {
       style = MiniTowerWE.getStyle();
       MiniTowerWE.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void MiniTowerWE_Released(MouseEvent event) {
       MiniTowerWE.setStyle(style);
    }

    @FXML
    void TowerWE_Clicked(MouseEvent event) {
       System.out.println("Switch to TowerWE View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.towerWE == null) {
          main.towerWE = new ViewTowerStation("TOWERSTATION", "TOWERWE");
          MobileApplication.getInstance().addViewFactory("TOWERWE", () -> { return main.towerWE;});
          new Thread(main.towerWE).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("TOWERWE");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void TowerWE_Pressed(MouseEvent event) {
       style = TowerWE.getStyle();
       TowerWE.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void TowerWE_Released(MouseEvent event) {
       TowerWE.setStyle(style);
    }

    @FXML
    void VCryoWE_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("CRYOWE_VCRYO");
    }

    @FXML
    void VCryoWE_Pressed(MouseEvent event) {
       style = VCryoWE.getStyle();
       VCryoWE.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void VCryoWE_Released(MouseEvent event) {
       VCryoWE.setStyle(style);
    }

    @FXML
    void VWE_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("VALVEBIGWE");
    }

    @FXML
    void VWE_Pressed(MouseEvent event) {
       style = VWE.getStyle();
       VWE.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void VWE_Released(MouseEvent event) {
       VWE.setStyle(style);
    }

    @Override
    void CreateAndShowValveLayer(String name) {
       if ( !MobileApplication.getInstance().isLayerPresent(name + ":-") ) {
          LayerData valve = new LayerValve("VALVE", name + ":-");
          Label valveName = (Label) valve.lookup("#ValveName");
          valveName.setText(name);
          try { 
             new Thread(valve).start(); 
          }
          catch (Exception e) {
             e.printStackTrace();
          }
          MobileApplication.getInstance().addLayerFactory(name + ":-", () -> { return  valve;});
       }
       MobileApplication.getInstance().showLayer(name + ":-");
   }
    
}

