package de.hdodenhof.xingapi.models;

import java.util.List;

public class MetaComment {

    private Integer amount;
    private List<Comment> latestComments;
    private Boolean currentUserCommented;

    public Integer getAmount() {
        return amount;
    }

    public List<Comment> getLatestComments() {
        return latestComments;
    }

    public Boolean getCurrentUserCommented() {
        return currentUserCommented;
    }

}
