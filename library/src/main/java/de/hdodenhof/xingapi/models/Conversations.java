package de.hdodenhof.xingapi.models;

import java.util.List;

public class Conversations{

    private List<Conversation> items;
    private Integer total;
    private Integer unreadCount;

    public List<Conversation> getItems() {
        return items;
    }

    public Integer getTotal() {
        return total;
    }

    public Integer getUnreadCount() {
        return unreadCount;
    }
}
