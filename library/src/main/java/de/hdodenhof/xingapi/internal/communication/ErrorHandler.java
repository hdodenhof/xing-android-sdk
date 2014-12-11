package de.hdodenhof.xingapi.internal.communication;

import de.hdodenhof.xingapi.exceptions.ConversionException;
import de.hdodenhof.xingapi.exceptions.NetworkException;
import de.hdodenhof.xingapi.exceptions.ApiException;
import de.hdodenhof.xingapi.models.ErrorResponse;
import retrofit.RetrofitError;

public class ErrorHandler {

    public static void handle(RetrofitError e) {
        switch (e.getKind()) {
            case NETWORK:
                throw new NetworkException(e);
            case CONVERSION:
                throw new ConversionException(e);
            case HTTP:
                throw new ApiException(e.getResponse().getStatus(), extractErrorResponse(e));
            default:
                throw e;

        }
    }

    private static ErrorResponse extractErrorResponse(RetrofitError e) {
        ErrorResponse error = null;
        try {
            error = (ErrorResponse) e.getBodyAs(ErrorResponse.class);
        } catch (Exception ignored) {
        }

        return error;
    }

}
