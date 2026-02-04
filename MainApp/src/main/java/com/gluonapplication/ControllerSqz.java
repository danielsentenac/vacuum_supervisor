package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.shape.SVGPath;
import javafx.scene.input.MouseEvent;

public class ControllerSqz extends ControlLayer implements ControlTypes {

     @FXML
    private Group GMid;

    @FXML
    private Circle StatusGMid;

    @FXML
    private Label PressureGMid;

    @FXML
    private Group V21Sqz200N;

    @FXML
    private SVGPath StatusV21Sqz200N;

    @FXML
    private Group V21Sqz100N;

    @FXML
    private SVGPath StatusV21Sqz100N;

    @FXML
    private Label PressureSqz0N;

    @FXML
    private Label PressureSqz100N;

    @FXML
    private Label PressureSqz200N;

    @FXML
    private Label PressureSqz300N;

    @FXML
    private Label StationSqz100N;

    @FXML
    private Label StationSqz200N;

    @FXML
    private Group VPSqz300N;

    @FXML
    private SVGPath StatusVPSqz300N;

    @FXML
    private Group VPSqzDET2;

    @FXML
    private SVGPath StatusVPSqzDET2;

    @FXML
    private Label StationSqz300N;

    @FXML
    private Group VPSqz0N;

    @FXML
    private SVGPath StatusVPSqz0N;

    @FXML
    private Label StationSqz0N;

    @FXML
    private Group VPSqzDET1;

    @FXML
    private SVGPath StatusVPSqzDET1;

    @FXML
    private Label StationSqzDET1;

    @FXML
    private Label StationSqzDET2;

    @FXML
    private Label PressureSqzDET2;

    @FXML
    private Label PressureSqzDET1;

    private String style = "";


    @FXML
    void GMid_Clicked(MouseEvent event) {
	CreateAndShowGaugeLayer("MAXIGAUGE", "GMid");
    }

    @FXML
    void GMid_Pressed(MouseEvent event) {
       style = StatusGMid.getStyle();
       StatusGMid.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void GMid_Released(MouseEvent event) {
       StatusGMid.setStyle(style);
    }

    @FXML
    void PressureGMid_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotGMid");
    }

    @FXML
    void PressureGMid_Pressed(MouseEvent event) {

    }

    @FXML
    void PressureGMid_Released(MouseEvent event) {

    }


