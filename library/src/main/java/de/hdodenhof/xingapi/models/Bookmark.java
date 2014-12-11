package de.hdodenhof.xingapi.models;

import java.util.Date;

import de.hdodenhof.xingapi.enums.ActivityObjectType;

public class Bookmark implements ActivityObject {

    private String id;
    private Date createdAt;
    private String title;
    private User creator;
    private String url;
    private String description;
    private String image;
    private String bookmarkType;

    @Override
    public String getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getTitle() {
        return title;
    }

    public User getCreator() {
        return creator;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getBookmarkType() {
        return bookmarkType;
    }

    @Override
    public ActivityObjectType getType() {
        return ActivityObjectType.BOOKMARK;
    }
}
