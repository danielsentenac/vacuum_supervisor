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

public class ControllerCryoLink extends ControlLayer implements ControlTypes {

    @FXML
    private Group CV2;

    @FXML
    private SVGPath StatusCV2;

    @FXML
    private Group Vs1;

    @FXML
    private SVGPath StatusVs1;

    @FXML
    private Label PressureGs3;

    @FXML
    private Label PressureGs4;

    @FXML
    private Group Gs3;

    @FXML
    private Circle StatusGs3;

    @FXML
    private Group Gs4;

    @FXML
    private Circle StatusGs4;

    @FXML
    private Group Gs6;

    @FXML
    private Circle StatusGs6;

    @FXML
    private Group V21;

    @FXML
    private SVGPath StatusV21;

    @FXML
    private Group P21;

    @FXML
    private Rectangle StatusP21;

    @FXML
    private Group V22;

    @FXML
    private SVGPath StatusV22;

    @FXML
    private Group P22;

    @FXML
    private Rectangle StatusP22;

    @FXML
    private Group G22;

    @FXML
    private Circle StatusG22;

    @FXML
    private Group G21;

    @FXML
    private Circle StatusG21;

    @FXML
    private Label PressureG21;

    @FXML
    private Label PressureG22;

    @FXML
    private Label PressureGs1;

    @FXML
    private Label PressureGs2;

    @FXML
    private Label SpeedP21;

    @FXML
    private Ellipse StatusLevelCryo;

    @FXML
    private Label TemperatureTF;

    @FXML
    private Label TemperatureT1;

    @FXML
    private Label TemperatureT2;

    @FXML
    private Label TemperatureT3;

    @FXML
    private Label Level;

    @FXML
    private Label TemperatureT12;

    @FXML
    private Group Gs1;

    @FXML
    private Circle StatusGs1;

    @FXML
    private Group Vs2;

    @FXML
    private SVGPath StatusVs2;

    @FXML
    private Group Gs2;

    @FXML
    private Circle StatusGs2;

    @FXML
    private Group Gs5;

    @FXML
    private Circle StatusGs5;

    @FXML
    private Label PressureGs5;

    @FXML
    private Group CV1;

    @FXML
    private SVGPath StatusCV1;

    @FXML
    private Label TemperatureTL;

    @FXML
    private Label TemperatureTN;

    @FXML
    private Label TemperatureT4;

    @FXML
    private Label TemperatureT5;

    @FXML
    private Label TemperatureT6;

    @FXML
    private Label TemperatureT7;

    @FXML
    private Label TemperatureT8;

    private String style = "";

    private String name = "";

