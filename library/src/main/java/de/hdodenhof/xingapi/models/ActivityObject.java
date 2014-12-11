package de.hdodenhof.xingapi.models;

import de.hdodenhof.xingapi.enums.ActivityObjectType;

public interface ActivityObject {

    public ActivityObjectType getType();

    public String getId();

}
