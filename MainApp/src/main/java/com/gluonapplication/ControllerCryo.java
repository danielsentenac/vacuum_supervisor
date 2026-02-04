package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.input.MouseEvent;

public class ControllerCryo extends ControlLayer implements ControlTypes {

    @FXML
    private Group Ve1;

    @FXML
    private SVGPath StatusVe1;

    @FXML
    private Group V31i;

    @FXML
    private SVGPath StatusV31i;

    @FXML
    private Group CV02;

    @FXML
    private SVGPath StatusCV02;

    @FXML
    private Group VCryo;

    @FXML
    private SVGPath StatusVCryo;

    @FXML
    private Label PressureGe1;

    @FXML
    private Label PressureG31i;

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
    private Group G31i;

    @FXML
    private Circle StatusG31i;

    @FXML
    private Group P31i;

    @FXML
    private Rectangle StatusP31i;

    @FXML
    private Group P32i;

    @FXML
    private Rectangle StatusP32i;

    @FXML
    private Group P33i;

    @FXML
    private Rectangle StatusP33i;

    @FXML
    private Group V21;

    @FXML
    private SVGPath StatusV21;

    @FXML
    private Group P1;

    @FXML
    private Rectangle StatusP1;

    @FXML
    private Group V1;

    @FXML
    private SVGPath StatusV1;

    @FXML
    private Group V22;

    @FXML
    private SVGPath StatusV22;

    @FXML
    private Group G22;

    @FXML
    private Circle StatusG22;

    @FXML
    private Group P2;

    @FXML
    private Rectangle StatusP2;

    @FXML
    private Label PressureG22;

    @FXML
    private Group G21;

    @FXML
    private Circle StatusG21;

    @FXML
    private Label PressureG21;

    @FXML
    private Label SpeedP2;

    @FXML
    private Rectangle StatusLevelPS;

    @FXML
    private Group Ve2;

    @FXML
    private SVGPath StatusVe2;

    @FXML
    private Group V32i;

    @FXML
    private SVGPath StatusV32i;

    @FXML
    private Ellipse StatusLevelCryo;

    @FXML
    private Group CV021;

    @FXML
    private SVGPath StatusCV021;

    @FXML
    private Group V31e;

    @FXML
    private SVGPath StatusV31e;

    @FXML
    private Label PressureG31e;

    @FXML
    private Group G31e;

    @FXML
    private Circle StatusG31e;

    @FXML
    private Group P31e;

    @FXML
    private Rectangle StatusP31e;

    @FXML
    private Group P32e;

    @FXML
    private Rectangle StatusP32e;

    @FXML
    private Group P33e;

    @FXML
    private Rectangle StatusP33e;

    @FXML
    private Group V32e;

    @FXML
    private SVGPath StatusV32e;

    @FXML
    private Group V23;

    @FXML
    private SVGPath StatusV221;

    @FXML
    private Label TemperatureTT07;

    @FXML
    private Label TemperatureTT04;

    @FXML
    private Label TemperatureTT05;

    @FXML
    private Label TemperatureTT06;

    @FXML
    private Label TemperatureInput;

    @FXML
    private Label LevelLT02;

    @FXML
    private Label PressurePT02;

    @FXML
    private Label PressurePT01;

    @FXML
    private Label LevelLT01;

    private String style = "";


