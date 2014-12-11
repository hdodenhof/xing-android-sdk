package de.hdodenhof.xingapi.internal.response;

import de.hdodenhof.xingapi.models.ProfileMessage;

public class ProfileMessageWrapper implements ResponseWrapper<ProfileMessage> {

    ProfileMessage profileMessage;

    @Override
    public ProfileMessage unwrap() {
        return profileMessage;
    }
}
