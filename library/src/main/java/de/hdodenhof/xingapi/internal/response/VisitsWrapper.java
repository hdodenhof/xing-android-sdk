package de.hdodenhof.xingapi.internal.response;

import java.util.List;

import de.hdodenhof.xingapi.models.Visit;

public class VisitsWrapper implements ResponseWrapper<List<Visit>> {

    List<Visit> visits;

    @Override
    public List<Visit> unwrap() {
        return visits;
    }
}
