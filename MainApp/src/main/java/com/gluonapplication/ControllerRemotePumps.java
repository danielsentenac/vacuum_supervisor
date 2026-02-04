package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.SVGPath;


public class ControllerRemotePumps extends ControlLayer implements ControlTypes {


    @FXML
    private Group NI;

    @FXML
    private Group WI;

    @FXML
    private Group BS;

    @FXML
    private Group PR;

    @FXML
    private Group SR;

    @FXML
    private Group DET;

    @FXML
    private Group IB;

    @FXML
    private Group LP;

    @FXML
    private Group LS;

    @FXML
    private Group Vwi;

    @FXML
    private SVGPath StatusVwi;

    @FXML
    private Group Vbs;

    @FXML
    private SVGPath StatusVbs;

    @FXML
    private Group Vlp;

    @FXML
    private SVGPath StatusVlp;

    @FXML
    private Group Vs3;

    @FXML
    private SVGPath StatusVs3;

    @FXML
    private Label PressureGbs;

    @FXML
    private Label PressureGlp;

    @FXML
    private Label PressureGni;

    @FXML
    private Label PressureGwi;

    @FXML
    private Label PressureGs1;

    @FXML
    private Group G3;

    @FXML
    private Circle StatusG3;

    @FXML
    private Group Vdt;

    @FXML
    private SVGPath StatusVdt;

    @FXML
    private Group TP1;

    @FXML
    private Rectangle StatusTP1;

    @FXML
    private Group Vs1;

    @FXML
    private SVGPath StatusVs1;

    @FXML
    private Group V22;

    @FXML
    private SVGPath StatusV2;

    @FXML
    private Group G22;

    @FXML
    private Circle StatusG2;

    @FXML
    private Group P1;

    @FXML
    private Rectangle StatusP1;

    @FXML
    private Label PressureGsr;

    @FXML
    private Label PressureGls;

    @FXML
    private Label PressureG1;

    @FXML
    private Label PressureG2;

    @FXML
    private Group P2;

    @FXML
    private Rectangle StatusP2;

    @FXML
    private Group G1;

    @FXML
    private Circle StatusG1;

    @FXML
    private Group V1;

    @FXML
    private SVGPath StatusV1;

    @FXML
    private Group Gdt;

    @FXML
    private Circle StatusGdt;

    @FXML
    private SVGPath StatusVdt1;

    @FXML
    private Group Vni;

    @FXML
    private SVGPath StatusVni;

    @FXML
    private Circle StatusGdt1;

    @FXML
    private Group Vsr;

    @FXML
    private SVGPath StatusVsr;

    @FXML
    private Group Gsr;

    @FXML
    private Circle StatusGsr;

    @FXML
    private Group Gs1;

    @FXML
    private Circle StatusGs1;

    @FXML
    private Label PressureGdt;

    @FXML
    private Label PressureG3;

    @FXML
    private Group Gni;

    @FXML
    private Circle StatusGni;

    @FXML
    private Group TP2;

    @FXML
    private Rectangle StatusTP2;

    @FXML
    private Group Vls;

    @FXML
    private SVGPath StatusVls;

    @FXML
    private Group Gls;

    @FXML
    private Circle StatusGls;

    @FXML
    private Group G4;

    @FXML
    private Circle StatusG4;

    @FXML
    private Label PressureG4;

    @FXML
    private Group Glp;

    @FXML
    private Circle StatusGlp;

    @FXML
    private Group Gbs;

    @FXML
    private Circle StatusGbs;

    @FXML
    private Group Gwi;

    @FXML
    private Circle StatusGwi;

    @FXML
    private Group G5;

    @FXML
    private Circle StatusG5;

    @FXML
    private Label PressureGls1;

    @FXML
    private Group Gpr;

    @FXML
    private Circle StatusGpr;

    @FXML
    private Group Vpr;

    @FXML
    private SVGPath StatusVpr;

