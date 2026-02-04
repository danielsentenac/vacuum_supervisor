package com.gluonapplication;

import com.gluonhq.charm.glisten.control.Dialog;
import javafx.scene.control.Button; 
import javafx.scene.control.PasswordField;

public class DialogAskMastership extends Dialog {

    private ControlCommand master = ControlCommand.getInstance();

    public DialogAskMastership(String query) { 
       if (query.equals("PrivilegeAccess"))  
          setTitleText("Enter Privilege Access password:");
       else  
          setTitleText("Enter Mastership password:");
     
       setAutoHide(true);
       PasswordField password = new PasswordField();
       setContent(password);
       Button okButton = new Button("OK");
       okButton.setDefaultButton(true);
       okButton.setOnAction(e -> {hide(); master.getMastership(password.getText());});
       getButtons().add(okButton);
       showAndWait();
    }
}
