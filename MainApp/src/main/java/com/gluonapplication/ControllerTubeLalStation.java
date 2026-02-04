package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.SVGPath;


public class ControllerTubeLalStation extends ControlLayer implements ControlTypes {

    @FXML
    private Group Va1;

    @FXML
    private SVGPath StatusVa1;

    @FXML
    private Group Va2;

    @FXML
    private SVGPath StatusVa2;

    @FXML
    private Group V31;

    @FXML
    private SVGPath StatusV31;

    @FXML
    private Group V32;

    @FXML
    private SVGPath StatusV32;

    @FXML
    private Group V91;

    @FXML
    private SVGPath StatusV91;

    @FXML
    private Group V11;

    @FXML
    private SVGPath StatusV11;

    @FXML
    private Label PressureGa1;

    @FXML
    private Label PressureG31;

    @FXML
    private Label PressureGa4;

    @FXML
    private Label PressureGa3;

    @FXML
    private Label PressureGa2;

    @FXML
    private Group Ga1;

    @FXML
    private Circle StatusGa1;

    @FXML
    private Group Ga3;

    @FXML
    private Circle StatusGa3;

    @FXML
    private Group Ga2;

    @FXML
    private Circle StatusGa2;

    @FXML
    private Group Ga4;

    @FXML
    private Circle StatusGa4;

    @FXML
    private Group Ga5;

    @FXML
    private Circle StatusGa5;

    @FXML
    private Group G31;

    @FXML
    private Circle StatusG31;

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
    private Group P23;
    
