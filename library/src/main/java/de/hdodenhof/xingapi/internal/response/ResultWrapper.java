package de.hdodenhof.xingapi.internal.response;

import de.hdodenhof.xingapi.models.Results;

public class ResultWrapper<T> implements ResponseWrapper<Results<T>> {

    Results<T> results;

    @Override
    public Results<T> unwrap() {
        return results;
    }
}
