package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import javafx.fxml.FXML;
import javafx.scene.shape.SVGPath;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.input.MouseEvent;
import com.gluonhq.charm.glisten.mvc.View;
import javafx.scene.input.ZoomEvent;

public class ControllerTubeN extends ControlLayer implements ControlTypes {

    @FXML
    private Label Station3000N;

    @FXML
    private Group V3000N;

    @FXML
    private SVGPath StatusV3000N;

    @FXML
    private Group V2400N;

    @FXML
    private SVGPath StatusV2400N;

    @FXML
    private Group V1800N;

    @FXML
    private SVGPath StatusV1800N;

    @FXML
    private Group V1200N;

    @FXML
    private SVGPath StatusV1200N;

    @FXML
    private Group V600N;

    @FXML
    private SVGPath StatusV600N;

    @FXML
    private Group V300N;

    @FXML
    private SVGPath StatusV300N;
    
    @FXML
    private Group V3000N1;

    @FXML
    private SVGPath StatusV3000N1;

    @FXML
    private Group V2400N1;

    @FXML
    private SVGPath StatusV2400N1;

    @FXML
    private Group V1800N1;

    @FXML
    private SVGPath StatusV1800N1;

    @FXML
    private Group V1200N1;

    @FXML
    private SVGPath StatusV1200N1;

    @FXML
    private Group V600N1;

    @FXML
    private SVGPath StatusV600N1;

    @FXML
    private Group V300N1;

    @FXML
    private SVGPath StatusV300N1;

    @FXML
    private Label Pressure3000N;

    @FXML
    private Label Pressure300N;

    @FXML
    private Label Pressure600N;

    @FXML
    private Label Pressure1200N;

    @FXML
    private Label Pressure1800N;

    @FXML
    private Label Pressure2400N;

    @FXML
    private Label Station300N;

    @FXML
    private Label Station600N;

    @FXML
    private Label Station1200N;

    @FXML
    private Label Station1800N;

    @FXML
    private Label Station2400N;

    @FXML
    private Group VNE;

    @FXML
    private SVGPath StatusVNE;

    @FXML
    private Group VNI;

    @FXML
    private SVGPath StatusVNI;

    @FXML
    private Group Ge4_1500N;
    
    @FXML
    private Circle StatusGe4_1500N; 
    
    @FXML
    private Group Gc4_1500N;
    
    @FXML
    private Circle StatusGc4_1500N; 
    
