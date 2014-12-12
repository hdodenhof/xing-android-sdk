package de.hdodenhof.xingapi.models;

import java.util.Date;

import de.hdodenhof.xingapi.enums.ActivityObjectType;

public class Group extends ActivityObject {

    private String displayName;
    private String permalink;
    private Date createdAt;

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getPermalink() {
        return permalink;
    }

    @Override
    public ActivityObjectType getType() {
        return ActivityObjectType.GROUP;
    }
}
