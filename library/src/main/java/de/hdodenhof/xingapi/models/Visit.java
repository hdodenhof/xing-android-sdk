package de.hdodenhof.xingapi.models;

public class Visit {

    private String userId;
    private String displayName;
    private String companyName;
    private PhotoUrls photoUrls;
    private Integer visitCount;

    public String getUserId() {
        return userId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public PhotoUrls getPhotoUrls() {
        return photoUrls;
    }

    public Integer getVisitCount() {
        return visitCount;
    }
}
