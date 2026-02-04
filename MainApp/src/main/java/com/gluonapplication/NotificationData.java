package com.gluonapplication;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.ZonedDateTime;
import java.util.Vector;

import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.down.plugins.LocalNotificationsService;
import com.gluonhq.charm.down.plugins.Notification;
import com.gluonhq.charm.glisten.control.Alert;
import javafx.application.Platform;
import javafx.scene.control.Alert.AlertType;


public class NotificationData implements Runnable, DataTypes {
    
    private int initCnt = 0;
    private static final int MAX_FR = 3;
    public DataSet data;
    public String name = "";
    public boolean connectionError = false;

    public NotificationData(String name) {
        this.name = name;
    }

    private boolean hasNotification(LocalNotificationsService service, String notificationId) {
        for (Notification notification : service.getNotifications()) {
            if (notificationId.equals(notification.getId())) {
                return true;
            }
        }
        return false;
    }

    private void sleepQuietly(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
        }
    }

    private void addNotification(LocalNotificationsService service, String notificationId, String message) {
        service.getNotifications().add(new Notification(
                notificationId,
                message,
                ZonedDateTime.now().plusSeconds(10),
                () -> {
                    Alert alert = new Alert(AlertType.WARNING, message);
                    Platform.runLater(() -> alert.showAndWait());
                }
        ));
    }

    private boolean isInvalidValue(String value) {
        return "---".equals(value) || "255".equals(value);
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
         URLConnection con = getServerConnection("http://olserver135.virgo.infn.it:8081/jchv/jchv");
         OutputStream outstream = con.getOutputStream();
         ObjectOutputStream oos = new ObjectOutputStream(outstream);
         oos.writeObject(data.svrNameList);
         oos.flush();
         oos.close();
         //System.out.println(data.svrNameList);
         // receive result from servlet
         InputStream instr = con.getInputStream();
         ObjectInputStream inputFromServlet = new ObjectInputStream(instr);
         data.svrValueList = (Vector<String>) inputFromServlet.readObject();
         inputFromServlet.close();
         instr.close();

         if (initCnt++ < MAX_FR) return; // First cycle data sent by Alp maybe corrupted!!

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
             switch (data.list.elementAt(i).type) {
                case LABEL_TURBO_BOX_STATUS_STRING:
                     if (!"0".equals(value) && !isInvalidValue(value)) {
                        try {
                           String notificationId = "TURBO_BOX:" +data.list.elementAt(i).name;
                           Services.get(LocalNotificationsService.class).ifPresent(service -> {
                              if (!hasNotification(service, notificationId) && TURBO_BOX_STATUS_STRING.get(value) != null) {
                                 System.out.println("CREATING NOTIFICATION TURBO_BOX:" + notificationId);
                                 sleepQuietly(1000);
                                 String message = notificationId + "(" + TURBO_BOX_STATUS_STRING.get(value) + ")";
                                 addNotification(service, notificationId, message);
                               }
                           });
                         }
                         catch (Exception e){}
                     }
                     break;
                case LABEL_TURBO_TEMP_STATUS_STRING:
                     if (!"0".equals(value) && !isInvalidValue(value)) {
                        try {
                           String notificationId = "TURBO_TEMP:" + data.list.elementAt(i).name;
                           Services.get(LocalNotificationsService.class).ifPresent(service -> {
                              if (!hasNotification(service, notificationId) && TURBO_TEMP_STATUS_STRING.get(value) != null) {
                                 System.out.println("CREATING NOTIFICATION TURBO_TEMP:" + notificationId);
                                 sleepQuietly(2000);
                                 String message = notificationId + "(" + TURBO_TEMP_STATUS_STRING.get(value) + ")";
                                 addNotification(service, notificationId, message);
                               }
                           });
                         }
                         catch (Exception e){}
                     }
                     break;
                case LABEL_TURBO_TEMP_BOX_STATUS_STRING:
                     if (!"0".equals(value) && !isInvalidValue(value)) {
                        try {
                           String notificationId = "TURBO_TEMP_BOX:" + data.list.elementAt(i).name;
                           Services.get(LocalNotificationsService.class).ifPresent(service -> {
                              if (!hasNotification(service, notificationId) && TURBO_TEMP_BOX_STATUS_STRING.get(value) != null) {
                                 System.out.println("CREATING NOTIFICATION TURBO_TEMP_BOX:" + notificationId);
                                 sleepQuietly(3000);
                                 String message = notificationId + "(" + TURBO_TEMP_BOX_STATUS_STRING.get(value) + ")";
                                 addNotification(service, notificationId, message);
                               }
                           });
                        }
                        catch (Exception e){}
                     }
                     break;
                case LABEL_TURBO_POWER_STATUS_STRING:
                     if (!isInvalidValue(value)) {
                        try {
                           int valueInt = Integer.parseInt(value); 
                           if (valueInt >=  data.list.elementAt(i).max) { 
                              String notificationId = "TURBO_POWER:" + data.list.elementAt(i).name;
                              Services.get(LocalNotificationsService.class).ifPresent(service -> {
                                 if (!hasNotification(service, notificationId)) { 
                                    System.out.println("CREATING NOTIFICATION TURBO_POWER:" + notificationId);
                                    sleepQuietly(4000);
                                    String message = notificationId + "(" + TURBO_POWER_STATUS_STRING.get("1") + "-> " + value + " Watt)";
                                    addNotification(service, notificationId, message);
                                  }
                              });
                            }
                         }
                         catch (Exception e){}
                     }
                     break;
                case LABEL_GOLDEN_STATUS_STRING:
                     if (!"1".equals(value) && !isInvalidValue(value)) {
                        try {
                           String notificationId = "GOLDEN:" + data.list.elementAt(i).name;
                           Services.get(LocalNotificationsService.class).ifPresent(service -> {
                              if (!hasNotification(service, notificationId) && GOLDEN_STATUS_STRING.get(value)!= null) {
                                 sleepQuietly(10000);
                                 System.out.println("CREATING NOTIFICATION GOLDEN ALERT:" + notificationId);
                                 String message = notificationId + "(" + GOLDEN_STATUS_STRING.get(value) + ")";
                                 addNotification(service, notificationId, message);
                              }
                           });
                         }
                         catch (Exception e){}
                     }
                     break;
                 case LABEL_RACK_STATUS_STRING:
                     if (!"0".equals(value) && !isInvalidValue(value)) {
                        try {
                           String notificationId = "RACK:" + data.list.elementAt(i).name;
                           Services.get(LocalNotificationsService.class).ifPresent(service -> {
                              if (!hasNotification(service, notificationId) && RACK_STATUS_STRING.get(value)!= null ) {
                                 sleepQuietly(6000);
                                 System.out.println("CREATING NOTIFICATION RACK ALERT:" + notificationId);
                                 String message = notificationId + "(" + RACK_STATUS_STRING.get(value) + ")";
                                 addNotification(service, notificationId, message);
                               }
                           });
                        } 
                         catch (Exception e){}
                     }
                     break;
                  case LABEL_VALVE_STATUS_STRING:
                     if (!"1".equals(value) && !"2".equals(value) && !isInvalidValue(value)) {
                        try {
                           String notificationId = "VALVE:" + data.list.elementAt(i).name;
                           Services.get(LocalNotificationsService.class).ifPresent(service -> {
                              if (!hasNotification(service, notificationId) && VALVE_STATUS_STRING.get(value)!= null ) {
                                 sleepQuietly(7000);
                                 System.out.println("CREATING NOTIFICATION VALVE ALERT:" + notificationId);
                                 String message = notificationId + "(" + VALVE_STATUS_STRING.get(value) + ")";
                                 addNotification(service, notificationId, message);
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
                              if (!hasNotification(service, notificationId) && OKFAILURE_STATUS_STRING.get(value)!= null ) {
                                 sleepQuietly(8000);
                                 System.out.println("CREATING NOTIFICATION OKFAILURE ALERT:" + notificationId);
                                 String message = notificationId + "(" + OKFAILURE_STATUS_STRING.get(value) + ")";
                                 addNotification(service, notificationId, message);
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
                              if (!hasNotification(service, notificationId) && FAILUREOK_STATUS_STRING.get(value)!= null ) {
                                 sleepQuietly(9000);
                                 System.out.println("CREATING NOTIFICATION FAILUREOK ALERT:" + notificationId);
                                 String message = notificationId + "(" + FAILUREOK_STATUS_STRING.get(value) + ")";
                                 addNotification(service, notificationId, message);
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
