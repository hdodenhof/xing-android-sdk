package de.hdodenhof.xingapi.models;

import de.hdodenhof.xingapi.enums.Reason;

public class ApiError {

    private String field;
    private Reason reason;

    public String getField() {
        return field;
    }

    public Reason getReason() {
        return reason;
    }
}
