package com.gluonapplication;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.SVGPath;


// TUBE900N station (SCADARPI rack): V31, V32, G31 (Maxigauge channel 6), P33 (Agilent IPCMini)
public class ControllerTube900NStation extends ControlLayer implements ControlTypes {

    @FXML
    private Group V31;

    @FXML
    private SVGPath StatusV31;

    @FXML
    private Group V32;

    @FXML
    private SVGPath StatusV32;

    @FXML
    private Group G31;

    @FXML
    private Circle StatusG31;

    @FXML
    private Label PressureG31;

    @FXML
    private Group P33;

    @FXML
    private Rectangle StatusP33;

    String style = "";

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
    void P33_Clicked(MouseEvent event) {
       CreateAndShowIonicIPCLayer("IONICIPC", "P33");
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
}
