package de.hdodenhof.xingapi.internal.response;

import de.hdodenhof.xingapi.models.Results;

/**
 * Created by alfdev on 12/08/15.
 */
public class JobWrapper<T> implements ResponseWrapper<Results<T>> {

    Results<T> jobs;

    @Override
    public Results<T> unwrap() {
        return jobs;
    }
}
