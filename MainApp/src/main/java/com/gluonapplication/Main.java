package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.visual.Swatch;
import com.gluonhq.charm.down.common.Platform;
import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.down.plugins.LocalNotificationsService;
import com.gluonhq.charm.down.plugins.RuntimeArgsService;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.net.CookieManager;
import java.net.CookieHandler;
import java.net.URI;
import java.net.URLDecoder;
import java.io.File;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

public class Main extends MobileApplication {

    private static final String DESKTOP_URI_SCHEME = "vacuum-supervisor";
    private static final String DESKTOP_ICON_PROPERTY = "vacuum.supervisor.desktop.icon";
    private static final String DESKTOP_ICON_ENV = "VACUUM_SUPERVISOR_DESKTOP_ICON_PATH";
    
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
    private LayerSplashProgress splash_layer = new LayerSplashProgress();
    private volatile boolean startupCompleted = false;
    private volatile String pendingStartupViewId = null;
      
    // Create Views
    public ViewData global = null;
    public ViewData venting = null;
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
      Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
         System.err.println("Uncaught exception in thread " + t.getName());
         e.printStackTrace();
      });
      try {
         global = new ViewGlobal("GLOBAL", "GLOBAL");
         venting = new ViewVenting1("VENTING1", "VENTING1");
      } catch (Throwable t) {
         System.err.println("View construction failed:");
         t.printStackTrace();
         throw t;
      }
      // Add Layers
       addLayerFactory("NETWORK_ERROR", () -> { return network_error_layer;});
       addLayerFactory("SERVER_KO", () -> { return server_ko_layer;});
       addLayerFactory("SPLASH_PROGRESS", () -> { return splash_layer;});

      // Add Views
      addViewFactory(HOME_VIEW, () -> { return global;});
      addViewFactory("VENTING", () -> { return venting;});
      addViewFactory("VENTING1", () -> { return venting;});
      
       // Necessary to handle tomcat sessions
       CookieManager cookieManager = new CookieManager();
       CookieHandler.setDefault(cookieManager);

       captureDesktopLaunchArguments();
    }

    /**
     * This method is called when the application should stop, 
     * and provides a convenient place to prepare for application exit and destroy resources. 
     */
    @Override
    public void stop() throws Exception {
       clearPendingNotifications();
       super.stop();
       System.exit(0);
    }

    private void clearPendingNotifications() {
       try {
          Services.get(LocalNotificationsService.class).ifPresent(service -> {
             int notificationCount = service.getNotifications().size();
             service.getNotifications().clear();
             System.out.println("Cleared pending notifications: " + notificationCount);
          });
       } catch (Exception e) {
          e.printStackTrace();
       }
    }

    private void captureDesktopLaunchArguments() {
       try {
          String viewId = extractLaunchViewId(getParameters().getRaw());
          if (viewId != null) {
             setPendingStartupViewId(viewId, "desktop launch");
          }
       } catch (Exception e) {
          e.printStackTrace();
       }
    }

    private String extractLaunchViewId(List<String> rawArgs) {
       if (rawArgs == null) {
          return null;
       }
       for (String rawArg : rawArgs) {
          String viewId = extractViewIdFromArgument(rawArg);
          if (viewId != null) {
             return viewId;
          }
       }
       return null;
    }

    private String extractViewIdFromArgument(String rawArg) {
       if (rawArg == null) {
          return null;
       }

       String trimmedArg = rawArg.trim();
       if (trimmedArg.isEmpty()) {
          return null;
       }

       String uriViewId = extractViewIdFromDesktopUri(trimmedArg);
       if (uriViewId != null) {
          return uriViewId;
       }

       if (trimmedArg.matches("[A-Za-z0-9_-]+")) {
          return normalizeViewId(trimmedArg);
       }

       return null;
    }

    private String extractViewIdFromDesktopUri(String rawArg) {
       URI launchUri;
       try {
          launchUri = URI.create(rawArg);
       } catch (IllegalArgumentException e) {
          return null;
       }

       if (launchUri.getScheme() == null || !DESKTOP_URI_SCHEME.equalsIgnoreCase(launchUri.getScheme())) {
          return null;
       }

       String queryViewId = extractViewIdFromQuery(launchUri.getRawQuery());
       if (queryViewId != null) {
          return queryViewId;
       }

       String pathViewId = extractLastPathSegment(launchUri.getPath());
       if (pathViewId != null) {
          return pathViewId;
       }

       String hostViewId = normalizeViewId(launchUri.getHost());
       if (hostViewId != null && !"OPEN".equals(hostViewId) && !"VIEW".equals(hostViewId)) {
          return hostViewId;
       }

       String schemeSpecificPart = launchUri.getSchemeSpecificPart();
       if (schemeSpecificPart != null && !schemeSpecificPart.startsWith("//")) {
          return normalizeViewId(stripLeadingSlashes(schemeSpecificPart));
       }

       return null;
    }

    private String extractViewIdFromQuery(String rawQuery) {
       if (rawQuery == null || rawQuery.isEmpty()) {
          return null;
       }

       String[] pairs = rawQuery.split("&");
       for (String pair : pairs) {
          int separatorIndex = pair.indexOf('=');
          String rawKey = separatorIndex >= 0 ? pair.substring(0, separatorIndex) : pair;
          if ("view".equalsIgnoreCase(urlDecode(rawKey))) {
             String rawValue = separatorIndex >= 0 ? pair.substring(separatorIndex + 1) : "";
             return normalizeViewId(urlDecode(rawValue));
          }
       }

       return null;
    }

    private String extractLastPathSegment(String rawPath) {
       if (rawPath == null || rawPath.isEmpty()) {
          return null;
       }

       String[] segments = rawPath.split("/");
       for (int i = segments.length - 1; i >= 0; i--) {
          String normalizedSegment = normalizeViewId(segments[i]);
          if (normalizedSegment != null) {
             return normalizedSegment;
          }
       }

       return null;
    }

    private String stripLeadingSlashes(String value) {
       String strippedValue = value;
       while (strippedValue.startsWith("/")) {
          strippedValue = strippedValue.substring(1);
       }
       return strippedValue;
    }

    private String urlDecode(String value) {
       if (value == null) {
          return null;
       }
       try {
          return URLDecoder.decode(value, StandardCharsets.UTF_8.name());
       } catch (Exception e) {
          return value;
       }
    }

    private String normalizeViewId(String viewId) {
       if (viewId == null) {
          return null;
       }

       String normalizedViewId = stripLeadingSlashes(viewId.trim());
       if (normalizedViewId.isEmpty()) {
          return null;
       }

       int querySeparatorIndex = normalizedViewId.indexOf('?');
       if (querySeparatorIndex >= 0) {
          normalizedViewId = normalizedViewId.substring(0, querySeparatorIndex);
       }

       int fragmentSeparatorIndex = normalizedViewId.indexOf('#');
       if (fragmentSeparatorIndex >= 0) {
          normalizedViewId = normalizedViewId.substring(0, fragmentSeparatorIndex);
       }

       normalizedViewId = normalizedViewId.replace("-", "").replace("_", "").trim();
       if (normalizedViewId.isEmpty()) {
          return null;
       }

       return normalizedViewId.toUpperCase(Locale.ENGLISH);
    }

    private void setPendingStartupViewId(String viewId, String source) {
       String normalizedViewId = normalizeViewId(viewId);
       if (normalizedViewId == null) {
          return;
       }
       pendingStartupViewId = normalizedViewId;
       System.out.println("Queued startup view from " + source + ": " + normalizedViewId);
    }

    private void applyDesktopWindowIcon(Scene scene) {
       if (scene == null || !(scene.getWindow() instanceof Stage)) {
          return;
       }

       String iconPath = System.getProperty(DESKTOP_ICON_PROPERTY);
       if (iconPath == null || iconPath.trim().isEmpty()) {
          iconPath = System.getenv(DESKTOP_ICON_ENV);
       }
       if (iconPath == null || iconPath.trim().isEmpty()) {
          return;
       }

       File iconFile = new File(iconPath.trim());
       if (!iconFile.isFile()) {
          System.err.println("Desktop icon file not found: " + iconFile.getAbsolutePath());
          return;
       }

       try {
          Stage stage = (Stage) scene.getWindow();
          stage.getIcons().setAll(new Image(iconFile.toURI().toString()));
       } catch (Exception e) {
          System.err.println("Failed to set desktop window icon from: " + iconFile.getAbsolutePath());
          e.printStackTrace();
       }
    }

    @Override
    public void postInit(Scene scene) {
        showStartupSplash();
        try {
            updateStartupProgress(0.10, "Starting...");
            Swatch.GREY.assignTo(scene);
            updateStartupProgress(0.30, "Applying style");

            // If running on Desktop, adjust the size
            if (Platform.isDesktop()) {
                scene.getWindow().setWidth(850);
                scene.getWindow().setHeight(850);
                applyDesktopWindowIcon(scene);
            }
            setTitle("Vacuum Supervisor");
            updateStartupProgress(0.55, "Preparing views");
            try {
                System.out.println("STARTING THREADS");
                new Thread(global).start();
                new Thread(venting).start();
                updateStartupProgress(0.75, "Starting services");
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
                registerNotificationLaunchHandler();
                clearPendingNotifications();
                updateStartupProgress(0.95, "Finalizing startup");
                updateStartupProgress(1.00, "Ready");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Throwable t) {
            System.err.println("postInit failed:");
            t.printStackTrace();
            throw t;
        } finally {
            startupCompleted = true;
            finalizeStartupUi();
        }
    }

    private void showStartupSplash() {
       runOnFxThread(() -> {
          try {
             showLayer("SPLASH_PROGRESS");
             // Fallback: never keep the app blocked on splash forever.
             PauseTransition timeout = new PauseTransition(Duration.seconds(8));
             timeout.setOnFinished(e -> {
                if (splash_layer != null && splash_layer.isShowing()) {
                   splash_layer.hide();
                }
             });
             timeout.play();
          } catch (Exception e) {
             e.printStackTrace();
          }
       });
    }

    private void hideStartupSplash() {
       runOnFxThread(() -> {
          try {
             if (splash_layer != null) {
                splash_layer.hide();
             }
          } catch (Exception e) {
             e.printStackTrace();
          }
       });
    }

    private void updateStartupProgress(double progress, String message) {
       if (splash_layer != null) {
          splash_layer.setProgress(progress, message);
       }
    }

    private void registerNotificationLaunchHandler() {
       try {
          Services.get(RuntimeArgsService.class).ifPresent(service ->
                  service.addListener(RuntimeArgsService.LAUNCH_LOCAL_NOTIFICATION_KEY, this::onLaunchFromNotification)
          );
       } catch (Exception e) {
          e.printStackTrace();
       }
    }

    private void onLaunchFromNotification(String notificationId) {
       if (notificationId == null || notificationId.isEmpty()) {
          return;
       }
       System.out.println("App launched from local notification: " + notificationId);
       removeNotificationById(notificationId);
       String viewId = NotificationData.getRelatedViewId(notificationId);
       if (viewId != null) {
          if (startupCompleted) {
             hideStartupSplash();
             switchToNotificationView(viewId);
          } else {
             setPendingStartupViewId(viewId, "local notification");
          }
       }
    }

    private void openPendingStartupViewIfAny() {
       String viewId = pendingStartupViewId;
       pendingStartupViewId = null;
       if (viewId != null && !viewId.isEmpty()) {
          switchToNotificationView(viewId);
       }
    }

    private void finalizeStartupUi() {
       runOnFxThread(() -> {
          hideStartupSplash();
          openPendingStartupViewIfAny();
       });
    }

    private void runOnFxThread(Runnable runnable) {
       if (javafx.application.Platform.isFxApplicationThread()) {
          runnable.run();
       } else {
          javafx.application.Platform.runLater(runnable);
       }
    }

    private void removeNotificationById(String notificationId) {
       try {
          Services.get(LocalNotificationsService.class).ifPresent(service ->
                  service.getNotifications().removeIf(notification -> notificationId.equals(notification.getId()))
          );
       } catch (Exception e) {
          e.printStackTrace();
       }
    }

    public void switchToNotificationView(String viewId) {
       if (viewId == null || viewId.isEmpty()) {
          return;
       }
       javafx.application.Platform.runLater(() -> {
          try {
             if (ensureViewFactory(viewId)) {
                switchView(viewId);
                System.out.println("Switch to related notification view: " + viewId);
             } else {
                System.err.println("Unsupported launch view: " + viewId);
             }
          } catch (Exception e) {
             e.printStackTrace();
          }
       });
    }

    private void registerViewFactoryAndStartThread(String viewId, ViewData view) {
       addViewFactory(viewId, () -> { return view;});
       new Thread(view).start();
    }

    private boolean ensureViewFactory(String viewId) {
       switch (viewId) {
          case "CB":
             if (cb == null) {
                cb = new ViewCentralBuilding("CB", "CB");
                registerViewFactoryAndStartThread("CB", cb);
             }
             return true;
          case "NE":
             if (ne == null) {
                ne = new ViewEndBuilding("NE", "NE");
                registerViewFactoryAndStartThread("NE", ne);
             }
             return true;
          case "WE":
             if (we == null) {
                we = new ViewEndBuilding("WE", "WE");
                registerViewFactoryAndStartThread("WE", we);
             }
             return true;
          case "TUBEN":
             if (tubeN == null) {
                tubeN = new ViewTube("TUBEN", "TUBEN");
                registerViewFactoryAndStartThread("TUBEN", tubeN);
             }
             return true;
          case "TUBEW":
             if (tubeW == null) {
                tubeW = new ViewTube("TUBEW", "TUBEW");
                registerViewFactoryAndStartThread("TUBEW", tubeW);
             }
             return true;
          case "SQZ":
             if (sqz == null) {
                sqz = new ViewSqz("SQZ", "SQZ");
                registerViewFactoryAndStartThread("SQZ", sqz);
             }
             return true;
          case "TUBEMC":
             if (tubeMC == null) {
                tubeMC = new ViewTubeMCStation("TUBEMC", "TUBEMC");
                registerViewFactoryAndStartThread("TUBEMC", tubeMC);
             }
             return true;
          case "REMOTEPUMPS":
             if (remotePumps == null) {
                remotePumps = new ViewRemotePumps("REMOTEPUMPS", "REMOTESCROLL");
                registerViewFactoryAndStartThread("REMOTEPUMPS", remotePumps);
             }
             return true;
          case "TUBELAL600W":
             if (tube600W == null) {
                tube600W = new ViewTubeLalStation("TUBELALSTATION", "TUBELAL600W");
                registerViewFactoryAndStartThread("TUBELAL600W", tube600W);
             }
             return true;
          case "TUBELAL1200W":
             if (tube1200W == null) {
                tube1200W = new ViewTubeLalStation("TUBELALSTATION", "TUBELAL1200W");
                registerViewFactoryAndStartThread("TUBELAL1200W", tube1200W);
             }
             return true;
          case "TUBELAL1800W":
             if (tube1800W == null) {
                tube1800W = new ViewTubeLalStation("TUBELALSTATION", "TUBELAL1800W");
                registerViewFactoryAndStartThread("TUBELAL1800W", tube1800W);
             }
             return true;
          case "TUBELAL2400W":
             if (tube2400W == null) {
                tube2400W = new ViewTubeLalStation("TUBELALSTATION", "TUBELAL2400W");
                registerViewFactoryAndStartThread("TUBELAL2400W", tube2400W);
             }
             return true;
          case "TUBELAL3000W":
             if (tube3000W == null) {
                tube3000W = new ViewTubeLalStation("TUBELALSTATION", "TUBELAL3000W");
                registerViewFactoryAndStartThread("TUBELAL3000W", tube3000W);
             }
             return true;
          case "TUBE300W":
             if (tube300W == null) {
                tube300W = new ViewTubeStation("TUBESTATION", "TUBE300W");
                registerViewFactoryAndStartThread("TUBE300W", tube300W);
             }
             return true;
          case "TUBELAL600N":
             if (tube600N == null) {
                tube600N = new ViewTubeLalStation("TUBELALSTATION", "TUBELAL600N");
                registerViewFactoryAndStartThread("TUBELAL600N", tube600N);
             }
             return true;
          case "TUBELAL1200N":
             if (tube1200N == null) {
                tube1200N = new ViewTubeLalStation("TUBELALSTATION", "TUBELAL1200N");
                registerViewFactoryAndStartThread("TUBELAL1200N", tube1200N);
             }
             return true;
          case "TUBELAL1800N":
             if (tube1800N == null) {
                tube1800N = new ViewTubeLalStation("TUBELALSTATION", "TUBELAL1800N");
                registerViewFactoryAndStartThread("TUBELAL1800N", tube1800N);
             }
             return true;
          case "TUBELAL2400N":
             if (tube2400N == null) {
                tube2400N = new ViewTubeLalStation("TUBELALSTATION", "TUBELAL2400N");
                registerViewFactoryAndStartThread("TUBELAL2400N", tube2400N);
             }
             return true;
          case "TUBELAL3000N":
             if (tube3000N == null) {
                tube3000N = new ViewTubeLalStation("TUBELALSTATION", "TUBELAL3000N");
                registerViewFactoryAndStartThread("TUBELAL3000N", tube3000N);
             }
             return true;
          case "TUBE300N":
             if (tube300N == null) {
                tube300N = new ViewTubeStation("TUBESTATION", "TUBE300N");
                registerViewFactoryAndStartThread("TUBE300N", tube300N);
             }
             return true;
          case "SQZ100N":
             if (tubesqz100N == null) {
                tubesqz100N = new ViewTubeSqzStation("TUBESQZ", "SQZ100N");
                registerViewFactoryAndStartThread("SQZ100N", tubesqz100N);
             }
             return true;
          case "SQZ200N":
             if (tubesqz200N == null) {
                tubesqz200N = new ViewTubeSqzStation("TUBESQZ", "SQZ200N");
                registerViewFactoryAndStartThread("SQZ200N", tubesqz200N);
             }
             return true;
          case "SQZ0N":
             if (minitowersqz0N == null) {
                minitowersqz0N = new ViewMiniTowerSqzStation("MINITOWERSQZ", "SQZ0N");
                registerViewFactoryAndStartThread("SQZ0N", minitowersqz0N);
             }
             return true;
          case "SQZ300N":
             if (minitowersqz300N == null) {
                minitowersqz300N = new ViewMiniTowerSqzStation("MINITOWERSQZ", "SQZ300N");
                registerViewFactoryAndStartThread("SQZ300N", minitowersqz300N);
             }
             return true;
          case "SQZDET1":
             if (minitowersqzdet1 == null) {
                minitowersqzdet1 = new ViewMiniTowerSqzStation("MINITOWERSQZ", "SQZDET1");
                registerViewFactoryAndStartThread("SQZDET1", minitowersqzdet1);
             }
             return true;
          case "SQZDET2":
             if (minitowersqzdet2 == null) {
                minitowersqzdet2 = new ViewMiniTowerSqzStation("MINITOWERSQZ", "SQZDET2");
                registerViewFactoryAndStartThread("SQZDET2", minitowersqzdet2);
             }
             return true;
          case "TOWERBS":
             if (towerBS == null) {
                towerBS = new ViewTowerStation("TOWERSTATION", "TOWERBS");
                registerViewFactoryAndStartThread("TOWERBS", towerBS);
             }
             return true;
          case "TOWERNI":
             if (towerNI == null) {
                towerNI = new ViewTowerStation("TOWERSTATION", "TOWERNI");
                registerViewFactoryAndStartThread("TOWERNI", towerNI);
             }
             return true;
          case "TOWERWI":
             if (towerWI == null) {
                towerWI = new ViewTowerStation("TOWERSTATION", "TOWERWI");
                registerViewFactoryAndStartThread("TOWERWI", towerWI);
             }
             return true;
          case "TOWERPR":
             if (towerPR == null) {
                towerPR = new ViewTowerStation("TOWERSTATION", "TOWERPR");
                registerViewFactoryAndStartThread("TOWERPR", towerPR);
             }
             return true;
          case "TOWERSR":
             if (towerSR == null) {
                towerSR = new ViewTowerStation("TOWERSTATION", "TOWERSR");
                registerViewFactoryAndStartThread("TOWERSR", towerSR);
             }
             return true;
          case "TOWERNE":
             if (towerNE == null) {
                towerNE = new ViewTowerStation("TOWERSTATION", "TOWERNE");
                registerViewFactoryAndStartThread("TOWERNE", towerNE);
             }
             return true;
          case "TOWERWE":
             if (towerWE == null) {
                towerWE = new ViewTowerStation("TOWERSTATION", "TOWERWE");
                registerViewFactoryAndStartThread("TOWERWE", towerWE);
             }
             return true;
          case "TOWERIB":
             if (towerIB == null) {
                towerIB = new ViewTowerBenchStation("TOWERBENCHSTATION", "TOWERIB");
                registerViewFactoryAndStartThread("TOWERIB", towerIB);
             }
             return true;
          case "TOWERDET":
             if (towerDET == null) {
                towerDET = new ViewTowerBenchStation("TOWERBENCHSTATION", "TOWERDET");
                registerViewFactoryAndStartThread("TOWERDET", towerDET);
             }
             return true;
          case "TOWERMC":
             if (towerMC == null) {
                towerMC = new ViewTowerBenchStation("TOWERBENCHSTATION", "TOWERMC");
                registerViewFactoryAndStartThread("TOWERMC", towerMC);
             }
             return true;
          case "CRYONI":
             if (cryoNI == null) {
                cryoNI = new ViewCryoStation("CRYOSTATION", "CRYONI");
                registerViewFactoryAndStartThread("CRYONI", cryoNI);
             }
             return true;
          case "CRYOWI":
             if (cryoWI == null) {
                cryoWI = new ViewCryoStation("CRYOSTATION", "CRYOWI");
                registerViewFactoryAndStartThread("CRYOWI", cryoWI);
             }
             return true;
          case "CRYONE":
             if (cryoNE == null) {
                cryoNE = new ViewCryoStation("CRYOSTATION", "CRYONE");
                registerViewFactoryAndStartThread("CRYONE", cryoNE);
             }
             return true;
          case "CRYOWE":
             if (cryoWE == null) {
                cryoWE = new ViewCryoStation("CRYOSTATION", "CRYOWE");
                registerViewFactoryAndStartThread("CRYOWE", cryoWE);
             }
             return true;
          case "CRYOLINKDET":
             if (cryolinkDET == null) {
                cryolinkDET = new ViewCryoLinkStation("CRYOLINKSTATION", "CRYOLINKDET");
                registerViewFactoryAndStartThread("CRYOLINKDET", cryolinkDET);
             }
             return true;
          case "CRYOLINKIB":
             if (cryolinkIB == null) {
                cryolinkIB = new ViewCryoLinkStation("CRYOLINKSTATION", "CRYOLINKIB");
                registerViewFactoryAndStartThread("CRYOLINKIB", cryolinkIB);
             }
             return true;
          case "LINKPR":
             if (linkPR == null) {
                linkPR = new ViewLinkStation("LINK", "LINKPR");
                registerViewFactoryAndStartThread("LINKPR", linkPR);
             }
             return true;
          case "LINKSR":
             if (linkSR == null) {
                linkSR = new ViewLinkStation("LINK", "LINKSR");
                registerViewFactoryAndStartThread("LINKSR", linkSR);
             }
             return true;
          default:
             return false;
       }
    }

    public static void main(String[] args) {
        try {
            launch(args);
        } catch (Throwable t) {
            System.err.println("Application launch failed:");
            t.printStackTrace();
        }
    }

}
