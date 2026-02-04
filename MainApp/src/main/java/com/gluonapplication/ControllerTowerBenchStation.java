package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.SVGPath;


public class ControllerTowerBenchStation extends ControlLayer implements ControlTypes {

    @FXML
    private Group Vc1;

    @FXML
    private SVGPath StatusVc1;

    @FXML
    private Group Vc2;

    @FXML
    private SVGPath StatusVc2;

    @FXML
    private Label PressureGc1;

    @FXML
    private Label PressureGc3;

    @FXML
    private Label PressureGc2;

    @FXML
    private Label PressureG61;

    @FXML
    private Label PressureG51;

    @FXML
    private Label SpeedP51;

    @FXML
    private Group Gc1;

    @FXML
    private Circle StatusGc1;

    @FXML
    private Group Gc2;

    @FXML
    private Circle StatusGc2;

    @FXML
    private Group Gc3;

    @FXML
    private Circle StatusGc3;

    @FXML
    private Group Gc4;

    @FXML
    private Circle StatusGc4;

    @FXML
    private Group V51;

    @FXML
    private SVGPath StatusV51;

    @FXML
    private Group P51;

    @FXML
    private Rectangle StatusP51;

    @FXML
    private Group G51;

    @FXML
    private Circle StatusG51;

    @FXML
    private Group V53;

    @FXML
    private SVGPath StatusV53;

    @FXML
    private Group V54;

    @FXML
    private SVGPath StatusV54;

    @FXML
    private Group G61;

    @FXML
    private Circle StatusG61;

    @FXML
    private Group P61;

    @FXML
    private Rectangle StatusP61;

    @FXML
    private Group V52;

    @FXML
    private SVGPath StatusV52;

    @FXML
    private Label PressureG41;

    @FXML
    private Group G41;

    @FXML
    private Circle StatusG41;

    @FXML
    private Group P41;

    @FXML
    private Rectangle StatusP41;

    @FXML
    private Group V41;

    @FXML
    private SVGPath StatusV41;

    @FXML
    private Group V42;

    @FXML
    private SVGPath StatusV42;

    @FXML
    private Group V91;

    @FXML
    private SVGPath StatusV91;

    @FXML
    private Group V92;

    @FXML
    private SVGPath StatusV92;

    @FXML
    private Label Flow;

    @FXML
    private Label Temperature;

    @FXML
    private Label Humidity;

    @FXML
    private Group RemotePumping;

    String style = "";


