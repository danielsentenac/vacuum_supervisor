package com.gluonapplication;

import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.Icon;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import com.gluonhq.charm.glisten.control.TimePicker;
import com.gluonhq.charm.glisten.control.DatePicker;


public class BasicView extends View {

    public BasicView() {
        
        TimePicker timepicker = new TimePicker();
        DatePicker datepicker = new DatePicker();
        Button buttonDate = new Button("Select Date");
        Button buttonTime = new Button("Select Time");
        buttonDate.setGraphic(new Icon(MaterialDesignIcon.LANGUAGE));
        buttonTime.setGraphic(new Icon(MaterialDesignIcon.LANGUAGE));
        buttonDate.setOnAction(e -> datepicker.showAndWait().ifPresent(System.out::println));
        buttonTime.setOnAction(e -> timepicker.showAndWait().ifPresent(System.out::println));
        VBox controls = new VBox(15.0, buttonDate, buttonTime);
        controls.setAlignment(Pos.CENTER);
        
        setCenter(controls);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> System.out.println("Menu")));
        appBar.setTitleText("Basic View");
        appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e -> System.out.println("Search")));
    }
    
}
