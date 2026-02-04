package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import java.net.URLConnection; //for url management 
import java.net.URL;
import java.io.IOException;
import java.lang.Runnable;
import java.net.MalformedURLException;
import java.lang.Thread;
import java.util.Vector;
import javafx.application.Platform;
import java.net.URLConnection; //for url management 
import java.net.URL;
import java.io.ObjectInputStream; //for stream management
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import javafx.collections.ObservableList;
import javafx.animation.PauseTransition;
import javafx.util.Duration;
import com.gluonhq.charm.down.Services;
import java.time.ZonedDateTime;
import com.gluonhq.charm.down.plugins.DisplayService;
import com.gluonhq.charm.down.plugins.LocalNotificationsService;
import com.gluonhq.charm.down.plugins.Notification;
import javafx.scene.control.Alert.AlertType;
import com.gluonhq.charm.glisten.control.Alert;


public class NotificationData implements Runnable, DataTypes {
    
    private URLConnection con;
    private int initCnt = 0;
    private int max_fr = 3;
    public DataSet data;
    public String name = "";
    public boolean connectionError = false;
    private String notificationId = "";

    public NotificationData(String _name) {
        name = _name;
        notificationId = name;
    }
    /**
       A connection method called every time a connection to the servlet is needed. 
       The servlet path points to "jchv" which contains the main servlet 
       for channel visualization.
    */
    protected URLConnection getServerConnection(String url)
            throws MalformedURLException, IOException {
        //System.out.println(getCodeBase() + " " + getDocumentBase());
        URL urlServlet = new URL(url);
        URLConnection con = urlServlet.openConnection();
        con.setConnectTimeout(10000);
        con.setDoInput(true);
        con.setDoOutput(true);
        con.setUseCaches(false);
        con.setRequestProperty("Content-Type", "application/x-java-serialized-object");
        return con;
    }

