package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.Icon;
import com.gluonhq.charm.glisten.mvc.View;
import javafx.scene.control.MenuItem;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.lang.Runnable;
import java.net.MalformedURLException;
import java.lang.NumberFormatException;
import java.net.ConnectException;
import java.lang.Thread;
import java.util.Vector;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import java.net.URLConnection; //for url management
import java.net.URL;
import java.io.ObjectInputStream; //for stream management
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import javafx.scene.input.ScrollEvent;
import javafx.scene.input.TouchEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ZoomEvent;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.ImagePattern;
import javafx.scene.layout.CornerRadii;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import com.gluonhq.charm.glisten.layout.Layer;
import javafx.animation.PauseTransition;
import javafx.util.Duration;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.CategoryAxis;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import com.github.javafx.charts.zooming.ZoomManager;
import javafx.scene.control.Tooltip;
import org.gillius.jfxutils.chart.JFXChartUtil;
import javafx.scene.web.WebView; 
import javafx.scene.web.WebEngine;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.StringWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter; 
import java.io.FileWriter;
import java.io.File; 
import com.gluonhq.charm.glisten.animation.BounceInDownTransition;
import com.gluonhq.charm.glisten.animation.BounceOutUpTransition;
import java.text.DecimalFormat;
import java.text.ParseException;
import javafx.util.StringConverter;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;


public class LayerData extends Layer implements Runnable, DataTypes {

    protected BorderPane backgroundPane;
    private ControllerChart controllerchart = null;
    private ControllerPlot controllerplot = null;
    private ControllerWeb controllerweb = null;
    private URLConnection con;
    protected Pane pane;
    protected Region region;
    protected WebView web;
    protected static FXMLLoader loader;
    public DataSet data;
    public String fxml = "";
    public String name = "";
    private int initCnt = 0;
    private int max_fr = 2;
    public boolean isSuspended = true;
    public boolean isStarted = true;
    private boolean plotStarted = false;
    private XYChart.Series series;
    public boolean connectionError = false;
    public boolean serverError = false;
    public static ClassLoader cachingClassLoader = new MyClassLoader(FXMLLoader.getDefaultClassLoader());

