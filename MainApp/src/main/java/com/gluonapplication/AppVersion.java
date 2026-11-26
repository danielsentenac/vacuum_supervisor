package com.gluonapplication;

import java.io.InputStream;
import java.util.Properties;

/**
 * Application version, read from the version.properties resource that the
 * Gradle build generates from android:versionName in AndroidManifest.xml
 * (single source of truth, bumped by release_app).
 */
public final class AppVersion {

    private static final String VERSION = load();

    private AppVersion() {
    }

    /** @return the version name (e.g. "0.7.4"), or an empty string if unknown. */
    public static String get() {
        return VERSION;
    }

    private static String load() {
        try (InputStream in = AppVersion.class.getResourceAsStream("/version.properties")) {
            if (in == null) {
                return "";
            }
            Properties props = new Properties();
            props.load(in);
            return props.getProperty("version", "").trim();
        } catch (Exception e) {
            return "";
        }
    }
}
