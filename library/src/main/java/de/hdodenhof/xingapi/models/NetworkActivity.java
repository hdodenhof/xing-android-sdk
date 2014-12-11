package de.hdodenhof.xingapi.models;

import java.util.Date;
import java.util.List;

import de.hdodenhof.xingapi.enums.ActivityAction;
import de.hdodenhof.xingapi.enums.ActivityAggregator;
import de.hdodenhof.xingapi.enums.ActivityVerb;

public class NetworkActivity {

    private List<ActivityObject> actors;
    private ActivityVerb verb;
    private List<ActivityObject> objects;
    private List<Group> targets;
    private List<String> ids;
    private String type;
    private Boolean aggregated;
    private ActivityAggregator aggregatedBy;
    private List<ActivityAction> possibleActions;
    private Date createdAt;
    private List<String> changes;
    private MetaComment comments;
    private MetaLike likes;

    public List<ActivityObject> getActors() {
        return actors;
    }

    public ActivityVerb getVerb() {
        return verb;
    }

    public List<ActivityObject> getObjects() {
        return objects;
    }

    public List<Group> getTargets() {
        return targets;
    }

    public List<String> getIds() {
        return ids;
    }

    public String getType() {
        return type;
    }

    public Boolean getAggregated() {
        return aggregated;
    }

    public ActivityAggregator getAggregatedBy() {
        return aggregatedBy;
    }

    public List<ActivityAction> getPossibleActions() {
        return possibleActions;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public List<String> getChanges() {
        return changes;
    }

    public MetaComment getComments() {
        return comments;
    }

    public MetaLike getLikes() {
        return likes;
    }
}
