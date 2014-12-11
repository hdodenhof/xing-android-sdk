package de.hdodenhof.xingapi.internal.response;

import java.util.List;

import de.hdodenhof.xingapi.models.NetworkActivity;

public class ActivityWrapper implements ResponseWrapper<List<NetworkActivity>> {

    List<NetworkActivity> activities;

    @Override
    public List<NetworkActivity> unwrap() {
        return activities;
    }
}
