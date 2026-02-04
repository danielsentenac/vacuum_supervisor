package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.shape.SVGPath;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle; 


public class ControllerCentralBuilding extends ControlLayer implements ControlTypes {

    @FXML
    private Rectangle TUBEN;

    @FXML
    private Rectangle TUBEW;

    @FXML
    private Rectangle Sqz;

    @FXML
    private Label CryoLinkIB;

    @FXML
    private Label TowerBS;

    @FXML
    private Label MiniTowerPR;

    @FXML
    private Group ValvePS;

    @FXML
    private SVGPath StatusValvePS;

    @FXML
    private Group VNI;

    @FXML
    private SVGPath StatusVNI;

    @FXML
    private Label TowerNI;

    @FXML
    private Label LinkPR;

    @FXML
    private Group ValveWS;

    @FXML
    private SVGPath StatusValveWS;

    @FXML
    private Group ValveNS;

    @FXML
    private SVGPath StatusValveNS;

    @FXML
    private Label TowerPR;

    @FXML
    private Label TowerWI;

    @FXML
    private Label TowerMC;

    @FXML
    private Label TowerIB;

    @FXML
    private Label MiniTowerIB;

    @FXML
    private Group ValveLI;

    @FXML
    private SVGPath StatusValveLI;

    @FXML
    private Label CryoWI;

    @FXML
    private Group VWI;

    @FXML
    private SVGPath StatusVWI;

    @FXML
    private Group ValveSS;

    @FXML
    private SVGPath StatusValveSS;

    @FXML
    private Label TowerSR;

    @FXML
    private Label CryoLinkDET;

    @FXML
    private Group VS1CryoDET;

    @FXML
    private SVGPath StatusVS1CryoDET;

    @FXML
    private Group VS2CryoDET;

    @FXML
    private SVGPath StatusVS2CryoDET;

    @FXML
    private Label TowerDET;

    @FXML
    private Label MiniTowerDET;

    @FXML
    private Label RemotePumps;

    @FXML
    private Label TubeMC;

    @FXML
    private Group VCryoWI;

    @FXML
    private SVGPath StatusVCryoWI;

    @FXML
    private Label CryoNI;

    @FXML
    private Group VCryoNI;

    @FXML
    private SVGPath StatusVCryoNI;

    @FXML
    private Label LinkNI;

    @FXML
    private Label LinkWI;

    @FXML
    private Group VS2CryoIB;

    @FXML
    private SVGPath StatusVS2CryoIB;

    @FXML
    private Group VS1CryoIB;

    @FXML
    private SVGPath StatusVS1CryoIB;

    @FXML
    private Label LinkSR;

     @FXML
    private Group VPSqzDET1;

    @FXML
    private SVGPath StatusVPSqzDET1;

    @FXML
    private Label MiniTowerSqzDET1;

    @FXML
    private Label MiniTowerSqzDET2;

    @FXML
    private Group VPSqzDET2;

    @FXML
    private SVGPath StatusVPSqzDET2;

    @FXML
    private Group WIVENT1;

    @FXML
    private SVGPath StatusWIVENT1;

     @FXML
    private Group WIVENT2;

    @FXML
    private SVGPath StatusWIVENT2;

    @FXML
    private Group NIVENT1;

    @FXML
    private SVGPath StatusNIVENT1;

     @FXML
    private Group NIVENT2;

    @FXML
    private SVGPath StatusNIVENT2;

    @FXML
    private Group VMC;

    @FXML
    private SVGPath StatusVMC;

    @FXML
    private Label StationMC;
   

    private String style = "";

