package de.hdodenhof.xingapi.internal.response;

import java.util.List;

import de.hdodenhof.xingapi.models.NetworkActivity;

public class NetworkActivityWrapper implements ResponseWrapper<List<NetworkActivity>> {

    List<NetworkActivity> networkActivities;

    @Override
    public List<NetworkActivity> unwrap() {
        return networkActivities;
    }
}
