package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.Dialog;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
   Login to the Virgo firewall portal from the application, to reach the
   backend from outside Virgo. The login is stored and, when asked, used
   again automatically each time the backend is not reached.
*/
public class DialogPortalLogin extends Dialog {

    private static boolean showing = false;

    /** Opens the dialog, unless it is already open. Call from the JavaFX thread. */
    public static void open() {
        if (showing) return;
        showing = true;
        // The outage messages would cover the dialog: they are shown again every second
        LayerMessage.suppressed = true;
        MobileApplication.getInstance().hideLayer("NETWORK_ERROR");
        MobileApplication.getInstance().hideLayer("SERVER_KO");
        try {
            new DialogPortalLogin();
        } finally {
            LayerMessage.suppressed = false;
            showing = false;
        }
    }

    private DialogPortalLogin() {
        setTitleText("Virgo firewall login");
        setAutoHide(false);

        TextField user = new TextField(PortalAccess.user());
        user.setPromptText("Login");
        PasswordField password = new PasswordField();
        password.setText(PortalAccess.password());
        password.setPromptText("Password");
        TextField portal = new TextField(PortalAccess.portalUrl());
        portal.setPromptText("https://...");
        TextField cert = new TextField(PortalAccess.certName());
        cert.setPromptText("only if it is not the name in the address");
        CheckBox auto = new CheckBox("Log in automatically at startup and when the server is not reached");
        auto.setSelected(PortalAccess.auto());
        auto.setWrapText(true);

        Label status = new Label();
        status.setWrapText(true);
        if (PortalAccess.refused()) {
            status.setText("The portal refused this login. Automatic login is stopped until you save it again.");
        } else {
            status.setText(PortalAccess.lastMessage());
        }
        Label note = new Label("The login and its password are kept on this device, in the application's private storage, "
                + "not encrypted. The password is sent only to the portal address, over a verified HTTPS connection.");
        note.setWrapText(true);
        note.setStyle("-fx-font-size: 11;");

        // The portal itself is built in: its address is shown only on request
        Label portalLabel = new Label("Address of the firewall portal login page");
        Label certLabel = new Label("Name on the portal certificate");
        CheckBox advanced = new CheckBox("Show the portal address");
        for (javafx.scene.Node n : new javafx.scene.Node[] {portalLabel, portal, certLabel, cert}) {
            n.visibleProperty().bind(advanced.selectedProperty());
            n.managedProperty().bind(advanced.selectedProperty());
        }

        VBox content = new VBox(4,
                new Label("Login"), user,
                new Label("Password"), password,
                auto, status, note,
                advanced, portalLabel, portal, certLabel, cert);
        content.setPrefWidth(320);
        setContent(content);

        Button loginButton = new Button("LOG IN");
        Button saveButton = new Button("SAVE");
        Button closeButton = new Button("CLOSE");
        loginButton.setDefaultButton(true);

        Runnable save = () -> PortalAccess.save(portal.getText(), cert.getText(), user.getText(), password.getText(),
                auto.isSelected());

        saveButton.setOnAction(e -> {
            save.run();
            hide();
        });
        closeButton.setOnAction(e -> hide());
        loginButton.setOnAction(e -> {
            save.run();
            loginButton.setDisable(true);
            saveButton.setDisable(true);
            status.setText("Logging in to the portal...");
            Thread t = new Thread(() -> {
                PortalLogin.Result r;
                try {
                    r = PortalAccess.login();
                } catch (Throwable ex) {
                    r = new PortalLogin.Result(false, String.valueOf(ex), false);
                }
                final PortalLogin.Result result = r;
                Platform.runLater(() -> {
                    status.setText((result.ok ? "Logged in: " : "Login failed: ") + result.message);
                    loginButton.setDisable(false);
                    saveButton.setDisable(false);
                    if (result.ok) {
                        PauseTransition pause = new PauseTransition(Duration.seconds(1.5));
                        pause.setOnFinished(f -> hide());
                        pause.play();
                    }
                });
            }, "portal-login-dialog");
            t.setDaemon(true);
            t.start();
        });
        getButtons().addAll(loginButton, saveButton, closeButton);
        showAndWait();
    }
}