    @FXML
    void SpeedP51_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotP51");
    }

    @FXML
    void SpeedP51_Pressed(MouseEvent event) {
       style = SpeedP51.getStyle();
       SpeedP51.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void SpeedP51_Released(MouseEvent event) {
       SpeedP51.setStyle(style);
    }

    @FXML
    void G41_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "G41");
    }

    @FXML
    void G41_Pressed(MouseEvent event) {
       style = StatusG41.getStyle();
       StatusG41.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void G41_Released(MouseEvent event) {
       StatusG41.setStyle(style);
    }

    @FXML
    void G51_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "G51");
    }

    @FXML
    void G51_Pressed(MouseEvent event) {
       style = StatusG51.getStyle();
       StatusG51.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void G51_Released(MouseEvent event) {
       StatusG51.setStyle(style);
    }

    @FXML
    void G61_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "G61");
    }

    @FXML
    void G61_Pressed(MouseEvent event) {
       style = StatusG61.getStyle();
       StatusG61.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void G61_Released(MouseEvent event) {
       StatusG61.setStyle(style);
    }

    @FXML
    void Gc1_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "Gc1");
    }

    @FXML
    void Gc1_Pressed(MouseEvent event) {
       style = StatusGc1.getStyle();
       StatusGc1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Gc1_Released(MouseEvent event) {
       StatusGc1.setStyle(style);
    }

    @FXML
    void Gc2_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "Gc2");
    }

    @FXML
    void Gc2_Pressed(MouseEvent event) {
       style = StatusGc2.getStyle();
       StatusGc2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Gc2_Released(MouseEvent event) {
       StatusGc2.setStyle(style);
    }

    @FXML
    void Gc3_Clicked(MouseEvent event) {
      CreateAndShowGaugeLayer("ITRGAUGE", "Gc3");
    }

    @FXML
    void Gc3_Pressed(MouseEvent event) {
       style = StatusGc3.getStyle();
       StatusGc3.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Gc3_Released(MouseEvent event) {
       StatusGc3.setStyle(style);
    }

    @FXML
    void Gc4_Clicked(MouseEvent event) {
       CreateAndShowRGALayer("Gc4");
    }

    @FXML
    void Gc4_Pressed(MouseEvent event) {
       style = StatusGc4.getStyle();
       StatusGc4.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Gc4_Released(MouseEvent event) {
       StatusGc4.setStyle(style);
    }

    @FXML
    void P41_Clicked(MouseEvent event) {
       CreateAndShowDryLayer("P41");
    }

    @FXML
    void P41_Pressed(MouseEvent event) {
       style = StatusP41.getStyle();
       StatusP41.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void P41_Released(MouseEvent event) {
       StatusP41.setStyle(style);
    }

    @FXML
    void P51_Clicked(MouseEvent event) {
       CreateAndShowTurboLayer("TURBO", "P51");
    }

    @FXML
    void P51_Pressed(MouseEvent event) {
       style = StatusP51.getStyle();
       StatusP51.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void P51_Released(MouseEvent event) {
       StatusP51.setStyle(style);
    }

    @FXML
    void P61_Clicked(MouseEvent event) {
       CreateAndShowDryLayer("P61");
    }

    @FXML
    void P61_Pressed(MouseEvent event) {
       style = StatusP61.getStyle();
       StatusP61.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void P61_Released(MouseEvent event) {
       StatusP61.setStyle(style);
    }

    @FXML
    void PressureG41_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotG41");
    }

    @FXML
    void PressureG41_Pressed(MouseEvent event) {
       style = PressureG41.getStyle();
       PressureG41.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureG41_Released(MouseEvent event) {
       PressureG41.setStyle(style);
    }

    @FXML
    void PressureG51_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotG51");
    }

    @FXML
    void PressureG51_Pressed(MouseEvent event) {
       style = PressureG51.getStyle();
       PressureG51.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureG51_Released(MouseEvent event) {
       PressureG51.setStyle(style);
    }

    @FXML
    void PressureG61_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotG61");
    }

    @FXML
    void PressureG61_Pressed(MouseEvent event) {
       style = PressureG61.getStyle();
       PressureG61.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureG61_Released(MouseEvent event) {
       PressureG61.setStyle(style);
    }

    @FXML
    void PressureGc1_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotGc1");
    }

    @FXML
    void PressureGc1_Pressed(MouseEvent event) {
       style = PressureGc1.getStyle();
       PressureGc1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureGc1_Released(MouseEvent event) {
       PressureGc1.setStyle(style);
    }

    @FXML
    void PressureGc2_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotGc2");
    }

    @FXML
    void PressureGc2_Pressed(MouseEvent event) {
       style = PressureGc2.getStyle();
       PressureGc2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureGc2_Released(MouseEvent event) {
       PressureGc2.setStyle(style);
    }

    @FXML
    void PressureGc3_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotGc3");
    }

    @FXML
    void PressureGc3_Pressed(MouseEvent event) {
       style = PressureGc3.getStyle();
       PressureGc3.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureGc3_Released(MouseEvent event) {
       PressureGc3.setStyle(style);
    }

    @FXML
    void V41_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("V41");
    }

    @FXML
    void V41_Pressed(MouseEvent event) {
       style = StatusV41.getStyle();
       StatusV41.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V41_Released(MouseEvent event) {
       StatusV41.setStyle(style);
    }

    @FXML
    void V42_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("V42");
    }

    @FXML
    void V42_Pressed(MouseEvent event) {
       style = StatusV42.getStyle();
       StatusV42.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V42_Released(MouseEvent event) {
       StatusV42.setStyle(style);
    }

    @FXML
    void V51_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("V51");
    }

    @FXML
    void V51_Pressed(MouseEvent event) {
       style = StatusV51.getStyle();
       StatusV51.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V51_Released(MouseEvent event) {
       StatusV51.setStyle(style);
    }

    @FXML
    void V52_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("V52");
    }

    @FXML
    void V52_Pressed(MouseEvent event) {
       style = StatusV52.getStyle();
       StatusV52.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V52_Released(MouseEvent event) {
       StatusV52.setStyle(style);
    }

    @FXML
    void V53_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("V53");
    }

    @FXML
    void V53_Pressed(MouseEvent event) {
       style = StatusV53.getStyle();
       StatusV53.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V53_Released(MouseEvent event) {
       StatusV53.setStyle(style);
    }

    @FXML
    void V54_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("V54");
    }

    @FXML
    void V54_Pressed(MouseEvent event) {
       style = StatusV54.getStyle();
       StatusV54.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V54_Released(MouseEvent event) {
       StatusV54.setStyle(style);
    }

    @FXML
    void V91_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("V91");
    }

    @FXML
    void V91_Pressed(MouseEvent event) {
       style = StatusV91.getStyle();
       StatusV91.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V91_Released(MouseEvent event) {
       StatusV91.setStyle(style);
    }

    @FXML
    void V92_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("V92");
    }

    @FXML
    void V92_Pressed(MouseEvent event) {
       style = StatusV92.getStyle();
       StatusV92.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V92_Released(MouseEvent event) {
       StatusV92.setStyle(style);
    }

    @FXML
    void Vc1_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("Vc1");
    }

    @FXML
    void Vc1_Pressed(MouseEvent event) {
       style = StatusVc1.getStyle();
       StatusVc1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Vc1_Released(MouseEvent event) {
       StatusVc1.setStyle(style);
    }

    @FXML
    void Vc2_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("Vc2");
    }

    @FXML
    void Vc2_Pressed(MouseEvent event) {
       style = StatusVc2.getStyle();
       StatusVc2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Vc2_Released(MouseEvent event) {
       StatusVc2.setStyle(style);
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
          MobileApplication.getInstance().removeLayerFactory("LINKDET:" + name);
          LayerData rga = new LayerRGA("CHART", "LINKDET:" + name);
          try { 
             new Thread(rga).start(); 
          }
          catch (Exception e) {
             e.printStackTrace();
          }
          MobileApplication.getInstance().addLayerFactory("LINKDET:" + name, () -> { return  rga;});
       //}
       MobileApplication.getInstance().showLayer("LINKDET:" + name);
   }
}

