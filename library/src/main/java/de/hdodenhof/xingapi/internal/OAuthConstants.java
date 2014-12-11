package de.hdodenhof.xingapi.internal;

public abstract class OAuthConstants {

    public static final String CALLBACK_URL = "xingapi://callback";
    public static final String VERIFIER_KEY = "oauth_verifier";

    public static final String[] WEBVIEW_INTERNAL_REDIRECT_URLS = new String[]{"https://api.xing.com",
            "https://login.xing.com"};

}
