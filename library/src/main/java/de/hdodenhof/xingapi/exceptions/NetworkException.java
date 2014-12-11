package de.hdodenhof.xingapi.exceptions;

public class NetworkException extends BaseException {

    public NetworkException(String message) {
        super(message);
    }

    public NetworkException(Throwable cause) {
        super(cause);
    }
}