    @FXML
    void StationSqz100N_Clicked(MouseEvent event) {
       System.out.println("Switch to TubeSqz100N View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.tubesqz100N == null) {
          main.tubesqz100N = new ViewTubeSqzStation("TUBESQZ", "SQZ100N");
          main.addViewFactory("SQZ100N", () -> { return main.tubesqz100N;});
          new Thread(main.tubesqz100N).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("SQZ100N");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void StationSqz100N_Pressed(MouseEvent event) {
       style = StationSqz100N.getStyle();
       StationSqz100N.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void StationSqz100N_Released(MouseEvent event) {
       StationSqz100N.setStyle(style);
    }

    @FXML
    void StationSqz200N_Clicked(MouseEvent event) {
       System.out.println("Switch to TubeSqz200N View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.tubesqz200N == null) {
          main.tubesqz200N = new ViewTubeSqzStation("TUBESQZ", "SQZ200N");
          main.addViewFactory("SQZ200N", () -> { return main.tubesqz200N;});
          new Thread(main.tubesqz200N).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("SQZ200N");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void StationSqz200N_Pressed(MouseEvent event) {
       style = StationSqz200N.getStyle();
       StationSqz200N.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void StationSqz200N_Released(MouseEvent event) {
       StationSqz200N.setStyle(style);
    }

    @FXML
    void StationSqz0N_Clicked(MouseEvent event) {
       System.out.println("Switch to TubeSqz0N View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.minitowersqz0N == null) {
          main.minitowersqz0N = new ViewMiniTowerSqzStation("MINITOWERSQZ", "SQZ0N");
          main.addViewFactory("SQZ0N", () -> { return main.minitowersqz0N;});
          new Thread(main.minitowersqz0N).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("SQZ0N");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void StationSqz0N_Pressed(MouseEvent event) {
       style = StationSqz0N.getStyle();
       StationSqz0N.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void StationSqz0N_Released(MouseEvent event) {
       StationSqz0N.setStyle(style);
    }

    @FXML
    void StationSqz300N_Clicked(MouseEvent event) {
       System.out.println("Switch to TubeSqz300N View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.minitowersqz300N == null) {
          main.minitowersqz300N = new ViewMiniTowerSqzStation("MINITOWERSQZ", "SQZ300N");
          main.addViewFactory("SQZ300N", () -> { return main.minitowersqz300N;});
          new Thread(main.minitowersqz300N).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("SQZ300N");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void StationSqz300N_Pressed(MouseEvent event) {
       style = StationSqz300N.getStyle();
       StationSqz300N.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void StationSqz300N_Released(MouseEvent event) {
       StationSqz300N.setStyle(style);
    }

    @FXML
    void StationSqzDET1_Clicked(MouseEvent event) {
       System.out.println("Switch to TubeSqzDET1 View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.minitowersqzdet1 == null) {
          main.minitowersqzdet1 = new ViewMiniTowerSqzStation("MINITOWERSQZ", "SQZDET1");
          main.addViewFactory("SQZDET1", () -> { return main.minitowersqzdet1;});
          new Thread(main.minitowersqzdet1).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("SQZDET1");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void StationSqzDET1_Pressed(MouseEvent event) {
       style = StationSqzDET1.getStyle();
       StationSqzDET1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void StationSqzDET1_Released(MouseEvent event) {
       StationSqzDET1.setStyle(style);
    }

    @FXML
    void StationSqzDET2_Clicked(MouseEvent event) {
       System.out.println("Switch to TubeSqzDET2 View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.minitowersqzdet2 == null) {
          main.minitowersqzdet2 = new ViewMiniTowerSqzStation("MINITOWERSQZ", "SQZDET2");
          main.addViewFactory("SQZDET2", () -> { return main.minitowersqzdet2;});
          new Thread(main.minitowersqzdet2).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("SQZDET2");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void StationSqzDET2_Pressed(MouseEvent event) {
       style = StationSqzDET2.getStyle();
       StationSqzDET2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void StationSqzDET2_Released(MouseEvent event) {
       StationSqzDET2.setStyle(style);
    }

    @FXML
    void V21Sqz100N_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("SQZ100N_V21");
    }

    @FXML
    void V21Sqz100N_Pressed(MouseEvent event) {
       style = V21Sqz100N.getStyle();
       V21Sqz100N.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V21Sqz100N_Released(MouseEvent event) {
       V21Sqz100N.setStyle(style);
    }

    @FXML
    void V21Sqz200N_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("SQZ200N_V21");
    }

    @FXML
    void V21Sqz200N_Pressed(MouseEvent event) {
       style = V21Sqz200N.getStyle();
       V21Sqz200N.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V21Sqz200N_Released(MouseEvent event) {
       V21Sqz200N.setStyle(style);
    }

    @FXML
    void VPSqz0N_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("SQZ0N_VP");
    }

    @FXML
    void VPSqz0N_Pressed(MouseEvent event) {
       style = VPSqz0N.getStyle();
       VPSqz0N.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void VPSqz0N_Released(MouseEvent event) {
       VPSqz0N.setStyle(style);
    }

    @FXML
    void VPSqz300N_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("SQZ300N_VP");
    }

    @FXML
    void VPSqz300N_Pressed(MouseEvent event) {
       style = VPSqz300N.getStyle();
       VPSqz300N.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void VPSqz300N_Released(MouseEvent event) {
       VPSqz300N.setStyle(style);
    }

    @FXML
    void VPSqzDET1_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("SQZDET1_VP");
    }

    @FXML
    void VPSqzDET1_Pressed(MouseEvent event) {
       style = VPSqzDET1.getStyle();
       VPSqzDET1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void VPSqzDET1_Released(MouseEvent event) {
       VPSqzDET1.setStyle(style);
    }

    @FXML
    void VPSqzDET2_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("SQZDET2_VP");
    }

    @FXML
    void VPSqzDET2_Pressed(MouseEvent event) {
       style = VPSqzDET2.getStyle();
       VPSqzDET2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void VPSqzDET2_Released(MouseEvent event) {
       VPSqzDET2.setStyle(style);
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

