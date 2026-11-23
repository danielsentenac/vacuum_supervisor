package com.gluonapplication;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/**
   Login to the Virgo firewall portal (a Check Point captive portal) from the
   application, as its own page does it:

   1. GET  PortalMain       opens a session (cookie);
   2. POST RSASettings      gives the public key (m, e, hex) and a one-time loginToken;
   3. POST Login            realm=passwordRealm&amp;username=..&amp;password=(encrypted);
      the answer is JSON with a type: SUCCESS, AUTH_FAILURE, SESSION_FAILURE, CHALLENGE...
   4. POST GetStateAndView  moves the session to its final state, as the page does after a success.

   The password is encrypted as in the page's cpRSA.encrypt: RSA on
   00 02 (random non-zero bytes) 00 (token + password) 00, the result written
   in hex with its bytes in reverse order. Same sequence as the raven-kn
   logbook client, read from the page served on 2026-11-18; a firewall update
   may change it.
*/
final class PortalLogin {

    private PortalLogin() {
    }

    static final class Result {
        final boolean ok;
        final String message;
        /** The portal refused the login or the password: do not try again with the same ones. */
        final boolean refused;

        Result(boolean ok, String message, boolean refused) {
            this.ok = ok;
            this.message = message;
            this.refused = refused;
        }
    }

    static final class Response {
        final int status;
        final String body;

        Response(int status, String body) {
            this.status = status;
            this.body = body;
        }
    }

    /** One request to the portal: method, action such as "Login", form body. */
    interface Transport {
        Response send(String method, String action, String body) throws IOException;
    }

    /** Encrypted password field of the Login request. */
    static String cpEncrypt(String modulusHex, String exponentHex, String token, String password, Random random) {
        BigInteger n = new BigInteger(modulusHex, 16);
        BigInteger e = new BigInteger(exponentHex, 16);
        int k = (n.bitLength() + 7) >> 3;
        byte[] text = (token + password).getBytes(StandardCharsets.UTF_8);
        if (k < text.length + 12) throw new IllegalArgumentException("password too long for the portal key");
        byte[] block = new byte[k];
        block[1] = 2;
        int start = k - 1 - text.length; // the text, followed by one zero byte
        for (int i = 2; i < start - 1; i++) {
            block[i] = (byte) (1 + random.nextInt(255));
        }
        block[start - 1] = 0;
        System.arraycopy(text, 0, block, start, text.length);
        String hex = new BigInteger(1, block).modPow(e, n).toString(16);
        if (hex.length() % 2 != 0) hex = "0" + hex;
        StringBuilder out = new StringBuilder(hex.length());
        for (int j = hex.length() - 2; j >= 0; j -= 2) {
            out.append(hex, j, j + 2);
        }
        return out.toString();
    }

    /** The login sequence on a transport (see Session for the real one). */
    static Result loginWith(Transport t, String user, String password, Random random) {
        try {
            Response r0 = t.send("GET", "PortalMain", "");
            if (r0.status != 200) return new Result(false, "the portal page answered HTTP " + r0.status, false);
            for (int attempt = 0; attempt < 2; attempt++) {
                Response r1 = t.send("POST", "RSASettings", "");
                if (!isJsonObject(r1.body)) {
                    return new Result(false, "the portal did not give its key (HTTP " + r1.status
                            + "): its login procedure may have changed", false);
                }
                if (jsonTrue(r1.body, "isAuthenticated")) return new Result(true, "the portal session was already open", false);
                String m = jsonString(r1.body, "m");
                String e = jsonString(r1.body, "e");
                if (r1.status != 200 || m == null || e == null || m.isEmpty() || e.isEmpty()) {
                    return new Result(false, "the portal did not give its key: its login procedure may have changed", false);
                }
                String token = jsonString(r1.body, "loginToken");
                String enc;
                try {
                    enc = cpEncrypt(m, e, token == null ? "" : token, password, random);
                } catch (IllegalArgumentException ex) {
                    return new Result(false, ex.getMessage(), false);
                }
                Response r2 = t.send("POST", "Login",
                        "realm=passwordRealm&username=" + URLEncoder.encode(user, "UTF-8") + "&password=" + enc);
                if (!isJsonObject(r2.body)) {
                    return new Result(false, "unreadable answer to the login (HTTP " + r2.status
                            + "): the login procedure may have changed", false);
                }
                String type = jsonString(r2.body, "type");
                if (type == null) type = "";
                String msg = jsonString(r2.body, "message");
                msg = msg == null ? "" : msg.replaceAll("<[^>]*>", "").trim();
                switch (type) {
                    case "SUCCESS":
                        try {
                            t.send("POST", "GetStateAndView", "");
                        } catch (IOException ignored) {
                            // the session is open; this step only completes the page's own sequence
                        }
                        return new Result(true, "logged in to the Virgo portal", false);
                    case "SESSION_FAILURE":
                        continue; // the page asks for a new key and tries once more
                    case "CHALLENGE":
                        return new Result(false, "the portal asks for a second step, which the application cannot do", true);
                    case "AUTH_FAILURE":
                        return new Result(false, "the portal refused the login or the password"
                                + (msg.isEmpty() ? "" : " (" + msg + ")"), true);
                    default:
                        return new Result(false, "the portal answered \"" + type + "\"" + (msg.isEmpty() ? "" : ": " + msg), false);
                }
            }
            return new Result(false, "the portal session failed twice", false);
        } catch (SSLHandshakeException | SSLPeerUnverifiedException ex) {
            return new Result(false, "the portal certificate was not accepted (" + shorten(ex.getMessage())
                    + "): check the certificate name", false);
        } catch (SocketTimeoutException ex) {
            return new Result(false, "the portal did not answer", false);
        } catch (IOException | RuntimeException ex) {
            return new Result(false, "the portal was not reached (" + shorten(ex.toString()) + ")", false);
        }
    }

