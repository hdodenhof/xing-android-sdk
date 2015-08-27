package de.hdodenhof.xingapi.models;

import com.google.gson.annotations.SerializedName;

import de.hdodenhof.xingapi.enums.ActivityObjectType;

/**
 * Created by alfdev on 12/08/15.
 */
public class Job extends ActivityObject {

    private Location location;
    private String title;

    @SerializedName(value = "published_at")
    private String publishedAt;

    private Company company;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public ActivityObjectType getType() {
        return ActivityObjectType.JOB;
    }
}