    public LayerData(String _fxml, String _name) { 
        fxml = _fxml;
        name = _name;

        try {
           System.out.println("Load FXML file:" + fxml);
           loader = new FXMLLoader(getClass().getResource("/" + fxml + ".fxml"));
           loader.setClassLoader(cachingClassLoader); 
           backgroundPane = new BorderPane();
           pane =  (Pane) loader.load();
           if (fxml.equals("WEB"))
              controllerweb = loader.<ControllerWeb>getController();
           if (fxml.equals("CHART")) 
              controllerchart = loader.<ControllerChart>getController();
           if (fxml.equals("PLOT")) 
              controllerplot = loader.<ControllerPlot>getController();
             
           backgroundPane.setCenter(pane);
           setBackgroundFade(0.3);
           backgroundPane.setBackground(Background.EMPTY);
           getChildren().addAll(backgroundPane);
           setAutoHide(true);
           System.out.println("Created Layer " + fxml + " " + backgroundPane);
           
        }
        catch (IOException e) {
           e.printStackTrace();
        }
        setShowTransitionFactory(BounceInDownTransition::new);
        setHideTransitionFactory(BounceOutUpTransition::new);
        setOnHidden(e -> {isSuspended = true;});
        setOnShowing(e -> {isSuspended = false;});
        
        
    }
    @Override
    public void layoutChildren() {
        super.layoutChildren();
        backgroundPane.setVisible(isShowing());
        if (!isShowing()) {
            return;
        }
        backgroundPane.resize(300, 150);
        resizeRelocate((MobileApplication.getInstance().getGlassPane().getWidth() - 300)/2,
        (MobileApplication.getInstance().getGlassPane().getHeight()- 150)/2, 300, 150);
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
        StringBuilder x = new StringBuilder(); // For Plot cases (RGA_WEB_DATA)
        StringBuilder y = new StringBuilder(); // For Plot cases (RGA_WE_DATA)
        Vector<XYChart.Data> xychartVect = new Vector<XYChart.Data>(); // For Plot cases (RGA_CHART_DATA, RGA_2_CHART_DATA)
      try {
         // send data to the servlet
         DataSet tmpData = (DataSet) data.clone();
         URLConnection con = getServerConnection("http://olserver135.virgo.infn.it:8081/jchv/jchv");
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

         if (initCnt++ < max_fr) return; // First cycle data sent by Alp maybe corrupted!!

         //System.out.println(data.svrValueList);
         for (int i = 0 ; i < data.list.size(); ++i ) {
             String svrValue =  data.svrValueList.elementAt(i).replace(" ", "").replace(",", ".");
             String svrUnits = " " + data.svrUnitsList.elementAt(i);
             //System.out.println("tmpData = #" + tmpData.svrValueList.elementAt(i).replace(" ", "").replace(",", ".") + "# data = #" +  svrValue + "#");
             if ( data.list.elementAt(i).type != Type.PLOT_DATA &&
                  data.list.elementAt(i).type != Type.RGA_CHART_DATA &&
                  tmpData.svrValueList.size() > 0 && initCnt != max_fr + 1 &&
                  svrValue.equals(tmpData.svrValueList.elementAt(i).replace(" ", "").replace(",", ".")) )
                continue;
             //System.out.println("[" + i + "]:" + " " + data.list.elementAt(i).name + "(" + data.list.elementAt(i).svrName + ")" + "=" + svrValue + " " + svrUnits 
              //                  + " Type=" + data.list.elementAt(i).type);
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
             final String svrName = data.list.elementAt(i).svrName;
             
             switch (data.list.elementAt(i).type) {
                case LABEL_VALUE_STRING: 
                        Label val = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (val != null)
                           Platform.runLater(() -> {val.setText(value + units);});
                     break;
                case SVGPATH_VALVE_STATUS_COLOR: 
                        SVGPath valve = (SVGPath) lookup("#" + data.list.elementAt(i).name);
                        if (valve != null)
                           Platform.runLater(() -> {valve.setFill(VALVE_STATUS_COLOR.get(value));});
                     break;
                case LABEL_VALVE_STATUS_STRING: 
                        Label valvestr = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (valvestr != null)
                           Platform.runLater(() -> {valvestr.setText(VALVE_STATUS_STRING.get(value));});
                     break;
                case LABEL_VALVE_2_STATUS_STRING: 
                        Label valve_2str = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (valve_2str != null)
                           Platform.runLater(() -> {valve_2str.setText(VALVE_2_STATUS_STRING.get(value));});
                     break;
                case LABEL_VALVE_3_STATUS_STRING: 
                        Label valve_3 = (Label) lookup("#" + data.list.elementAt(i).name);
                        final int position = i;
                        if (valve_3 != null)
                           Platform.runLater(() -> {
                              try {
                                 int z_10_dout = Integer.parseInt(value);
                                 byte tmp = (byte)(z_10_dout & 0xFF);
                                 int valve_3_status = ( z_10_dout >> data.list.elementAt(position).bit) & 1;
                                 System.out.println("valve_3 status=" + String.valueOf(valve_3_status));
                                 valve_3.setText(VALVE_3_STATUS_STRING.get(String.valueOf(valve_3_status)));
                              }
                              catch (NumberFormatException e) {
                                 valve_3.setText(VALVE_3_STATUS_STRING.get("255"));
                              }
                           });
                     break;
                case LABEL_ACTIVEOFF_STATUS_STRING: 
                        Label activeofftxt = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (activeofftxt != null) {
                           Platform.runLater(() -> {
                              activeofftxt.setText(ACTIVEOFF_STATUS_STRING.get(value));
                              activeofftxt.setStyle(LABEL_STRING_STYLE + ACTIVEOFF_STATUS_COLOR.get(value));
                           });
                        }
                     break;
                case LABEL_ACTIVEOFF_STATUS_COLOR: 
                        Label activeoffcol = (Label) lookup("#" + data.list.elementAt(i).name);
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
                        Label offontxt = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (offontxt != null) {
                           Platform.runLater(() -> {
                              offontxt.setText(OFFON_STATUS_STRING.get(value));
                              offontxt.setStyle(LABEL_STRING_STYLE + OFFON_STATUS_COLOR.get(value));  
                           });
                        }
                     break;
                case LABEL_OFFON_STATUS_COLOR: 
                        Label offoncol = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (offoncol != null)
                           Platform.runLater(() -> {
                              offoncol.setStyle(LABEL_STRING_STYLE + OFFON_STATUS_COLOR.get(value));
                        });
                     break;
                case LABEL_ONOFF_3_STATUS_STRING: 
                        Label offon2txt = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (offon2txt != null) {
                           Platform.runLater(() -> {
                              offon2txt.setText(ONOFF_3_STATUS_STRING.get(value));
                              offon2txt.setStyle(LABEL_STRING_STYLE + ONOFF_3_STATUS_COLOR.get(value));  
                           });
                        }
                     break;
                case LABEL_ONOFF_STATUS_STRING: 
                        Label onofftxt = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (onofftxt != null) {
                           Platform.runLater(() -> {
                              onofftxt.setText(ONOFF_STATUS_STRING.get(value));
                              onofftxt.setStyle(LABEL_STRING_STYLE + ONOFF_STATUS_COLOR.get(value));  
                           });
                        }
                     break;
                case LABEL_ONOFF_STATUS_COLOR: 
                        Label onoffcol = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (onoffcol != null)
                           Platform.runLater(() -> {
                              onoffcol.setStyle(LABEL_STRING_STYLE + ONOFF_STATUS_COLOR.get(value));
                        });
                     break;
                case LABEL_ONOFF_2_STATUS_STRING: 
                        Label onoff2txt = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (onoff2txt != null) {
                           Platform.runLater(() -> {
                              onoff2txt.setText(ONOFF_2_STATUS_STRING.get(value));
                              onoff2txt.setStyle(LABEL_STRING_STYLE + ONOFF_2_STATUS_COLOR.get(value));  
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
                case RECTANGLE_BUILDING_STATUS_COLOR:
                     break;
                case RECTANGLE_PUMP_STATUS_COLOR: 
                        Rectangle pump = (Rectangle) lookup("#" + data.list.elementAt(i).name);
                        if (pump != null)
                           Platform.runLater(() -> {pump.setFill(PUMP_STATUS_COLOR.get(value));});
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
                           Platform.runLater(() -> {station.setStyle(station.getStyle().
                                       replaceAll("-fx-background-color:.......", "-fx-background-color:" 
                                       + RACK_STATUS_COLOR.get(value)));});
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
                case LABEL_MAXIGAUGE_SENSOR_STATUS_STRING: 
                        Label maxigauge_status = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (maxigauge_status != null)
                           Platform.runLater(() -> {maxigauge_status.setText(MAXIGAUGE_SENSOR_STATUS_STRING.get(value));});
                     break;
                case LABEL_MAXIGAUGE_PRESSURE_STATUS_STRING: 
                         Label maxigauge_pressure_status = (Label) lookup("#" + data.list.elementAt(i).name);
                         if (maxigauge_pressure_status != null)
                           Platform.runLater(() -> {maxigauge_pressure_status.setText(MAXIGAUGE_PRESSURE_STATUS_STRING.get(value));});
                     break;
                case LABEL_XGSGAUGE_EMISSION_STATUS_STRING: 
                         Label xgsgauge_emission_status = (Label) lookup("#" + data.list.elementAt(i).name);
                         if (xgsgauge_emission_status != null)
                           Platform.runLater(() -> {xgsgauge_emission_status.setText(XGSGAUGE_EMISSION_STATUS_STRING.get(value));});
                     break;
                case LABEL_XGSGAUGE_FILAMENT_STATUS_STRING: 
                         Label xgsgauge_filament_status = (Label) lookup("#" + data.list.elementAt(i).name);
                         if (xgsgauge_filament_status != null)
                           Platform.runLater(() -> {xgsgauge_filament_status.setText(XGSGAUGE_FILAMENT_STATUS_STRING.get(value));});
                     break;
                case LABEL_XGSGAUGE_DEGAS_STATUS_STRING: 
                         Label xgsgauge_degas_status = (Label) lookup("#" + data.list.elementAt(i).name);
                         if (xgsgauge_degas_status != null)
                           Platform.runLater(() -> {xgsgauge_degas_status.setText(XGSGAUGE_DEGAS_STATUS_STRING.get(value));});
                     break;
                case LABEL_ITRGAUGE_SENSOR_STATUS_STRING: 
                        Label itrgauge_status = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (itrgauge_status != null)
                           Platform.runLater(() -> {itrgauge_status.setText(ITRGAUGE_SENSOR_STATUS_STRING.get(value));});
                     break;
                case LABEL_ITRGAUGE_EMISSION_STATUS_STRING: 
                        Label itrgauge_emission_status = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (itrgauge_emission_status != null)
                           Platform.runLater(() -> {itrgauge_emission_status.setText(ITRGAUGE_EMISSION_STATUS_STRING.get(value));});
                     break;
                case LABEL_ITRGAUGE_DEGAS_STATUS_STRING: 
                        Label itrgauge_degas_status = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (itrgauge_degas_status != null)
                           Platform.runLater(() -> {itrgauge_degas_status.setText(ITRGAUGE_DEGAS_STATUS_STRING.get(value));});
                     break;
                case LABEL_DRY_STATUS_STRING: 
                        Label dry_status = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (dry_status != null)
                           Platform.runLater(() -> {dry_status.setText(DRY_STATUS_STRING.get(value));});
                     break;
                case LABEL_TURBO_STATUS_STRING: 
                        Label turbo_status = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (turbo_status != null)
                           Platform.runLater(() -> {turbo_status.setText(TURBO_STATUS_STRING.get(value));});
                     break;
                case LABEL_TURBO_STANDBY_STATUS_STRING: 
                        Label turbo_standby_status = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (turbo_standby_status != null)
                           Platform.runLater(() -> {turbo_standby_status.setText(TURBO_STANDBY_STATUS_STRING.get(value));});
                     break;
                case LABEL_TURBO_TEMP_STATUS_STRING: 
                        Label turbo_temp_status = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (turbo_temp_status != null)
                           Platform.runLater(() -> {turbo_temp_status.setText(TURBO_TEMP_STATUS_STRING.get(value));});
                     break;
                case LABEL_TURBO_TEMP_BOX_STATUS_STRING: 
                        Label turbo_temp_box_status = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (turbo_temp_box_status != null)
                           Platform.runLater(() -> {turbo_temp_box_status.setText(TURBO_TEMP_BOX_STATUS_STRING.get(value));});
                     break;
                case LABEL_TURBO_BOX_STATUS_STRING: 
                        Label turbo_box_status = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (turbo_box_status != null)
                           Platform.runLater(() -> {turbo_box_status.setText(TURBO_BOX_STATUS_STRING.get(value));});
                     break;
                case LABEL_TURBO_BOX_2_STATUS_STRING: 
                        Label turbo_box_2_status = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (turbo_box_2_status != null)
                           Platform.runLater(() -> {turbo_box_2_status.setText(TURBO_BOX_2_STATUS_STRING.get(value));});
                     break;
                case LABEL_IONIC_STATUS_STRING: 
                        Label ionic_status = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (ionic_status != null)
                           Platform.runLater(() -> {ionic_status.setText(IONIC_STATUS_STRING.get(value));});
                     break;
                case LABEL_IONIC_STATUS_ERROR_STRING: 
                        Label ionic_error_status = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (ionic_error_status != null)
                           Platform.runLater(() -> {ionic_error_status.setText(IONIC_STATUS_ERROR_STRING.get(value));});
                     break;
                case LABEL_IONIC_COMM_STATUS_STRING: 
                        Label ionic_comm_status = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (ionic_comm_status != null)
                           Platform.runLater(() -> {ionic_comm_status.setText(IONIC_COMM_STATUS_STRING.get(value));});
                     break;
                case LABEL_IONIC_OPERATING_MODE_STRING: 
                        Label ionic_operating_mode = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (ionic_operating_mode != null)
                           Platform.runLater(() -> {ionic_operating_mode.setText(IONIC_OPERATING_MODE_STRING.get(value));});
                     break;
                case LABEL_IONIC_VOLTAGE_MODE_STRING: 
                        Label ionic_voltage_mode = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (ionic_voltage_mode != null)
                           Platform.runLater(() -> {ionic_voltage_mode.setText(IONIC_VOLTAGE_MODE_STRING.get(value));});
                     break;
                case LABEL_TITANE_STATUS_STRING: 
                        Label titane_status = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (titane_status != null)
                           Platform.runLater(() -> {titane_status.setText(TITANE_STATUS_STRING.get(value));});
                     break;
                case LABEL_TITANE_FILAMENT_STATUS_STRING: 
                        Label titane_filament_status = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (titane_filament_status != null)
                           Platform.runLater(() -> {titane_filament_status.setText(TITANE_FILAMENT_STATUS_STRING.get(value));});
                     break;
                case LABEL_TITANE_CONTROLLER_STATUS_STRING: 
                        Label titane_controller_status = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (titane_controller_status != null)
                           Platform.runLater(() -> {titane_controller_status.setText(TITANE_CONTROLLER_STATUS_STRING.get(value));});
                     break;
                case LABEL_TITANE_RECOVER_STATUS_STRING: 
                        Label titane_recover_status = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (titane_recover_status != null)
                           Platform.runLater(() -> {titane_recover_status.setText(TITANE_RECOVER_STATUS_STRING.get(value));});
                     break;
                case LABEL_TITANE_OPERATING_MODE_STRING: 
                        Label titane_operating_mode = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (titane_operating_mode != null)
                           Platform.runLater(() -> {titane_operating_mode.setText(TITANE_OPERATING_MODE_STRING.get(value));});
                     break;
                case LABEL_TITANE_AUTOSTART_STATUS_STRING: 
                        Label titane_autostart_status = (Label) lookup("#" + data.list.elementAt(i).name);
                        if (titane_autostart_status != null)
                           Platform.runLater(() -> {titane_autostart_status.setText(TITANE_AUTOSTART_STATUS_STRING.get(value));});
                     break;
                case RGA_WEB_DATA: try {
                          if (!data.svrNameList.elementAt(i).contains("_200")) {
                             x.append(data.list.elementAt(i).name + ",");
                             y.append(value +  ",");
                          }
                          else {
                             x.append(data.list.elementAt(i).name);
                             y.append(value);
                             if (controllerweb.REFRESH_Clicked) {
                                WebView web = (WebView) lookup("#web");
                                Platform.runLater(() -> {loadBarChartData(web, name, x.toString(), y.toString());});
                                controllerweb.REFRESH_Clicked = false;
                             }
                          }
                     }  catch (NumberFormatException e) {}
                     break;
                case PLOT_DATA:  
                     try {
                          if ( plotStarted == false ) {  // Init Live Chart
                             Platform.runLater(() -> {
                                series = new XYChart.Series();
                                LineChart chart = (LineChart) lookup("#chart");
                                chart.getData().clear();
                                chart.layout();
                                chart.setTitle(svrName);
                                chart.setStyle("-fx-font-size: 11");
                                chart.getData().add(series);
                                plotStarted = true;
                             });
                          }
                          else {
                             String gpsValue =  data.svrValueList.lastElement().replace(" ", "").replace(",", ".");
                             if (gpsValue.contains("NOTEXIST"))
                                gpsValue = "---";
                             if (gpsValue.contains("TIMOUT"))
                                gpsValue = "...";
                             final String gps = gpsValue;
                             //System.out.println("GPS = " + gps + " value = " + value);
                             Platform.runLater(() -> {
                                try {
                                   series.getData().add(new XYChart.Data<String,Double>(formatGPS(gps),Double.parseDouble(value)));
                                } catch (Exception e) {}
                            
                             });
                         }
                     } catch (Exception e) {}
                     break;
                case RGA_CHART_DATA: 
                     try {
                          if (!data.svrNameList.elementAt(i).contains("_200")) {
                             if (Double.parseDouble(value) > 0)
                                xychartVect.addElement(new XYChart.Data<String,Double>(data.list.elementAt(i).name,Double.parseDouble(value)));
                             else
                                xychartVect.addElement(new XYChart.Data<String,Double>(data.list.elementAt(i).name,new Double(1e-20)));
                          }
                          else {
                             if (Double.parseDouble(value) > 0)
                                xychartVect.addElement(new XYChart.Data<String,Double>(data.list.elementAt(i).name,Double.parseDouble(value)));
                             else
                                xychartVect.addElement(new XYChart.Data<String,Double>(data.list.elementAt(i).name,new Double(1e-20)));
                             if (controllerchart.REFRESH_Clicked) {
                                Platform.runLater(() -> {
                                   BarChart chart = (BarChart) lookup("#chart");
                                   chart.getData().clear();
                                   chart.layout();
                                   chart.setTitle("RGA:" + name); 
                                   XYChart.Series series = new XYChart.Series();                                   
                                   for (int j = 0 ; j < xychartVect.size(); j++) {
                                     //System.out.println(xychartVect.elementAt(j) + ":add value=" + value);
                                     series.getData().add(xychartVect.elementAt(j));
                                     }
                                   chart.getData().add( series );
                                   for (int j = 0 ; j < xychartVect.size(); j++) {
                                        XYChart.Data<String,Double> data = (XYChart.Data<String,Double>)series.getData().get(j);
                                        Tooltip tooltip = new Tooltip();
                                        tooltip.setText("AMU " + data.getXValue() + " : " + Double.toString(data.getYValue()));
                                        Tooltip.install(data.getNode(),tooltip);
                                        data.getNode().setOnMousePressed(new EventHandler<MouseEvent>() {
                                           public void handle(MouseEvent event) {
                                              //System.out.println("Node pressed:" + data.getNode());
                                              if (event.getClickCount() == 1) {
                                                 //System.out.println("Show tooltip:" + tooltip.getText() + 
                                                 //     "(" + event.getScreenX() + "," + event.getScreenY() + ")");
                                                 tooltip.show(data.getNode(), event.getScreenX(), event.getScreenY()-100);
                                              }
                                           }
                                        });
                                        data.getNode().setOnMouseReleased(new EventHandler<MouseEvent>() {
                                           public void handle(MouseEvent event) {
                                              //System.out.println("Node released:" + data.getNode());
                                              if (event.getClickCount() == 1) {
                                                 //System.out.println("Hide tooltip:" + tooltip.getText() + 
                                                 //     "(" + event.getScreenX() + "," + event.getScreenY() + ")");
                                                 tooltip.hide();
                                              }
                                           }
                                        });
                                     }
                                controllerchart.REFRESH_Clicked = false;});
                             }
                          }
                     } catch (Exception e) {controllerchart.REFRESH_Clicked = true;}
                     break;
              case RGA_2_CHART_DATA: 
                     try {
                          if (!data.svrNameList.elementAt(i).contains("_050")) {
                             if (Double.parseDouble(value) > 0)
                                xychartVect.addElement(new XYChart.Data<String,Double>(data.list.elementAt(i).name,Double.parseDouble(value)));
                             else
                                xychartVect.addElement(new XYChart.Data<String,Double>(data.list.elementAt(i).name,new Double(1e-20)));
                          }
                          else {
                             if (Double.parseDouble(value) > 0)
                                xychartVect.addElement(new XYChart.Data<String,Double>(data.list.elementAt(i).name,Double.parseDouble(value)));
                             else
                                xychartVect.addElement(new XYChart.Data<String,Double>(data.list.elementAt(i).name,new Double(1e-20)));
                           if (controllerchart.REFRESH_Clicked) {
                                Platform.runLater(() -> {
                                   BarChart chart = (BarChart) lookup("#chart");
                                   chart.getData().clear();
                                   chart.layout();
                                   chart.setTitle("RGA:" + name); 
                                   XYChart.Series series = new XYChart.Series();                                   
                                   for (int j = 0 ; j < xychartVect.size(); j++) {
                                     //System.out.println(xychartVect.elementAt(j) + ":add value=" + value);
                                     series.getData().add(xychartVect.elementAt(j));
                                     }
                                   chart.getData().add( series );
                                   for (int j = 0 ; j < xychartVect.size(); j++) {
                                        XYChart.Data<String,Double> data = (XYChart.Data<String,Double>)series.getData().get(j);
                                        Tooltip tooltip = new Tooltip();
                                        tooltip.setText("AMU " + data.getXValue() + " : " + Double.toString(data.getYValue()));
                                        Tooltip.install(data.getNode(),tooltip);
                                        data.getNode().setOnMousePressed(new EventHandler<MouseEvent>() {
                                           public void handle(MouseEvent event) {
                                              //System.out.println("Node pressed:" + data.getNode());
                                              if (event.getClickCount() == 1) {
                                                 //System.out.println("Show tooltip:" + tooltip.getText() + 
                                                 //     "(" + event.getScreenX() + "," + event.getScreenY() + ")");
                                                 tooltip.show(data.getNode(), event.getScreenX(), event.getScreenY()-100);
                                              }
                                           }
                                        });
                                        data.getNode().setOnMouseReleased(new EventHandler<MouseEvent>() {
                                           public void handle(MouseEvent event) {
                                              //System.out.println("Node released:" + data.getNode());
                                              if (event.getClickCount() == 1) {
                                                 //System.out.println("Hide tooltip:" + tooltip.getText() + 
                                                 //     "(" + event.getScreenX() + "," + event.getScreenY() + ")");
                                                 tooltip.hide();
                                              }
                                           }
                                        });
                                     }
                                controllerchart.REFRESH_Clicked = false;});
                             }
                          }
                     } catch (Exception e) {controllerchart.REFRESH_Clicked = true;}
                     break;
             }
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
            this.hide();
            MobileApplication.getInstance().showLayer("SERVER_KO");
            setMouseTransparent(true);
         });
         serverError = true;
      }
      catch (IOException e) {
         e.printStackTrace();
         Platform.runLater(() -> {
            this.hide();
            MobileApplication.getInstance().showLayer("NETWORK_ERROR");
            setMouseTransparent(true);
         });
         connectionError = true;
      }
      catch (Exception e) {e.printStackTrace();}
    }

    public void loadBarChartData(WebView web, String title, String x, String y) {
       
       String oldContent = "";
       BufferedReader reader = null;
       try {
          reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/barchart.html")));
          String line = null; 
          while ((line = reader.readLine()) != null) 
             oldContent = oldContent + line + System.lineSeparator();
          String newContent = oldContent.replaceAll("text: \'\'", "text: \'" + title + "\'");
          newContent = newContent.replaceAll("categories:", "categories: [" + x + "]");
          newContent = newContent.replaceAll("data:", "data: [" + y + "]");
          //System.out.println(newContent);
          web.getEngine().loadContent(newContent);
       }
       catch (IOException e)  {
           e.printStackTrace();
       }
       finally {
          try {
             reader.close();
          } 
          catch (IOException e) {
               e.printStackTrace();
          }
       }
    }

    public void run() {
       System.out.println(fxml + " " + name + ": started thread");
       while (true) {
          if (isSuspended == false || isStarted == true) {
             updateViewData();            
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
    // Utility method
     private String formatGPS(String gps) {
        Date gpsInit;
        try{
           String ds = "06/01/1980";
           DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
           gpsInit = df.parse(ds);
           long difference = Integer.parseInt(gps) + gpsInit.getTime()/1000;
           String pattern = "HH:mm:ss";
           SimpleDateFormat utcFormat = new SimpleDateFormat(pattern);
           Date utcNow = new Date(difference*1000);
           return utcFormat.format(utcNow);
        }
        catch(Exception e) {
        }
        
        return null;
    }
}
