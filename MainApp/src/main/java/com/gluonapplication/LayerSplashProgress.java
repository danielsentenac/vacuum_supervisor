package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.layout.Layer;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class LayerSplashProgress extends Layer {

    private final BorderPane backgroundPane;
    private final ProgressBar progressBar;
    private final Label progressLabel;

    public LayerSplashProgress() {
        Label title = new Label("Vacuum Supervisor");
        title.setStyle("-fx-text-fill: #d1d1e0; -fx-font-size: 22; -fx-font-weight: bold;");
        progressLabel = new Label("Starting...");
        progressLabel.setStyle("-fx-text-fill: #d1d1e0; -fx-font-size: 14;");
        progressBar = new ProgressBar(0.0);
        progressBar.setPrefWidth(260);
        progressBar.setMaxWidth(260);
        VBox content = new VBox(12, title, progressBar, progressLabel);
        content.setAlignment(Pos.CENTER);

        backgroundPane = new BorderPane();
        backgroundPane.setCenter(content);
        backgroundPane.setBackground(new Background(new BackgroundFill(Color.web("#333333"), CornerRadii.EMPTY, Insets.EMPTY)));

        setBackgroundFade(0.0);
        getChildren().add(backgroundPane);
        setAutoHide(false);
    }

    public void setProgress(double progress, String message) {
        Platform.runLater(() -> {
            progressBar.setProgress(progress);
            if (message != null && !message.isEmpty()) {
                progressLabel.setText(message);
            }
        });
    }

    @Override
    public void layoutChildren() {
        super.layoutChildren();
        backgroundPane.setVisible(isShowing());
        if (!isShowing()) {
            return;
        }
        double width = MobileApplication.getInstance().getGlassPane().getWidth();
        double height = MobileApplication.getInstance().getGlassPane().getHeight();
        backgroundPane.resize(width, height);
        resizeRelocate(0, 0, width, height);
    }
}
