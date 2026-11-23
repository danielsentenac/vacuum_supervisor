package com.gluonapplication;

import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.down.plugins.StorageService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

/**
   Access to the backend from outside Virgo: the stored firewall portal login,
   and the automatic login when the backend is not reached.

   The login and its password are entered by the user and kept, with the
   portal address when it is not the built-in one, in the application's private storage, not encrypted (owner-only
   file). The password is sent only to the portal address, over HTTPS with the
   certificate verified.
*/
final class PortalAccess {

    /** Login page of the Virgo firewall portal, and the name on its certificate (not the one in its address). */
    static final String DEFAULT_PORTAL_URL = "https://fw1a.virgo.infn.it/connect/PortalMain";
    static final String DEFAULT_CERT_NAME = "fw.ego-gw.it";

    private static final String FILE_NAME = "vacuum_supervisor_portal.properties";
    /** After a successful login, the next automatic one (the backend may be down for another reason). */
    private static final long AFTER_SUCCESS_MS = 5 * 60 * 1000L;
    /** After a login that did not go through (portal not reached). */
    private static final long AFTER_FAILURE_MS = 30 * 1000L;

    private static final Object LOGIN_LOCK = new Object();
    private static final AtomicBoolean autoRunning = new AtomicBoolean(false);
    private static Properties props;
    private static volatile long nextAutoAttempt = 0;
    private static volatile String lastMessage = "";

    private PortalAccess() {
    }

    // --- Stored settings

    private static File file() {
        File dir = null;
        try {
            dir = Services.get(StorageService.class).flatMap(StorageService::getPrivateStorage).orElse(null);
        } catch (Throwable ignored) {
            // no storage service on this platform
        }
        if (dir == null) dir = new File(System.getProperty("user.home", "."), ".vacuum_supervisor");
        return new File(dir, FILE_NAME);
    }

    private static synchronized Properties props() {
        if (props == null) {
            Properties p = new Properties();
            File f = file();
            if (f.isFile()) {
                try (InputStream in = new FileInputStream(f)) {
                    p.load(in);
                } catch (IOException e) {
                    System.err.println("Firewall portal: settings not read: " + e);
                }
            }
            props = p;
        }
        return props;
    }

    private static synchronized String get(String key) {
        return props().getProperty(key, "");
    }

    private static synchronized void store() {
        File f = file();
        try {
            File dir = f.getParentFile();
            if (dir != null && !dir.isDirectory()) dir.mkdirs();
            if (!f.exists()) f.createNewFile();
            // owner only, before the password is written
            f.setReadable(false, false);
            f.setWritable(false, false);
            f.setReadable(true, true);
            f.setWritable(true, true);
            try (OutputStream out = new FileOutputStream(f)) {
                props().store(out, "Vacuum Supervisor - firewall portal login");
            }
        } catch (IOException e) {
            System.err.println("Firewall portal: settings not saved: " + e);
        }
    }

    /** The built-in portal address, unless another one was saved. */
    static String portalUrl() {
        String v = get("portal_url");
        return v.isEmpty() ? DEFAULT_PORTAL_URL : v;
    }

    /** Name on the portal's certificate, when it is not the name in its address. */
    static String certName() {
        String v = get("portal_cert_name");
        return v.isEmpty() && DEFAULT_PORTAL_URL.equals(portalUrl()) ? DEFAULT_CERT_NAME : v;
    }

    static String user() { return get("portal_user"); }

    static String password() { return get("portal_password"); }

    static boolean auto() { return !"0".equals(get("portal_auto")); }

    /**
       The portal refused these credentials: no automatic login until they are
       saved again (repeated refusals could lock the account).
    */
    static boolean refused() { return "1".equals(get("portal_refused")); }

    static boolean canAutoLogin() {
        return auto() && !refused() && !portalUrl().isEmpty() && !user().isEmpty() && !password().isEmpty();
    }

    /** What the last login attempt gave, for the login dialog. */
    static String lastMessage() { return lastMessage; }

    static synchronized void save(String portalUrl, String certName, String user, String password, boolean auto) {
        Properties p = props();
        // Only what differs from the built-in portal is stored, so that a new default reaches every client
        String url = portalUrl.trim();
        boolean builtIn = url.isEmpty() || url.equals(DEFAULT_PORTAL_URL);
        String cert = certName.trim();
        if (builtIn) p.remove("portal_url"); else p.setProperty("portal_url", url);
        if (cert.isEmpty() || (builtIn && cert.equals(DEFAULT_CERT_NAME))) p.remove("portal_cert_name");
        else p.setProperty("portal_cert_name", cert);
        p.setProperty("portal_user", user.trim());
        p.setProperty("portal_password", password);
        p.setProperty("portal_auto", auto ? "1" : "0");
        p.remove("portal_refused");
        store();
        nextAutoAttempt = 0;
    }

    // --- Login

    /** Logs in with the stored settings; blocks, so never call it from the JavaFX thread. */
    static PortalLogin.Result login() {
        synchronized (LOGIN_LOCK) {
            PortalLogin.Result r;
            if (portalUrl().isEmpty()) {
                r = new PortalLogin.Result(false, "the portal address is not set", false);
            } else if (user().isEmpty() || password().isEmpty()) {
                r = new PortalLogin.Result(false, "the portal login or its password is not set", false);
            } else {
                r = PortalLogin.login(portalUrl(), certName(), user(), password());
            }
            if (r.refused) {
                synchronized (PortalAccess.class) {
                    props().setProperty("portal_refused", "1");
                    store();
                }
            }
            nextAutoAttempt = System.currentTimeMillis() + (r.ok ? AFTER_SUCCESS_MS : AFTER_FAILURE_MS);
            String message = (r.ok ? "Logged in: " : "Login failed: ") + r.message;
            // Log on change only: this may run every 30 s while outside without network
            if (!message.equals(lastMessage)) System.err.println("Firewall portal: " + message);
            lastMessage = message;
            return r;
        }
    }

    /**
       Called by the data threads each time the backend is not reached (every
       second during an outage): when a portal login is stored, logs in to the
       portal in the background; the threads then get their data at their next cycle.
    */
    static void backendUnreachable() {
        if (System.currentTimeMillis() < nextAutoAttempt) return;
        startAutoLogin();
    }

    /**
       Called once when the application starts: with a stored login, logs in to
       the portal at once, in the background, without waiting for a first
       failed request.
    */
    static void loginAtStartup() {
        startAutoLogin();
    }

    private static void startAutoLogin() {
        if (!canAutoLogin()) return;
        if (!autoRunning.compareAndSet(false, true)) return;
        Thread t = new Thread(() -> {
            try {
                if (canAutoLogin()) login();
            } catch (Throwable e) {
                nextAutoAttempt = System.currentTimeMillis() + AFTER_FAILURE_MS;
                System.err.println("Firewall portal: automatic login failed: " + e);
            } finally {
                autoRunning.set(false);
            }
        }, "portal-login");
        t.setDaemon(true);
        t.start();
    }
}