    @FXML
    private Rectangle StatusP23;

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
    void G31_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "G31");
    }

    @FXML
    void G31_Pressed(MouseEvent event) {
       style = StatusG31.getStyle();
       StatusG31.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void G31_Released(MouseEvent event) {
       StatusG31.setStyle(style);
    }

    @FXML
    void Ga1_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "Ga1");
    }
    
    @FXML
    void Ga1_Pressed(MouseEvent event) {
       style = StatusGa1.getStyle();
       StatusGa1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Ga1_Released(MouseEvent event) {
       StatusGa1.setStyle(style);
    }

    @FXML
    void Ga2_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "Ga2");
    }

    @FXML
    void Ga2_Pressed(MouseEvent event) {
       style = StatusGa2.getStyle();
       StatusGa2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Ga2_Released(MouseEvent event) {
       StatusGa2.setStyle(style);
    }

    @FXML
    void Ga3_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "Ga3");
    }

    @FXML
    void Ga3_Pressed(MouseEvent event) {
       style = StatusGa3.getStyle();
       StatusGa3.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Ga3_Released(MouseEvent event) {
       StatusGa3.setStyle(style);
    }

    @FXML
    void Ga4_Clicked(MouseEvent event) {
      CreateAndShowGaugeLayer("XGSGAUGE", "Ga4");
    }

    @FXML
    void Ga4_Pressed(MouseEvent event) {
       style = StatusGa4.getStyle();
       StatusGa4.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Ga4_Released(MouseEvent event) {
       StatusGa4.setStyle(style);
    }

    @FXML
    void Ga5_Clicked(MouseEvent event) {
       CreateAndShowRGALayer("Ga5");
    }

    @FXML
    void Ga5_Pressed(MouseEvent event) {
       style = StatusGa5.getStyle();
       StatusGa5.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Ga5_Released(MouseEvent event) {
       StatusGa5.setStyle(style);
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
    void P31_Clicked(MouseEvent event) {
       CreateAndShowTitaneLayer("TITANE", "P31");
    }

    @FXML
    void P31_Pressed(MouseEvent event) {
       style = StatusP31.getStyle();
       StatusP31.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void P31_Released(MouseEvent event) {
       StatusP31.setStyle(style);
    }

    @FXML
    void P32_Clicked(MouseEvent event) {
       CreateAndShowTitaneLayer("TITANE", "P32");
    }

    @FXML
    void P32_Pressed(MouseEvent event) {
       style = StatusP32.getStyle();
       StatusP32.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void P32_Released(MouseEvent event) {
       StatusP32.setStyle(style);
    }

    @FXML
    void P33_Clicked(MouseEvent event) {
       CreateAndShowIonicLayer("IONIC", "P33");
    }

    @FXML
    void P33_Pressed(MouseEvent event) {
       style = StatusP33.getStyle();
       StatusP33.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void P33_Released(MouseEvent event) {
       StatusP33.setStyle(style);
    }
    
    @FXML
    void P23_Clicked(MouseEvent event) {
       CreateAndShowIonicLayer("IONIC", "P23");
    }

    @FXML
    void P23_Pressed(MouseEvent event) {
       style = StatusP23.getStyle();
       StatusP23.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void P23_Released(MouseEvent event) {
       StatusP23.setStyle(style);
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
    void PressureG31_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotG31");
    }

    @FXML
    void PressureG31_Pressed(MouseEvent event) {
       style = PressureG31.getStyle();
       PressureG31.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureG31_Released(MouseEvent event) {
       PressureG31.setStyle(style);
    }

    @FXML
    void PressureGa1_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotGa1");
    }

    @FXML
    void PressureGa1_Pressed(MouseEvent event) {
       style = PressureGa1.getStyle();
       PressureGa1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureGa1_Released(MouseEvent event) {
       PressureGa1.setStyle(style);
    }

    @FXML
    void PressureGa2_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotGa2");
    }

    @FXML
    void PressureGa2_Pressed(MouseEvent event) {
       style = PressureGa2.getStyle();
       PressureGa2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureGa2_Released(MouseEvent event) {
       PressureGa2.setStyle(style);
    }

    @FXML
    void PressureGa3_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotGa3");
    }

    @FXML
    void PressureGa3_Pressed(MouseEvent event) {
       style = PressureGa3.getStyle();
       PressureGa3.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureGa3_Released(MouseEvent event) {
       PressureGa3.setStyle(style);
    }

    @FXML
    void PressureGa4_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotGa4");
    }

    @FXML
    void PressureGa4_Pressed(MouseEvent event) {
       style = PressureGa4.getStyle();
       PressureGa4.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureGa4_Released(MouseEvent event) {
       PressureGa4.setStyle(style);
    }

    @FXML
    void V11_Clicked(MouseEvent event) {
	CreateAndShowValveLayer("V11");
    }

    @FXML
    void V11_Pressed(MouseEvent event) {
       style = StatusV11.getStyle();
       StatusV11.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V11_Released(MouseEvent event) {
       StatusV11.setStyle(style);
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
    void V31_Clicked(MouseEvent event) {
	CreateAndShowValveLayer("V31");
    }

    @FXML
    void V31_Pressed(MouseEvent event) {
       style = StatusV31.getStyle();
       StatusV31.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V31_Released(MouseEvent event) {
       StatusV31.setStyle(style);
    }

    @FXML
    void V32_Clicked(MouseEvent event) {
	CreateAndShowValveLayer("V32");
    }

    @FXML
    void V32_Pressed(MouseEvent event) {
       style = StatusV32.getStyle();
       StatusV32.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V32_Released(MouseEvent event) {
       StatusV32.setStyle(style);
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
    void V91_released(MouseEvent event) {
       StatusV91.setStyle(style);
    }

    @FXML
    void Va1_Clicked(MouseEvent event) {
	CreateAndShowValveLayer("Va1");
    }

    @FXML
    void Va1_Pressed(MouseEvent event) {
       style = StatusVa1.getStyle();
       StatusVa1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Va1_Released(MouseEvent event) {
       StatusVa1.setStyle(style);
    }

    @FXML
    void Va2_Clicked(MouseEvent event) {
	CreateAndShowValveLayer("Va2");
    }

    @FXML
    void Va2_Pressed(MouseEvent event) {
       style = StatusVa2.getStyle();
       StatusVa2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Va2_Released(MouseEvent event) {
       StatusVa2.setStyle(style);
    }
}