     protected void updateViewData() {
      try {
         // send data to the servlet
         URLConnection con = getServerConnection("http://online-data-provider.example:8081/jchv/jchv");
         OutputStream outstream = con.getOutputStream();
         ObjectOutputStream oos = new ObjectOutputStream(outstream);
         oos.writeObject(data.svrNameList);
         oos.flush();
         oos.close();
         //System.out.println(data.svrNameList);
         // receive result from servlet
         InputStream instr = con.getInputStream();
         ObjectInputStream inputFromServlet = new ObjectInputStream(instr);
         data.svrValueList = (Vector <String> ) inputFromServlet.readObject();
         inputFromServlet.close();
         instr.close();

         if ( initCnt++ < max_fr) return; // First cycle data sent by Alp maybe corrupted!!

         //System.out.println(data.svrValueList);
         for (int i = 0 ; i < data.list.size(); ++i ) {
             String svrValue =  data.svrValueList.elementAt(i).replace(" ", "").replace(",", ".");
             String svrUnits = " " + data.svrUnitsList.elementAt(i);
             //System.out.println(i + " " + data.list.elementAt(i).name + "=" + svrValue + " " + svrUnits);
             if (svrValue.contains("NOTEXIST")) {
                svrValue = "---";
                svrUnits = " ";
             } 
             if (svrValue.contains("TIMOUT")) {
                svrValue = "---";
                svrUnits = " ";
             }
             final String value = svrValue;
             final String units = svrUnits;
             switch (data.list.elementAt(i).type) {
                case LABEL_TURBO_BOX_STATUS_STRING:
                     if (!value.equals("0") && !value.equals("---") && !value.equals("255")) {
                        try {
                           String notificationId = "TURBO_BOX:" +data.list.elementAt(i).name;
                           Services.get(LocalNotificationsService.class).ifPresent(service -> {
                              boolean alreadyExisting = false;
                              for(Notification notification: service.getNotifications()) {
                                 if (notification.getId().equals(notificationId)) {
                                    alreadyExisting = true;
                                    break;
                                 }
                              }
                              if ( alreadyExisting == false && TURBO_BOX_STATUS_STRING.get(value) != null) {
                                 System.out.println("CREATING NOTIFICATION TURBO_BOX:" + notificationId);
                                 try {Thread.sleep(1000);} catch (Exception e){}
                                 service.getNotifications().add( new Notification(notificationId, notificationId + 
                                                                          "(" + TURBO_BOX_STATUS_STRING.get(value) + ")", 
                                                                          ZonedDateTime.now().plusSeconds(10), () -> {
                                     Alert alert = new Alert(AlertType.WARNING, notificationId + 
                                                                          "(" + TURBO_BOX_STATUS_STRING.get(value) + ")");
                                     Platform.runLater(() -> alert.showAndWait());
                                 }));
                               }
                           });
                         }
                         catch (Exception e){}
                     }
                     break;
                case LABEL_TURBO_TEMP_STATUS_STRING:
                     if (!value.equals("0") && !value.equals("---") && !value.equals("255")) {
                        try {
                           String notificationId = "TURBO_TEMP:" + data.list.elementAt(i).name;
                           Services.get(LocalNotificationsService.class).ifPresent(service -> {
                              boolean alreadyExisting = false;
                              for(Notification notification: service.getNotifications()) {
                                 if (notification.getId().equals(notificationId)) {
                                    alreadyExisting = true;
                                    break;
                                 }
                              }
                              if ( alreadyExisting == false && TURBO_TEMP_STATUS_STRING.get(value) != null) {
                                 System.out.println("CREATING NOTIFICATION TURBO_TEMP:" + notificationId);
                                 try {Thread.sleep(2000);} catch (Exception e){}
                                 service.getNotifications().add( new Notification(notificationId, notificationId + 
                                                                          "(" + TURBO_TEMP_STATUS_STRING.get(value) + ")", 
                                                                          ZonedDateTime.now().plusSeconds(10), () -> {
                                     Alert alert = new Alert(AlertType.WARNING, notificationId + 
                                                                          "(" + TURBO_TEMP_STATUS_STRING.get(value) + ")");
                                     Platform.runLater(() -> alert.showAndWait());
                                 }));
                               }
                           });
                         }
                         catch (Exception e){}
                     }
                     break;
                case LABEL_TURBO_TEMP_BOX_STATUS_STRING:
                     if (!value.equals("0") && !value.equals("---") && !value.equals("255")) {
                        try {
                           String notificationId = "TURBO_TEMP_BOX:" + data.list.elementAt(i).name;
                           Services.get(LocalNotificationsService.class).ifPresent(service -> {
                              boolean alreadyExisting = false;
                              for(Notification notification: service.getNotifications()) {
                                 if (notification.getId().equals(notificationId)) {
                                    alreadyExisting = true;
                                    break;
                                 }
                              }
                              if ( alreadyExisting == false && TURBO_TEMP_BOX_STATUS_STRING.get(value) != null) {
                                 System.out.println("CREATING NOTIFICATION TURBO_TEMP_BOX:" + notificationId);
                                 try {Thread.sleep(3000);} catch (Exception e){}
                                 service.getNotifications().add( new Notification(notificationId, notificationId + 
                                                                          "(" + TURBO_TEMP_BOX_STATUS_STRING.get(value) + ")", 
                                                                          ZonedDateTime.now().plusSeconds(10), () -> {
                                     Alert alert = new Alert(AlertType.WARNING, notificationId + 
                                                                          "(" + TURBO_TEMP_BOX_STATUS_STRING.get(value) + ")");
                                     Platform.runLater(() -> alert.showAndWait());
                                 }));
                               }
                           });
                        }
                        catch (Exception e){}
                     }
                     break;
                case LABEL_TURBO_POWER_STATUS_STRING:
                     if (!value.equals("---") && !value.equals("255")) {
                        try {
                           int valueInt = Integer.parseInt(value); 
                           if (valueInt >=  data.list.elementAt(i).max) { 
                              String notificationId = "TURBO_POWER:" + data.list.elementAt(i).name;
                              Services.get(LocalNotificationsService.class).ifPresent(service -> {
                                 boolean alreadyExisting = false;
                                 for(Notification notification: service.getNotifications()) {
                                    if (notification.getId().equals(notificationId)) {
                                       alreadyExisting = true;
                                       break;
                                    }
                                 }
                                 if ( alreadyExisting == false) { 
                                    System.out.println("CREATING NOTIFICATION TURBO_POWER:" + notificationId);
                                    try {Thread.sleep(4000);} catch (Exception e){}
                                    service.getNotifications().add( new Notification(notificationId, notificationId + 
                                                                          "(" + TURBO_POWER_STATUS_STRING.get("1") + "-> " + value + " Watt)", 
                                                                          ZonedDateTime.now().plusSeconds(10), () -> {
                                       Alert alert = new Alert(AlertType.WARNING, notificationId + 
                                                                          "(" + TURBO_POWER_STATUS_STRING.get("1") + "-> " + value + " Watt)");
                                       Platform.runLater(() -> alert.showAndWait());
                                    }));
                                  }
                              });
                            }
                         }
                         catch (Exception e){}
                     }
                     break;
                case LABEL_GOLDEN_STATUS_STRING:
                     if (!value.equals("1") && !value.equals("---") && !value.equals("255")) {
                        try {
                           String notificationId = "GOLDEN:" + data.list.elementAt(i).name;
                           Services.get(LocalNotificationsService.class).ifPresent(service -> {
                              boolean alreadyExisting = false;
                              for(Notification notification: service.getNotifications()) {
                                 if (notification.getId().equals(notificationId)) {
                                    alreadyExisting = true;
                                    break;
                                 }
                              }
                              if ( alreadyExisting == false && GOLDEN_STATUS_STRING.get(value)!= null) {
                                 try {Thread.sleep(10000);} catch (Exception e){}
                                 System.out.println("CREATING NOTIFICATION GOLDEN ALERT:" + notificationId);
                                 service.getNotifications().add( new Notification(notificationId, notificationId + 
                                                                          "(" + GOLDEN_STATUS_STRING.get(value) + ")",  
                                                                          ZonedDateTime.now().plusSeconds(10), () -> {
                                     Alert alert = new Alert(AlertType.WARNING, notificationId + 
                                                                          "(" + GOLDEN_STATUS_STRING.get(value) + ")");
                                     Platform.runLater(() -> alert.showAndWait());
                                 }));
                              }
                           });
                         }
                         catch (Exception e){}
                     }
                     break;
                 case LABEL_RACK_STATUS_STRING:
                     if (!value.equals("0") && !value.equals("---") && !value.equals("255")) {
                        try {
                           String notificationId = "RACK:" + data.list.elementAt(i).name;
                           Services.get(LocalNotificationsService.class).ifPresent(service -> {
                              boolean alreadyExisting = false;
                              for(Notification notification: service.getNotifications()) {
                                 if (notification.getId().equals(notificationId)) {
                                    alreadyExisting = true;
                                    break;
                                 }
                              }
                              if ( alreadyExisting == false && RACK_STATUS_STRING.get(value)!= null ) {
                                 try {Thread.sleep(6000);} catch (Exception e){}
                                 System.out.println("CREATING NOTIFICATION RACK ALERT:" + notificationId);
                                 service.getNotifications().add( new Notification(notificationId, notificationId + 
                                                                          "(" + RACK_STATUS_STRING.get(value) + ")",  
                                                                          ZonedDateTime.now().plusSeconds(10), () -> {
                                     Alert alert = new Alert(AlertType.WARNING, notificationId + 
                                                                          "(" + RACK_STATUS_STRING.get(value) + ")");
                                     Platform.runLater(() -> alert.showAndWait());
                                 }));
                               }
                           });
                        } 
                         catch (Exception e){}
                     }
                     break;
                  case LABEL_VALVE_STATUS_STRING:
                     if (!value.equals("1") && !value.equals("2") && !value.equals("---") && !value.equals("255")) {
                        try {
                           String notificationId = "VALVE:" + data.list.elementAt(i).name;
                           Services.get(LocalNotificationsService.class).ifPresent(service -> {
                              boolean alreadyExisting = false;
                              for(Notification notification: service.getNotifications()) {
                                 if (notification.getId().equals(notificationId)) {
                                    alreadyExisting = true;
                                    break;
                                 }
                              }
                              if ( alreadyExisting == false && VALVE_STATUS_STRING.get(value)!= null ) {
                                 try {Thread.sleep(7000);} catch (Exception e){}
                                 System.out.println("CREATING NOTIFICATION VALVE ALERT:" + notificationId);
                                 service.getNotifications().add( new Notification(notificationId, notificationId + 
                                                                          "(" + VALVE_STATUS_STRING.get(value) + ")",  
                                                                          ZonedDateTime.now().plusSeconds(10), () -> {
                                     Alert alert = new Alert(AlertType.WARNING, notificationId + 
                                                                          "(" + VALVE_STATUS_STRING.get(value) + ")");
                                     Platform.runLater(() -> alert.showAndWait());
                                 }));
                               }
                           });
                        } 
                         catch (Exception e){}
                     }
                     break;
                 case LABEL_OKFAILURE_STATUS_STRING:
                     if (value.equals("1") ) {
                        try {
                           String notificationId = data.list.elementAt(i).name;
                           Services.get(LocalNotificationsService.class).ifPresent(service -> {
                              boolean alreadyExisting = false;
                              for(Notification notification: service.getNotifications()) {
                                 if (notification.getId().equals(notificationId)) {
                                    alreadyExisting = true;
                                    break;
                                 }
                              }
                              if ( alreadyExisting == false && OKFAILURE_STATUS_STRING.get(value)!= null ) {
                                 try {Thread.sleep(8000);} catch (Exception e){}
                                 System.out.println("CREATING NOTIFICATION OKFAILURE ALERT:" + notificationId);
                                 service.getNotifications().add( new Notification(notificationId, notificationId + 
                                                                          "(" + OKFAILURE_STATUS_STRING.get(value) + ")",  
                                                                          ZonedDateTime.now().plusSeconds(10), () -> {
                                     Alert alert = new Alert(AlertType.WARNING, notificationId + 
                                                                          "(" + OKFAILURE_STATUS_STRING.get(value) + ")");
                                     Platform.runLater(() -> alert.showAndWait());
                                 }));
                               }
                           });
                        } 
                         catch (Exception e){}
                     }
                     break;
                 case LABEL_FAILUREOK_STATUS_STRING:
                     if (value.equals("0")) {
                        try {
                           String notificationId = data.list.elementAt(i).name;
                           Services.get(LocalNotificationsService.class).ifPresent(service -> {
                              boolean alreadyExisting = false;
                              for(Notification notification: service.getNotifications()) {
                                 if (notification.getId().equals(notificationId)) {
                                    alreadyExisting = true;
                                    break;
                                 }
                              }
                              if ( alreadyExisting == false && FAILUREOK_STATUS_STRING.get(value)!= null ) {
                                 try {Thread.sleep(9000);} catch (Exception e){}
                                 System.out.println("CREATING NOTIFICATION FAILUREOK ALERT:" + notificationId);
                                 service.getNotifications().add( new Notification(notificationId, notificationId + 
                                                                          "(" + FAILUREOK_STATUS_STRING.get(value) + ")",  
                                                                          ZonedDateTime.now().plusSeconds(10), () -> {
                                     Alert alert = new Alert(AlertType.WARNING, notificationId + 
                                                                          "(" + FAILUREOK_STATUS_STRING.get(value) + ")");
                                     Platform.runLater(() -> alert.showAndWait());
                                 }));
                               }
                           });
                        } 
                         catch (Exception e){}
                     }
                     break;
             }
         }
      }
      catch (IOException e) {
      }
      catch (Exception e) {e.printStackTrace();}
    }

    public void run() {
      System.out.println(name + " Notification : started thread");
      while (true) {
         try {
            Thread.sleep(10000);
            updateViewData();
         }
         catch (Exception e) {
         }
      }
   } 
}
