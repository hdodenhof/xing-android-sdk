package de.hdodenhof.xingapi;

import java.util.List;

public abstract class BaseAPI {

    protected void validateNotEmpty(String arg, String argName) {
        if (arg == null || arg.isEmpty()) {
            throw new IllegalArgumentException(String.format("%s must not be NULL or empty", argName));
        }
    }

    protected void validateNotEmpty(List list, String argName) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException(String.format("%s must not be NULL or empty", argName));
        }
    }

}
