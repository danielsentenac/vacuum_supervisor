package com.gluonapplication;


import com.gluonhq.charm.glisten.control.Dialog;
import javafx.scene.control.Button; 


public class DialogRefusedMastership extends Dialog {

    public DialogRefusedMastership() {  
       setTitleText("Authorization refused"); 
       setAutoHide(true);
       Button okButton = new Button("OK");
       okButton.setOnAction(e -> {hide();});
       getButtons().add(okButton);
       showAndWait();
    }
}
