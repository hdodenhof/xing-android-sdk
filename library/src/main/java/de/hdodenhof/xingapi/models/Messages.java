package de.hdodenhof.xingapi.models;

import java.util.List;

public class Messages {

    private List<Message> items;
    private Integer total;

    public List<Message> getItems() {
        return items;
    }

    public Integer getTotal() {
        return total;
    }
}
