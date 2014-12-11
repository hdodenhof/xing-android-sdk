package de.hdodenhof.xingapi.internal.communication;

import com.squareup.okhttp.OkHttpClient;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;

import android.net.Uri;

import java.io.IOException;
import java.util.Map;

import de.hdodenhof.xingapi.internal.util.HTTPUtils;
import retrofit.client.OkClient;
import retrofit.client.Request;
import retrofit.client.Response;

public class SigningOkClient extends OkClient {

    private final OAuthService mOAuthService;
    private Token mAccessToken;

    public SigningOkClient(OAuthService oAuthService) {
        mOAuthService = oAuthService;
    }

    public SigningOkClient(OkHttpClient client, OAuthService oAuthService) {
        super(client);
        mOAuthService = oAuthService;
    }

    public void setAccessToken(Token accessToken) {
        mAccessToken = accessToken;
    }

    @Override
    public Response execute(Request request) throws IOException {
        if (mAccessToken != null) {
            String method = request.getMethod();
            String url = request.getUrl();

            OAuthRequest oAuthRequest = new OAuthRequest(HTTPUtils.scribeVerbFromString(method), url);
            mOAuthService.signRequest(mAccessToken, oAuthRequest);

            Uri.Builder uriBuilder = Uri.parse(url).buildUpon();

            Map<String, String> oAuthParams = oAuthRequest.getOauthParameters();
            for (Map.Entry<String, String> oAuthParam : oAuthParams.entrySet()) {
                uriBuilder.appendQueryParameter(oAuthParam.getKey(), oAuthParam.getValue());
            }

            request = new Request(method, uriBuilder.build().toString(), request.getHeaders(), request.getBody());
        }
        return super.execute(request);
    }
}
