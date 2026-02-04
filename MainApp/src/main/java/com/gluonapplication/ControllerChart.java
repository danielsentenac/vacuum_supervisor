package com.gluonapplication;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.CategoryAxis;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import javafx.util.StringConverter;
import javafx.event.EventHandler;
import javafx.scene.input.ScrollEvent;
import org.gillius.jfxutils.chart.JFXChartUtil;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.input.ZoomEvent;
import javafx.scene.control.Tooltip;
import javafx.scene.Node; 
import java.util.Vector;

public class ControllerChart {

    final double SCALE_DELTA = 1.1;

    private double scaleX;

    private double scaleY;

    public boolean REFRESH_Clicked;

    @FXML
    private BarChart chart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private LogarithmicAxis yAxis;

    public void initialize() {
      
      REFRESH_Clicked = true;
      chart.setLegendVisible(false);
      xAxis.setLabel("AMU");
      yAxis.setLabel("LN2 Eq. Level");
      scaleX = chart.getParent().getScaleX(); // to revert the changes
      scaleY = chart.getParent().getScaleY();

      chart.setOnScroll(new EventHandler<ScrollEvent>() {
         @Override public void handle(ScrollEvent event) {
            if (!event.isInertia()) {
                  chart.getParent().setTranslateX(chart.getParent().getTranslateX() + event.getDeltaX());
                  chart.getParent().setTranslateY(chart.getParent().getTranslateY() + event.getDeltaY());
            }
            event.consume();
         }
      });     
      chart.setOnTouchPressed(new EventHandler<TouchEvent>() {
         @Override public void handle(TouchEvent event) {
            if (event.getEventType() == TouchEvent.TOUCH_STATIONARY) {
               chart.getParent().setScaleX(chart.getParent().getScaleX());
               chart.getParent().setScaleY(chart.getParent().getScaleY());
            }
            event.consume();
         }
      });
      chart.setOnZoom(new EventHandler<ZoomEvent>() {
          @Override
          public void handle(ZoomEvent event) {
              if (chart.getParent().getScaleX()*event.getZoomFactor() > scaleX)
                 chart.getParent().setScaleX(chart.getParent().getScaleX()*event.getZoomFactor());
              if (chart.getParent().getScaleY()*event.getZoomFactor() > scaleY)
                 chart.getParent().setScaleY(chart.getParent().getScaleY()*event.getZoomFactor());
              event.consume();
          }
       });
      chart.setOnMousePressed(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {
           if (event.getClickCount() == 2) {
              chart.getParent().setScaleX(1.0);
              chart.getParent().setScaleY(1.0);
              chart.getParent().setTranslateX(0);
              chart.getParent().setTranslateY(0);
           }
           event.consume();
        }
      });

    } 

    public ControllerChart () {
       xAxis = new CategoryAxis();
       yAxis = new LogarithmicAxis();
       chart = new BarChart(xAxis,yAxis);
    }

}