    @FXML
    private Rectangle NE;

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
    void NE_Clicked(MouseEvent event) {
       System.out.println("Clicked to NE View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.ne == null) {
          main.ne = new ViewEndBuilding("NE", "NE");
          MobileApplication.getInstance().addViewFactory("NE", () -> { return main.ne;});
          new Thread(main.ne).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("NE");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void NE_Pressed(MouseEvent event) {
       style = NE.getStyle();
       NE.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void NE_Released(MouseEvent event) {
       NE.setStyle(style);
    }   


    @FXML
    void Station1200N_Clicked(MouseEvent event) {
       System.out.println("Switch to Station1200N View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.tube1200N == null) {
          main.tube1200N = new ViewTubeLalStation("TUBELALSTATION", "TUBELAL1200N");
          main.addViewFactory("TUBELAL1200N", () -> { return main.tube1200N;});
          new Thread(main.tube1200N).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("TUBELAL1200N");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void Station1200N_Pressed(MouseEvent event) {
       style = Station1200N.getStyle();
       Station1200N.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Station1200N_Released(MouseEvent event) {
       Station1200N.setStyle(style);
    }

    @FXML
    void Station2400N_Clicked(MouseEvent event) {
       System.out.println("Switch to Station2400N View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.tube2400N == null) {
          main.tube2400N = new ViewTubeLalStation("TUBELALSTATION", "TUBELAL2400N");
          main.addViewFactory("TUBELAL2400N", () -> { return main.tube2400N;});
          new Thread(main.tube2400N).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("TUBELAL2400N");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void Station2400N_Pressed(MouseEvent event) {
       style = Station2400N.getStyle();
       Station2400N.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Station2400N_Released(MouseEvent event) {
       Station2400N.setStyle(style);
    }

    @FXML
    void Station1800N_Clicked(MouseEvent event) {
       System.out.println("Switch to Station1800N View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.tube1800N == null) {
          main.tube1800N = new ViewTubeLalStation("TUBELALSTATION", "TUBELAL1800N");
          main.addViewFactory("TUBELAL1800N", () -> { return main.tube1800N;});
          new Thread(main.tube1800N).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("TUBELAL1800N");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void Station1800N_Pressed(MouseEvent event) {
       style = Station1800N.getStyle();
       Station1800N.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Station1800N_Released(MouseEvent event) {
       Station1800N.setStyle(style);
    }

    @FXML
    void Station3000N_Clicked(MouseEvent event) {
       System.out.println("Switch to Station3000N View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.tube3000N == null) {
          main.tube3000N = new ViewTubeLalStation("TUBELALSTATION", "TUBELAL3000N");
          main.addViewFactory("TUBELAL3000N", () -> { return main.tube3000N;});
          new Thread(main.tube3000N).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("TUBELAL3000N");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void Station3000N_Pressed(MouseEvent event) {
       style = Station3000N.getStyle();
       Station3000N.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Station3000N_Released(MouseEvent event) {
       Station3000N.setStyle(style);
    }

    @FXML
    void Station300N_Clicked(MouseEvent event) {
       System.out.println("Switch to Station300N View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.tube300N == null) {
          main.tube300N = new ViewTubeStation("TUBESTATION", "TUBE300N");
          main.addViewFactory("TUBE300N", () -> { return main.tube300N;});
          new Thread(main.tube300N).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("TUBE300N");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void Station300N_Pressed(MouseEvent event) {
       style = Station300N.getStyle();
       Station300N.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Station300N_Released(MouseEvent event) {
       Station300N.setStyle(style);
    }

    @FXML
    void Station600N_Clicked(MouseEvent event) {
       System.out.println("Switch to Station600N View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.tube600N == null) {
          main.tube600N = new ViewTubeLalStation("TUBELALSTATION", "TUBELAL600N");
          main.addViewFactory("TUBELAL600N", () -> { return main.tube600N;});
          new Thread(main.tube600N).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("TUBELAL600N");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void Station600N_Pressed(MouseEvent event) {
        style = Station600N.getStyle();
        Station600N.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Station600N_Released(MouseEvent event) {
       Station600N.setStyle(style);
    }

    @FXML
    void V1200N_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("TUBELAL1200N_V21");
    }

    @FXML
    void V1200N_Pressed(MouseEvent event) {
        style = StatusV1200N.getStyle();
        StatusV1200N.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V1200N_Released(MouseEvent event) {
       StatusV1200N.setStyle(style);
    }

    @FXML
    void V1800N_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("TUBELAL1800N_V21");
    }

    @FXML
    void V1800N_Pressed(MouseEvent event) {
        style = StatusV1800N.getStyle();
        StatusV1800N.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V1800N_Released(MouseEvent event) {
       StatusV1800N.setStyle(style);
    }

    @FXML
    void V2400N_Clicked(MouseEvent event) {
      CreateAndShowValveLayer("TUBELAL2400N_V21");
    }

    @FXML
    void V2400N_Pressed(MouseEvent event) {
        style = StatusV2400N.getStyle();
        StatusV2400N.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V2400N_Released(MouseEvent event) {
       StatusV2400N.setStyle(style);
    }

    @FXML
    void V3000N_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("TUBELAL3000N_V21");
    }

    @FXML
    void V3000N_Pressed(MouseEvent event) {
        style = StatusV3000N.getStyle();
        StatusV3000N.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V3000N_Released(MouseEvent event) {
       StatusV3000N.setStyle(style);
    }

    @FXML
    void V300N_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("TUBE300N_V21");
    }

    @FXML
    void V300N_Pressed(MouseEvent event) {
        style = StatusV300N.getStyle();
        StatusV300N.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V300N_Released(MouseEvent event) {
       StatusV300N.setStyle(style);
    }

    @FXML
    void V600N_Clicked(MouseEvent event) {
      CreateAndShowValveLayer("TUBELAL600N_V21");
    }

    @FXML
    void V600N_Pressed(MouseEvent event) {
        style = StatusV600N.getStyle();
        StatusV600N.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V600N_Released(MouseEvent event) {
       StatusV600N.setStyle(style);
    }

    @FXML
    void V1200N1_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("TUBELAL1200N_V31");
    }

    @FXML
    void V1200N1_Pressed(MouseEvent event) {
        style = StatusV1200N1.getStyle();
        StatusV1200N1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V1200N1_Released(MouseEvent event) {
       StatusV1200N1.setStyle(style);
    }

    @FXML
    void V1800N1_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("TUBELAL1800N_V31");
    }

    @FXML
    void V1800N1_Pressed(MouseEvent event) {
        style = StatusV1800N1.getStyle();
        StatusV1800N1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V1800N1_Released(MouseEvent event) {
       StatusV1800N1.setStyle(style);
    }

    @FXML
    void V2400N1_Clicked(MouseEvent event) {
      CreateAndShowValveLayer("TUBELAL2400N_V31");
    }

    @FXML
    void V2400N1_Pressed(MouseEvent event) {
        style = StatusV2400N1.getStyle();
        StatusV2400N1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V2400N1_Released(MouseEvent event) {
       StatusV2400N1.setStyle(style);
    }

    @FXML
    void V3000N1_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("TUBELAL3000N_V31");
    }

    @FXML
    void V3000N1_Pressed(MouseEvent event) {
        style = StatusV3000N1.getStyle();
        StatusV3000N1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V3000N1_Released(MouseEvent event) {
       StatusV3000N1.setStyle(style);
    }

    @FXML
    void V300N1_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("TUBE300N_V31");
    }

    @FXML
    void V300N1_Pressed(MouseEvent event) {
        style = StatusV300N1.getStyle();
        StatusV300N1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V300N1_Released(MouseEvent event) {
       StatusV300N1.setStyle(style);
    }

    @FXML
    void V600N1_Clicked(MouseEvent event) {
      CreateAndShowValveLayer("TUBELAL600N_V31");
    }

    @FXML
    void V600N1_Pressed(MouseEvent event) {
        style = StatusV600N1.getStyle();
        StatusV600N1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V600N1_Released(MouseEvent event) {
       StatusV600N1.setStyle(style);
    }
    
    @FXML
    void VNE_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("VALVEBIGNE");
    }

    @FXML
    void VNE_Pressed(MouseEvent event) {
        style = StatusVNE.getStyle();
        StatusVNE.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void VNE_Released(MouseEvent event) {
       StatusVNE.setStyle(style);
    }

    @FXML
    void VNI_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("VALVEBIGNI");
    }

    @FXML
    void VNI_Pressed(MouseEvent event) {
        style = StatusVNI.getStyle();
        StatusVNI.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void VNI_Released(MouseEvent event) {
       StatusVNI.setStyle(style);
    }
    
    @FXML
    void Ge4_1500N_Clicked(MouseEvent event) {
       CreateAndShowRGALayer("Ge4");
    }

    @FXML
    void Ge4_1500N_Pressed(MouseEvent event) {
        style = StatusGe4_1500N.getStyle();
        StatusGe4_1500N.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Ge4_1500N_Released(MouseEvent event) {
       StatusGe4_1500N.setStyle(style);
    }
    
    @FXML
    void Gc4_1500N_Clicked(MouseEvent event) {
       CreateAndShowRGALayer("Gc4");
    }

    @FXML
    void Gc4_1500N_Pressed(MouseEvent event) {
        style = StatusGc4_1500N.getStyle();
        StatusGc4_1500N.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Gc4_1500N_Released(MouseEvent event) {
       StatusGc4_1500N.setStyle(style);
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
   
   @Override
   void CreateAndShowRGALayer(String name) {
       ViewData presentView = (ViewData) MobileApplication.getInstance().getView();
       //if ( !MobileApplication.getInstance().isLayerPresent(presentView.name + ":" + name) ) {
          MobileApplication.getInstance().removeLayerFactory("RGA1500N:" + name);
          LayerData rga = new LayerRGA("CHART", "RGA1500N:" + name);
          try { 
             new Thread(rga).start(); 
          }
          catch (Exception e) {
             e.printStackTrace();
          }
          MobileApplication.getInstance().addLayerFactory("RGA1500N:" + name, () -> { return  rga;});
       //}
       MobileApplication.getInstance().showLayer("RGA1500N:" + name);
   }
    
}

