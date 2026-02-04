package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import com.gluonhq.charm.glisten.layout.Layer;
import com.gluonhq.charm.glisten.animation.BounceInDownTransition;
import com.gluonhq.charm.glisten.animation.BounceOutDownTransition;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

public class LayerMessage extends Layer {

    private BorderPane backgroundPane;
    private Label label;

    public LayerMessage(String fxml, String message, boolean isAutoHide) {   
        try {     
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("/" + fxml + ".fxml"));
           label =  (Label) loader.load();
           backgroundPane = new BorderPane();
           backgroundPane.setCenter(label);
           setBackgroundFade(0.3);
           backgroundPane.setBackground(Background.EMPTY);
           getChildren().addAll(backgroundPane);
           label.setText(message);
        }
        catch (IOException e) {
           e.printStackTrace();
        }
        setAutoHide(false);
        setShowTransitionFactory(BounceInDownTransition::new);
        setHideTransitionFactory(BounceOutDownTransition::new);
        if ( isAutoHide == true ) {
           setOnShown( e -> { 
              PauseTransition pause = new PauseTransition(Duration.seconds(1));
              pause.setOnFinished(f -> {this.hide();});
              pause.play(); 
           });
        }
        System.out.println("Created layer message " + fxml);
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
}
