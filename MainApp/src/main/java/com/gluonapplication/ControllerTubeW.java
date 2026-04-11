package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import javafx.fxml.FXML;
import javafx.scene.shape.SVGPath;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import com.gluonhq.charm.glisten.mvc.View;

public class ControllerTubeW extends ControlLayer implements ControlTypes {

    @FXML
    private Label Station3000W;

    @FXML
    private Group V3000W;

    @FXML
    private SVGPath StatusV3000W;

    @FXML
    private Group V2400W;

    @FXML
    private SVGPath StatusV2400W;

    @FXML
    private Group V1800W;

    @FXML
    private SVGPath StatusV1800W;

    @FXML
    private Group V1200W;

    @FXML
    private SVGPath StatusV1200W;

    @FXML
    private Group V600W;

    @FXML
    private SVGPath StatusV600W;

    @FXML
    private Group V300W;

    @FXML
    private SVGPath StatusV300W;
    
    @FXML
    private Group V3000W1;

    @FXML
    private SVGPath StatusV3000W1;

    @FXML
    private Group V2400W1;

    @FXML
    private SVGPath StatusV2400W1;

    @FXML
    private Group V1800W1;

    @FXML
    private SVGPath StatusV1800W1;

    @FXML
    private Group V1200W1;

    @FXML
    private SVGPath StatusV1200W1;

    @FXML
    private Group V600W1;

    @FXML
    private SVGPath StatusV600W1;

    @FXML
    private Group V300W1;

    @FXML
    private SVGPath StatusV300W1;

    @FXML
    private Label Pressure3000W;

    @FXML
    private Label Pressure300W;

    @FXML
    private Label Pressure600W;

    @FXML
    private Label Pressure1200W;

    @FXML
    private Label Pressure1800W;

    @FXML
    private Label Pressure2400W;

    @FXML
    private Label Station300W;

    @FXML
    private Label Station600W;

    @FXML
    private Label Station1200W;

    @FXML
    private Label Station1800W;

    @FXML
    private Label Station2400W;

    @FXML
    private Group VWE;

    @FXML
    private SVGPath StatusVWE;

    @FXML
    private Group VWI;

    @FXML
    private SVGPath StatusVWI;
    
    @FXML
    private Group Ge4_1500W;
    
    @FXML
    private Circle StatusGe4_1500W;  

    @FXML
    private Rectangle WE;

    @FXML
    private Rectangle CB; 

    String style = "";


