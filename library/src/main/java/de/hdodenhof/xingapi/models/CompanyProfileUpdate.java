package de.hdodenhof.xingapi.models;

import java.util.Date;

import de.hdodenhof.xingapi.enums.ActivityObjectType;

public class CompanyProfileUpdate extends ActivityObject {

    private Date createdAt;
    private String name;
    private String permalink;
    private String description;

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getName() {
        return name;
    }

    public String getPermalink() {
        return permalink;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public ActivityObjectType getType() {
        return ActivityObjectType.COMPANY_PROFILE_UPDATE;
    }
}
