package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;

/**
 * Shared helper for navigating between the three safety-flags panels
 * (CB / NE / WE). Mirrors the lazy-create-then-switch pattern used by
 * SidePopupViewGlobal, so the three Main.safetyFlags* fields stay as the
 * single backing store for view instances.
 */
final class SafetyFlagsNavigation {

    private SafetyFlagsNavigation() {}

    static void show(String fxml, String viewId) {
        Main main = (Main) MobileApplication.getInstance();
        ensureView(main, fxml, viewId);
        main.switchView(viewId);
    }

    private static void ensureView(Main main, String fxml, String viewId) {
        switch (viewId) {
            case "CB Safety Flags":
                if (main.safetyFlagsCB == null) {
                    main.safetyFlagsCB = new ViewSafetyFlags(fxml, viewId);
                    MobileApplication.getInstance().addViewFactory(viewId, () -> main.safetyFlagsCB);
                    new Thread(main.safetyFlagsCB).start();
                }
                break;
            case "NE Safety Flags":
                if (main.safetyFlagsNE == null) {
                    main.safetyFlagsNE = new ViewSafetyFlags(fxml, viewId);
                    MobileApplication.getInstance().addViewFactory(viewId, () -> main.safetyFlagsNE);
                    new Thread(main.safetyFlagsNE).start();
                }
                break;
            case "WE Safety Flags":
                if (main.safetyFlagsWE == null) {
                    main.safetyFlagsWE = new ViewSafetyFlags(fxml, viewId);
                    MobileApplication.getInstance().addViewFactory(viewId, () -> main.safetyFlagsWE);
                    new Thread(main.safetyFlagsWE).start();
                }
                break;
            default:
                /* no-op: unknown viewId */
                break;
        }
    }
}
