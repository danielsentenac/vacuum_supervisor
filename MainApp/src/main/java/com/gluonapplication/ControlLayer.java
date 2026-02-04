package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import javafx.scene.control.Label;


public class ControlLayer {

void CreateAndShowGaugeLayer(String fxml, String name) {
       ViewData presentView = (ViewData) MobileApplication.getInstance().getView();
       if ( !MobileApplication.getInstance().isLayerPresent(presentView.name + ":" + name) ) {
          LayerData gauge = new LayerGauge(fxml, presentView.name+ ":" + name);
          Label gaugeName = (Label) gauge.lookup("#GaugeName");
          gaugeName.setText(name);
          try { 
             new Thread(gauge).start(); 
          }
          catch (Exception e) {
             e.printStackTrace();
          }
          MobileApplication.getInstance().addLayerFactory(presentView.name+ ":" + name, () -> { 
             return  gauge;
          });
       }
       MobileApplication.getInstance().showLayer(presentView.name + ":" + name);
   }

   void CreateAndShowValveLayer(String name) {
       ViewData presentView = (ViewData) MobileApplication.getInstance().getView();
       if ( !MobileApplication.getInstance().isLayerPresent(presentView.name + ":" + name) ) {
          LayerData valve = new LayerValve("VALVE", presentView.name+ ":" + name);
          Label valveName = (Label) valve.lookup("#ValveName");
          valveName.setText(name);
          try { 
             new Thread(valve).start(); 
          }
          catch (Exception e) {
             e.printStackTrace();
          }
          MobileApplication.getInstance().addLayerFactory(presentView.name+ ":" + name, () -> { return  valve;});
       }
       MobileApplication.getInstance().showLayer(presentView.name + ":" + name);
   }

   void CreateAndShowDryLayer(String name) {
       ViewData presentView = (ViewData) MobileApplication.getInstance().getView();
       if ( !MobileApplication.getInstance().isLayerPresent(presentView.name + ":" + name) ) {
          LayerData dry = new LayerDry("DRY", presentView.name+ ":" + name);
          Label dryName = (Label) dry.lookup("#DryName");
          dryName.setText(name);
          try { 
             new Thread(dry).start(); 
          }
          catch (Exception e) {
             e.printStackTrace();
          }
          MobileApplication.getInstance().addLayerFactory(presentView.name+ ":" + name, () -> { return  dry;});
       }
       MobileApplication.getInstance().showLayer(presentView.name + ":" + name);
   }

   void CreateAndShowTurboLayer(String fxml, String name) {
       ViewData presentView = (ViewData) MobileApplication.getInstance().getView();
       if ( !MobileApplication.getInstance().isLayerPresent(presentView.name + ":" + name) ) {
          LayerData turbo = new LayerTurbo(fxml, presentView.name+ ":" + name);
          Label turboName = (Label) turbo.lookup("#TurboName");
          turboName.setText(name);
          System.out.println("CreateAndShowTurboLayer TurboName = " + turboName.getText());
          try { 
             new Thread(turbo).start(); 
          }
          catch (Exception e) {
             e.printStackTrace();
          }
          MobileApplication.getInstance().addLayerFactory(presentView.name+ ":" + name, () -> { return  turbo;});
       }
       MobileApplication.getInstance().showLayer(presentView.name + ":" + name);
   }

   void CreateAndShowIonicLayer(String fxml, String name) {
       ViewData presentView = (ViewData) MobileApplication.getInstance().getView();
       if ( !MobileApplication.getInstance().isLayerPresent(presentView.name + ":" + name) ) {
          LayerData ionic = new LayerIonic(fxml, presentView.name+ ":" + name);
          Label ionicName = (Label) ionic.lookup("#IonicName");
          ionicName.setText(name);
          try { 
             new Thread(ionic).start(); 
          }
          catch (Exception e) {
             e.printStackTrace();
          }
          MobileApplication.getInstance().addLayerFactory(presentView.name+ ":" + name, () -> { return  ionic;});
       }
       MobileApplication.getInstance().showLayer(presentView.name + ":" + name);
   }

   void CreateAndShowTitaneLayer(String fxml, String name) {
       ViewData presentView = (ViewData) MobileApplication.getInstance().getView();
       if ( !MobileApplication.getInstance().isLayerPresent(presentView.name + ":" + name) ) {
          LayerData titane = new LayerTitane(fxml, presentView.name+ ":" + name);
          Label titaneName = (Label) titane.lookup("#TitaneName");
          titaneName.setText(name);
          try { 
             new Thread(titane).start(); 
          }
          catch (Exception e) {
             e.printStackTrace();
          }
          MobileApplication.getInstance().addLayerFactory(presentView.name+ ":" + name, () -> { return  titane;});
       }
       MobileApplication.getInstance().showLayer(presentView.name + ":" + name);
   }

   void CreateAndShowRGALayer(String name) {
       ViewData presentView = (ViewData) MobileApplication.getInstance().getView();
       //if ( !MobileApplication.getInstance().isLayerPresent(presentView.name + ":" + name) ) {
          MobileApplication.getInstance().removeLayerFactory(presentView.name.replace("LAL","") + ":" + name);
          LayerData rga = new LayerRGA("CHART", presentView.name.replace("LAL","") + ":" + name);
          try { 
             new Thread(rga).start(); 
          }
          catch (Exception e) {
             e.printStackTrace();
          }
          MobileApplication.getInstance().addLayerFactory(presentView.name.replace("LAL","") + ":" + name, () -> { return  rga;});
       //}
       MobileApplication.getInstance().showLayer(presentView.name.replace("LAL","") + ":" + name);
   }

   void CreateAndShowPlotLayer(String name) {
       ViewData presentView = (ViewData) MobileApplication.getInstance().getView();
       //if ( !MobileApplication.getInstance().isLayerPresent(presentView.name + ":" + name) ) {
          MobileApplication.getInstance().removeLayerFactory(presentView.name + ":" + name);
          LayerData livechart = new LayerPlot("PLOT", presentView.name + ":" + name);
          try { 
             new Thread(livechart).start(); 
          }
          catch (Exception e) {
             e.printStackTrace();
          }
          MobileApplication.getInstance().addLayerFactory(presentView.name + ":" + name, () -> { return  livechart;});
       //}
       MobileApplication.getInstance().showLayer(presentView.name + ":" + name);
   }

}
