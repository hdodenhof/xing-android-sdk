package de.hdodenhof.xingapi.models;

public class IdCard {

    private String id;
    private String displayName;
    private String permalink;
    private PhotoUrls photoUrls;

    public String getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getPermalink() {
        return permalink;
    }

    public PhotoUrls getPhotoUrls() {
        return photoUrls;
    }
}