    @FXML
    void CryoNI_Clicked(MouseEvent event) {
       System.out.println("Switch to CryoNI View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.cryoNI == null) {
          main.cryoNI = new ViewCryoStation("CRYOSTATION", "CRYONI");
          main.addViewFactory("CRYONI", () -> { return main.cryoNI;});
          new Thread(main.cryoNI).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("CRYONI");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void CryoNI_Pressed(MouseEvent event) {
       style = CryoNI.getStyle();
       CryoNI.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void CryoNI_Released(MouseEvent event) {
       CryoNI.setStyle(style);
    }

    @FXML
    void CryoWI_Clicked(MouseEvent event) {
       System.out.println("Switch to CryoWI View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.cryoWI == null) {
          main.cryoWI = new ViewCryoStation("CRYOSTATION", "CRYOWI");
          main.addViewFactory("CRYOWI", () -> { return main.cryoWI;});
          new Thread(main.cryoWI).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("CRYOWI");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void CryoWI_Pressed(MouseEvent event) {
       style = CryoWI.getStyle();
       CryoWI.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void CryoWI_Released(MouseEvent event) {
       CryoWI.setStyle(style);
    }

    @FXML
    void LinkNI_Clicked(MouseEvent event) {

    }

    @FXML
    void LinkNI_Pressed(MouseEvent event) {
       style = LinkNI.getStyle();
       LinkNI.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void LinkNI_Released(MouseEvent event) {
       LinkNI.setStyle(style);
    }

    @FXML
    void LinkWI_Clicked(MouseEvent event) {

    }

    @FXML
    void LinkWI_Pressed(MouseEvent event) {
       style = LinkWI.getStyle();
       LinkWI.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void LinkWI_Released(MouseEvent event) {
       LinkWI.setStyle(style);
    }

    @FXML
    void LinkPR_Clicked(MouseEvent event) {
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
    void LinkPR_Pressed(MouseEvent event) {
       style = LinkPR.getStyle();
       LinkPR.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void LinkPR_Released(MouseEvent event) {
       LinkPR.setStyle(style);
    }

    @FXML
    void LinkSR_Clicked(MouseEvent event) {
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
    void LinkSR_Pressed(MouseEvent event) {
       style = LinkSR.getStyle();
       LinkSR.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void LinkSR_Released(MouseEvent event) {
       LinkSR.setStyle(style);
    }

    @FXML
    void MiniTowerDET_Clicked(MouseEvent event) {

    }

    @FXML
    void MiniTowerDET_Pressed(MouseEvent event) {
       style = MiniTowerDET.getStyle();
       MiniTowerDET.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void MiniTowerDET_Released(MouseEvent event) {
       MiniTowerDET.setStyle(style);
    }

    @FXML
    void MiniTowerIB_Clicked(MouseEvent event) {

    }

    @FXML
    void MiniTowerIB_Pressed(MouseEvent event) {
       style = MiniTowerIB.getStyle();
       MiniTowerIB.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void MiniTowerIB_Released(MouseEvent event) {
       MiniTowerIB.setStyle(style);
    }

    @FXML
    void MiniTowerPR_Clicked(MouseEvent event) {

    }

    @FXML
    void MiniTowerPR_Pressed(MouseEvent event) {
       style = MiniTowerPR.getStyle();
       MiniTowerPR.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void MiniTowerPR_Released(MouseEvent event) {
       MiniTowerPR.setStyle(style);
    }

    @FXML
    void RemotePumps_Clicked(MouseEvent event) {
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
    void RemotePumps_Pressed(MouseEvent event) {
       style = RemotePumps.getStyle();
       RemotePumps.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void RemotePumps_Released(MouseEvent event) {
       RemotePumps.setStyle(style);
    }

    @FXML
    void CryoLinkDET_Clicked(MouseEvent event) {
       System.out.println("Switch to CryolinkDET View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.cryolinkDET == null) {
          main.cryolinkDET = new ViewCryoLinkStation("CRYOLINKSTATION", "CRYOLINKDET");
          main.addViewFactory("CRYOLINKDET", () -> { return main.cryolinkDET;});
          new Thread(main.cryolinkDET).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("CRYOLINKDET");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void CryoLinkDET_Pressed(MouseEvent event) {
       style = CryoLinkDET.getStyle();
       CryoLinkDET.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void CryoLinkDET_Released(MouseEvent event) {
       CryoLinkDET.setStyle(style);
    }

    @FXML
    void CryoLinkIB_Clicked(MouseEvent event) {
       System.out.println("Switch to CryolinkIB View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.cryolinkIB == null) {
          main.cryolinkIB = new ViewCryoLinkStation("CRYOLINKSTATION", "CRYOLINKIB");
          main.addViewFactory("CRYOLINKIB", () -> { return main.cryolinkIB;});
          new Thread(main.cryolinkIB).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("CRYOLINKIB");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void CryoLinkIB_Pressed(MouseEvent event) {
       style = CryoLinkIB.getStyle();
       CryoLinkIB.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void CryoLinkIB_Released(MouseEvent event) {
       CryoLinkIB.setStyle(style);
    }

    @FXML
    void TowerBS_Clicked(MouseEvent event) {
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
    void TowerBS_Pressed(MouseEvent event) {
       style = TowerBS.getStyle();
       TowerBS.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void TowerBS_Released(MouseEvent event) {
       TowerBS.setStyle(style);
    }

    @FXML
    void TowerDET_Clicked(MouseEvent event) {
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
    void TowerDET_Pressed(MouseEvent event) {
       style = TowerDET.getStyle();
       TowerDET.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void TowerDET_Released(MouseEvent event) {
       TowerDET.setStyle(style);
    }

    @FXML
    void TowerIB_Clicked(MouseEvent event) {
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
    void TowerIB_Pressed(MouseEvent event) {
       style = TowerIB.getStyle();
       TowerIB.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void TowerIB_Released(MouseEvent event) {
       TowerIB.setStyle(style);
    }

    @FXML
    void TowerNI_Clicked(MouseEvent event) {
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
    void TowerMC_Clicked(MouseEvent event) {
       System.out.println("Switch to TowerMC View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.towerMC == null) {
          main.towerMC = new ViewTowerBenchStation("TOWERBENCHSTATION", "TOWERMC");
          main.addViewFactory("TOWERMC", () -> { return main.towerMC;});
          new Thread(main.towerMC).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("TOWERMC");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void TowerMC_Pressed(MouseEvent event) {
       style = TowerMC.getStyle();
       TowerMC.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void TowerMC_Released(MouseEvent event) {
       TowerMC.setStyle(style);
    }

    @FXML
    void TowerNI_Pressed(MouseEvent event) {
       style = TowerNI.getStyle();
       TowerNI.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void TowerNI_Released(MouseEvent event) {
       TowerNI.setStyle(style);
    }

    @FXML
    void TowerPR_Clicked(MouseEvent event) {
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
    void TowerPR_Pressed(MouseEvent event) {
       style = TowerPR.getStyle();
       TowerPR.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void TowerPR_Released(MouseEvent event) {
       TowerPR.setStyle(style);
    }

    @FXML
    void TowerSR_Clicked(MouseEvent event) {
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
    void TowerSR_Pressed(MouseEvent event) {
       style = TowerSR.getStyle();
       TowerSR.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void TowerSR_Released(MouseEvent event) {
       TowerSR.setStyle(style);
    }

    @FXML
    void TowerWI_Clicked(MouseEvent event) {
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
    void TowerWI_Pressed(MouseEvent event) {
       style = TowerWI.getStyle();
       TowerWI.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void TowerWI_Released(MouseEvent event) {
       TowerWI.setStyle(style);
    }

    @FXML
    void TubeMC_Clicked(MouseEvent event) {

    }

    @FXML
    void TubeMC_Pressed(MouseEvent event) {
       //style = TubeMC.getStyle();
       //TubeMC.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void TubeMC_Released(MouseEvent event) {
       //TubeMC.setStyle(style);
    }

    @FXML
    void TUBEN_Clicked(MouseEvent event) {
       System.out.println("Switch to TUBEN View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.tubeN == null) {
          main.tubeN = new ViewTube("TUBEN", "TUBEN");
          main.addViewFactory("TUBEN", () -> { return main.tubeN;});
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
       System.out.println("Switch to TUBEW View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.tubeW == null) {
          main.tubeW = new ViewTube("TUBEW", "TUBEW");
          main.addViewFactory("TUBEW", () -> { return main.tubeW;});
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
       System.out.println("Switch to SQZ View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.sqz == null) {
          main.sqz = new ViewSqz("SQZ", "SQZ");
          main.addViewFactory("SQZ", () -> { return main.sqz;});
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
    void MiniTowerSqzDET1_Clicked(MouseEvent event) {
       System.out.println("Switch to SQZDET1 View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.minitowersqzdet1 == null) {
          main.minitowersqzdet1 = new ViewMiniTowerSqzStation("MINITOWERSQZ", "SQZDET1");
          main.addViewFactory("SQZDET1", () -> { return main.minitowersqzdet1;});
          new Thread(main.minitowersqzdet1).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("SQZDET1");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void MiniTowerSqzDET1_Pressed(MouseEvent event) {
       style = MiniTowerSqzDET1.getStyle();
       MiniTowerSqzDET1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void MiniTowerSqzDET1_Released(MouseEvent event) {
       MiniTowerSqzDET1.setStyle(style);
    }

    @FXML
    void MiniTowerSqzDET2_Clicked(MouseEvent event) {
       System.out.println("Switch to SQZDET2 View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.minitowersqzdet2 == null) {
          main.minitowersqzdet2 = new ViewMiniTowerSqzStation("MINITOWERSQZ", "SQZDET2");
          main.addViewFactory("SQZDET2", () -> { return main.minitowersqzdet2;});
          new Thread(main.minitowersqzdet2).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("SQZDET2");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void MiniTowerSqzDET2_Pressed(MouseEvent event) {
       style = MiniTowerSqzDET2.getStyle();
       MiniTowerSqzDET2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void MiniTowerSqzDET2_Released(MouseEvent event) {
       MiniTowerSqzDET2.setStyle(style);
    }

    @FXML
    void StationMC_Clicked(MouseEvent event) {
       System.out.println("Switch to TUBEMC View");
       Main main = (Main) MobileApplication.getInstance();
       if (main.tubeMC == null) {
          main.tubeMC = new ViewTubeMCStation("TUBEMC", "TUBEMC");
          main.addViewFactory("TUBEMC", () -> { return main.tubeMC;});
          new Thread(main.tubeMC).start(); 
       }
       ViewData previousView = (ViewData) main.getView();
       main.switchView("TUBEMC");
       ViewData presentView = (ViewData) main.getView();
    }

    @FXML
    void StationMC_Pressed(MouseEvent event) {
       style = StationMC.getStyle();
       StationMC.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void StationMC_Released(MouseEvent event) {
       StationMC.setStyle(style);
    }

    @FXML
    void VPSqzDET1_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("SQZDET1_VP");
    }

    @FXML
    void VPSqzDET1_Pressed(MouseEvent event) {
       style = VPSqzDET1.getStyle();
       VPSqzDET1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void VPSqzDET1_Released(MouseEvent event) {
       VPSqzDET1.setStyle(style);
    }

    @FXML
    void VPSqzDET2_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("SQZDET2_VP");
    }

    @FXML
    void VPSqzDET2_Pressed(MouseEvent event) {
       style = VPSqzDET2.getStyle();
       VPSqzDET2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void VPSqzDET2_Released(MouseEvent event) {
       VPSqzDET2.setStyle(style);
    }

    @FXML
    void VCryoNI_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("CRYONI_VCRYO");
    }

    @FXML
    void VCryoNI_Pressed(MouseEvent event) {
       style = VCryoNI.getStyle();
       VCryoNI.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void VCryoNI_Released(MouseEvent event) {
       VCryoNI.setStyle(style);
    }

    @FXML
    void VCryoWI_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("CRYOWI_VCRYO");
    }

    @FXML
    void VCryoWI_Pressed(MouseEvent event) {
       style = VCryoWI.getStyle();
       VCryoWI.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void VCryoWI_Released(MouseEvent event) {
       VCryoWI.setStyle(style);
    }

    @FXML
    void VNI_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("VALVEBIGNI");
    }

    @FXML
    void VNI_Pressed(MouseEvent event) {
       style = VNI.getStyle();
       VNI.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void VNI_Released(MouseEvent event) {
       VNI.setStyle(style);
    }

    @FXML
    void VS1CryoDET_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("CRYOLINKDET_Vs1");
    }

    @FXML
    void VS1CryoDET_Pressed(MouseEvent event) {
       style = VS1CryoDET.getStyle();
       VS1CryoDET.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void VS1CryoDET_Released(MouseEvent event) {
       VS1CryoDET.setStyle(style);
    }

    @FXML
    void WIVENT1_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("VENTINGVALVEWI_1");
    }

    @FXML
    void WIVENT1_Pressed(MouseEvent event) {
       style = WIVENT1.getStyle();
       WIVENT1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void WIVENT1_Released(MouseEvent event) {
       WIVENT1.setStyle(style);
    }

    @FXML
    void WIVENT2_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("VENTINGVALVEWI_2");
    }

    @FXML
    void WIVENT2_Pressed(MouseEvent event) {
       style = WIVENT2.getStyle();
       WIVENT2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void WIVENT2_Released(MouseEvent event) {
       WIVENT2.setStyle(style);
    }

    @FXML
    void NIVENT1_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("VENTINGVALVENI_1");
    }

    @FXML
    void NIVENT1_Pressed(MouseEvent event) {
       style = NIVENT1.getStyle();
       NIVENT1.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void NIVENT1_Released(MouseEvent event) {
       NIVENT1.setStyle(style);
    }

    @FXML
    void NIVENT2_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("VENTINGVALVENI_2");
    }

    @FXML
    void NIVENT2_Pressed(MouseEvent event) {
       style = NIVENT2.getStyle();
       NIVENT2.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void NIVENT2_Released(MouseEvent event) {
       NIVENT2.setStyle(style);
    }

    @FXML
    void VS1CryoIB_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("CRYOLINKIB_Vs1");
    }

    @FXML
    void VS1CryoIB_Pressed(MouseEvent event) {
       style = VS1CryoIB.getStyle();
       VS1CryoIB.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void VS1CryoIB_Released(MouseEvent event) {
       VS1CryoIB.setStyle(style);
    }

    @FXML
    void VS2CryoDET_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("CRYOLINKDET_Vs2");
    }

    @FXML
    void VS2CryoDET_Pressed(MouseEvent event) {
       style = VS2CryoDET.getStyle();
       VS2CryoDET.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void VS2CryoDET_Released(MouseEvent event) {
       VS2CryoDET.setStyle(style);
    }

    @FXML
    void VS2CryoIB_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("CRYOLINKIB_Vs2");
    }

    @FXML
    void VS2CryoIB_Pressed(MouseEvent event) {
       style = VS2CryoIB.getStyle();
       VS2CryoIB.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void VS2CryoIB_Released(MouseEvent event) {
       VS2CryoIB.setStyle(style);
    }

    @FXML
    void VWI_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("VALVEBIGWI");
    }

    @FXML
    void VWI_Pressed(MouseEvent event) {
       style = VWI.getStyle();
       VWI.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void VWI_Released(MouseEvent event) {
       VWI.setStyle(style);
    }

    @FXML
    void ValveLI_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("VALVECENTRAL_VLI");
    }

    @FXML
    void ValveLI_Pressed(MouseEvent event) {
       style = ValveLI.getStyle();
       ValveLI.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void ValveLI_Released(MouseEvent event) {
       ValveLI.setStyle(style);
    }

    @FXML
    void ValveNS_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("VALVECENTRAL_VNS");
    }

    @FXML
    void ValveNS_Pressed(MouseEvent event) {
       style = ValveNS.getStyle();
       ValveNS.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void ValveNS_Released(MouseEvent event) {
       ValveNS.setStyle(style);
    }

    @FXML
    void ValvePS_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("VALVECENTRAL_VPS");
    }

    @FXML
    void ValvePS_Pressed(MouseEvent event) {
       style = ValvePS.getStyle();
       ValvePS.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void ValvePS_Released(MouseEvent event) {
       ValvePS.setStyle(style);
    }

    @FXML
    void ValveSS_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("VALVECENTRAL_VSS");
    }

    @FXML
    void ValveSS_Pressed(MouseEvent event) {
       style = ValveSS.getStyle();
       ValveSS.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void ValveSS_Released(MouseEvent event) {
       ValveSS.setStyle(style);
    }

    @FXML
    void ValveWS_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("VALVECENTRAL_VWS");
    }

    @FXML
    void ValveWS_Pressed(MouseEvent event) {
       style = ValveWS.getStyle();
       ValveWS.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void ValveWS_Released(MouseEvent event) {
       ValveWS.setStyle(style);
    }

    @FXML
    void VMC_Clicked(MouseEvent event) {
       CreateAndShowValveLayer("TUBEMC_V21");
    }

    @FXML
    void VMC_Pressed(MouseEvent event) {
       style = VMC.getStyle();
       VMC.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void VMC_Released(MouseEvent event) {
       VMC.setStyle(style);
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

}

