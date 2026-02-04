package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.SVGPath;


public class ControllerMiniTowerSqz extends ControlLayer implements ControlTypes {

    @FXML
    private Group Ve1;

    @FXML
    private SVGPath StatusVe1;

    @FXML
    private Group Ve2;

    @FXML
    private SVGPath StatusVe2;

    @FXML
    private Group VP;

    @FXML
    private SVGPath StatusVP;
    
    @FXML
    private Group Vrem;

    @FXML
    private SVGPath StatusVrem;

    @FXML
    private Group V24;

    @FXML
    private SVGPath StatusV24;

    @FXML
    private Group V1;

    @FXML
    private SVGPath StatusV1;

    @FXML
    private Label PressureGe1;

    @FXML
    private Label PressureGP;


    @FXML
    private Label PressureGe3;

    @FXML
    private Label PressureGe2;

    @FXML
    private Group Ge1;

    @FXML
    private Circle StatusGe1;

    @FXML
    private Group Ge3;

    @FXML
    private Circle StatusGe3;

    @FXML
    private Group Ge2;

    @FXML
    private Circle StatusGe2;

    @FXML
    private Group Ge4;

    @FXML
    private Circle StatusGe4;

    @FXML
    private Group Ge5;

    @FXML
    private Circle StatusGe5;

    @FXML
    private Group GP;

    @FXML
    private Circle StatusGP;

    @FXML
    private Group P31;

    @FXML
    private Rectangle StatusP31;

    @FXML
    private Group P32;

    @FXML
    private Rectangle StatusP32;

    @FXML
    private Group P33;

    @FXML
    private Rectangle StatusP33;

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
    private Group V25;

    @FXML
    private SVGPath StatusV25;

    @FXML
    private Group G21;

    @FXML
    private Circle StatusG21;

    @FXML
    private Label PressureG21;

    @FXML
    private Label SpeedP21;

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
    void GP_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "GP");
    }

    @FXML
    void GP_Pressed(MouseEvent event) {
       style = StatusGP.getStyle();
       StatusGP.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void GP_Released(MouseEvent event) {
       StatusGP.setStyle(style);
    }

    @FXML
    void Ge1_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "Ge1");
    }
    
    @FXML
    void Ge1_Pressed(MouseEvent event) {
       style = StatusGe1.getStyle();
       StatusGe1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Ge1_Released(MouseEvent event) {
       StatusGe1.setStyle(style);
    }

    @FXML
    void Ge2_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "Ge2");
    }

    @FXML
    void Ge2_Pressed(MouseEvent event) {
       style = StatusGe2.getStyle();
       StatusGe2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Ge2_Released(MouseEvent event) {
       StatusGe2.setStyle(style);
    }

    @FXML
    void Ge3_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "Ge3");
    }

    @FXML
    void Ge3_Pressed(MouseEvent event) {
       style = StatusGe3.getStyle();
       StatusGe3.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Ge3_Released(MouseEvent event) {
       StatusGe3.setStyle(style);
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
    void PressureGP_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotGP");
    }

    @FXML
    void PressureGP_Pressed(MouseEvent event) {
       style = PressureGP.getStyle();
       PressureGP.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureGP_Released(MouseEvent event) {
       PressureGP.setStyle(style);
    }

    @FXML
    void PressureGe1_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotGe1");
    }

    @FXML
    void PressureGe1_Pressed(MouseEvent event) {
       style = PressureGe1.getStyle();
       PressureGe1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureGe1_Released(MouseEvent event) {
       PressureGe1.setStyle(style);
    }

    @FXML
    void PressureGe2_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotGe2");
    }

    @FXML
    void PressureGe2_Pressed(MouseEvent event) {
       style = PressureGe2.getStyle();
       PressureGe2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureGe2_Released(MouseEvent event) {
       PressureGe2.setStyle(style);
    }

    @FXML
    void PressureGe3_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotGe3");
    }

    @FXML
    void PressureGe3_Pressed(MouseEvent event) {
       style = PressureGe3.getStyle();
       PressureGe3.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureGe3_Released(MouseEvent event) {
       PressureGe3.setStyle(style);
    }

    @FXML
    void V1_Clicked(MouseEvent event) {
	CreateAndShowValveLayer("V1");
    }

    @FXML
    void V1_Pressed(MouseEvent event) {
       style = StatusV1.getStyle();
       StatusV1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V1_Released(MouseEvent event) {
       StatusV1.setStyle(style);
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
    void V25_Clicked(MouseEvent event) {
	CreateAndShowValveLayer("V25");
    }

    @FXML
    void V25_Pressed(MouseEvent event) {
       style = StatusV25.getStyle();
       StatusV25.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V25_Released(MouseEvent event) {
       StatusV25.setStyle(style);
    }

    @FXML
    void VP_Clicked(MouseEvent event) {
	CreateAndShowValveLayer("VP");
    }

    @FXML
    void VP_Pressed(MouseEvent event) {
       style = StatusVP.getStyle();
       StatusVP.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void VP_Released(MouseEvent event) {
       StatusVP.setStyle(style);
    }
    
    @FXML
    void Vrem_Clicked(MouseEvent event) {
	CreateAndShowValveLayer("Vrem");
    }

    @FXML
    void Vrem_Pressed(MouseEvent event) {
       style = StatusVrem.getStyle();
       StatusVrem.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Vrem_Released(MouseEvent event) {
       StatusVrem.setStyle(style);
    }

    @FXML
    void V24_Clicked(MouseEvent event) {
	CreateAndShowValveLayer("V24");
    }

    @FXML
    void V24_Pressed(MouseEvent event) {
       style = StatusV24.getStyle();
       StatusV24.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V24_Released(MouseEvent event) {
       StatusV24.setStyle(style);
    }

    @FXML
    void Ve1_Clicked(MouseEvent event) {
	CreateAndShowValveLayer("Ve1");
    }

    @FXML
    void Ve1_Pressed(MouseEvent event) {
       style = StatusVe1.getStyle();
       StatusVe1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Ve1_Released(MouseEvent event) {
       StatusVe1.setStyle(style);
    }

    @FXML
    void Ve2_Clicked(MouseEvent event) {
	CreateAndShowValveLayer("Ve2");
    }

    @FXML
    void Ve2_Pressed(MouseEvent event) {
       style = StatusVe2.getStyle();
       StatusVe2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Ve2_Released(MouseEvent event) {
       StatusVe2.setStyle(style);
    }
}

