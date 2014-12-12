package de.hdodenhof.xingapi.models;

import de.hdodenhof.xingapi.enums.ActivityObjectType;

public abstract class ActivityObject {

    private String id;

    public abstract ActivityObjectType getType();

    public String getId() {
        return id;
    }

}
