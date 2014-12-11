package de.hdodenhof.xingapi.models;

import java.util.Date;

import de.hdodenhof.xingapi.enums.ActivityObjectType;

public class Event implements ActivityObject {

    private String id;
    private String name;
    private String permalink;
    private Date createdAt;

    @Override
    public String getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getName() {
        return name;
    }

    public String getPermalink() {
        return permalink;
    }

    @Override
    public ActivityObjectType getType() {
        return ActivityObjectType.EVENT;
    }
}