    @FXML
    private Group Vib;

    @FXML
    private SVGPath StatusVib;

    @FXML
    private Group Gib;

    @FXML
    private Circle StatusGib;

    @FXML
    private Label PressureGpr;

    @FXML
    private Label PressureGib;

    @FXML
    private Label PressureG5;

    @FXML
    private Group Vmc;

    @FXML
    private SVGPath StatusVmc;

    @FXML
    private Group Gmc;

    @FXML
    private Circle StatusGmc;

    @FXML
    private Group Vs2;

    @FXML
    private SVGPath StatusVs2;

    @FXML
    private Group Gs2;

    @FXML
    private Circle StatusGs2;

    @FXML
    private Group Vb;

    @FXML
    private SVGPath StatusVb;

    @FXML
    private Label PressureGmc;

    @FXML
    private Label PressureGs2;

    String style = "";

    @FXML
    void NI_Clicked(MouseEvent event) {
       System.out.println("Switch to TowerNI View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.towerNI == null) {
          main.towerNI = new ViewTowerStation("TOWERSTATION", "TOWERNI");
          main.addViewFactory("TOWERNI", () -> { return main.towerNI;});
          new Thread(main.towerNI).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("TOWERNI");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void NI_Pressed(MouseEvent event) {
       style = NI.getStyle();
       NI.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void NI_Released(MouseEvent event) {
       NI.setStyle(style);
    }

    @FXML
    void WI_Clicked(MouseEvent event) {
       System.out.println("Switch to TowerWI View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.towerWI == null) {
          main.towerWI = new ViewTowerStation("TOWERSTATION", "TOWERWI");
          main.addViewFactory("TOWERWI", () -> { return main.towerWI;});
          new Thread(main.towerWI).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("TOWERWI");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void WI_Pressed(MouseEvent event) {
       style = WI.getStyle();
       WI.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void WI_Released(MouseEvent event) {
       WI.setStyle(style);
    }

    @FXML
    void BS_Clicked(MouseEvent event) {
       System.out.println("Switch to TowerBS View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.towerBS == null) {
          main.towerBS = new ViewTowerStation("TOWERSTATION", "TOWERBS");
          main.addViewFactory("TOWERBS", () -> { return main.towerBS;});
          new Thread(main.towerBS).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("TOWERBS");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void BS_Pressed(MouseEvent event) {
       style = BS.getStyle();
       BS.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void BS_Released(MouseEvent event) {
       BS.setStyle(style);
    }

    @FXML
    void PR_Clicked(MouseEvent event) {
       System.out.println("Switch to TowerPR View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.towerPR == null) {
          main.towerPR = new ViewTowerStation("TOWERSTATION", "TOWERPR");
          main.addViewFactory("TOWERPR", () -> { return main.towerPR;});
          new Thread(main.towerPR).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("TOWERPR");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void PR_Pressed(MouseEvent event) {
       style = PR.getStyle();
       PR.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PR_Released(MouseEvent event) {
       PR.setStyle(style);
    }

    @FXML
    void SR_Clicked(MouseEvent event) {
       System.out.println("Switch to TowerSR View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.towerSR == null) {
          main.towerSR = new ViewTowerStation("TOWERSTATION", "TOWERSR");
          main.addViewFactory("TOWERSR", () -> { return main.towerSR;});
          new Thread(main.towerSR).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("TOWERSR");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void SR_Pressed(MouseEvent event) {
       style = SR.getStyle();
       SR.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void SR_Released(MouseEvent event) {
       SR.setStyle(style);
    }

    @FXML
    void IB_Clicked(MouseEvent event) {
       System.out.println("Switch to TowerIB View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.towerIB == null) {
          main.towerIB = new ViewTowerBenchStation("TOWERBENCHSTATION", "TOWERIB");
          main.addViewFactory("TOWERIB", () -> { return main.towerIB;});
          new Thread(main.towerIB).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("TOWERIB");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void IB_Pressed(MouseEvent event) {
       style = IB.getStyle();
       IB.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void IB_Released(MouseEvent event) {
       IB.setStyle(style);
    }

    @FXML
    void DET_Clicked(MouseEvent event) {
       System.out.println("Switch to TowerDET View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.towerDET == null) {
          main.towerDET = new ViewTowerBenchStation("TOWERBENCHSTATION", "TOWERDET");
          main.addViewFactory("TOWERDET", () -> { return main.towerDET;});
          new Thread(main.towerDET).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("TOWERDET");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void DET_Pressed(MouseEvent event) {
       style = DET.getStyle();
       DET.setStyle(DECORATION_STYLE_PUSHED);
    } 

    @FXML
    void DET_Released(MouseEvent event) {
       DET.setStyle(style);
    }

    @FXML
    void LS_Clicked(MouseEvent event) {
      System.out.println("Switch to LinkSR View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.linkSR == null) {
          main.linkSR = new ViewLinkStation("LINK", "LINKSR");
          main.addViewFactory("LINKSR", () -> { return main.linkSR;});
          new Thread(main.linkSR).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("LINKSR");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void LS_Pressed(MouseEvent event) {
       style = LS.getStyle();
       LS.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void LS_Released(MouseEvent event) {
       LS.setStyle(style);
    }

    @FXML
    void LP_Clicked(MouseEvent event) {
       System.out.println("Switch to LinkPR View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.linkPR == null) {
          main.linkPR = new ViewLinkStation("LINK", "LINKPR");
          main.addViewFactory("LINKPR", () -> { return main.linkPR;});
          new Thread(main.linkPR).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("LINKPR");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void LP_Pressed(MouseEvent event) {
       style = LP.getStyle();
       LP.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void LP_Released(MouseEvent event) {
       LP.setStyle(style);
    }

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
    void G3_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "G3");
    }

    @FXML
    void G3_Pressed(MouseEvent event) {
       style = StatusG3.getStyle();
       StatusG3.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void G3_Released(MouseEvent event) {
       StatusG3.setStyle(style);
    }

    @FXML
    void G4_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "G4");
    }

    @FXML
    void G4_Pressed(MouseEvent event) {
       style = StatusG4.getStyle();
       StatusG4.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void G4_Released(MouseEvent event) {
       StatusG4.setStyle(style);
    }

    @FXML
    void G5_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "G5");
    }

    @FXML
    void G5_Pressed(MouseEvent event) {
       style = StatusG5.getStyle();
       StatusG5.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void G5_Released(MouseEvent event) {
       StatusG5.setStyle(style);
    }

    @FXML
    void Gbs_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "Gbs");
    }

    @FXML
    void Gbs_Pressed(MouseEvent event) {
       style = StatusGbs.getStyle();
       StatusGbs.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Gbs_Released(MouseEvent event) {
       StatusGbs.setStyle(style);
    }

    @FXML
    void Gdt_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "Gdt");
    }

    @FXML
    void Gdt_Pressed(MouseEvent event) {
       style = StatusGdt.getStyle();
       StatusGdt.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Gdt_Released(MouseEvent event) {
       StatusGdt.setStyle(style);
    }

    @FXML
    void Gib_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "Gib");
    }

    @FXML
    void Gib_Pressed(MouseEvent event) {
       style = StatusGib.getStyle();
       StatusGib.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Gib_Released(MouseEvent event) {
       StatusGib.setStyle(style);
    }

    @FXML
    void Glp_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "Glp");
    }

    @FXML
    void Glp_Pressed(MouseEvent event) {
       style = StatusGlp.getStyle();
       StatusGlp.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Glp_Released(MouseEvent event) {
       StatusGlp.setStyle(style);
    }

    @FXML
    void Gpr_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "Gpr");
    }

    @FXML
    void Gpr_Pressed(MouseEvent event) {
       style = StatusGpr.getStyle();
       StatusGpr.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Gpr_Released(MouseEvent event) {
       StatusGpr.setStyle(style);
    }

    @FXML
    void Gls_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "Gls");
    }

    @FXML
    void Gls_Pressed(MouseEvent event) {
       style = StatusGls.getStyle();
       StatusGls.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Gls_Released(MouseEvent event) {
       StatusGls.setStyle(style);
    }

    @FXML
    void Gmc_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "Gmc");
    }

    @FXML
    void Gmc_Pressed(MouseEvent event) {
       style = StatusGmc.getStyle();
       StatusGmc.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Gmc_Released(MouseEvent event) {
       StatusGmc.setStyle(style);
    }

    @FXML
    void Gni_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "Gni");
    }

    @FXML
    void Gni_Pressed(MouseEvent event) {
       style = StatusGni.getStyle();
       StatusGni.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Gni_Released(MouseEvent event) {
       StatusGni.setStyle(style);
    }

    @FXML
    void Gs1_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "Gs1");
    }

    @FXML
    void Gs1_Pressed(MouseEvent event) {
       style = StatusGs1.getStyle();
       StatusGs1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Gs1_Released(MouseEvent event) {
       StatusGs1.setStyle(style);
    }

    @FXML
    void Gs2_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "Gs2");
    }

    @FXML
    void Gs2_Pressed(MouseEvent event) {
       style = StatusGs2.getStyle();
       StatusGs2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Gs2_Released(MouseEvent event) {
       StatusGs2.setStyle(style);
    }

    @FXML
    void Gsr_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "Gsr");
    }

    @FXML
    void Gsr_Pressed(MouseEvent event) {
       style = StatusGsr.getStyle();
       StatusGsr.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Gsr_Released(MouseEvent event) {
       StatusGsr.setStyle(style);
    }

    @FXML
    void Gwi_Clicked(MouseEvent event) {
       CreateAndShowGaugeLayer("MAXIGAUGE", "Gwi");
    }

    @FXML
    void Gwi_Pressed(MouseEvent event) {
       style = StatusGwi.getStyle();
       StatusGwi.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Gwi_Released(MouseEvent event) {
       StatusGwi.setStyle(style);
    }

    @FXML
    void P1_Clicked(MouseEvent event) {
       CreateAndShowDryLayer("PR1");
    }

    @FXML
    void P1_Pressed(MouseEvent event) {
       style = StatusP1.getStyle();
       StatusP1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void P1_Released(MouseEvent event) {
       StatusP1.setStyle(style);
    }

    @FXML
    void P2_Clicked(MouseEvent event) {
       CreateAndShowDryLayer("PR2");
    }

    @FXML
    void P2_Pressed(MouseEvent event) {
       style = StatusP2.getStyle();
       StatusP2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void P2_Released(MouseEvent event) {
       StatusP2.setStyle(style);
    }

    @FXML
    void PressureG3_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotG3");
    }

    @FXML
    void PressureG3_Pressed(MouseEvent event) {
       style = PressureG3.getStyle();
       PressureG3.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureG3_Released(MouseEvent event) {
       PressureG3.setStyle(style);
    }

    @FXML
    void PressureG4_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotG4");
    }

    @FXML
    void PressureG4_Pressed(MouseEvent event) {
       style = PressureG4.getStyle();
       PressureG4.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureG4_Released(MouseEvent event) {
       PressureG4.setStyle(style);
    }

    @FXML
    void PressureGbs_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotGbs");
    }

    @FXML
    void PressureGbs_Pressed(MouseEvent event) {
     style = PressureGbs.getStyle();
       PressureGbs.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureGbs_Released(MouseEvent event) {
       PressureGbs.setStyle(style);
    }

    @FXML
    void PressureGdt_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotGdt");
    }

    @FXML
    void PressureGdt_Pressed(MouseEvent event) {
       style = PressureGdt.getStyle();
       PressureGdt.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureGdt_Released(MouseEvent event) {
       PressureGdt.setStyle(style);
    }

    @FXML
    void PressureGib_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotGib");
    }

    @FXML
    void PressureGib_Pressed(MouseEvent event) {
       style = PressureGib.getStyle();
       PressureGib.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureGib_Released(MouseEvent event) {
       PressureGib.setStyle(style);
    }

    @FXML
    void PressureGlp_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotGlp");
    }

    @FXML
    void PressureGlp_Pressed(MouseEvent event) {
       style = PressureGlp.getStyle();
       PressureGlp.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureGlp_Released(MouseEvent event) {
       PressureGlp.setStyle(style);
    }

    @FXML
    void PressureGls_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotGls");
    }

    @FXML
    void PressureGls_Pressed(MouseEvent event) {
       style = PressureGls.getStyle();
       PressureGls.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureGls_Released(MouseEvent event) {
       PressureGls.setStyle(style);
    }

    @FXML
    void PressureGmc_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotGmc");
    }

    @FXML
    void PressureGmc_Pressed(MouseEvent event) {
       style = PressureGmc.getStyle();
       PressureGmc.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureGmc_Released(MouseEvent event) {
       PressureGmc.setStyle(style);
    }

    @FXML
    void PressureGni_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotGni");
    }

    @FXML
    void PressureGni_Pressed(MouseEvent event) {
       style = PressureGni.getStyle();
       PressureGni.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureGni_Released(MouseEvent event) {
       PressureGni.setStyle(style);
    }

    @FXML
    void PressureGpr_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotGpr");
    }

    @FXML
    void PressureGpr_Pressed(MouseEvent event) {
       style = PressureGpr.getStyle();
       PressureGpr.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureGpr_Released(MouseEvent event) {
       PressureGpr.setStyle(style);
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
    void PressureGsr_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotGsr");
    }

    @FXML
    void PressureGsr_Pressed(MouseEvent event) {
       style = PressureGsr.getStyle();
       PressureGsr.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureGsr_Released(MouseEvent event) {
       PressureGsr.setStyle(style);
    }

    @FXML
    void PressureGwi_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotGwi");
    }

    @FXML
    void PressureGwi_Pressed(MouseEvent event) {
       style = PressureGwi.getStyle();
       PressureGwi.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureGwi_Released(MouseEvent event) {
       PressureGwi.setStyle(style);
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
    void PressureG5_Clicked(MouseEvent event) {
       CreateAndShowPlotLayer("PlotG5");
    }

    @FXML
    void PressureG5_Pressed(MouseEvent event) {
       style = PressureG5.getStyle();
       PressureG5.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void PressureG5_Released(MouseEvent event) {
       PressureG5.setStyle(style);
    }

    @FXML
    void TP1_Clicked(MouseEvent event) {
       CreateAndShowTurboLayer("TURBOT", "TP1");
    }

    @FXML
    void TP1_Pressed(MouseEvent event) {
       style = StatusTP1.getStyle();
       StatusTP1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void TP1_Released(MouseEvent event) {
       StatusTP1.setStyle(style);
    }

    @FXML
    void TP2_Clicked(MouseEvent event) {
       CreateAndShowTurboLayer("TURBOT", "TP2");
    }

    @FXML
    void TP2_Pressed(MouseEvent event) {
       style = StatusTP2.getStyle();
       StatusTP2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void TP2_Released(MouseEvent event) {
       StatusTP2.setStyle(style);
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
    void V2_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("V2");
    }

    @FXML
    void V2_Pressed(MouseEvent event) {
       style = StatusV2.getStyle();
       StatusV2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void V2_Released(MouseEvent event) {
       StatusV2.setStyle(style);
    }

    @FXML
    void Vb_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("Vb");
    }

    @FXML
    void Vb_Pressed(MouseEvent event) {
       style = StatusVb.getStyle();
       StatusVb.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Vb_released(MouseEvent event) {
       StatusVb.setStyle(style);
    }

    @FXML
    void Vbs_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("Vbs");
    }

    @FXML
    void Vbs_Pressed(MouseEvent event) {
       style = StatusVbs.getStyle();
       StatusVbs.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Vbs_Released(MouseEvent event) {
       StatusVbs.setStyle(style);
    }

    @FXML
    void Vdt_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("Vdt");
    }

    @FXML
    void Vdt_Pressed(MouseEvent event) {
       style = StatusVdt.getStyle();
       StatusVdt.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Vdt_Released(MouseEvent event) {
       StatusVdt.setStyle(style);
    }

    @FXML
    void Vib_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("Vib");
    }

    @FXML
    void Vib_Pressed(MouseEvent event) {
       style = StatusVib.getStyle();
       StatusVib.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Vib_released(MouseEvent event) {
       StatusVib.setStyle(style);
    }

    @FXML
    void Vlp_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("Vlp");
    }

    @FXML
    void Vlp_Pressed(MouseEvent event) {
       style = StatusVlp.getStyle();
       StatusVlp.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Vlp_released(MouseEvent event) {
       StatusVlp.setStyle(style);
    }

    @FXML
    void Vls_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("Vls");
    }

    @FXML
    void Vls_Pressed(MouseEvent event) {
       style = StatusVls.getStyle();
       StatusVls.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Vls_Released(MouseEvent event) {
       StatusVls.setStyle(style);
    }

    @FXML
    void Vmc_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("Vmc");
    }

    @FXML
    void Vmc_Pressed(MouseEvent event) {
       style = StatusVmc.getStyle();
       StatusVmc.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Vmc_released(MouseEvent event) {
       StatusVmc.setStyle(style);
    }

    @FXML
    void Vni_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("Vni");
    }

    @FXML
    void Vni_Pressed(MouseEvent event) {
       style = StatusVni.getStyle();
       StatusVni.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Vni_Released(MouseEvent event) {
       StatusVni.setStyle(style);
    }

    @FXML
    void Vpr_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("Vpr");
    }

    @FXML
    void Vpr_Pressed(MouseEvent event) {
       style = StatusVpr.getStyle();
       StatusVpr.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Vpr_released(MouseEvent event) {
       StatusVpr.setStyle(style);
    }

    @FXML
    void Vs1_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("Vs1");
    }

    @FXML
    void Vs1_Pressed(MouseEvent event) {
       style = StatusVs1.getStyle();
       StatusVs1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Vs1_Released(MouseEvent event) {
       StatusVs1.setStyle(style);
    }

    @FXML
    void Vs2_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("Vs2");
    }

    @FXML
    void Vs2_Pressed(MouseEvent event) {
       style = StatusVs2.getStyle();
       StatusVs2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Vs2_released(MouseEvent event) {
       StatusVs2.setStyle(style);
    }

    @FXML
    void Vs3_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("Vs3");
    }

    @FXML
    void Vs3_Pressed(MouseEvent event) {
       style = StatusVs3.getStyle();
       StatusVs3.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Vs3_Released(MouseEvent event) {
       StatusVs3.setStyle(style);
    }

    @FXML
    void Vsr_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("Vsr");
    }

    @FXML
    void Vsr_Pressed(MouseEvent event) {
       style = StatusVsr.getStyle();
       StatusVsr.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Vsr_Released(MouseEvent event) {
       StatusVsr.setStyle(style);
    }

    @FXML
    void Vwi_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("Vwi");
    }

    @FXML
    void Vwi_Pressed(MouseEvent event) {
       style = StatusVwi.getStyle();
       StatusVwi.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void Vwi_Released(MouseEvent event) {
       StatusVwi.setStyle(style);
    }

}

