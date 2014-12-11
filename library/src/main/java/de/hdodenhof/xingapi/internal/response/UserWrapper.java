package de.hdodenhof.xingapi.internal.response;

import java.util.List;

import de.hdodenhof.xingapi.models.User;

public class UserWrapper implements ResponseWrapper<List<User>> {

    List<User> users;

    @Override
    public List<User> unwrap() {
        return users;
    }

}
