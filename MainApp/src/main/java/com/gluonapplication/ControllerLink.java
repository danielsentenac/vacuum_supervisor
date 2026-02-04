package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.SVGPath;


public class ControllerLink extends ControlLayer implements ControlTypes {

    @FXML
    private Group V21;

    @FXML
    private SVGPath StatusV21;

    @FXML
    private Group P21;

    @FXML
    private Rectangle StatusP21;

    @FXML
    private Group V23;

    @FXML
    private SVGPath StatusV23;

    @FXML
    private Group V22;

    @FXML
    private SVGPath StatusV22;

    @FXML
    private Group G22;

    @FXML
    private Circle StatusG22;

    @FXML
    private Group P22;

    @FXML
    private Rectangle StatusP22;

    @FXML
    private Label PressureG22;

    @FXML
    private Group G21;

    @FXML
    private Circle StatusG21;

    @FXML
    private Label PressureG21;

    @FXML
    private Label SpeedP21;

    @FXML
    private Group RemotePumping;
    
    @FXML
    private Group Ge4;
    
    @FXML
    private Circle StatusGe4;
        
    String style = "";

    @FXML
    void SpeedP21_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotP21");
    }

    @FXML
    void SpeedP21_Pressed(MouseEvent event) {
       style = SpeedP21.getStyle();
       SpeedP21.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void SpeedP21_Released(MouseEvent event) {
       SpeedP21.setStyle(style);
    }

    @FXML
    void G21_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "G21");
    }

    @FXML
    void G21_Pressed(MouseEvent event) {
       style = StatusG21.getStyle();
       StatusG21.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void G21_Released(MouseEvent event) {
       StatusG21.setStyle(style);
    }

    @FXML
    void G22_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "G22");
    }

    @FXML
    void G22_Pressed(MouseEvent event) {
       style = StatusG22.getStyle();
       StatusG22.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void G22_Released(MouseEvent event) {
       StatusG22.setStyle(style);
    }

    @FXML
    void P21_Clicked(MouseEvent event) {
       CreateAndShowTurboLayer("TURBO", "P21");
    }

    @FXML
    void P21_Pressed(MouseEvent event) {
       style = StatusP21.getStyle();
       StatusP21.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void P21_Released(MouseEvent event) {
       StatusP21.setStyle(style);
    }

    @FXML
    void P22_Clicked(MouseEvent event) {
       CreateAndShowDryLayer("P22");
    }

    @FXML
    void P22_Pressed(MouseEvent event) {
       style = StatusP22.getStyle();
       StatusP22.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void P22_Released(MouseEvent event) {
       StatusP22.setStyle(style);
    }


    @FXML
    void PressureG21_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotG21");
    }

    @FXML
    void PressureG21_Pressed(MouseEvent event) {
       style = PressureG21.getStyle();
       PressureG21.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureG21_Released(MouseEvent event) {
       PressureG21.setStyle(style);
    }

    @FXML
    void PressureG22_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotG22");
    }

    @FXML
    void PressureG22_Pressed(MouseEvent event) {
       style = PressureG22.getStyle();
       PressureG22.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureG22_Released(MouseEvent event) {
       PressureG22.setStyle(style);
    }

    @FXML
    void Ge4_Clicked(MouseEvent event) {
       CreateAndShowRGALayer("Ge4");
    }

    @FXML
    void Ge4_Pressed(MouseEvent event) {
       style = StatusGe4.getStyle();
       StatusGe4.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Ge4_Released(MouseEvent event) {
       StatusGe4.setStyle(style);
    }
    
    @FXML
    void V21_Clicked(MouseEvent event) {
	CreateAndShowValveLayer("V21");
    }

    @FXML
    void V21_Pressed(MouseEvent event) {
       style = StatusV21.getStyle();
       StatusV21.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V21_Released(MouseEvent event) {
       StatusV21.setStyle(style);
    }

    @FXML
    void V22_Clicked(MouseEvent event) {
	CreateAndShowValveLayer("V22");
    }

    @FXML
    void V22_Pressed(MouseEvent event) {
       style = StatusV22.getStyle();
       StatusV22.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V22_Released(MouseEvent event) {
       StatusV22.setStyle(style);
    }

    @FXML
    void V23_Clicked(MouseEvent event) {
	CreateAndShowValveLayer("V23");
    }

    @FXML
    void V23_Pressed(MouseEvent event) {
       style = StatusV23.getStyle();
       StatusV23.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V23_Released(MouseEvent event) {
       StatusV23.setStyle(style);
    }
   
    @FXML
    void RemotePumping_Clicked(MouseEvent event) {
       System.out.println("Switch to REMOTEPUMPS View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.remotePumps == null) {
          main.remotePumps = new ViewRemotePumps("REMOTEPUMPS", "REMOTESCROLL");
          main.addViewFactory("REMOTEPUMPS", () -> { return main.remotePumps;});
          new Thread(main.remotePumps).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("REMOTEPUMPS");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void RemotePumping_Pressed(MouseEvent event) {
       style = RemotePumping.getStyle();
       RemotePumping.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void RemotePumping_Released(MouseEvent event) {
       RemotePumping.setStyle(style);
    }
    @Override
   void CreateAndShowRGALayer(String name) {
       ViewData presentView = (ViewData) MobileApplication.getInstance().getView();
       //if ( !MobileApplication.getInstance().isLayerPresent(presentView.name + ":" + name) ) {
          MobileApplication.getInstance().removeLayerFactory("LINKPR:" + name);
          LayerData rga = new LayerRGA("CHART", "LINKPR:" + name);
          try { 
             new Thread(rga).start(); 
          }
          catch (Exception e) {
             e.printStackTrace();
          }
          MobileApplication.getInstance().addLayerFactory("LINKPR:" + name, () -> { return  rga;});
       //}
       MobileApplication.getInstance().showLayer("LINKPR:" + name);
   }
}

