package com.gluonapplication;

import com.gluonhq.charm.glisten.control.Dialog;
import javafx.scene.control.Button; 
import javafx.scene.control.TextField;

public class DialogAskValue extends Dialog {

    private ControlCommand master = ControlCommand.getInstance();

    public DialogAskValue(String msgChannel) {
       // IONIC IPCMINI COMMANDS (SCADARPI racks)
       if (msgChannel.endsWith("_IPC_P33PRTCUR"))
          setTitleText("Protect Current [1,10000] uA:");
       else if (msgChannel.endsWith("_IPC_P33MAXVOLT"))
          setTitleText("Target Voltage [3000,7000] V:");
       else if (msgChannel.endsWith("_IPC_P33MAXW"))
          setTitleText("Max Power [10,40] W:");
       // IONIC COMMANDS
       else if (msgChannel.contains("P33OP") ||
           msgChannel.contains("P81OP") ||
           msgChannel.contains("P33EOP") ||
           msgChannel.contains("P33IOP") )
          setTitleText("Start=1, Protect=2:");
       else if (msgChannel.contains("P33VOLT") ||
                msgChannel.contains("P81VOLT") ||
                msgChannel.contains("P33EVOLT") ||
                msgChannel.contains("P33IVOLT") )
          setTitleText("Fixed=1, Stepped=2:");
       // TITANE COMMANDS
       /*else if (msgChannel.contains("P31OP") ||
                msgChannel.contains("P32OP") ||
                msgChannel.contains("P31EO") ||
                msgChannel.contains("P32EO") ||
                msgChannel.contains("P31IO") ||
                msgChannel.contains("P32IO"))
          setTitleText("Manual=0, Automatic=1, Remote=2, Auto/Remote=3");  NOT IMPLEMENTED IN PLC */
       
       else
           setTitleText("Enter value:");
       setAutoHide(true);
       TextField askedValue = new TextField();
       setContent(askedValue);
       Button okButton = new Button("OK");
       okButton.setDefaultButton(true);
       okButton.setOnAction(e -> {hide(); master.setAskedValue(askedValue.getText());});
       getButtons().add(okButton);
       Button cancelButton = new Button("CANCEL");
       cancelButton.setDefaultButton(true);
       cancelButton.setOnAction(e -> {hide();});
       getButtons().add(cancelButton);
       showAndWait();
    }
}
