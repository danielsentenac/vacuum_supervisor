package com.gluonapplication;

import javafx.fxml.FXML;
import javafx.scene.web.WebView; 
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;


public class ControllerWeb implements ControlTypes {

    
    @FXML
    private WebView web;

    @FXML
    private Label REFRESH;

    public boolean REFRESH_Clicked;
    
    String style = "";

    @FXML
    public void initialize() {
       REFRESH_Clicked = true;
       web.setContextMenuEnabled(true);
       web.getEngine().setJavaScriptEnabled(true);
    }

    @FXML
    void REFRESH_Clicked(MouseEvent event) {
      REFRESH_Clicked = true;
    }

    @FXML
    void REFRESH_Pressed(MouseEvent event) {
       style = REFRESH.getStyle();
       REFRESH.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void REFRESH_Released(MouseEvent event) {
       REFRESH.setStyle(style);
    }
}




