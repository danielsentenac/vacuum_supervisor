package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.visual.Swatch;
import com.gluonhq.charm.down.common.Platform;
import javafx.scene.Scene;
import java.net.CookieManager;
import java.net.CookieHandler;
import java.lang.reflect.Method;

public class Main extends MobileApplication {
    
    static {
       if (Platform.isAndroid()) {
           try {
                Method forName = Class.class.getDeclaredMethod("forName", String.class);
                Method getDeclaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);

                Class<?> vmRuntimeClass = (Class<?>) forName.invoke(null, "dalvik.system.VMRuntime");
                Method getRuntime = (Method) getDeclaredMethod.invoke(vmRuntimeClass, "getRuntime", null);
                Method setHiddenApiExemptions = (Method) getDeclaredMethod.invoke(vmRuntimeClass, "setHiddenApiExemptions", new Class[]{String[].class});
                Object sVmRuntime = getRuntime.invoke(null);
                if (sVmRuntime != null && setHiddenApiExemptions != null) {
                    setHiddenApiExemptions.invoke(sVmRuntime, new Object[]{new String[]{"L"}});
                }
           } catch (Throwable e) {
           }
       }
    }
    // Create Layers
    public LayerMessage network_error_layer = new LayerMessage("INFORMATION", "Network is unreachable", false);
    public LayerMessage server_ko_layer = new LayerMessage("INFORMATION", "No response from server", false);
    public LayerMessage command_success_layer = null;
    public LayerMessage command_failure_layer= null;
    public LayerMessage command_simulation_layer= null;
      
    // Create Views
    public ViewData global = new ViewGlobal("GLOBAL", "GLOBAL");
    public ViewData tubeN = null;
    public ViewData tubeW = null;   
    public ViewData tube300W = null; 
    public ViewData tube600W = null;
    public ViewData tube1200W = null; 
    public ViewData tube1800W = null;
    public ViewData tube2400W = null; 
    public ViewData tube3000W = null;
    public ViewData we = null;
    public ViewData tube300N = null; 
    public ViewData tube600N = null;
    public ViewData tube1200N = null;
    public ViewData tube1800N = null;
    public ViewData tube2400N = null; 
    public ViewData tube3000N = null;
    public ViewData tubeMC = null;
    public ViewData ne = null;
    public ViewData cb = null;
    public ViewData towerBS = null;
    public ViewData towerNI = null;
    public ViewData towerWI = null;
    public ViewData towerPR = null;
    public ViewData towerSR = null;
    public ViewData towerNE = null;
    public ViewData towerWE = null;
    public ViewData towerIB = null;
    public ViewData towerMC = null;
    public ViewData towerDET = null;
    public ViewData cryoNI = null;
    public ViewData cryoWI = null;
    public ViewData cryoNE = null;
    public ViewData cryoWE = null;
    public ViewData cryolinkIB = null;
    public ViewData cryolinkDET = null;
    public ViewData linkPR = null;
    public ViewData linkSR = null;
    public ViewData remotePumps = null;
    public ViewData sqz = null;
    public ViewData tubesqz100N = null;
    public ViewData tubesqz200N = null;
    public ViewData minitowersqz0N = null;
    public ViewData minitowersqz300N = null;
    public ViewData minitowersqzdet1 = null;
    public ViewData minitowersqzdet2 = null;
    public ViewData tiltmeter = null;

    // Notification service
    NotificationService notificationTurboBox = new NotificationService("TurboBox Alert");
    NotificationService notificationTurboTemp = new NotificationService("TurboTemp Alert");
    NotificationService notificationTurboBoxTemp = new NotificationService("TurboBoxTemp Alert");
    NotificationService notificationTurboPower = new NotificationService("TurboPower Alert");
    NotificationService notificationGolden = new NotificationService("Golden Alert");
    NotificationService notificationRack = new NotificationService("Rack Alert");
    NotificationService notificationValve = new NotificationService("Valve Alert");
    NotificationService notificationUps = new NotificationService("UPS Alert");
    NotificationService notificationO2Sensor = new NotificationService("O2 Sensor Alert");
    NotificationService notificationCompressAir = new NotificationService("Compress Air Alert");

    @Override
    public void init() {
      
      // Add Layers
       addLayerFactory("NETWORK_ERROR", () -> { return network_error_layer;});
       addLayerFactory("SERVER_KO", () -> { return server_ko_layer;});

      // Add Views
      addViewFactory(HOME_VIEW, () -> { return global;});
      
       // Necessary to handle tomcat sessions
       CookieManager cookieManager = new CookieManager();
       CookieHandler.setDefault(cookieManager);
    }

    /**
     * This method is called when the application should stop, 
     * and provides a convenient place to prepare for application exit and destroy resources. 
     */
    @Override
    public void stop() throws Exception {
       super.stop();
       System.exit(0);
    }
    @Override
    public void postInit(Scene scene) {
      
        Swatch.GREY.assignTo(scene);

        // If running on Desktop, adjust the size
        if(Platform.isDesktop()){
            scene.getWindow().setWidth(850);
            scene.getWindow().setHeight(850);
        }
        setTitle("Vacuum Supervisor");
        try {
           System.out.println("STARTING THREADS");
           new Thread(global).start();
           new Thread(notificationTurboBox).start();
           new Thread(notificationTurboTemp).start();
           new Thread(notificationTurboBoxTemp).start();
           new Thread(notificationTurboPower).start();
           new Thread(notificationGolden).start();
           new Thread(notificationRack).start();
           new Thread(notificationValve).start();
           new Thread(notificationUps).start();
           new Thread(notificationO2Sensor).start();
           new Thread(notificationCompressAir).start();
        }
        catch (Exception e) {
           e.printStackTrace();
        }
    }
}