    @FXML
    void CB_Clicked(MouseEvent event) {
       System.out.println("Clicked to CB View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.cb == null) {
          main.cb = new ViewCentralBuilding("CB", "CB");
          MobileApplication.getInstance().addViewFactory("CB", () -> { return main.cb;});
          new Thread(main.cb).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("CB");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void CB_Pressed(MouseEvent event) {
       style = CB.getStyle();
       CB.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void CB_Released(MouseEvent event) {
       CB.setStyle(style);
    }

    @FXML
    void WE_Clicked(MouseEvent event) {
       System.out.println("Clicked to WE View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.we == null) {
          main.we = new ViewEndBuilding("WE", "WE");
          MobileApplication.getInstance().addViewFactory("WE", () -> { return main.we;});
          new Thread(main.we).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("WE");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void WE_Pressed(MouseEvent event) {
       style = WE.getStyle();
       WE.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void WE_Released(MouseEvent event) {
       WE.setStyle(style);
    }

    @FXML
    void Station1200W_Clicked(MouseEvent event) {
       System.out.println("Switch to Station1200W View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.tube1200W == null) {
          main.tube1200W = new ViewTubeLalStation("TUBELALSTATION", "TUBELAL1200W");
          main.addViewFactory("TUBELAL1200W", () -> { return main.tube1200W;});
          new Thread(main.tube1200W).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("TUBELAL1200W");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void Station1200W_Pressed(MouseEvent event) {
       style = Station1200W.getStyle();
       Station1200W.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Station1200W_Released(MouseEvent event) {
       Station1200W.setStyle(style);
    }

    @FXML
    void Station2400W_Clicked(MouseEvent event) {
       System.out.println("Switch to Station2400W View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.tube2400W == null) {
          main.tube2400W = new ViewTubeLalStation("TUBELALSTATION", "TUBELAL2400W");
          main.addViewFactory("TUBELAL2400W", () -> { return main.tube2400W;});
          new Thread(main.tube2400W).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("TUBELAL2400W");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void Station2400W_Pressed(MouseEvent event) {
       style = Station2400W.getStyle();
       Station2400W.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Station2400W_Released(MouseEvent event) {
       Station2400W.setStyle(style);
    }

    @FXML
    void Station1800W_Clicked(MouseEvent event) {
       System.out.println("Switch to Station1800W View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.tube1800W == null) {
          main.tube1800W = new ViewTubeLalStation("TUBELALSTATION", "TUBELAL1800W");
          main.addViewFactory("TUBELAL1800W", () -> { return main.tube1800W;});
          new Thread(main.tube1800W).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("TUBELAL1800W");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void Station1800W_Pressed(MouseEvent event) {
       style = Station1800W.getStyle();
       Station1800W.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Station1800W_Released(MouseEvent event) {
       Station1800W.setStyle(style);
    }

    @FXML
    void Station3000W_Clicked(MouseEvent event) {
       System.out.println("Switch to Station3000W View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.tube3000W == null) {
          main.tube3000W = new ViewTubeLalStation("TUBELALSTATION", "TUBELAL3000W");
          main.addViewFactory("TUBELAL3000W", () -> { return main.tube3000W;});
          new Thread(main.tube3000W).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("TUBELAL3000W");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void Station3000W_Pressed(MouseEvent event) {
       style = Station3000W.getStyle();
       Station3000W.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Station3000W_Released(MouseEvent event) {
       Station3000W.setStyle(style);
    }

    @FXML
    void Station300W_Clicked(MouseEvent event) {
       System.out.println("Switch to Station300W View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.tube300W == null) {
          main.tube300W = new ViewTubeStation("TUBESTATION", "TUBE300W");
          main.addViewFactory("TUBE300W", () -> { return main.tube300W;});
          new Thread(main.tube300W).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("TUBE300W");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void Station300W_Pressed(MouseEvent event) {
       style = Station300W.getStyle();
       Station300W.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Station300W_Released(MouseEvent event) {
       Station300W.setStyle(style);
    }

    @FXML
    void Station600W_Clicked(MouseEvent event) {
       System.out.println("Switch to Station600W View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.tube600W == null) {
          main.tube600W = new ViewTubeLalStation("TUBELALSTATION", "TUBELAL600W");
          main.addViewFactory("TUBELAL600W", () -> { return main.tube600W;});
          new Thread(main.tube600W).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("TUBELAL600W");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void Station600W_Pressed(MouseEvent event) {
        style = Station600W.getStyle();
        Station600W.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Station600W_Released(MouseEvent event) {
       Station600W.setStyle(style);
    }

    @FXML
    void V1200W_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("TUBELAL1200W_V21");
    }

    @FXML
    void V1200W_Pressed(MouseEvent event) {
        style = StatusV1200W.getStyle();
        StatusV1200W.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V1200W_Released(MouseEvent event) {
       StatusV1200W.setStyle(style);
    }

    @FXML
    void V1800W_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("TUBELAL1800W_V21");
    }

    @FXML
    void V1800W_Pressed(MouseEvent event) {
        style = StatusV1800W.getStyle();
        StatusV1800W.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V1800W_Released(MouseEvent event) {
       StatusV1800W.setStyle(style);
    }

    @FXML
    void V2400W_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("TUBELAL2400W_V21");
    }

    @FXML
    void V2400W_Pressed(MouseEvent event) {
        style = StatusV2400W.getStyle();
        StatusV2400W.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V2400W_Released(MouseEvent event) {
       StatusV2400W.setStyle(style);
    }

    @FXML
    void V3000W_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("TUBELAL3000W_V21");
    }

    @FXML
    void V3000W_Pressed(MouseEvent event) {
        style = StatusV3000W.getStyle();
        StatusV3000W.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V3000W_Released(MouseEvent event) {
       StatusV3000W.setStyle(style);
    }

    @FXML
    void V300W_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("TUBE300W_V21");
    }

    @FXML
    void V300W_Pressed(MouseEvent event) {
        style = StatusV300W.getStyle();
        StatusV300W.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V300W_Released(MouseEvent event) {
       StatusV300W.setStyle(style);
    }

    @FXML
    void V600W_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("TUBELAL600W_V21");
    }

    @FXML
    void V600W_Pressed(MouseEvent event) {
        style = StatusV600W.getStyle();
        StatusV600W.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V600W_Released(MouseEvent event) {
       StatusV600W.setStyle(style);
    }

    @FXML
    void V1200W1_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("TUBELAL1200W_V31");
    }

    @FXML
    void V1200W1_Pressed(MouseEvent event) {
        style = StatusV1200W1.getStyle();
        StatusV1200W1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V1200W1_Released(MouseEvent event) {
       StatusV1200W1.setStyle(style);
    }

    @FXML
    void V1800W1_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("TUBELAL1800W_V31");
    }

    @FXML
    void V1800W1_Pressed(MouseEvent event) {
        style = StatusV1800W1.getStyle();
        StatusV1800W1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V1800W1_Released(MouseEvent event) {
       StatusV1800W1.setStyle(style);
    }

    @FXML
    void V2400W1_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("TUBELAL2400W_V31");
    }

    @FXML
    void V2400W1_Pressed(MouseEvent event) {
        style = StatusV2400W1.getStyle();
        StatusV2400W1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V2400W1_Released(MouseEvent event) {
       StatusV2400W1.setStyle(style);
    }

    @FXML
    void V3000W1_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("TUBELAL3000W_V31");
    }

    @FXML
    void V3000W1_Pressed(MouseEvent event) {
        style = StatusV3000W1.getStyle();
        StatusV3000W1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V3000W1_Released(MouseEvent event) {
       StatusV3000W1.setStyle(style);
    }

    @FXML
    void V300W1_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("TUBE300W_V31");
    }

    @FXML
    void V300W1_Pressed(MouseEvent event) {
        style = StatusV300W1.getStyle();
        StatusV300W1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V300W1_Released(MouseEvent event) {
       StatusV300W1.setStyle(style);
    }

    @FXML
    void V600W1_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("TUBELAL600W_V31");
    }

    @FXML
    void V600W1_Pressed(MouseEvent event) {
        style = StatusV600W1.getStyle();
        StatusV600W1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V600W1_Released(MouseEvent event) {
       StatusV600W1.setStyle(style);
    }
    
    @FXML
    void VWE_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("VALVEBIGWE");
    }

    @FXML
    void VWE_Pressed(MouseEvent event) {
        style = StatusVWE.getStyle();
        StatusVWE.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void VWE_Released(MouseEvent event) {
       StatusVWE.setStyle(style);
    }

    @FXML
    void VWI_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("VALVEBIGWI");
    }

    @FXML
    void VWI_Pressed(MouseEvent event) {
        style = StatusVWI.getStyle();
        StatusVWI.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void VWI_Released(MouseEvent event) {
       StatusVWI.setStyle(style);
    }
    
    @FXML
    void Ge4_1500W_Clicked(MouseEvent event) {
       CreateAndShowRGALayer("Ge4");
    }

    @FXML
    void Ge4_1500W_Pressed(MouseEvent event) {
        style = StatusGe4_1500W.getStyle();
        StatusGe4_1500W.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Ge4_1500W_Released(MouseEvent event) {
       StatusGe4_1500W.setStyle(style);
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
       MobileApplication.getInstance().showLayer(name+ ":-");
   }
   
   @Override
   void CreateAndShowRGALayer(String name) {
       ViewData presentView = (ViewData) MobileApplication.getInstance().getView();
       //if ( !MobileApplication.getInstance().isLayerPresent(presentView.name + ":" + name) ) {
          MobileApplication.getInstance().removeLayerFactory("RGA1500W:" + name);
          LayerData rga = new LayerRGA("CHART", "RGA1500W:" + name);
          try { 
             new Thread(rga).start(); 
          }
          catch (Exception e) {
             e.printStackTrace();
          }
          MobileApplication.getInstance().addLayerFactory("RGA1500W:" + name, () -> { return  rga;});
       //}
       MobileApplication.getInstance().showLayer("RGA1500W:" + name);
   }
}

