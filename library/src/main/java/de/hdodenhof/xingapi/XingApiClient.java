package de.hdodenhof.xingapi;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.squareup.okhttp.OkHttpClient;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.XingApi;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import de.hdodenhof.xingapi.internal.AuthHandler;
import de.hdodenhof.xingapi.internal.OAuthConstants;
import de.hdodenhof.xingapi.internal.communication.SigningOkClient;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class XingApiClient {

    public interface AuthenticationCallback extends AuthHandler.Callback {
    }

    public interface Logger {
        public void log(String message);
    }

    private static final String API_ENDPOINT = "https://api.xing.com";
    private static final String API_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";
    private static final int HTTP_CONNECT_TIMEOUT_SECONDS = 5;
    private static final int HTTP_READ_TIMEOUT_SECONDS = 10;

    private final OAuthService mOAuthService;
    private final SigningOkClient mClient;
    private final RestAdapter mRestAdapter;
    private final Logger mLogger;

    private ContactsAPI mContactsAPI;
    private MessagesAPI mMessagesAPI;
    private NetworkFeedAPI mNetworkFeedAPI;
    private ProfileVisitsAPI mProfileVisitsAPI;
    private UserProfilesAPI mUserProfilesAPI;

    public XingApiClient(String consumerKey, String consumerSecret, Logger logger) {
        mOAuthService = new ServiceBuilder()
                .provider(XingApi.class)
                .apiKey(consumerKey)
                .apiSecret(consumerSecret)
                .callback(OAuthConstants.CALLBACK_URL)
                .build();

        mClient = buildClient(mOAuthService);

        mRestAdapter = new RestAdapter.Builder()
                .setEndpoint(API_ENDPOINT)
                .setClient(mClient)
                .setConverter(buildGsonConverter())
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        mLogger = logger;
    }

    private SigningOkClient buildClient(OAuthService oAuthService) {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(HTTP_CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        okHttpClient.setReadTimeout(HTTP_READ_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        return new SigningOkClient(okHttpClient, oAuthService);
    }

    private GsonConverter buildGsonConverter() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setDateFormat(API_DATE_FORMAT)
                .create();
        return new GsonConverter(gson);
    }

    public void setCredentials(String accessToken, String secret) {
        mClient.setAccessToken(new Token(accessToken, secret));
    }

    public void requestAuthentication(Context context, AuthenticationCallback callback) {
        AuthHandler authHandler = new AuthHandler(mOAuthService);
        authHandler.authenticate(context, callback);
    }

    public ContactsAPI getContactsAPI() {
        if (mContactsAPI == null) {
            mContactsAPI = new ContactsAPI(mRestAdapter);
        }
        return mContactsAPI;
    }

    public MessagesAPI getMessagesAPI() {
        if (mMessagesAPI == null) {
            mMessagesAPI = new MessagesAPI(mRestAdapter);
        }
        return mMessagesAPI;
    }

    public NetworkFeedAPI getNetworkFeedAPI() {
        if (mNetworkFeedAPI == null) {
            mNetworkFeedAPI = new NetworkFeedAPI(mRestAdapter);
        }
        return mNetworkFeedAPI;
    }

    public ProfileVisitsAPI getProfileVisitsAPI() {
        if (mProfileVisitsAPI == null) {
            mProfileVisitsAPI = new ProfileVisitsAPI(mRestAdapter);
        }
        return mProfileVisitsAPI;
    }

    public UserProfilesAPI getUserProfilesAPI() {
        if (mUserProfilesAPI == null) {
            mUserProfilesAPI = new UserProfilesAPI(mRestAdapter);
        }
        return mUserProfilesAPI;
    }
}
