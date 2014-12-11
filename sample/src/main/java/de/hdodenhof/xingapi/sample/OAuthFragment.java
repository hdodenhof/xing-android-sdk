package de.hdodenhof.xingapi.sample;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import de.hdodenhof.xingapi.XingApiClient;
import de.hdodenhof.xingapi.models.User;

public class OAuthFragment extends Fragment {

    private XingApiClient mXingApiClient;

    @InjectView(R.id.btn_auth)
    Button mButtonAuth;

    @InjectView(R.id.progress)
    ProgressBar mProgressBar;

    public static OAuthFragment newInstance() {
        return new OAuthFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_oauth, container, false);
        ButterKnife.inject(this, rootView);

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mXingApiClient = ((MainActivity) activity).getXingApiClient();
    }

    private void setProgress(boolean progress) {
        if (progress) {
            mButtonAuth.setVisibility(View.GONE);
            mProgressBar.setVisibility(View.VISIBLE);
        } else {
            mProgressBar.setVisibility(View.GONE);
            mButtonAuth.setVisibility(View.VISIBLE);
        }
    }

    @OnClick(R.id.btn_auth)
    public void doAuth() {
        setProgress(true);
        mXingApiClient.requestAuthentication(getActivity(), new XingApiClient.AuthenticationCallback() {
            @Override
            public void onSuccess(String token, String secret) {
                mXingApiClient.setCredentials(token, secret);
                loadUser();
            }

            @Override
            public void onCancel() {
                Toast.makeText(getActivity(), "OAuth canceled", Toast.LENGTH_SHORT).show();
                setProgress(false);
            }

            @Override
            public void onFailure() {
                Toast.makeText(getActivity(), "OAuth failed", Toast.LENGTH_SHORT).show();
                setProgress(false);
            }
        });
    }

    private void loadUser() {
        new AsyncTask<Void, Void, User>(){
            @Override
            protected User doInBackground(Void... params) {
                return mXingApiClient.getUserProfilesAPI().getMe();
            }

            @Override
            protected void onPostExecute(User user) {
                if (user != null) {
                    ((MainActivity) getActivity()).setUser(user);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, ProfileFragment.newInstance()).commit();
                } else {
                    Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_SHORT).show();
                    setProgress(false);
                }
            }
        }.execute();
    }

}