    @FXML
    void Level_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotLevel");
    }

    @FXML
    void Level_Pressed(MouseEvent event) {
       style = Level.getStyle();
       Level.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Level_Released(MouseEvent event) {
       Level.setStyle(style);
    }

    @FXML
    void TemperatureT12_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotT12");
    }

    @FXML
    void TemperatureT12_Pressed(MouseEvent event) {
       style = TemperatureT12.getStyle();
       TemperatureT12.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void TemperatureT12_Released(MouseEvent event) {
       TemperatureT12.setStyle(style);
    }

    @FXML
    void TemperatureT1_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotT1");
    }

    @FXML
    void TemperatureT1_Pressed(MouseEvent event) {
       style = TemperatureT1.getStyle();
       TemperatureT1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void TemperatureT1_Released(MouseEvent event) {
       TemperatureT1.setStyle(style);
    }

    @FXML
    void TemperatureT2_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotT2");
    }

    @FXML
    void TemperatureT2_Pressed(MouseEvent event) {
       style = TemperatureT2.getStyle();
       TemperatureT2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void TemperatureT2_Released(MouseEvent event) {
       TemperatureT2.setStyle(style);
    }

    @FXML
    void TemperatureT3_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotT3");
    }

    @FXML
    void TemperatureT3_Pressed(MouseEvent event) {
       style = TemperatureT3.getStyle();
       TemperatureT3.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void TemperatureT3_Released(MouseEvent event) {
       TemperatureT3.setStyle(style);
    }

    @FXML
    void TemperatureT4_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotT4");
    }

    @FXML
    void TemperatureT4_Pressed(MouseEvent event) {
       style = TemperatureT4.getStyle();
       TemperatureT4.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void TemperatureT4_Released(MouseEvent event) {
       TemperatureT4.setStyle(style);
    }

    @FXML
    void TemperatureT5_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotT5");
    }

    @FXML
    void TemperatureT5_Pressed(MouseEvent event) {
       style = TemperatureT5.getStyle();
       TemperatureT5.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void TemperatureT5_Released(MouseEvent event) {
       TemperatureT5.setStyle(style);
    }

    @FXML
    void TemperatureT6_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotT6");
    }

    @FXML
    void TemperatureT6_Pressed(MouseEvent event) {
       style = TemperatureT6.getStyle();
       TemperatureT6.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void TemperatureT6_Released(MouseEvent event) {
       TemperatureT6.setStyle(style);
    }

    @FXML
    void TemperatureT7_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotT7");
    }

    @FXML
    void TemperatureT7_Pressed(MouseEvent event) {
       style = TemperatureT7.getStyle();
       TemperatureT7.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void TemperatureT7_Released(MouseEvent event) {
       TemperatureT7.setStyle(style);
    }

    @FXML
    void TemperatureT8_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotT8");
    }

    @FXML
    void TemperatureT8_Pressed(MouseEvent event) {
       style = TemperatureT8.getStyle();
       TemperatureT8.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void TemperatureT8_Released(MouseEvent event) {
       TemperatureT8.setStyle(style);
    }

    @FXML
    void TemperatureTF_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotTF");
    }

    @FXML
    void TemperatureTF_Pressed(MouseEvent event) {
       style = TemperatureTF.getStyle();
       TemperatureTF.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void TemperatureTF_Released(MouseEvent event) {
       TemperatureTF.setStyle(style);
    }

    @FXML
    void TemperatureTL_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotTL");
    }

    @FXML
    void TemperatureTL_Pressed(MouseEvent event) {
       style = TemperatureTL.getStyle();
       TemperatureTL.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void TemperatureTL_Released(MouseEvent event) {
       TemperatureTL.setStyle(style);
    }

    @FXML
    void TemperatureTN_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotTN");
    }

    @FXML
    void TemperatureTN_Pressed(MouseEvent event) {
       style = TemperatureTN.getStyle();
       TemperatureTN.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void TemperatureTN_Released(MouseEvent event) {
       TemperatureTN.setStyle(style);
    }

    @FXML
    void CV1_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("CV1");
    }

    @FXML
    void CV1_Pressed(MouseEvent event) {
       style = CV1.getStyle();
       CV1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void CV1_Released(MouseEvent event) {
       CV1.setStyle(style);
    }

    @FXML
    void CV2_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("CV2");
    }

    @FXML
    void CV2_Pressed(MouseEvent event) {
       style = CV2.getStyle();
       CV2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void CV2_Released(MouseEvent event) {
       CV2.setStyle(style);
    }

    @FXML
    void Gs5_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "Gs5");
    }

    @FXML
    void Gs5_Pressed(MouseEvent event) {
       style = Gs5.getStyle();
       Gs5.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Gs5_Released(MouseEvent event) {
       Gs5.setStyle(style);
    }

    @FXML
    void Gs1_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "Gs1");
    }

    @FXML
    void Gs1_Pressed(MouseEvent event) {
       style = Gs1.getStyle();
       Gs1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Gs1_Released(MouseEvent event) {
       Gs1.setStyle(style);
    }

    @FXML
    void Gs2_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "Gs2");
    }

    @FXML
    void Gs2_Pressed(MouseEvent event) {
       style = Gs2.getStyle();
       Gs2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Gs2_Released(MouseEvent event) {
       Gs2.setStyle(style);
    }

    @FXML
    void Gs3_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "Gs3");
    }

    @FXML
    void Gs3_Pressed(MouseEvent event) {
       style = Gs3.getStyle();
       Gs3.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Gs3_Released(MouseEvent event) {
       Gs3.setStyle(style);
    }

    @FXML
    void Gs4_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "Gs4");
    }

    @FXML
    void Gs4_Pressed(MouseEvent event) {
       style = Gs4.getStyle();
       Gs4.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Gs4_Released(MouseEvent event) {
       Gs4.setStyle(style);
    }

    @FXML
    void Gs6_Clicked(MouseEvent event) {

    }

    @FXML
    void Gs6_Pressed(MouseEvent event) {
       style = Gs6.getStyle();
       Gs6.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Gs6_Released(MouseEvent event) {
       Gs6.setStyle(style);
    }

    @FXML
    void P22_Clicked(MouseEvent event) {
       CreateAndShowDryLayer("P22");
    }

    @FXML
    void P22_Pressed(MouseEvent event) {
       style = P22.getStyle();
       P22.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void P22_Released(MouseEvent event) {
       P22.setStyle(style);
    }

    @FXML
    void P21_Clicked(MouseEvent event) {
       CreateAndShowTurboLayer("TURBO", "P21");
    }

    @FXML
    void P21_Pressed(MouseEvent event) {
       style = P21.getStyle();
       P21.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void P21_Released(MouseEvent event) {
       P21.setStyle(style);
    }

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
       style = G21.getStyle();
       G21.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void G21_Released(MouseEvent event) {
       G21.setStyle(style);
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
    void PressureG22_Clicked(MouseEvent event) {
       // Get Present View name
       ViewData presentView = (ViewData) MobileApplication.getInstance().getView();
       name = presentView.name;
       if (name.contains("DET"))
          CreateAndShowPlotLayer("PlotG22DET");
       else
          CreateAndShowPlotLayer("PlotG22IB");
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
    void PressureGs1_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotGs1");
    }

    @FXML
    void PressureGs1_Pressed(MouseEvent event) {
       style = PressureGs1.getStyle();
       PressureGs1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureGs1_Released(MouseEvent event) {
       PressureGs1.setStyle(style);
    }

    @FXML
    void PressureGs2_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotGs2");
    }

    @FXML
    void PressureGs2_Pressed(MouseEvent event) {
       style = PressureGs2.getStyle();
       PressureGs2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureGs2_Released(MouseEvent event) {
       PressureGs2.setStyle(style);
    }

    @FXML
    void PressureGs3_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotGs3");
    }

    @FXML
    void PressureGs3_Pressed(MouseEvent event) {
       style = PressureGs3.getStyle();
       PressureGs3.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureGs3_Released(MouseEvent event) {
       PressureGs3.setStyle(style);
    }

    @FXML
    void PressureGs4_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotGs4");
    }

    @FXML
    void PressureGs4_Pressed(MouseEvent event) {
       style = PressureGs4.getStyle();
       PressureGs4.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureGs4_Released(MouseEvent event) {
       PressureGs4.setStyle(style);
    }

    @FXML
    void PressureGs5_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotGs5");
    }

    @FXML
    void PressureGs5_Pressed(MouseEvent event) {
       style = PressureGs5.getStyle();
       PressureGs5.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureGs5_Released(MouseEvent event) {
       PressureGs5.setStyle(style);
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
    void Vs1_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("Vs1");
    }

    @FXML
    void Vs1_Pressed(MouseEvent event) {
       style = Vs1.getStyle();
       Vs1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Vs1_Released(MouseEvent event) {
       Vs1.setStyle(style);
    }

    @FXML
    void Vs2_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("Vs2");
    }

    @FXML
    void Vs2_Pressed(MouseEvent event) {
       style = Vs2.getStyle();
       Vs2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Vs2_Released(MouseEvent event) {
       Vs2.setStyle(style);
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
}

