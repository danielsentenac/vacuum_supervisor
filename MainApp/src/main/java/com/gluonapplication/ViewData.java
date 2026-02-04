package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.net.ConnectException;
import java.util.Vector;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Circle;
import java.net.URLConnection; //for url management 
import java.net.URL;
import java.io.ObjectInputStream; //for stream management
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import javafx.scene.input.ScrollEvent;
import javafx.scene.input.TouchEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ZoomEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.animation.PauseTransition;
import javafx.util.Duration;


public class ViewData extends View implements Runnable, DataTypes {

    public boolean isSuspended = true;
    public boolean isStarted = true;
    public boolean connectionError = false;
    public boolean serverError = false;
    public String fxml = "";
    public String name = ""; 
    private int initCnt = 0;
    private int max_fr = 2;
    protected static FXMLLoader mainLoader;
    public DataSet data;
    private double scaleX;
    private double scaleY;
    private Pane mainPane, backgroundPane;
    public static ClassLoader cachingClassLoader = new MyClassLoader(FXMLLoader.getDefaultClassLoader());

    public ViewData(String _fxml, String _name) {
        fxml = _fxml;
        name = _name;
        try {
           mainLoader = new FXMLLoader(getClass().getResource("/" + fxml + ".fxml"));
           mainLoader.setClassLoader(cachingClassLoader); 
           mainPane =  mainLoader.load();
           backgroundPane = new Pane();
           backgroundPane.getChildren().addAll(mainPane);
           backgroundPane.setBackground(new Background(new BackgroundFill(Color.web("#333333"),CornerRadii.EMPTY, Insets.EMPTY)));
           setCenter(backgroundPane);
           scaleX = mainPane.getScaleX(); // to revert the changes
           scaleY = mainPane.getScaleY();
           setupZoom();
           setupScroll();
           setupTouch();
           setupMouse();          
           setOnHidden(e -> {isSuspended = true;});
           setOnShowing(e -> {isSuspended = false;});
        }
        catch (IOException e) {
           e.printStackTrace();
        }
    }
    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.ARROW_BACK.button(e -> {
           ViewData previousView = (ViewData) MobileApplication.getInstance().getView();
           MobileApplication.getInstance().switchToPreviousView();
           ViewData presentView = (ViewData) MobileApplication.getInstance().getView();
           System.out.println("Switch to " + presentView.fxml + " View");
        }));
        appBar.setTitleText(name + " View");
    }
    private void setupScroll() {
        mainPane.setOnScroll(new EventHandler<ScrollEvent>() {
           @Override public void handle(ScrollEvent event) {
               if (!event.isInertia()) {
                  mainPane.setTranslateX(mainPane.getTranslateX() + event.getDeltaX());
                  mainPane.setTranslateY(mainPane.getTranslateY() + event.getDeltaY());
               }
               event.consume();
           } 
        });
    }
    private void setupTouch() {      
        mainPane.setOnTouchPressed(new EventHandler<TouchEvent>() {
           @Override public void handle(TouchEvent event) {
               if (event.getEventType() == TouchEvent.TOUCH_STATIONARY) {
                  mainPane.setScaleX(scaleX);
                  mainPane.setScaleY(scaleY);
               }
               event.consume();
           }
        });
    }
    private void setupMouse() {      
        mainPane.setOnMousePressed(new EventHandler<MouseEvent>() {
           @Override public void handle(MouseEvent event) {
               if (event.getClickCount() == 2) {
                  mainPane.setScaleX(scaleX);
                  mainPane.setScaleY(scaleY);
                  mainPane.setTranslateX(0);
                  mainPane.setTranslateY(0);
               }
               event.consume();
           }
        });
    }
    private void setupZoom() {
       mainPane.setOnZoom(new EventHandler<ZoomEvent>() {
          @Override
          public void handle(ZoomEvent event) {
              if (mainPane.getScaleX()*event.getZoomFactor() > scaleX)
                 mainPane.setScaleX(mainPane.getScaleX()*event.getZoomFactor());
              if (mainPane.getScaleY()*event.getZoomFactor() > scaleY)
                 mainPane.setScaleY(mainPane.getScaleY()*event.getZoomFactor());
              event.consume();
          }
       });
    }
    /**
       A connection method called every time a connection to the servlet is needed. 
       The servlet path points to "jchv" which contains the main servlet 
       for channel visualization.
    */
    protected URLConnection getServerConnection(String url)
            throws MalformedURLException, IOException {
        //System.out.println(getCodeBase() + " " + getDocumentBase());
        URL urlServlet = new URL(url);
        URLConnection con = urlServlet.openConnection();
        con.setConnectTimeout(5000);
        con.setDoInput(true);
        con.setDoOutput(true);
        con.setUseCaches(false);
        con.setRequestProperty("Content-Type", "application/x-java-serialized-object");
        return con;
    }

     protected void updateViewData() {
      try {
         // send data to the servlet
         DataSet tmpData = (DataSet) data.clone();
         URLConnection con = getServerConnection("http://olserver135.virgo.infn.it:8081/jchv/jchv");
         OutputStream outstream = con.getOutputStream();
         ObjectOutputStream oos = new ObjectOutputStream(outstream);
         oos.writeObject(data.svrNameList);
         oos.flush();
         oos.close();
   
         // receive result from servlet
         InputStream instr = con.getInputStream();
         ObjectInputStream inputFromServlet = new ObjectInputStream(instr);
         data.svrValueList = (Vector <String> ) inputFromServlet.readObject();
         inputFromServlet.close();
         instr.close();
       
         if ( initCnt++ < max_fr) return; // First cycle data sent by Alp maybe corrupted!!

         for (int i = 0 ; i < data.list.size(); ++i ) {
             String svrValue =  data.svrValueList.elementAt(i).replace(" ", "").replace(",", ".");
             String svrUnits = " " + data.svrUnitsList.elementAt(i);
             if ( tmpData.svrValueList.size() > 0 && 
                  initCnt != max_fr + 1 && 
                  svrValue.equals(tmpData.svrValueList.elementAt(i).replace(" ", "").replace(",", ".") ) )
                continue;
             if (svrValue.contains("NOTEXIST")) {
                svrValue = "---";
                svrUnits = " ";
             }
             if (svrValue.contains("TIMOUT")) {
                svrValue = "...";
                svrUnits = " ";
             }

             // Store data value
             data.list.elementAt(i).svrValue = svrValue; // Used only for Small Cryotrap valve commands in ControllerValve (!)
             final String value = svrValue;
             final String units = svrUnits;
             //System.out.println(i + " " + data.list.elementAt(i).name + "(" + data.list.elementAt(i).svrName + ") =" + value + " " + data.svrUnitsList.elementAt(i));
             switch (data.list.elementAt(i).type) {
                case LABEL_VALUE_STRING: 
                        Label val = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (val != null)
                           Platform.runLater(() -> {val.setText(value + units);});
                     break;
                case LABEL_VALUE_2E_STRING: 
                        Label val2e = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (val2e != null)
                           Platform.runLater(() -> {
                              try {
                                 val2e.setText(String.format("%.2e",Double.parseDouble(value)) + units);
                              }
                              catch (NumberFormatException e) {
                                 val2e.setText("---");
                              }
                           });
                     break;
                case LABEL_VALUE_2F_STRING: 
                        Label val2f = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (val2f != null)
                           Platform.runLater(() -> {
                              try {
                                 val2f.setText(String.format("%.2f",Double.parseDouble(value)) + units);
                              }
                              catch (NumberFormatException e) {
                                 val2f.setText("---");
                              }
                            });
                     break;
                case LABEL_ACTIVEOFF_STATUS_STRING: 
                        Label activeofftxt = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (activeofftxt != null)
                           Platform.runLater(() -> {activeofftxt.setText(ACTIVEOFF_STATUS_STRING.get(value));});
                     break;
                case LABEL_ACTIVEOFF_STATUS_COLOR: 
                        Label activeoffcol = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (activeoffcol != null)
                           Platform.runLater(() -> {
                              activeoffcol.setStyle(LABEL_STRING_STYLE + ACTIVEOFF_STATUS_COLOR.get(value));
                           });
                     break;
                case SVGPATH_VALVE_STATUS_COLOR: 
                        SVGPath valve = (SVGPath) lookup("#" + data.list.elementAt(i).name);
                        if (valve != null)
                           Platform.runLater(() -> {valve.setFill(VALVE_STATUS_COLOR.get(value));});
                     break;
                case SVGPATH_VALVE_2_STATUS_COLOR: 
                        SVGPath valve_2 = (SVGPath) lookup("#" + data.list.elementAt(i).name);
                        if (valve_2 != null)
                           Platform.runLater(() -> {valve_2.setFill(VALVE_2_STATUS_COLOR.get(value));});
                     break;
                case SVGPATH_VALVE_3_STATUS_COLOR: 
                        SVGPath valve_3 = (SVGPath) lookup("#" + data.list.elementAt(i).name);
                        final int position = i;
                        if (valve_3 != null)
                           Platform.runLater(() -> {
                              try {
                                 int z_10_dout = Integer.parseInt(value);
                                 byte tmp = (byte)(z_10_dout & 0xFF);
                                 int valve_3_status = ( z_10_dout >> data.list.elementAt(position).bit) & 1;
                                 valve_3.setFill(VALVE_3_STATUS_COLOR.get(String.valueOf(valve_3_status)));
                              }
                              catch (NumberFormatException e) {
                                 valve_3.setFill(VALVE_3_STATUS_COLOR.get("255"));
                              }
                           });
                     break;
                case RECTANGLE_PUMP_STATUS_COLOR: 
                        Rectangle pump = (Rectangle) lookup("#" + data.list.elementAt(i).name);
                        if (pump != null)
                           Platform.runLater(() -> {pump.setFill(PUMP_STATUS_COLOR.get(value));});
                     break;
                case RECTANGLE_VENTING_STATUS_COLOR: 
                        Rectangle venting = (Rectangle) lookup("#" + data.list.elementAt(i).name);
                        if (venting != null) {
                           try {
                              double svrValueD = Double.parseDouble(svrValue);
                              Platform.runLater(() -> {
                                 if (svrValueD > 0.3) venting.setFill(VENTING_STATUS_COLOR.get("0"));
                                 else venting.setFill(VENTING_STATUS_COLOR.get("1"));
                              });
                           }    
                           catch(Exception e) {
                              Platform.runLater(() -> { venting.setFill(VENTING_STATUS_COLOR.get("255"));});
                           }    
                        }
                     break;
                case RECTANGLE_REMOTE_PUMPING_STATUS_COLOR: 
                        Rectangle remotepumping = (Rectangle) lookup("#" + data.list.elementAt(i).name);
                        if (remotepumping != null)
                              Platform.runLater(() -> {remotepumping.setFill(REMOTE_PUMPING_STATUS_COLOR.get(value));});
                     break;
                case CIRCLE_GAUGE_STATUS_COLOR: 
                        Circle gauge = (Circle) lookup("#" + data.list.elementAt(i).name);
                        if (gauge != null)
                           Platform.runLater(() -> {gauge.setFill(GAUGE_STATUS_COLOR.get(value));});
                     break;
                case CIRCLE_XGSGAUGE_STATUS_COLOR: 
                     Circle xgsgauge = (Circle) lookup("#" + data.list.elementAt(i).name);
                        if (xgsgauge != null)
                           Platform.runLater(() -> {xgsgauge.setFill(XGSGAUGE_STATUS_COLOR.get(value));});
                     break;
                case CIRCLE_ITRGAUGE_STATUS_COLOR: 
                     Circle itrgauge = (Circle) lookup("#" + data.list.elementAt(i).name);
                        if (itrgauge != null)
                           Platform.runLater(() -> {itrgauge.setFill(ITRGAUGE_STATUS_COLOR.get(value));});
                     break;
                case LABEL_RACK_STATUS_COLOR: 
                        Label station = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (station != null) 
                           Platform.runLater(() -> {
                              station.setStyle(LABEL_BACKGROUND_STYLE + RACK_STATUS_COLOR.get(value));
                           });
                     break;
                case CIRCLE_RGA_STATUS_COLOR: 
                        Circle rga = (Circle) lookup("#" + data.list.elementAt(i).name);
                        if (rga != null)
                           Platform.runLater(() -> {rga.setFill(RGA_STATUS_COLOR.get(value));});
                     break;
                case CIRCLE_RGA_2_STATUS_COLOR: 
                        Circle rga2 = (Circle) lookup("#" + data.list.elementAt(i).name);
                        if (rga2 != null)
                           Platform.runLater(() -> {rga2.setFill(RGA_2_STATUS_COLOR.get(value));});
                     break;
                case RECTANGLE_FILL_LEVEL:
                        try { 
                           Rectangle rectfill = (Rectangle) lookup("#" + data.list.elementAt(i).name);
                           double valuedrect = Double.parseDouble(value);
                           int percentilerect = (int) (valuedrect * 100./( data.list.elementAt(i).max - data.list.elementAt(i).min));
                           String resultrect = String.format("%d",percentilerect);
                           if (rectfill != null) {
                              if (!value.equals("---") && !value.equals("..."))  
                                 Platform.runLater(() -> {
                                    rectfill.setStyle(RECTANGLE_FILL_STYLE + "deepskyblue " + resultrect + "%, white 0%)");
                                 });
                              else
                                 Platform.runLater(() -> {
                                    rectfill.setStyle(RECTANGLE_FILL_STYLE + "grey 100%, white 0%)");
                                 });
                           }
                        }
                        catch (Exception ex){}
                     break;
                case ELLIPSE_FILL_LEVEL: 
                        try {
                           Ellipse ellipsefill = (Ellipse) lookup("#" + data.list.elementAt(i).name);
                           double valuedell = Double.parseDouble(value);
                           int percentileell = (int) (valuedell * 100./( data.list.elementAt(i).max - data.list.elementAt(i).min));
                           String resultell = String.format("%d",percentileell);
                           if (ellipsefill != null) {
                              if (!value.equals("---") && !value.equals("..."))  
                                 Platform.runLater(() -> {
                                    ellipsefill.setStyle(FILL_STYLE + "deepskyblue " + resultell + "%, white 0%)");
                                 });
                              else
                                 Platform.runLater(() -> {
                                    ellipsefill.setStyle(FILL_STYLE + "grey 100%, white 0%)");
                                 });
                           }
                        }
                        catch (Exception ex){}
                     break;
                 case SVGPATH_FILL_LEVEL: 
                        try {
                           SVGPath  svgpathfill = (SVGPath) lookup("#" + data.list.elementAt(i).name);
                           double valuedell = Double.parseDouble(value);
                           int percentileell = (int) (valuedell * 100./( data.list.elementAt(i).max - data.list.elementAt(i).min));
                           String resultell = String.format("%d",percentileell);
                           if (svgpathfill != null) {
                              if (!value.equals("---") && !value.equals("..."))  
                                 Platform.runLater(() -> {
                                    svgpathfill.setStyle(FILL_STYLE + "deepskyblue " + resultell + "%, white 0%)");
                                 });
                              else
                                 Platform.runLater(() -> {
                                    svgpathfill.setStyle(FILL_STYLE + "grey 100%, white 0%)");
                                 });
                           }
                        }
                        catch (Exception ex){}
                     break;
             }
         }
         // Show GPS value
         Label gps = (Label) lookup("#GPS");
         if (gps != null) {
            String svrValue =  data.svrValueList.lastElement().replace(" ", "").replace(",", ".");
            if (svrValue.contains("NOTEXIST"))
                svrValue = "---";
             if (svrValue.contains("TIMOUT"))
                svrValue = "...";
            final String value = svrValue;
            Platform.runLater(() -> {gps.setText("GPS: " + value);});
         }
         if (connectionError == true) {
            Platform.runLater(() -> {
               PauseTransition p = new PauseTransition(Duration.seconds(1));
               p.setOnFinished(f -> MobileApplication.getInstance().hideLayer("NETWORK_ERROR"));
               p.play();
               setMouseTransparent(false);
            });
            connectionError = false;
         }
         if (serverError == true) {
            Platform.runLater(() -> {
               PauseTransition p = new PauseTransition(Duration.seconds(1));
               p.setOnFinished(f -> MobileApplication.getInstance().hideLayer("SERVER_KO"));
               p.play();
               setMouseTransparent(false);
            });
            serverError = false;
         }
         isStarted = false;
      }
      catch (ConnectException e) {
         e.printStackTrace();
         Platform.runLater(() -> {
            MobileApplication.getInstance().showLayer("SERVER_KO");
            setMouseTransparent(true);
         });
         serverError = true;
      }
      catch (IOException e) {
         e.printStackTrace();
         Platform.runLater(() -> {
            MobileApplication.getInstance().showLayer("NETWORK_ERROR");
            setMouseTransparent(true);
         });
         connectionError = true;
      }
      catch (Exception e) {e.printStackTrace();}
    }

    public void run() {
      System.out.println(fxml + " " + name + ": started thread");
      while (true) {
         if (isSuspended == false || isStarted == true) {
            updateViewData();
            //System.out.println("Update View :" + fxml + " " + name);
         }
         else {
            Platform.runLater(() -> {
            PauseTransition p = new PauseTransition(Duration.seconds(1));
            p.setOnFinished(f -> MobileApplication.getInstance().hideLayer("NETWORK_ERROR"));
            p.play();
            });
            Platform.runLater(() -> {
               PauseTransition p = new PauseTransition(Duration.seconds(1));
               p.setOnFinished(f -> MobileApplication.getInstance().hideLayer("SERVER_KO"));
               p.play();
               setMouseTransparent(false);
            });
          }
         try {
            Thread.sleep(1000);
         }
         catch (Exception e) {
         }
      }
   }
}
