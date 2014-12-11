package de.hdodenhof.xingapi.exceptions;

public class ConversionException extends BaseException {

    public ConversionException(String message) {
        super(message);
    }

    public ConversionException(Throwable cause) {
        super(cause);
    }
}
