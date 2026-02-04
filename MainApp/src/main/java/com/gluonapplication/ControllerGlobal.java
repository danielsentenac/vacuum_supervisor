package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.input.MouseEvent;

public class ControllerGlobal extends ControlLayer implements ControlTypes {

    @FXML
    private Label TUBEMC;

    @FXML
    private Label TUBEW;

    @FXML
    private Label TUBEN;

    @FXML
    private Label Sqz;

    @FXML
    private Label NE;

    @FXML
    private Label WE;

    @FXML
    private Label CB;

    @FXML
    private Label MC;

    @FXML
    private Rectangle StatusLevelCB;

    @FXML
    private Group ValveLN2WI;

    @FXML
    private SVGPath StatusValveLN2WI;

    @FXML
    private Group ValveLN2NI;

    @FXML
    private SVGPath StatusValveLN2NI;

    @FXML
    private Group ValveLN2WE;

    @FXML
    private SVGPath StatusValveLN2WE;

    @FXML
    private Group ValveLN2NE;

    @FXML
    private SVGPath StatusValveLN2NE;

    @FXML
    private Rectangle StatusLevelNE;

    @FXML
    private Rectangle StatusLevelWE;

    @FXML
    private Label PressureLN2NE;

    @FXML
    private Label PressureLN2WE;

    @FXML
    private Label LevelLN2WE;

    @FXML
    private Label PressureLN2CB;

    @FXML
    private Label LevelLN2CB;

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
    void MC_Clicked(MouseEvent event) {
       System.out.println("Clicked to TOWERMC View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.towerMC == null) {
          main.towerMC = new ViewTowerBenchStation("TOWERBENCHSTATION", "TOWERMC");
          MobileApplication.getInstance().addViewFactory("TOWERMC", () -> { return main.towerMC;});
          new Thread(main.towerMC).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("TOWERMC");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void MC_Pressed(MouseEvent event) {
       style = MC.getStyle();
       MC.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void MC_Released(MouseEvent event) {
       MC.setStyle(style);
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
    void TUBEMC_Clicked(MouseEvent event) {

    }

    @FXML
    void TUBEMC_Pressed(MouseEvent event) {
       //style = TUBEMC.getStyle();
       //TUBEMC.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void TUBEMC_Released(MouseEvent event) {
       //TUBEMC.setStyle(style);
    }

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
    void Sqz_Clicked(MouseEvent event) {
       System.out.println("Clicked to Sqz View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.sqz == null) {
          main.sqz = new ViewSqz("SQZ", "SQZ");
          MobileApplication.getInstance().addViewFactory("SQZ", () -> { return main.sqz;});
          new Thread(main.sqz).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("SQZ");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void Sqz_Pressed(MouseEvent event) {
       style = Sqz.getStyle();
       Sqz.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Sqz_Released(MouseEvent event) {
       Sqz.setStyle(style);
    }

    @FXML
    void ValveLN2NE_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("NE_LN2TANKVALVE");
    }

    @FXML
    void ValveLN2NE_Pressed(MouseEvent event) {
       style = ValveLN2NE.getStyle();
       ValveLN2NE.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void ValveLN2NE_Released(MouseEvent event) {
       ValveLN2NE.setStyle(style);
    }

    @FXML
    void ValveLN2NI_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("NI_LN2TANKVALVE");
    }

    @FXML
    void ValveLN2NI_Pressed(MouseEvent event) {
       style = ValveLN2NI.getStyle();
       ValveLN2NI.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void ValveLN2NI_Released(MouseEvent event) {
       ValveLN2NI.setStyle(style);
    }

    @FXML
    void ValveLN2WE_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("WE_LN2TANKVALVE");
    }

    @FXML
    void ValveLN2WE_Pressed(MouseEvent event) {
       style = ValveLN2WE.getStyle();
       ValveLN2WE.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void ValveLN2WE_Released(MouseEvent event) {
       ValveLN2WE.setStyle(style);
    }

    @FXML
    void ValveLN2WI_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("LN2TANKVALVE_WI");
    }

    @FXML
    void ValveLN2WI_Pressed(MouseEvent event) {
       style = ValveLN2WI.getStyle();
       ValveLN2WI.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void ValveLN2WI_Released(MouseEvent event) {
       ValveLN2WI.setStyle(style);
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

    @Override
    void CreateAndShowValveLayer(String name) {
       ViewData presentView = (ViewData) MobileApplication.getInstance().getView();
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

