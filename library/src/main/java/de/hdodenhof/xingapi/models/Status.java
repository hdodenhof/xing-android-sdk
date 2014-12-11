package de.hdodenhof.xingapi.models;

import java.util.Date;

import de.hdodenhof.xingapi.enums.ActivityObjectType;

public class Status implements ActivityObject {

    private String id;
    private Date createdAt;
    private String content;
    private User creator;

    @Override
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

    @Override
    public ActivityObjectType getType() {
        return ActivityObjectType.STATUS;
    }
}
