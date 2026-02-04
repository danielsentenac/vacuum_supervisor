package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.input.MouseEvent;

public class ControllerCryoLinkActions implements ControlTypes {

    @FXML
    private Label ViewName;

    @FXML
    private Label RefillMode;

    private String style = "";

    String name = "";

    private ControlCommand master = ControlCommand.getInstance();

    @FXML
    public void initialize() {
       ViewData presentView = (ViewData) MobileApplication.getInstance().getView();
       name = presentView.name.replace("Actions","");
    }

    @FXML
    void RefillMode_Clicked(MouseEvent event) {
       master.setCommand("ModbusVac", "SETREGISTER", "VAC_" + name, 
                         CRYOLINKACTIONS_COMMAND_CHANNELS.get("RefillMode"), "", 2000, true, "Authorize", true);  // SET VALUE (TO BE ASKED)
    }

    @FXML
    void RefillMode_Pressed(MouseEvent event) {
       style = RefillMode.getStyle();
       RefillMode.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void RefillMode_Released(MouseEvent event) {
       RefillMode.setStyle(style);
    }

}