    /** Logs in to the portal at portalUrl. */
    static Result login(String portalUrl, String certName, String user, String password) {
        Session session;
        try {
            session = new Session(portalUrl, certName);
        } catch (IllegalArgumentException ex) {
            return new Result(false, ex.getMessage(), false);
        }
        return loginWith(session, user, password, new SecureRandom());
    }

    private static String shorten(String s) {
        if (s == null) return "";
        return s.length() > 100 ? s.substring(0, 100) : s;
    }

    // --- The few JSON values of the portal's answers (flat objects of strings and booleans)

    private static boolean isJsonObject(String body) {
        return body != null && body.trim().startsWith("{");
    }

    static String jsonString(String json, String key) {
        Matcher m = Pattern.compile("\"" + Pattern.quote(key) + "\"\\s*:\\s*\"((?:[^\"\\\\]|\\\\.)*)\"").matcher(json);
        if (!m.find()) return null;
        String raw = m.group(1);
        if (raw.indexOf('\\') < 0) return raw;
        StringBuilder out = new StringBuilder(raw.length());
        for (int i = 0; i < raw.length(); i++) {
            char c = raw.charAt(i);
            if (c != '\\' || i + 1 >= raw.length()) {
                out.append(c);
                continue;
            }
            char d = raw.charAt(++i);
            switch (d) {
                case 'n': out.append('\n'); break;
                case 't': out.append('\t'); break;
                case 'r': out.append('\r'); break;
                case 'b': case 'f': out.append(' '); break;
                case 'u':
                    if (i + 4 <= raw.length() - 1) {
                        try {
                            out.append((char) Integer.parseInt(raw.substring(i + 1, i + 5), 16));
                            i += 4;
                        } catch (NumberFormatException ex) {
                            out.append('u');
                        }
                    } else {
                        out.append('u');
                    }
                    break;
                default: out.append(d); // \" \\ \/
            }
        }
        return out.toString();
    }

    static boolean jsonTrue(String json, String key) {
        return Pattern.compile("\"" + Pattern.quote(key) + "\"\\s*:\\s*true\\b").matcher(json).find();
    }

    /**
       HTTPS session with the portal, with its cookies; one connection per request.

       certName: the name on the portal's certificate when it differs from the
       address (the firewall node presents a certificate issued for another
       name). The connection then goes to the address, and the certificate is
       checked, fully, against that name. Verification is never switched off.
    */
    static final class Session implements Transport {

        private static final int TIMEOUT_MS = 20000;
        private static final int MAX_BODY = 8 * 1024 * 1024;

        private final URI page;
        private final String connectHost;
        private final int port;
        private final String tlsHost;
        private final Map<String, String> cookies = new LinkedHashMap<String, String>();

