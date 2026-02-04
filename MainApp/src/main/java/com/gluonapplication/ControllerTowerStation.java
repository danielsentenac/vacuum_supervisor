package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.SVGPath;


public class ControllerTowerStation extends ControlLayer implements ControlTypes {

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
    private Group P31;

    @FXML
    private Rectangle StatusP31;

    @FXML
    private Group P32;

    @FXML
    private Rectangle StatusP32;

    @FXML
    private Group P81;

    @FXML
    private Rectangle StatusP81;

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
    private Label PressureG71;

    @FXML
    private Label SpeedP71;

    @FXML
    private Group V71;

    @FXML
    private SVGPath StatusV71;

    @FXML
    private Group P71;

    @FXML
    private Rectangle StatusP71;

    @FXML
    private Group G71;

    @FXML
    private Circle StatusG71;

    @FXML
    private Group V75;

    @FXML
    private SVGPath StatusV75;

    @FXML
    private Group V73;

    @FXML
    private SVGPath StatusV73;

    @FXML
    private Group G41;

    @FXML
    private Circle StatusG41;

    @FXML
    private Group P41;

    @FXML
    private Rectangle StatusP41;

    @FXML
    private Group V43;

    @FXML
    private SVGPath StatusV43;

    @FXML
    private Group V74;

    @FXML
    private SVGPath StatusV74;

    @FXML
    private Group G72;

    @FXML
    private Circle StatusG72;

    @FXML
    private Label PressureG72;

    @FXML
    private Group V41;

    @FXML
    private SVGPath StatusV41;

    @FXML
    private Group V42;

    @FXML
    private SVGPath StatusV42;

    @FXML
    private Group V72;

    @FXML
    private SVGPath StatusV72;

    @FXML
    private Group V91;

    @FXML
    private SVGPath StatusV91;

    @FXML
    private Group V92;

    @FXML
    private SVGPath StatusV92;

    @FXML
    private Group V82;

    @FXML
    private SVGPath StatusV82;

    @FXML
    private Group G81;

    @FXML
    private Circle StatusG81;

    @FXML
    private Group V81;

    @FXML
    private SVGPath StatusV81;

    @FXML
    private Label PressureG81;

    @FXML
    private Group P33;

    @FXML
    private Rectangle StatusP33;

    @FXML
    private Group G31;

    @FXML
    private Circle StatusG31;

    @FXML
    private Group V31;

    @FXML
    private SVGPath StatusV31;

    @FXML
    private Label PressureG31;

    @FXML
    private Group V32;

    @FXML
    private SVGPath StatusV32;

    @FXML
    private Label Flow;

    @FXML
    private Label Temperature;

    @FXML
    private Label Humidity;

    @FXML
    private Group Vd1;

    @FXML
    private SVGPath StatusVd1;

    @FXML
    private Label PressureGd1;

    @FXML
    private Label PressureGd3;

    @FXML
    private Label PressureGd2;

    @FXML
    private Group Gd1;

    @FXML
    private Circle StatusGd1;

    @FXML
    private Group Gd2;

    @FXML
    private Group Gd3;

    @FXML
    private Circle StatusGd3;

    @FXML
    private Group Gd4;

    @FXML
    private Circle StatusGd4;

    @FXML
    private Group Vd2;

    @FXML
    private SVGPath StatusVd2;

