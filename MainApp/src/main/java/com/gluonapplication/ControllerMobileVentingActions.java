package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ControllerMobileVentingActions implements ControlTypes {

    @FXML
    private Label ViewName;

    @FXML
    private Label OpExecute;

    @FXML
    private Label OpStop;

    @FXML
    private Label OpStep;

    private String style = "";
    private String name = "";

    private final ControlCommand master = ControlCommand.getInstance();

    @FXML
    public void initialize() {
       ViewData presentView = (ViewData) MobileApplication.getInstance().getView();
       name = presentView.name.replace("Actions", "");
    }

    @FXML
    void OpExecute_Clicked(MouseEvent event) {
       if (OpExecute.getText().equals("OFF")) {
          master.setCommand("Lab1500NVac1", "SETREGISTER", "VAC_" + name,
                  MOBILEVENTINGACTIONS_COMMAND_CHANNELS.get("OpExecute"),
                  "1", 2000, true, "Authorize", true);
       } else if (OpExecute.getText().equals("ACTIVE")) {
          master.setCommand("Lab1500NVac1", "SETREGISTER", "VAC_" + name,
                  MOBILEVENTINGACTIONS_COMMAND_CHANNELS.get("OpExecute"),
                  "0", 2000, true, "Authorize", true);
       }
    }

    @FXML
    void OpExecute_Pressed(MouseEvent event) {
       style = OpExecute.getStyle();
       OpExecute.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void OpExecute_Released(MouseEvent event) {
       OpExecute.setStyle(style);
    }

    @FXML
    void OpStop_Clicked(MouseEvent event) {
       if (OpStop.getText().equals("OFF")) {
          master.setCommand("Lab1500NVac1", "SETREGISTER", "VAC_" + name,
                  MOBILEVENTINGACTIONS_COMMAND_CHANNELS.get("OpStop"),
                  "1", 2000, true, "Authorize", true);
       } else if (OpStop.getText().equals("ACTIVE")) {
          master.setCommand("Lab1500NVac1", "SETREGISTER", "VAC_" + name,
                  MOBILEVENTINGACTIONS_COMMAND_CHANNELS.get("OpStop"),
                  "0", 2000, true, "Authorize", true);
       }
    }

    @FXML
    void OpStop_Pressed(MouseEvent event) {
       style = OpStop.getStyle();
       OpStop.setStyle(DECORATION_STYLE_PUSHED);
    }

    @FXML
    void OpStop_Released(MouseEvent event) {
       OpStop.setStyle(style);
    }
}
