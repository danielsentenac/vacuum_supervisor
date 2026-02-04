package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import javafx.scene.Node;
import javafx.scene.chart.BarChart; 
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.web.WebView; 
import javafx.scene.web.WebEngine;



public class LayerPlot extends LayerData {

    public LayerPlot(String _fxml, String _name) {
        super(_fxml, _name);
        data = new DataSetPlot(_name);
    }

    @Override
    public void layoutChildren() {
        super.layoutChildren();
        backgroundPane.setVisible(isShowing());
        if (!isShowing()) {
            return;
        }
        backgroundPane.resize(300, 300);
        resizeRelocate((MobileApplication.getInstance().getGlassPane().getWidth() - 300)/2,
        (MobileApplication.getInstance().getGlassPane().getHeight()- 300)/2, 300, 300);
    }
}
