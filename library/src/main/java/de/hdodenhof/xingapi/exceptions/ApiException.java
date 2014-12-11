package de.hdodenhof.xingapi.exceptions;

import de.hdodenhof.xingapi.models.ErrorResponse;

public class ApiException extends BaseException {

    private final int mStatusCode;
    private final ErrorResponse mErrorResponse;

    public ApiException(int statusCode, ErrorResponse errorResponse) {
        mStatusCode = statusCode;
        mErrorResponse = errorResponse;
    }

    public int getStatusCode() {
        return mStatusCode;
    }

    public ErrorResponse getErrorResponse() {
        return mErrorResponse;
    }
}
