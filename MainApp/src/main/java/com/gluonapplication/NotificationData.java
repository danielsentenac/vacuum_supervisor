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
import com.gluonhq.charm.glisten.application.MobileApplication;
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
                () -> Platform.runLater(() -> showNotificationAlert(notificationId, message))
        ));
    }

    private void showNotificationAlert(String notificationId, String message) {
        Alert alert = new Alert(AlertType.WARNING, message);
        alert.showAndWait();
        openRelatedView(notificationId);
    }

    private void openRelatedView(String notificationId) {
        String viewId = getRelatedViewId(notificationId);
        if (viewId == null) {
            return;
        }
        try {
            Main main = (Main) MobileApplication.getInstance();
            if (main != null) {
                main.switchToNotificationView(viewId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getRelatedViewId(String notificationId) {
        if (notificationId == null) {
            return null;
        }
        String key = notificationId.toUpperCase();

        if (key.contains("REMOTESCROLL")) {
            return "REMOTEPUMPS";
        }

        if (key.contains("CRYOLINKDET")) {
            return "CRYOLINKDET";
        }
        if (key.contains("CRYOLINKIB")) {
            return "CRYOLINKIB";
        }
        if (key.contains("CRYOLINK(DET/IB)") || key.contains("CRYOLINK")) {
            return "CRYOLINKDET";
        }

        if (key.contains("TOWERBS")) {
            return "TOWERBS";
        }
        if (key.contains("TOWERPR")) {
            return "TOWERPR";
        }
        if (key.contains("TOWERNI")) {
            return "TOWERNI";
        }
        if (key.contains("TOWERWI")) {
            return "TOWERWI";
        }
        if (key.contains("TOWERSR")) {
            return "TOWERSR";
        }
        if (key.contains("TOWERNE")) {
            return "TOWERNE";
        }
        if (key.contains("TOWERWE")) {
            return "TOWERWE";
        }
        if (key.contains("TOWERIB")) {
            return "TOWERIB";
        }
        if (key.contains("TOWERDET")) {
            return "TOWERDET";
        }
        if (key.contains("TOWERMC")) {
            return "TOWERMC";
        }

        if (key.contains("LINKPR")) {
            return "LINKPR";
        }
        if (key.contains("LINKSR")) {
            return "LINKSR";
        }
        if (key.contains("LINK")) {
            return "LINKPR";
        }

        if (key.contains("CRYONI")) {
            return "CRYONI";
        }
        if (key.contains("CRYOWI")) {
            return "CRYOWI";
        }
        if (key.contains("CRYONE")) {
            return "CRYONE";
        }
        if (key.contains("CRYOWE")) {
            return "CRYOWE";
        }

        if (key.contains("SQZ DET2") || key.contains("SQZDET2")) {
            return "SQZDET2";
        }
        if (key.contains("SQZ DET1") || key.contains("SQZDET1")) {
            return "SQZDET1";
        }
        if (key.contains("SQZ300N") || key.contains("SQZ 300N")) {
            return "SQZ300N";
        }
        if (key.contains("SQZ200N") || key.contains("SQZ 200N")) {
            return "SQZ200N";
        }
        if (key.contains("SQZ100N") || key.contains("SQZ 100N")) {
            return "SQZ100N";
        }
        if (key.contains("SQZ0N") || key.contains("SQZ 0N")) {
            return "SQZ0N";
        }
        if (key.contains("SQZ PATH")) {
            return "SQZ";
        }
        if (key.contains("SQZ")) {
            return "SQZ";
        }

        if (key.contains("TUBEMC")) {
            return "TUBEMC";
        }

        if (key.contains("3000W")) {
            return "TUBELAL3000W";
        }
        if (key.contains("2400W")) {
            return "TUBELAL2400W";
        }
        if (key.contains("1800W")) {
            return "TUBELAL1800W";
        }
        if (key.contains("1200W")) {
            return "TUBELAL1200W";
        }
        if (key.contains("600W")) {
            return "TUBELAL600W";
        }
        if (key.contains("300W")) {
            return "TUBE300W";
        }

        if (key.contains("3000N")) {
            return "TUBELAL3000N";
        }
        if (key.contains("2400N")) {
            return "TUBELAL2400N";
        }
        if (key.contains("1800N")) {
            return "TUBELAL1800N";
        }
        if (key.contains("1200N")) {
            return "TUBELAL1200N";
        }
        if (key.contains("600N")) {
            return "TUBELAL600N";
        }
        if (key.contains("300N")) {
            return "TUBE300N";
        }

        if (key.contains("SAFE TUBE WEST") || key.contains("TUBE WEST")) {
            return "TUBEW";
        }
        if (key.contains("SAFE TUBE NORTH") || key.contains("TUBE NORTH")) {
            return "TUBEN";
        }
        if (key.contains("VAC_TUBE0W")) {
            return "TUBEW";
        }
        if (key.contains("SAFE CENTRAL") || key.contains("VALVECENTRAL")) {
            return "CB";
        }
        if (key.contains("BEAM PATH")) {
            return "CB";
        }
        if (key.contains("SAFE TOWERNE") || key.contains("VALVEBIGNE")) {
            return "TOWERNE";
        }
        if (key.contains("SAFE TOWERWE") || key.contains("VALVEBIGWE")) {
            return "TOWERWE";
        }
        if (key.contains("VALVEBIGNI")) {
            return "TOWERNI";
        }
        if (key.contains("VALVEBIGWI")) {
            return "TOWERWI";
        }
        if (key.contains("UPS1:WE") || key.contains("UPS2:WE") || key.contains("WE UPS")
                || key.contains("O2 WE") || key.contains("SENSOR O2: WE")) {
            return "WE";
        }
        if (key.contains("UPS1:NE") || key.contains("UPS2:NE") || key.contains("NE UPS")
                || key.contains("O2 NE") || key.contains("SENSOR O2: NE")) {
            return "NE";
        }
        if (key.contains("UPS1:MC") || key.contains("UPS2:MC") || key.contains("MC UPS")
                || key.contains("UPS:TB") || key.contains("TB UPS")
                || key.contains("O2 CB") || key.contains("SENSOR O2: CB")) {
            return "CB";
        }

        return null;
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
