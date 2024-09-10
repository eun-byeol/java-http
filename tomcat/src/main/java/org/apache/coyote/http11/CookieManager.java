package org.apache.coyote.http11;

import java.util.UUID;

public class CookieManager {

    private static final String TOKEN_NAME = "JSESSIONID";

    private CookieManager() {
    }

    public static String setCookie() {
        return TOKEN_NAME + "=" + UUID.randomUUID();
    }
}