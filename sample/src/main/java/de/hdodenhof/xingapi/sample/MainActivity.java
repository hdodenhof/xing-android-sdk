package de.hdodenhof.xingapi.sample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import de.hdodenhof.xingapi.XingApiClient;
import de.hdodenhof.xingapi.models.User;

public class MainActivity extends ActionBarActivity {

    private static final String CONSUMER_KEY = "";
    private static final String CONSUMER_SECRET = "";

    private XingApiClient mXingApiClient;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.action_toolbar);
        setSupportActionBar(toolbar);

        mXingApiClient = new XingApiClient(CONSUMER_KEY, CONSUMER_SECRET, new Logger());

        getSupportFragmentManager().beginTransaction().add(R.id.container, OAuthFragment.newInstance()).commit();
    }

    public XingApiClient getXingApiClient() {
        return mXingApiClient;
    }

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;
    }

    private class Logger implements XingApiClient.Logger {

        private static final String TAG = "XingAPI";

        @Override
        public void log(String message) {
            Log.d(TAG, message);
        }
    }

}
