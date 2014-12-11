package de.hdodenhof.xingapi.internal.response;

import java.util.List;

import de.hdodenhof.xingapi.models.Comment;

public class CommentsWrapper implements ResponseWrapper<List<Comment>> {

    List<Comment> comments;

    @Override
    public List<Comment> unwrap() {
        return comments;
    }
}
