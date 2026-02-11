package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import java.net.URLConnection; //for url management 
import java.net.URL;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ConnectException;
import java.util.Vector;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import java.io.ObjectInputStream; //for stream management
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

public class SidePopupViewData implements Runnable, DataTypes {
    
    private URLConnection con;
    public Pane pane;
    protected BorderPane backgroundPane;
    protected static FXMLLoader loader;
    public DataSet data;
    public String fxml = "";
    public String name = "";
    private int initCnt = 0;
    private int max_fr = 2;
    public boolean isSuspended = true;
    public boolean isStarted = true;
    public boolean connectionError = false;
    public boolean serverError = false;
    public static ClassLoader cachingClassLoader = new MyClassLoader(FXMLLoader.getDefaultClassLoader());

    public SidePopupViewData(String _fxml, String _name) {
        fxml = _fxml;
        name = _name;

        try {
           //System.out.println("Load FXML file:" + fxml);
           loader = new FXMLLoader(getClass().getResource("/" + fxml + ".fxml"));
           loader.setClassLoader(cachingClassLoader); 
           backgroundPane = new BorderPane();
           pane =  (Pane) loader.load();
           if (pane instanceof Region) {
              Region regionPane = (Region) pane;
              // Keep authored FXML width, but compute height from real content.
              double fxmlPrefWidth = regionPane.getPrefWidth();
              regionPane.setPrefWidth(fxmlPrefWidth);
              regionPane.setMinWidth(Region.USE_PREF_SIZE);
              regionPane.setMaxWidth(Region.USE_PREF_SIZE);
              regionPane.setPrefHeight(Region.USE_COMPUTED_SIZE);
              regionPane.setMinHeight(Region.USE_PREF_SIZE);
              regionPane.setMaxHeight(Region.USE_PREF_SIZE);
           }
           System.out.println("Created  SidePopupViewData " + fxml + " " + name);
        }
        catch (Exception e) {
           e.printStackTrace();
        }
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
         URLConnection con = getServerConnection("http://online-data-provider.example:8081/jchv/jchv");
         OutputStream outstream = con.getOutputStream();
         ObjectOutputStream oos = new ObjectOutputStream(outstream);
         oos.writeObject(data.svrNameList);
         oos.flush();
         oos.close();
         //System.out.println(data.svrNameList);
         // receive result from servlet
         InputStream instr = con.getInputStream();
         ObjectInputStream inputFromServlet = new ObjectInputStream(instr);
         data.svrValueList = (Vector <String> ) inputFromServlet.readObject();
         inputFromServlet.close();
         instr.close();
         //System.out.println(data.svrValueList);

         if ( initCnt++ < max_fr) return; // First cycle data sent by Alp maybe corrupted!!
         //System.out.println("data size = " + data.list.size());
         //System.out.println("svrValueList size = " + data.svrValueList.size());
         //System.out.println("svrUnitsList size = " + data.svrUnitsList.size());
         for (int i = 0 ; i < data.list.size(); ++i ) {
             String svrValue =  data.svrValueList.elementAt(i).replace(" ", "").replace(",", ".");
             String svrUnits = " " + data.svrUnitsList.elementAt(i);
             if ( tmpData.svrValueList.size() > 0 && 
                  initCnt != max_fr + 1 && 
                  svrValue.equals(tmpData.svrValueList.elementAt(i).replace(" ", "").replace(",", ".") ) )
                continue;
             //System.out.println(i + " " + data.list.elementAt(i).name + "=" + svrValue + " " + svrUnits);
             if (svrValue.contains("NOTEXIST")) {
                svrValue = "---";
                svrUnits = " ";
             }
             if (svrValue.contains("TIMOUT")) {
                svrValue = "...";
                svrUnits = " ";
             }
             final String value = svrValue;
             final String units = svrUnits;
             
             switch (data.list.elementAt(i).type) {
                case LABEL_VALUE_STRING: 
                        Label val = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (val != null)
                           Platform.runLater(() -> {val.setText(value + units);});
                     break;
                case LABEL_VALUE_2E_STRING: 
                        Label val2e = (Label) pane.lookup("#" + data.list.elementAt(i).name);
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
                        Label val2f = (Label) pane.lookup("#" + data.list.elementAt(i).name);
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
                        Label activeofftxt = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (activeofftxt != null) {
                           Platform.runLater(() -> {
                              activeofftxt.setText(ACTIVEOFF_STATUS_STRING.get(value));
                              activeofftxt.setStyle(LABEL_STRING_STYLE + ACTIVEOFF_STATUS_COLOR.get(value));  
                           });
                        }
                     break;
                case LABEL_ACTIVEOFF_STATUS_COLOR: 
                        Label activeoffcol = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (activeoffcol != null)
                           Platform.runLater(() -> {
                              activeoffcol.setStyle(LABEL_STRING_STYLE + ACTIVEOFF_STATUS_COLOR.get(value));
                           });
                     break;
                case LABEL_OFFACTIVE_STATUS_STRING: 
                        Label offactivetxt = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (offactivetxt != null) {
                           Platform.runLater(() -> {
                              offactivetxt.setText(OFFACTIVE_STATUS_STRING.get(value));
                              offactivetxt.setStyle(LABEL_STRING_STYLE + OFFACTIVE_STATUS_COLOR.get(value));  
                           });
                        }
                     break;
                case LABEL_OFFACTIVE_STATUS_COLOR: 
                        Label offactivecol = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (offactivecol != null)
                           Platform.runLater(() -> {
                              offactivecol.setStyle(LABEL_STRING_STYLE + OFFACTIVE_STATUS_COLOR.get(value));
                           });
                     break;
                case LABEL_OFFON_STATUS_STRING: 
                        Label offontxt = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (offontxt != null) {
                           Platform.runLater(() -> {
                              offontxt.setText(OFFON_STATUS_STRING.get(value));
                              offontxt.setStyle(LABEL_STRING_STYLE + OFFON_STATUS_COLOR.get(value));  
                           });
                        }
                     break;
                case LABEL_OFFON_STATUS_COLOR: 
                        Label offoncol = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (offoncol != null)
                           Platform.runLater(() -> {
                              offoncol.setStyle(LABEL_STRING_STYLE + OFFON_STATUS_COLOR.get(value));
                        });
                     break;
                case LABEL_ONOFF_3_STATUS_STRING: 
                        Label offon2txt = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (offon2txt != null) {
                           Platform.runLater(() -> {
                              offon2txt.setText(ONOFF_3_STATUS_STRING.get(value));
                              offon2txt.setStyle(LABEL_STRING_STYLE + ONOFF_3_STATUS_COLOR.get(value));  
                           });
                        }
                     break;
                case LABEL_ONOFF_STATUS_STRING: 
                        Label onofftxt = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (onofftxt != null) {
                           Platform.runLater(() -> {
                              onofftxt.setText(ONOFF_STATUS_STRING.get(value));
                              onofftxt.setStyle(LABEL_STRING_STYLE + ONOFF_STATUS_COLOR.get(value));  
                           });
                        }
                     break;
                case LABEL_ONOFF_STATUS_COLOR: 
                        Label onoffcol = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (onoffcol != null)
                           Platform.runLater(() -> {
                              onoffcol.setStyle(LABEL_STRING_STYLE + ONOFF_STATUS_COLOR.get(value));
                           });
                     break;
                case LABEL_ONOFF_2_STATUS_STRING: 
                        Label onoff2txt = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (onoff2txt != null) {
                           Platform.runLater(() -> {
                              onoff2txt.setText(ONOFF_2_STATUS_STRING.get(value));
                              onoff2txt.setStyle(LABEL_STRING_STYLE + ONOFF_2_STATUS_COLOR.get(value));  
                           });
                        }
                     break;
                case LABEL_ONOFF_4_STATUS_STRING: 
                        Label onoff4txt = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (onoff4txt != null) {
                           Platform.runLater(() -> {
                              onoff4txt.setText(ONOFF_4_STATUS_STRING.get(value));
                              onoff4txt.setStyle(LABEL_STRING_STYLE + ONOFF_4_STATUS_COLOR.get(value));  
                           });
                        }
                     break;
                case LABEL_OKFAILURE_STATUS_STRING:
                        Label okfailure_status = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (okfailure_status != null)
                           Platform.runLater(() -> {
                              okfailure_status.setStyle(LABEL_STRING_STYLE + OKFAILURE_STATUS_COLOR_2.get(value)); 
                              okfailure_status.setText(OKFAILURE_STATUS_STRING.get(value));
                           });
                     break;
                case LABEL_OKFAILURE_STATUS_COLOR: 
                        Label okfailurecol = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (okfailurecol != null)
                           Platform.runLater(() -> {okfailurecol.setStyle(LABEL_STRING_STYLE + OKFAILURE_STATUS_COLOR.get(value));});
                     break;
                case LABEL_FAILUREOK_STATUS_STRING:
                        Label failureok_status = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (failureok_status != null)
                           Platform.runLater(() -> {
                              failureok_status.setStyle(LABEL_STRING_STYLE + FAILUREOK_STATUS_COLOR_2.get(value)); 
                              failureok_status.setText(FAILUREOK_STATUS_STRING.get(value));
                           });
                     break;
                case LABEL_FAILUREOK_STATUS_COLOR: 
                        Label failureokcol = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (failureokcol != null)
                           Platform.runLater(() -> {failureokcol.setStyle(LABEL_STRING_STYLE + FAILUREOK_STATUS_COLOR.get(value));});
                     break;
                case SVGPATH_VALVE_STATUS_COLOR: 
                        SVGPath valve = (SVGPath) pane.lookup("#" + data.list.elementAt(i).name);
                        if (valve != null)
                           Platform.runLater(() -> {valve.setFill(VALVE_STATUS_COLOR.get(value));});
                     break;
                case LABEL_VALVE_STATUS_STRING: 
                        Label valvestr = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (valvestr != null)
                           Platform.runLater(() -> {valvestr.setText(VALVE_STATUS_STRING.get(value));});
                     break;
                case LABEL_INHIBIT_VALVE_STATUS_STRING: 
                        Label inhibitvalve_status = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (inhibitvalve_status != null)
                           Platform.runLater(() -> {
                               inhibitvalve_status.setStyle(LABEL_STRING_STYLE + INHIBIT_VALVE_STATUS_COLOR.get(value)); 
                               inhibitvalve_status.setText(INHIBIT_VALVE_STATUS_STRING.get(value));});
                     break;
                case LABEL_INHIBIT_VALVE_2_STATUS_STRING: 
                        Label inhibitvalve_2 = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        final int position = i;
                        if (inhibitvalve_2 != null)
                           Platform.runLater(() -> {
                              try {
                                 int inhibitvalve_2_value = Integer.parseInt(value);
                                 int inhibitvalve_2_status = ( inhibitvalve_2_value >> data.list.elementAt(position).bit) & 1;
                                 inhibitvalve_2.setText(INHIBIT_VALVE_STATUS_STRING.get(String.valueOf(inhibitvalve_2_status)));
                                 inhibitvalve_2.setStyle(LABEL_STRING_STYLE +
                                               INHIBIT_VALVE_STATUS_COLOR.get(String.valueOf(inhibitvalve_2_status)));
                              }
                              catch (NumberFormatException e) {
                                 inhibitvalve_2.setText(INHIBIT_VALVE_STATUS_STRING.get("255"));
                                 inhibitvalve_2.setStyle(LABEL_STRING_STYLE + INHIBIT_VALVE_STATUS_COLOR.get("255"));
                              }
                           });
                     break;
                case RECTANGLE_BUILDING_STATUS_COLOR:
                     break;
                case LABEL_VENTING_STATUS_STRING: 
                        Label venting = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (venting != null) 
                           try {
                              final double svrValueD1 = Double.parseDouble(svrValue);
                              Platform.runLater(() -> {
                                 if (Math.abs(svrValueD1) > 0.1) { 
                                    venting.setText(VENTING_STATUS_STRING.get("0"));
                                    venting.setStyle(LABEL_STRING_STYLE + VENTING_STATUS_COLOR_2.get("0"));
                                 }
                                 else {
                                    venting.setText(VENTING_STATUS_STRING.get("1"));
                                    venting.setStyle(LABEL_STRING_STYLE + VENTING_STATUS_COLOR_2.get("1"));
                                 }    
                              });
                           }
                           catch (NumberFormatException e) {
                               Platform.runLater(() -> {
                                 venting.setText(VENTING_STATUS_STRING.get("255"));
                                 venting.setStyle(LABEL_STRING_STYLE + VENTING_STATUS_COLOR_2.get("255"));
                               });
                           }
                     break;
                case LABEL_OPERATION_STATUS_STRING: 
                        Label operation = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (operation != null)
                           try {
                              final double svrValueD2 = Double.parseDouble(svrValue);
                              Platform.runLater(() -> {
                                 if (svrValueD2 < 0.01) { 
                                    operation.setText(OPERATION_STATUS_STRING.get("0"));
                                    operation.setStyle(LABEL_STRING_STYLE + OPERATION_STATUS_COLOR.get("0"));
                                 }
                                 else if (svrValueD2 > 0.01 && svrValueD2 < 500) { 
                                    operation.setText(OPERATION_STATUS_STRING.get("2"));
                                    operation.setStyle(LABEL_STRING_STYLE + OPERATION_STATUS_COLOR.get("2"));
                                 }
                                 else {
                                    operation.setText(OPERATION_STATUS_STRING.get("1"));
                                    operation.setStyle(LABEL_STRING_STYLE + OPERATION_STATUS_COLOR.get("1"));
                                 }
                              });
                           }    
                           catch (NumberFormatException e) {
                              Platform.runLater(() -> {
                                 operation.setText(OPERATION_STATUS_STRING.get("255"));
                                 operation.setStyle(LABEL_STRING_STYLE + OPERATION_STATUS_COLOR.get("255"));
                              });
                           }
                     break;
                case LABEL_REMOTE_PUMPING_STATUS_STRING: 
                        Label remotepumping = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (remotepumping != null) {
                           Platform.runLater(() -> {
                              remotepumping.setText(REMOTE_PUMPING_STATUS_STRING.get(value));
                              remotepumping.setStyle(LABEL_STRING_STYLE + REMOTE_PUMPING_STATUS_COLOR_2.get(value));
                                
                           });
                        }
                     break;
                case RECTANGLE_PUMP_STATUS_COLOR: 
                        Rectangle pump = (Rectangle) pane.lookup("#" + data.list.elementAt(i).name);
                        if (pump != null)
                           Platform.runLater(() -> {pump.setFill(PUMP_STATUS_COLOR.get(value));});
                     break;
                case CIRCLE_GAUGE_STATUS_COLOR: 
                        Circle gauge = (Circle) pane.lookup("#" + data.list.elementAt(i).name);
                        if (gauge != null)
                           Platform.runLater(() -> {gauge.setFill(GAUGE_STATUS_COLOR.get(value));});
                     break;
                case LABEL_RACK_STATUS_COLOR: 
                        Label station = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (station != null) 
                           Platform.runLater(() -> {
                              station.setStyle(LABEL_BACKGROUND_STYLE + RACK_STATUS_COLOR.get(value));
                           });
                     break;
                case LABEL_RACK_STATUS_STRING: 
                        Label station_status = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (station_status != null) 
                           Platform.runLater(() -> {
                              station_status.setStyle(LABEL_STRING_STYLE + RACK_2_STATUS_COLOR.get(value));
                              station_status.setText(RACK_STATUS_STRING.get(value));
                           });    
                     break;
                case CIRCLE_XGSGAUGE_STATUS_COLOR: 
                        Circle xgsgauge = (Circle) pane.lookup("#" + data.list.elementAt(i).name);
                        if (xgsgauge != null)
                           Platform.runLater(() -> {xgsgauge.setFill(XGSGAUGE_STATUS_COLOR.get(value));});
                     break;
                case CIRCLE_RGA_STATUS_COLOR: 
                        Circle rga = (Circle) pane.lookup("#" + data.list.elementAt(i).name);
                        if (rga != null)
                           Platform.runLater(() -> {rga.setFill(RGA_STATUS_COLOR.get(value));});
                     break;
                case LABEL_MAXIGAUGE_SENSOR_STATUS_STRING: 
                        Label maxigauge_status = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (maxigauge_status != null)
                           Platform.runLater(() -> {maxigauge_status.setText(MAXIGAUGE_SENSOR_STATUS_STRING.get(value));});
                     break;
                case LABEL_MAXIGAUGE_PRESSURE_STATUS_STRING: 
                        Label maxigauge_pressure_status = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (maxigauge_pressure_status != null)
                            Platform.runLater(() -> {maxigauge_pressure_status.setText(MAXIGAUGE_PRESSURE_STATUS_STRING.get(value));});
                     break;
                case LABEL_XGSGAUGE_EMISSION_STATUS_STRING: 
                        Label xgsgauge_emission_status = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (xgsgauge_emission_status != null)
                            Platform.runLater(() -> {xgsgauge_emission_status.setText(XGSGAUGE_EMISSION_STATUS_STRING.get(value));});
                     break;
                case LABEL_XGSGAUGE_FILAMENT_STATUS_STRING: 
                        Label xgsgauge_filament_status = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (xgsgauge_filament_status != null)
                            Platform.runLater(() -> {xgsgauge_filament_status.setText(XGSGAUGE_FILAMENT_STATUS_STRING.get(value));});
                     break;
                case LABEL_XGSGAUGE_DEGAS_STATUS_STRING: 
                        Label xgsgauge_degas_status = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (xgsgauge_degas_status != null)
                            Platform.runLater(() -> {xgsgauge_degas_status.setText(XGSGAUGE_DEGAS_STATUS_STRING.get(value));});
                     break;
                case LABEL_DRY_STATUS_STRING: 
                        Label dry_status = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (dry_status != null)
                            Platform.runLater(() -> {dry_status.setText(DRY_STATUS_STRING.get(value));});
                     break;
                case LABEL_TURBO_STATUS_STRING: 
                        Label turbo_status = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (turbo_status != null)
                            Platform.runLater(() -> {turbo_status.setText(TURBO_STATUS_STRING.get(value));});
                     break;
                case LABEL_TURBO_STANDBY_STATUS_STRING: 
                        Label turbo_standby_status = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (turbo_standby_status != null)
                            Platform.runLater(() -> {turbo_standby_status.setText(TURBO_STANDBY_STATUS_STRING.get(value));});
                     break;
                case LABEL_TURBO_TEMP_STATUS_STRING: 
                        Label turbo_temp_status = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (turbo_temp_status != null)
                            Platform.runLater(() -> {turbo_temp_status.setText(TURBO_TEMP_STATUS_STRING.get(value));});
                     break;
                case LABEL_TURBO_TEMP_BOX_STATUS_STRING: 
                        Label turbo_temp_box_status = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (turbo_temp_box_status != null)
                           Platform.runLater(() -> {turbo_temp_box_status.setText(TURBO_TEMP_BOX_STATUS_STRING.get(value));});
                     break;
                case LABEL_TURBO_BOX_STATUS_STRING: 
                        Label turbo_box_status = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (turbo_box_status != null)
                           Platform.runLater(() -> {turbo_box_status.setText(TURBO_BOX_STATUS_STRING.get(value));});
                     break;
                case CIRCLE_GOLDEN_STATUS_COLOR: 
                        Circle golden = (Circle) pane.lookup("#" + data.list.elementAt(i).name);
                        if (golden != null) {
                           Platform.runLater(() -> {
                              golden.setStyle("-fx-fill:" + GOLDEN_STATUS_COLOR.get(value));
                           });
                        }
                     break;
                case CIRCLE_O2SENSOR_STATUS_COLOR: 
                        Circle o2sensor_status = (Circle) pane.lookup("#" + data.list.elementAt(i).name);
                        if (o2sensor_status != null) {
                           try {
                              final int valueO2St = Integer.parseInt(value);
                              int[] status = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};// There are 16 status bits
                              String tmpCol = "255";
                              for (int k = 0 ; k < 16 ; k++) status[k] = (valueO2St >> k) & 1;
                              if ( status[7] == 1 )  tmpCol = "0";
                              if ( status[2] == 1 )  tmpCol = "1";
                              if ( status[3] == 1 )  tmpCol = "2";
                              if ( status[4] == 1 )  tmpCol = "3";
                              if ( status[0] == 1 )  tmpCol = "4";
                              if ( status[11] == 1 || status[15] == 1 || status[10] == 1 || status[14] == 1 )
                                 tmpCol = "5";
                              if ( status[8] == 1 )  tmpCol = "6";
                              final String color_value = tmpCol;
                              Platform.runLater(() -> {
                                 o2sensor_status.setStyle("-fx-fill:" + O2SENSOR_STATUS_COLOR.get(color_value));
                              });
                           }
                        catch (NumberFormatException e) {
                              Platform.runLater(() -> {
                                o2sensor_status.setStyle("-fx-fill:" + O2SENSOR_STATUS_COLOR.get("255"));
                              });
                           }
                        }
                     break;
                case LABEL_GOLDEN_STATUS_STRING: 
                        Label golden_status = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (golden_status != null) {
                           Platform.runLater(() -> {
                              golden_status.setText(GOLDEN_STATUS_STRING.get(value));
                              golden_status.setStyle(LABEL_STRING_STYLE + GOLDEN_STATUS_COLOR.get(value));
                           });
                        }
                     break;
                case LABEL_SAFE_STATUS_STRING: 
                        Label safe_status = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (safe_status != null) {
                           Platform.runLater(() -> {
                              safe_status.setText(SAFE_STATUS_STRING.get(value));
                              safe_status.setStyle(LABEL_STRING_STYLE + SAFE_STATUS_COLOR.get(value));
                           });
                        }
                     break;
                case LABEL_CRYO_STATUS_STRING:
                        Label cryo_status = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (cryo_status != null)
                           Platform.runLater(() -> {
                              cryo_status.setText(CRYO_STATUS_STRING.get(value));
                              cryo_status.setStyle(LABEL_STRING_STYLE + CRYO_STATUS_COLOR_2.get(value));
                           });
                     break;
                case LABEL_REFILL_MODE_STATUS_STRING:
                        Label refill_mode_status = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (refill_mode_status != null)
                           Platform.runLater(() -> {refill_mode_status.setText(REFILL_MODE_STATUS_STRING.get(value));});
                     break;
                case LABEL_FANSPEED_STATUS_STRING: 
                        Label fanspeedtxt = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (fanspeedtxt != null) {
                           Platform.runLater(() -> {
                              fanspeedtxt.setText(FANSPEED_STATUS_STRING.get(value));
                              fanspeedtxt.setStyle(LABEL_STRING_STYLE + FANSPEED_STATUS_COLOR.get(value));  
                           });
                        }
                     break;
                case LABEL_OKWORKING_STATUS_STRING: 
                        Label okworkingtxt = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (okworkingtxt != null) {
                           Platform.runLater(() -> {
                              okworkingtxt.setText(OKWORKING_STATUS_STRING.get(value));
                              okworkingtxt.setStyle(LABEL_STRING_STYLE + OKWORKING_STATUS_COLOR.get(value));  
                           });
                        }
                     break;
                case LABEL_OKLOW_STATUS_STRING: 
                        Label oklowtxt = (Label) pane.lookup("#" + data.list.elementAt(i).name);
                        if (oklowtxt != null) {
                           Platform.runLater(() -> {
                              oklowtxt.setText(OKLOW_STATUS_STRING.get(value));
                              oklowtxt.setStyle(LABEL_STRING_STYLE + OKLOW_STATUS_COLOR.get(value));  
                           });
                        }
                     break;
             }
         }
         if (connectionError == true) {
            Platform.runLater(() -> {
               PauseTransition p = new PauseTransition(Duration.seconds(1));
               p.setOnFinished(f -> MobileApplication.getInstance().hideLayer("NETWORK_ERROR"));
               p.play();
            });
            connectionError = false;
         }
         if (serverError == true) {
            Platform.runLater(() -> {
               PauseTransition p = new PauseTransition(Duration.seconds(1));
               p.setOnFinished(f -> MobileApplication.getInstance().hideLayer("SERVER_KO"));
               p.play();
            });
            serverError = false;
         }
         isStarted = false;
      }
      catch (ConnectException e) {
         e.printStackTrace();
         Platform.runLater(() -> {
            MobileApplication.getInstance().showLayer("SERVER_KO");
         });
         serverError = true;
      }
      catch (IOException e) {
         e.printStackTrace();
         Platform.runLater(() -> {
            MobileApplication.getInstance().showLayer("NETWORK_ERROR");
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
            //System.out.println(    fxml + " " + name + ": running");
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
