package com.gluonapplication;

final class ServerEndpoints {

    private static final String DEFAULT_HOST = "online-data-provider.example";
    private static final String BACKEND_HOST_PROPERTY = "vacuum.supervisor.backend.host";
    private static final String BACKEND_HOST_ENV = "VACUUM_SUPERVISOR_BACKEND_HOST";

    private ServerEndpoints() {
    }

    static String jchvUrl() {
        return buildUrl(8081, "jchv/jchv");
    }

    static String jmasterUrl() {
        return buildUrl(8081, "jmaster/jmaster");
    }

    static String jcmdUrl() {
        return buildUrl(9081, "jcmd/jcmd");
    }

    private static String buildUrl(int port, String path) {
        return "http://" + resolveHost() + ":" + port + "/" + path;
    }

    private static String resolveHost() {
        String host = System.getProperty(BACKEND_HOST_PROPERTY);
        if (host == null || host.trim().isEmpty()) {
            host = System.getenv(BACKEND_HOST_ENV);
        }
        if (host == null || host.trim().isEmpty()) {
            host = DEFAULT_HOST;
        }
        return stripSchemeAndPath(host.trim());
    }

    private static String stripSchemeAndPath(String host) {
        int schemeSeparator = host.indexOf("://");
        if (schemeSeparator >= 0) {
            host = host.substring(schemeSeparator + 3);
        }

        int slashIndex = host.indexOf('/');
        if (slashIndex >= 0) {
            host = host.substring(0, slashIndex);
        }

        return host;
    }
}
