package com.gluonapplication;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

public class ControllerMobileVenting extends ControlLayer implements ControlTypes {

    private String style;

    @FXML
    private Group G1;

    @FXML
    private Group G2;

    @FXML
    private Circle StatusG1;

    @FXML
    private Circle StatusG2;

    @FXML
    private Label PressureG1;

    @FXML
    private Label PressureG2;

    @FXML
    private Group VBypass;

    @FXML
    private Group VMain;

    @FXML
    private Group VSoft;

    @FXML
    private Group VRP;

    @FXML
    private Group VDryer;

    @FXML
    private Group V1;

    @FXML
    private Group P1;

    @FXML
    void G1_Clicked(MouseEvent event) {
        CreateAndShowGaugeLayer("MAXIGAUGE", "G1");
    }

    @FXML
    void G1_Pressed(MouseEvent event) {
        style = StatusG1.getStyle();
        StatusG1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void G1_Released(MouseEvent event) {
        StatusG1.setStyle(style);
    }

    @FXML
    void G2_Clicked(MouseEvent event) {
        CreateAndShowGaugeLayer("MAXIGAUGE", "G2");
    }

    @FXML
    void G2_Pressed(MouseEvent event) {
        style = StatusG2.getStyle();
        StatusG2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void G2_Released(MouseEvent event) {
        StatusG2.setStyle(style);
    }

    @FXML
    void PressureG1_Clicked(MouseEvent event) {
        CreateAndShowPlotLayer("PlotG1");
    }

    @FXML
    void PressureG1_Pressed(MouseEvent event) {
        style = PressureG1.getStyle();
        PressureG1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureG1_Released(MouseEvent event) {
        PressureG1.setStyle(style);
    }

    @FXML
    void PressureG2_Clicked(MouseEvent event) {
        CreateAndShowPlotLayer("PlotG2");
    }

    @FXML
    void PressureG2_Pressed(MouseEvent event) {
        style = PressureG2.getStyle();
        PressureG2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureG2_Released(MouseEvent event) {
        PressureG2.setStyle(style);
    }

    @FXML
    void VBypass_Clicked(MouseEvent event) {
        CreateAndShowValveLayer("VBypass");
    }

    @FXML
    void VBypass_Pressed(MouseEvent event) {
        style = VBypass.getStyle();
        VBypass.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void VBypass_Released(MouseEvent event) {
        VBypass.setStyle(style);
    }

    @FXML
    void VMain_Clicked(MouseEvent event) {
        CreateAndShowValveLayer("VMain");
    }

    @FXML
    void VMain_Pressed(MouseEvent event) {
        style = VMain.getStyle();
        VMain.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void VMain_Released(MouseEvent event) {
        VMain.setStyle(style);
    }

    @FXML
    void VSoft_Clicked(MouseEvent event) {
        CreateAndShowValveLayer("VSoft");
    }

    @FXML
    void VSoft_Pressed(MouseEvent event) {
        style = VSoft.getStyle();
        VSoft.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void VSoft_Released(MouseEvent event) {
        VSoft.setStyle(style);
    }

    @FXML
    void VRP_Clicked(MouseEvent event) {
        CreateAndShowValveLayer("VRP");
    }

    @FXML
    void VRP_Pressed(MouseEvent event) {
        style = VRP.getStyle();
        VRP.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void VRP_Released(MouseEvent event) {
        VRP.setStyle(style);
    }

    @FXML
    void VDryer_Clicked(MouseEvent event) {
        CreateAndShowValveLayer("VDryer");
    }

    @FXML
    void VDryer_Pressed(MouseEvent event) {
        style = VDryer.getStyle();
        VDryer.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void VDryer_Released(MouseEvent event) {
        VDryer.setStyle(style);
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
}
