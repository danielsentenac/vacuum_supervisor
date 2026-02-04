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
import java.net.URLConnection; //for url management 
import java.net.URL;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.lang.Runnable;
import java.net.MalformedURLException;
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
