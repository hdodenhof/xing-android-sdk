package de.hdodenhof.xingapi.models;

import java.util.Date;

public class Comment {

    private String id;
    private Date createdAt;
    private String content;
    private User creator;

    public String getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getContent() {
        return content;
    }

    public User getCreator() {
        return creator;
    }

}
