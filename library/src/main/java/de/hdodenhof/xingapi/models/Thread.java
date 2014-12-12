package de.hdodenhof.xingapi.models;

import java.util.Date;

import de.hdodenhof.xingapi.enums.ActivityObjectType;

public class Thread extends ActivityObject {

    private Date createdAt;
    private String title;
    private String permalink;

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getTitle() {
        return title;
    }

    public String getPermalink() {
        return permalink;
    }

    @Override
    public ActivityObjectType getType() {
        return ActivityObjectType.THREAD;
    }
}
