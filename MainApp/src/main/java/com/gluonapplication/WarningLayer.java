package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.scene.layout.Background;
import com.gluonhq.charm.glisten.layout.Layer;

public class WarningLayer extends Layer {

    private BorderPane backgroundPane;
    private Pane panel;

    public WarningLayer(String name) {   
        try {     
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("/" + name + ".fxml"));
           Pane pane =  (Pane) loader.load();
           backgroundPane = new BorderPane();
           backgroundPane.setCenter(pane);
           setBackgroundFade(0.3);
           backgroundPane.setBackground(Background.EMPTY);
           getChildren().addAll(backgroundPane);
        }
        catch (IOException e) {
           e.printStackTrace();
        }
    }
    @Override
    public void layoutChildren() {
        super.layoutChildren();
        backgroundPane.setVisible(isShowing());
        if (!isShowing()) {
            return;
        }
        backgroundPane.resize(300, 150);
        resizeRelocate((MobileApplication.getInstance().getGlassPane().getWidth() - 300)/2,          (MobileApplication.getInstance().getGlassPane().getHeight()- 150)/2, 300, 150);
    }
}