    @FXML
    void SpeedP2_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotP2");
    }

    @FXML
    void SpeedP2_Pressed(MouseEvent event) {
       style = SpeedP2.getStyle();
       SpeedP2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void SpeedP2_Released(MouseEvent event) {
       SpeedP2.setStyle(style);
    }

    @FXML
    void TemperatureInput_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotVALVEBIG_TInput");
    }

    @FXML
    void TemperatureInput_Pressed(MouseEvent event) {
       style = TemperatureInput.getStyle();
       TemperatureInput.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void TemperatureInput_Released(MouseEvent event) {
       TemperatureInput.setStyle(style);
    }
    @FXML
    void TemperatureTT04_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotLN2_TT04");
    }
    
    @FXML
    void TemperatureTT04_Pressed(MouseEvent event) {
       style = TemperatureTT04.getStyle();
       TemperatureTT04.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void TemperatureTT04_Released(MouseEvent event) {
       TemperatureTT04.setStyle(style);
    }

    @FXML
    void TemperatureTT05_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotLN2_TT05");
    }

    @FXML
    void TemperatureTT05_Pressed(MouseEvent event) {
       style = TemperatureTT05.getStyle();
       TemperatureTT05.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void TemperatureTT05_Released(MouseEvent event) {
       TemperatureTT05.setStyle(style);
    }

    @FXML
    void TemperatureTT06_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotLN2_TT06");
    }

    @FXML
    void TemperatureTT06_Pressed(MouseEvent event) {
       style = TemperatureTT06.getStyle();
       TemperatureTT06.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void TemperatureTT06_Released(MouseEvent event) {
       TemperatureTT06.setStyle(style);
    }

    @FXML
    void TemperatureTT07_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotLN2_TT07");
    }

    @FXML
    void TemperatureTT07_Pressed(MouseEvent event) {
       style = TemperatureTT07.getStyle();
       TemperatureTT07.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void TemperatureTT07_Released(MouseEvent event) {
       TemperatureTT07.setStyle(style);
    }

    @FXML
    void PressurePT01_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotLN2_PT01");
    }

    @FXML
    void PressurePT01_Pressed(MouseEvent event) {
       style = PressurePT01.getStyle();
       PressurePT01.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressurePT01_Released(MouseEvent event) {
       PressurePT01.setStyle(style);
    }

    @FXML
    void PressurePT02_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotLN2_PT02");
    }

    @FXML
    void PressurePT02_Pressed(MouseEvent event) {
       style = PressurePT02.getStyle();
       PressurePT02.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressurePT02_Released(MouseEvent event) {
       PressurePT02.setStyle(style);
    }

    @FXML
    void LevelLT01_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotLN2_LT01");
    }

    @FXML
    void LevelLT01_Pressed(MouseEvent event) {
       style = LevelLT01.getStyle();
       LevelLT01.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void LevelLT01_Released(MouseEvent event) {
       LevelLT01.setStyle(style);
    }

    @FXML
    void G21_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "G21");
    }

    @FXML
    void G21_Pressed(MouseEvent event) {
       style = G21.getStyle();
       G21.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void G21_Released(MouseEvent event) {
       G21.setStyle(style);
    }

    @FXML
    void G22_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "G22");
    }

    @FXML
    void G22_Pressed(MouseEvent event) {
       style = G22.getStyle();
       G22.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void G22_Released(MouseEvent event) {
       G22.setStyle(style);
    }

    @FXML
    void G31e_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "G31e");
    }

    @FXML
    void G31e_Pressed(MouseEvent event) {
       style = G31e.getStyle();
       G31e.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void G31e_Released(MouseEvent event) {
       G31e.setStyle(style);
    }

    @FXML
    void G31i_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "G31i");
    }

    @FXML
    void G31i_Pressed(MouseEvent event) {
       style = G31i.getStyle();
       G31i.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void G31i_Released(MouseEvent event) {
       G31i.setStyle(style);
    }

    @FXML
    void Ge1_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "Ge1");
    }

    @FXML
    void Ge1_Pressed(MouseEvent event) {
       style = Ge1.getStyle();
       Ge1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Ge1_Released(MouseEvent event) {
       Ge1.setStyle(style);
    }

    @FXML
    void Ge2_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "Ge2");
    }

    @FXML
    void Ge2_Pressed(MouseEvent event) {
       style = Ge2.getStyle();
       Ge2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Ge2_Released(MouseEvent event) {
       Ge2.setStyle(style);
    }

    @FXML
    void Ge3_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "Ge3");
    }

    @FXML
    void Ge3_Pressed(MouseEvent event) {
       style = Ge3.getStyle();
       Ge3.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Ge3_Released(MouseEvent event) {
       Ge3.setStyle(style);
    }

    @FXML
    void Ge4_Clicked(MouseEvent event) {
       CreateAndShowRGALayer("Ge4");
    }

    @FXML
    void Ge4_Pressed(MouseEvent event) {
       style = Ge4.getStyle();
       Ge4.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Ge4_Released(MouseEvent event) {
       Ge4.setStyle(style);
    }

    @FXML
    void P2_Clicked(MouseEvent event) {
       CreateAndShowTurboLayer("TURBO", "P2");
    }

    @FXML
    void P2_Pressed(MouseEvent event) {
       style = P2.getStyle();
       P2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void P2_Released(MouseEvent event) {
       P2.setStyle(style);
    }

    @FXML
    void P1_Clicked(MouseEvent event) {
       CreateAndShowDryLayer("P1");
    }

    @FXML
    void P1_Pressed(MouseEvent event) {
       style = P1.getStyle();
       P1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void P1_Released(MouseEvent event) {
       P1.setStyle(style);
    }

    @FXML
    void P31e_Clicked(MouseEvent event) {
       CreateAndShowTitaneLayer("TITANE", "P31e");
    }

    @FXML
    void P31e_Pressed(MouseEvent event) {
       style = P31e.getStyle();
       P31e.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void P31e_Released(MouseEvent event) {
       P31e.setStyle(style);
    }

    @FXML
    void P31i_Clicked(MouseEvent event) {
       CreateAndShowTitaneLayer("TITANE", "P31i");
    }

    @FXML
    void P31i_Pressed(MouseEvent event) {
       style = P31i.getStyle();
       P31i.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void P31i_Released(MouseEvent event) {
       P31i.setStyle(style);
    }

    @FXML
    void P32e_Clicked(MouseEvent event) {
       CreateAndShowTitaneLayer("TITANE", "P32e");
    }

    @FXML
    void P32e_Pressed(MouseEvent event) {
       style = P32e.getStyle();
       P32e.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void P32e_Released(MouseEvent event) {
       P32e.setStyle(style);
    }

    @FXML
    void P32i_Clicked(MouseEvent event) {
       CreateAndShowTitaneLayer("TITANE", "P32i");
    }

    @FXML
    void P32i_Pressed(MouseEvent event) {
       style = P32i.getStyle();
       P32i.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void P32i_Released(MouseEvent event) {
       P32i.setStyle(style);
    }

    @FXML
    void P33e_Clicked(MouseEvent event) {
       CreateAndShowIonicLayer("IONIC", "P33e");
    }

    @FXML
    void P33e_Pressed(MouseEvent event) {
       style = P33e.getStyle();
       P33e.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void P33e_Released(MouseEvent event) {
       P33e.setStyle(style);
    }

    @FXML
    void P33i_Clicked(MouseEvent event) {
       CreateAndShowIonicLayer("IONIC", "P33i");
    }

    @FXML
    void P33i_Pressed(MouseEvent event) {
       style = P33i.getStyle();
       P33i.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void P33i_Released(MouseEvent event) {
       P33i.setStyle(style);
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
    void PressureG31e_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotG31e");
    }

    @FXML
    void PressureG31e_Pressed(MouseEvent event) {
       style = PressureG31e.getStyle();
       PressureG31e.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureG31e_Released(MouseEvent event) {
       PressureG31e.setStyle(style);
    }

    @FXML
    void PressureG31i_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotG31i");
    }

    @FXML
    void PressureG31i_Pressed(MouseEvent event) {
       style = PressureG31i.getStyle();
       PressureG31i.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureG31i_Released(MouseEvent event) {
       PressureG31i.setStyle(style);
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
       style = V1.getStyle();
       V1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V1_Released(MouseEvent event) {
       V1.setStyle(style);
    }

    @FXML
    void V21_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("V21");
    }

    @FXML
    void V21_Pressed(MouseEvent event) {
      style = V21.getStyle();
      V21.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V21_Released(MouseEvent event) {
       V21.setStyle(style);
    }

    @FXML
    void V22_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("V22");
    }

    @FXML
    void V22_Pressed(MouseEvent event) {
      style = V22.getStyle();
      V22.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V22_Released(MouseEvent event) {
       V22.setStyle(style);
    }

    @FXML
    void V23_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("V23");
    }

    @FXML
    void V23_Pressed(MouseEvent event) {
      style = V23.getStyle();
      V23.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V23_Released(MouseEvent event) {
       V23.setStyle(style);
    }

    @FXML
    void V31e_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("V31e");
    }

    @FXML
    void V31e_Pressed(MouseEvent event) {
      style = V31e.getStyle();
      V31e.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V31e_Released(MouseEvent event) {
       V31e.setStyle(style);
    }

    @FXML
    void V31i_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("V31i");
    }

    @FXML
    void V31i_Pressed(MouseEvent event) {
      style = V31i.getStyle();
      V31i.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V31i_Released(MouseEvent event) {
       V31i.setStyle(style);
    }

    @FXML
    void V32e_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("V32e");
    }

    @FXML
    void V32e_Pressed(MouseEvent event) {
      style = V32e.getStyle();
      V32e.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V32e_Released(MouseEvent event) {
       V32e.setStyle(style);
    }

    @FXML
    void V32i_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("V32i");
    }

    @FXML
    void V32i_Pressed(MouseEvent event) {
      style = V32i.getStyle();
      V32i.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V32i_Released(MouseEvent event) {
       V32i.setStyle(style);
    }

    @FXML
    void VCryo_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("VCryo");
    }

    @FXML
    void VCryo_Pressed(MouseEvent event) {
      style = VCryo.getStyle();
      VCryo.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void VCryo_Released(MouseEvent event) {
       VCryo.setStyle(style);
    }

    @FXML
    void Ve1_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("Ve1");
    }

    @FXML
    void Ve1_Pressed(MouseEvent event) {
      style = Ve1.getStyle();
      Ve1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Ve1_Released(MouseEvent event) {
       Ve1.setStyle(style);
    }

    @FXML
    void Ve2_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("Ve2");
    }

    @FXML
    void Ve2_Pressed(MouseEvent event) {
      style = Ve2.getStyle();
      Ve2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Ve2_Released(MouseEvent event) {
       Ve2.setStyle(style);
    }



}