        Session(String portalUrl, String certName) {
            URI u;
            try {
                u = new URI(portalUrl == null ? "" : portalUrl.trim());
            } catch (Exception ex) {
                throw new IllegalArgumentException("the portal address is not a valid URL");
            }
            if (!"https".equalsIgnoreCase(u.getScheme()) || u.getHost() == null || u.getHost().isEmpty()) {
                throw new IllegalArgumentException(
                        "the portal address must start with https:// (the password is not sent otherwise)");
            }
            page = u;
            connectHost = u.getHost();
            port = u.getPort() < 0 ? 443 : u.getPort();
            String cert = certName == null ? "" : certName.trim();
            tlsHost = cert.isEmpty() ? connectHost : cert;
        }

        @Override
        public Response send(String method, String action, String body) throws IOException {
            String path = page.resolve(action).getRawPath();
            byte[] payload = body.getBytes(StandardCharsets.UTF_8);
            StringBuilder head = new StringBuilder();
            head.append(method).append(' ').append(path).append(" HTTP/1.1\r\n");
            head.append("Host: ").append(tlsHost);
            if (port != 443) head.append(':').append(port);
            head.append("\r\n");
            head.append("User-Agent: VacuumSupervisor\r\nAccept: */*\r\nConnection: close\r\n");
            if (!cookies.isEmpty()) {
                head.append("Cookie: ");
                boolean first = true;
                for (Map.Entry<String, String> c : cookies.entrySet()) {
                    if (!first) head.append("; ");
                    head.append(c.getKey()).append('=').append(c.getValue());
                    first = false;
                }
                head.append("\r\n");
            }
            if ("POST".equals(method)) {
                head.append("Content-Type: application/x-www-form-urlencoded\r\n");
                head.append("Content-Length: ").append(payload.length).append("\r\n");
            }
            head.append("\r\n");

            Socket plain = new Socket();
            SSLSocket socket = null;
            try {
                plain.connect(new InetSocketAddress(connectHost, port), TIMEOUT_MS);
                plain.setSoTimeout(TIMEOUT_MS);
                socket = (SSLSocket) socketFactory().createSocket(plain, tlsHost, port, true);
                SSLParameters params = socket.getSSLParameters();
                params.setEndpointIdentificationAlgorithm("HTTPS"); // the certificate must be for tlsHost
                socket.setSSLParameters(params);
                socket.startHandshake();
                checkCertificateName(socket, tlsHost);

                OutputStream out = socket.getOutputStream();
                out.write(head.toString().getBytes(StandardCharsets.ISO_8859_1));
                out.write(payload);
                out.flush();
                return readResponse(new BufferedInputStream(socket.getInputStream()));
            } finally {
                try {
                    if (socket != null) socket.close();
                } catch (IOException ignored) {
                }
                try {
                    plain.close();
                } catch (IOException ignored) {
                }
            }
        }

        private static SSLSocketFactory factory;

        /**
           The platform's certificate authorities, plus the roots of portal-roots.pem:
           the authority that issued the portal's certificate (HARICA 2021, a public
           one) is missing from the Java 8 and older Android lists.
        */
        private static synchronized SSLSocketFactory socketFactory() throws IOException {
            if (factory != null) return factory;
            try {
                KeyStore store = KeyStore.getInstance(KeyStore.getDefaultType());
                store.load(null, null);
                TrustManagerFactory platform = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                platform.init((KeyStore) null);
                int count = 0;
                for (TrustManager tm : platform.getTrustManagers()) {
                    if (!(tm instanceof X509TrustManager)) continue;
                    for (X509Certificate ca : ((X509TrustManager) tm).getAcceptedIssuers()) {
                        store.setCertificateEntry("platform-" + (count++), ca);
                    }
                }
                InputStream pem = PortalLogin.class.getResourceAsStream("/portal-roots.pem");
                if (pem != null) {
                    try {
                        for (Certificate ca : CertificateFactory.getInstance("X.509").generateCertificates(pem)) {
                            store.setCertificateEntry("portal-" + (count++), ca);
                        }
                    } finally {
                        pem.close();
                    }
                }
                TrustManagerFactory all = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                all.init(store);
                SSLContext context = SSLContext.getInstance("TLS");
                context.init(null, all.getTrustManagers(), null);
                factory = context.getSocketFactory();
                return factory;
            } catch (GeneralSecurityException ex) {
                throw new IOException("the certificate authorities could not be read: " + ex.getMessage());
            }
        }

