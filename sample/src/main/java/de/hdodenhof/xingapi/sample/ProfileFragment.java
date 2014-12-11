package de.hdodenhof.xingapi.sample;

import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import de.hdodenhof.xingapi.models.User;

public class ProfileFragment extends Fragment {

    @InjectView(R.id.profile_picture)
    ImageView mProfilePicture;

    @InjectView(R.id.user_name)
    TextView mUserName;

    @InjectView(R.id.haves)
    TextView mHaves;

    @InjectView(R.id.wants)
    TextView mWants;

    private User mUser;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.inject(this, rootView);

        Picasso.with(getActivity()).load(mUser.getPhotoUrls().getSize256()).into(mProfilePicture);

        mUserName.setText(mUser.getDisplayName());
        mHaves.setText(mUser.getHaves());
        mWants.setText(mUser.getWants());

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mUser = ((MainActivity) activity).getUser();
    }

}
