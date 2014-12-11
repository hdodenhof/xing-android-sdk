package de.hdodenhof.xingapi.models;

import java.util.List;

import de.hdodenhof.xingapi.enums.ErrorName;

public class ErrorResponse {

    private String message;
    private ErrorName errorName;
    private List<ApiError> errors;

    public String getMessage() {
        return message;
    }

    public ErrorName getErrorName() {
        return errorName;
    }

    public List<ApiError> getErrors() {
        return errors;
    }
}
