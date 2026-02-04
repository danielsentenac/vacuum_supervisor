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

public class ControllerNE extends ControlLayer implements ControlTypes {

    @FXML
    private Label CryoNE;

    @FXML
    private Label TowerNE;

    @FXML
    private Label MiniTowerNE;
    
    @FXML
    private Label Tiltmeter;

    @FXML
    private Group VCryoNE;

    @FXML
    private SVGPath StatusVCryoNE;

    @FXML
    private Group VNE;

    @FXML
    private SVGPath StatusVNE;

    @FXML
    private Rectangle TUBEN;

    String style = "";

    @FXML
    void TUBEN_Clicked(MouseEvent event) {
       System.out.println("Clicked to TUBEN View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.tubeN == null) {
          main.tubeN = new ViewTube("TUBEN", "TUBEN");
          MobileApplication.getInstance().addViewFactory("TUBEN", () -> { return main.tubeN;});
          new Thread(main.tubeN).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("TUBEN");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void TUBEN_Pressed(MouseEvent event) {
       style = TUBEN.getStyle();
       TUBEN.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void TUBEN_Released(MouseEvent event) {
       TUBEN.setStyle(style);
    }


    @FXML
    void CryoNE_Clicked(MouseEvent event) {
       System.out.println("Switch to CryoNE View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.cryoNE == null) {
          main.cryoNE = new ViewCryoStation("CRYOSTATION", "CRYONE");
          main.addViewFactory("CRYONE", () -> { return main.cryoNE;});
          new Thread(main.cryoNE).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("CRYONE");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void CryoNE_Pressed(MouseEvent event) {
       style = CryoNE.getStyle();
       CryoNE.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void CryoNE_Released(MouseEvent event) {
       CryoNE.setStyle(style);
    }

    @FXML
    void MiniTowerNE_Clicked(MouseEvent event) {

    }

    @FXML
    void MiniTowerNE_Pressed(MouseEvent event) {
       style = MiniTowerNE.getStyle();
       MiniTowerNE.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void MiniTowerNE_Released(MouseEvent event) {
       MiniTowerNE.setStyle(style);
    }

    @FXML
    void TowerNE_Clicked(MouseEvent event) {
       System.out.println("Switch to TowerNE View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.towerNE == null) {
          main.towerNE = new ViewTowerStation("TOWERSTATION", "TOWERNE");
          MobileApplication.getInstance().addViewFactory("TOWERNE", () -> { return main.towerNE;});
          new Thread(main.towerNE).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("TOWERNE");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void TowerNE_Pressed(MouseEvent event) {
       style = TowerNE.getStyle();
       TowerNE.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void TowerNE_Released(MouseEvent event) {
       TowerNE.setStyle(style);
    }
    
    @FXML
    void Tiltmeter_Clicked(MouseEvent event) {
       System.out.println("Switch to Tiltmeter View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.tiltmeter == null) {
          main.tiltmeter = new ViewMiniTowerSqzStation("MINITOWERSQZ", "TILTMETER");
          MobileApplication.getInstance().addViewFactory("TILTMETER", () -> { return main.tiltmeter;});
          new Thread(main.tiltmeter).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("TILTMETER");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void Tiltmeter_Pressed(MouseEvent event) {
       style = Tiltmeter.getStyle();
       Tiltmeter.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Tiltmeter_Released(MouseEvent event) {
       Tiltmeter.setStyle(style);
    }

    @FXML
    void VCryoNE_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("CRYONE_VCRYO");
    }

    @FXML
    void VCryoNE_Pressed(MouseEvent event) {
       style = VCryoNE.getStyle();
       VCryoNE.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void VCryoNE_Released(MouseEvent event) {
       VCryoNE.setStyle(style);
    }

    @FXML
    void VNE_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("VALVEBIGNE");
    }

    @FXML
    void VNE_Pressed(MouseEvent event) {
       style = VNE.getStyle();
       VNE.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void VNE_Released(MouseEvent event) {
       VNE.setStyle(style);
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

