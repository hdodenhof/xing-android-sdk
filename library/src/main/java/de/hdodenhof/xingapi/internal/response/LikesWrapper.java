package de.hdodenhof.xingapi.internal.response;

import java.util.List;

import de.hdodenhof.xingapi.models.User;

public class LikesWrapper implements ResponseWrapper<List<User>> {

    List<User> likes;

    @Override
    public List<User> unwrap() {
        return likes;
    }

}
