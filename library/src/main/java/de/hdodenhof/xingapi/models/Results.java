package de.hdodenhof.xingapi.models;

import java.util.List;

public class Results<T> {

    private List<T> items;
    private Integer total;

    public List<T> getItems() {
        return items;
    }

    public Integer getTotal() {
        return total;
    }
}
