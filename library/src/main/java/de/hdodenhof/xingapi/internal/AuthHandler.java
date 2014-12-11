package de.hdodenhof.xingapi.internal;

import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import android.content.Context;
import android.os.AsyncTask;

import de.hdodenhof.xingapi.internal.widget.AuthWebDialog;

public class AuthHandler {

    private OAuthService mOAuthService;
    private Callback mCallback;

    public interface Callback {
        public void onSuccess(String token, String secret);
        public void onCancel();
        public void onFailure();
    }

    public AuthHandler(OAuthService oAuthService) {
        mOAuthService = oAuthService;
    }

    public void authenticate(final Context context, Callback callback) {
        mCallback = callback;

        new AsyncTask<Void, Void, Token>() {
            @Override
            protected Token doInBackground(Void... params) {
                try {
                    return mOAuthService.getRequestToken();
                } catch (Exception e) {
                    return null;
                }
            }

            @Override
            protected void onPostExecute(Token requestToken) {
                if (requestToken != null) {
                    showAuthDialog(context, requestToken);
                } else {
                    sendErrorToAuthListener();
                }
            }
        }.execute();
    }

    private void showAuthDialog(Context context, final Token requestToken) {
        new AuthWebDialog(context, mOAuthService.getAuthorizationUrl(requestToken), new AuthWebDialog.OnCompleteListener() {
            @Override
            public void onComplete(String verifier) {
                finishAuth(requestToken, new Verifier(verifier));
            }

            @Override
            public void onAbort() {
                sendCancelToAuthListener();
            }

            @Override
            public void onError() {
                sendErrorToAuthListener();
            }
        }).show();
    }

    private void finishAuth(final Token requestToken, final Verifier verifier) {
        new AsyncTask<Void, Void, Token>() {
            @Override
            protected Token doInBackground(Void... params) {
                try {
                    return mOAuthService.getAccessToken(requestToken, verifier);
                } catch (Exception e) {
                    return null;
                }
            }

            @Override
            protected void onPostExecute(Token accessToken) {
                if (accessToken != null && !accessToken.isEmpty()) {
                    sendSuccessToAuthListener(accessToken);
                } else {
                    sendErrorToAuthListener();
                }
            }
        }.execute();
    }

    private void sendSuccessToAuthListener(Token token) {
        if (mCallback != null) {
            mCallback.onSuccess(token.getToken(), token.getSecret());
        }
    }

    private void sendErrorToAuthListener() {
        if (mCallback != null) {
            mCallback.onFailure();
        }
    }

    private void sendCancelToAuthListener() {
        if (mCallback != null) {
            mCallback.onCancel();
        }
    }
}
