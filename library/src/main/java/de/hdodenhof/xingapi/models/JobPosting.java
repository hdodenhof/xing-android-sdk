package de.hdodenhof.xingapi.models;

import java.util.Date;

import de.hdodenhof.xingapi.enums.ActivityObjectType;

public class JobPosting extends ActivityObject {

    private Date createdAt;
    private String name;
    private String permalink;

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
        return ActivityObjectType.JOB_POSTING;
    }
}
