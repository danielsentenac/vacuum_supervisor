package com.gluonapplication;

import com.gluonhq.charm.glisten.control.Dialog;
import javafx.scene.control.Button; 
import javafx.scene.control.Label;

public class DialogOverTakeMastership extends Dialog {

    private ControlCommand master = ControlCommand.getInstance();

    public DialogOverTakeMastership(String reason) {   
       setTitleText("Mastership used by:" + reason);
       setAutoHide(true);
       setContent(new Label("Want to take over ?"));
       Button yesButton = new Button("YES");
       Button noButton = new Button("NO");
       yesButton.setOnAction(e -> {
          hide(); 
          master.getMastership("TakeMastership");
       });
       noButton.setOnAction(e -> {hide(); });
       getButtons().addAll(yesButton, noButton);
       showAndWait();
    }
}