    @FXML
    private Circle StatusGd2;

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
    void SpeedP71_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotP71");
    }

    @FXML
    void SpeedP71_Pressed(MouseEvent event) {
       style = SpeedP71.getStyle();
       SpeedP71.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void SpeedP71_Released(MouseEvent event) {
       SpeedP71.setStyle(style);
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
    void G71_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "G71");
    }

    @FXML
    void G71_Pressed(MouseEvent event) {
       style = StatusG71.getStyle();
       StatusG71.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void G71_Released(MouseEvent event) {
       StatusG71.setStyle(style);
    }

    @FXML
    void G72_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "G72");
    }

    @FXML
    void G72_Pressed(MouseEvent event) {
       style = StatusG72.getStyle();
       StatusG72.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void G72_Released(MouseEvent event) {
       StatusG72.setStyle(style);
    }

    @FXML
    void G81_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "G81");
    }

    @FXML
    void G81_Pressed(MouseEvent event) {
       style = StatusG81.getStyle();
       StatusG81.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void G81_Released(MouseEvent event) {
       StatusG81.setStyle(style);
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
    void Gd1_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "Gd1");
    }

    @FXML
    void Gd1_Pressed(MouseEvent event) {
       style = StatusGd1.getStyle();
       StatusGd1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Gd1_Released(MouseEvent event) {
       StatusGd1.setStyle(style);
    }

    @FXML
    void Gd2_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "Gd2");
    }

    @FXML
    void Gd2_Pressed(MouseEvent event) {
       style = StatusGd2.getStyle();
       StatusGd2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Gd2_Released(MouseEvent event) {
       StatusGd2.setStyle(style);
    }

    @FXML
    void Gd3_Clicked(MouseEvent event) {
      CreateAndShowGaugeLayer("ITRGAUGE", "Gd3");
    }

    @FXML
    void Gd3_Pressed(MouseEvent event) {
       style = StatusGd3.getStyle();
       StatusGd3.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Gd3_Released(MouseEvent event) {
       StatusGd3.setStyle(style);
    }

    @FXML
    void Gd4_Clicked(MouseEvent event) {
       CreateAndShowRGALayer("Gd4");
    }

    @FXML
    void Gd4_Pressed(MouseEvent event) {
       style = StatusGd4.getStyle();
       StatusGd4.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Gd4_Released(MouseEvent event) {
       StatusGd4.setStyle(style);
    }

     @FXML
    void P31_Clicked(MouseEvent event) {
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
    void P71_Clicked(MouseEvent event) {
       CreateAndShowTurboLayer("TURBO", "P71");
    }

    @FXML
    void P71_Pressed(MouseEvent event) {
       style = StatusP71.getStyle();
       StatusP71.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void P71_Released(MouseEvent event) {
       StatusP71.setStyle(style);
    }

    @FXML
    void P81_Clicked(MouseEvent event) {
       CreateAndShowIonicLayer("IONIC", "P81");
    }

    @FXML
    void P81_Pressed(MouseEvent event) {
       style = StatusP81.getStyle();
       StatusP81.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void P81_Released(MouseEvent event) {
       StatusP81.setStyle(style);
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
    void PressureG71_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotG71");
    }

    @FXML
    void PressureG71_Pressed(MouseEvent event) {
       style = PressureG71.getStyle();
       PressureG71.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureG71_Released(MouseEvent event) {
       PressureG71.setStyle(style);
    }

    @FXML
    void PressureG72_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotG72");
    }

    @FXML
    void PressureG72_Pressed(MouseEvent event) {
       style = PressureG72.getStyle();
       PressureG72.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureG72_Released(MouseEvent event) {
       PressureG72.setStyle(style);
    }

    @FXML
    void PressureG81_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotG81");
    }

    @FXML
    void PressureG81_Pressed(MouseEvent event) {
       style = PressureG81.getStyle();
       PressureG81.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureG81_Released(MouseEvent event) {
       PressureG81.setStyle(style);
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
    void PressureGd1_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotGd1");
    }

    @FXML
    void PressureGd1_Pressed(MouseEvent event) {
       style = PressureGd1.getStyle();
       PressureGd1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureGd1_Released(MouseEvent event) {
       PressureGd1.setStyle(style);
    }

    @FXML
    void PressureGd2_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotGd2");
    }

    @FXML
    void PressureGd2_Pressed(MouseEvent event) {
       style = PressureGd2.getStyle();
       PressureGd2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureGd2_Released(MouseEvent event) {
       PressureGd2.setStyle(style);
    }

    @FXML
    void PressureGd3_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotGd3");
    }

    @FXML
    void PressureGd3_Pressed(MouseEvent event) {
       style = PressureGd3.getStyle();
       PressureGd3.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureGd3_Released(MouseEvent event) {
       PressureGd3.setStyle(style);
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
    void V43_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("V43");
    }

    @FXML
    void V43_Pressed(MouseEvent event) {
       style = StatusV43.getStyle();
       StatusV43.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V43_Released(MouseEvent event) {
       StatusV43.setStyle(style);
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
    void V71_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("V71");
    }

    @FXML
    void V71_Pressed(MouseEvent event) {
       style = StatusV71.getStyle();
       StatusV71.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V71_Released(MouseEvent event) {
       StatusV71.setStyle(style);
    }

    @FXML
    void V72_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("V72");
    }

    @FXML
    void V72_Pressed(MouseEvent event) {
       style = StatusV72.getStyle();
       StatusV72.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V72_Released(MouseEvent event) {
       StatusV72.setStyle(style);
    }

    @FXML
    void V73_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("V73");
    }

    @FXML
    void V73_Pressed(MouseEvent event) {
       style = StatusV73.getStyle();
       StatusV73.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V73_Released(MouseEvent event) {
       StatusV73.setStyle(style);
    }

    @FXML
    void V74_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("V74");
    }

    @FXML
    void V74_Pressed(MouseEvent event) {
       style = StatusV74.getStyle();
       StatusV74.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V74_Released(MouseEvent event) {
       StatusV74.setStyle(style);
    }

    @FXML
    void V75_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("V75");
    }

    @FXML
    void V75_Pressed(MouseEvent event) {
       style = StatusV75.getStyle();
       StatusV75.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V75_Released(MouseEvent event) {
       StatusV75.setStyle(style);
    }

    @FXML
    void V81_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("V81");
    }

    @FXML
    void V81_Pressed(MouseEvent event) {
       style = StatusV81.getStyle();
       StatusV81.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V81_Released(MouseEvent event) {
       StatusV81.setStyle(style);
    }

    @FXML
    void V82_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("V82");
    }

    @FXML
    void V82_Pressed(MouseEvent event) {
       style = StatusV81.getStyle();
       StatusV81.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V82_Released(MouseEvent event) {
       StatusV82.setStyle(style);
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
    void Vd1_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("Vd1");
    }

    @FXML
    void Vd1_Pressed(MouseEvent event) {
       style = StatusVd1.getStyle();
       StatusVd1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Vd1_Released(MouseEvent event) {
       StatusVd1.setStyle(style);
    }

    @FXML
    void Vd2_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("Vd2");
    }

    @FXML
    void Vd2_Pressed(MouseEvent event) {
       style = StatusVd2.getStyle();
       StatusVd2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Vd2_Released(MouseEvent event) {
       StatusVd2.setStyle(style);
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
}