        /**
           Second check of the name on the certificate, after the one of the TLS
           layer, so that it never depends on the platform's defaults.
        */
        private static void checkCertificateName(SSLSocket socket, String host) throws IOException {
            Certificate[] chain = socket.getSession().getPeerCertificates();
            if (chain.length > 0 && chain[0] instanceof X509Certificate) {
                try {
                    Collection<List<?>> names = ((X509Certificate) chain[0]).getSubjectAlternativeNames();
                    if (names != null) {
                        for (List<?> entry : names) {
                            if (entry.size() >= 2 && Integer.valueOf(2).equals(entry.get(0))
                                    && nameMatches(String.valueOf(entry.get(1)), host)) {
                                return;
                            }
                        }
                    }
                } catch (CertificateParsingException ex) {
                    // refused below
                }
            }
            throw new SSLPeerUnverifiedException("the certificate is not for " + host);
        }

        static boolean nameMatches(String pattern, String host) {
            String p = pattern.toLowerCase(Locale.ENGLISH);
            String h = host.toLowerCase(Locale.ENGLISH);
            if (p.startsWith("*.")) {
                int dot = h.indexOf('.');
                return dot > 0 && h.substring(dot).equals(p.substring(1)) && h.indexOf('.', dot + 1) > 0;
            }
            return p.equals(h);
        }

        private Response readResponse(InputStream in) throws IOException {
            String statusLine = readLine(in);
            if (statusLine == null) throw new IOException("no answer from the portal");
            String[] parts = statusLine.split(" ");
            int status;
            try {
                status = Integer.parseInt(parts[1]);
            } catch (RuntimeException ex) {
                throw new IOException("unexpected answer from the portal");
            }
            int contentLength = -1;
            boolean chunked = false;
            String line;
            while ((line = readLine(in)) != null && !line.isEmpty()) {
                int colon = line.indexOf(':');
                if (colon < 0) continue;
                String name = line.substring(0, colon).trim().toLowerCase(Locale.ENGLISH);
                String value = line.substring(colon + 1).trim();
                if (name.equals("set-cookie")) {
                    int semi = value.indexOf(';');
                    String pair = semi >= 0 ? value.substring(0, semi) : value;
                    int eq = pair.indexOf('=');
                    if (eq > 0) cookies.put(pair.substring(0, eq).trim(), pair.substring(eq + 1).trim());
                } else if (name.equals("content-length")) {
                    try {
                        contentLength = Integer.parseInt(value);
                    } catch (NumberFormatException ignored) {
                    }
                } else if (name.equals("transfer-encoding")) {
                    chunked = value.toLowerCase(Locale.ENGLISH).contains("chunked");
                }
            }
            ByteArrayOutputStream body = new ByteArrayOutputStream();
            if (chunked) {
                while ((line = readLine(in)) != null) {
                    int semi = line.indexOf(';');
                    String sizeText = (semi >= 0 ? line.substring(0, semi) : line).trim();
                    if (sizeText.isEmpty()) continue;
                    int size;
                    try {
                        size = Integer.parseInt(sizeText, 16);
                    } catch (NumberFormatException ex) {
                        throw new IOException("unexpected answer from the portal");
                    }
                    if (size == 0) break;
                    copy(in, body, size);
                }
            } else if (contentLength >= 0) {
                copy(in, body, contentLength);
            } else {
                try {
                    copy(in, body, MAX_BODY);
                } catch (SSLException ex) {
                    // connection closed without the TLS closing message: what was read is the answer
                    if (body.size() == 0) throw ex;
                }
            }
            return new Response(status, new String(body.toByteArray(), StandardCharsets.UTF_8));
        }

        /** Copies up to count bytes; stops at the end of the stream. */
        private static void copy(InputStream in, ByteArrayOutputStream out, int count) throws IOException {
            byte[] buf = new byte[8192];
            int left = count;
            while (left > 0) {
                int n = in.read(buf, 0, Math.min(buf.length, left));
                if (n < 0) break;
                out.write(buf, 0, n);
                left -= n;
                if (out.size() > MAX_BODY) throw new IOException("answer too long from the portal");
            }
        }

        private static String readLine(InputStream in) throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;
            boolean any = false;
            while ((c = in.read()) >= 0) {
                any = true;
                if (c == '\n') break;
                if (c != '\r') sb.append((char) c);
                if (sb.length() > 65536) throw new IOException("unexpected answer from the portal");
            }
            return any ? sb.toString() : null;
        }
    }
}
