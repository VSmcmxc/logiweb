package com.mcmxc.controller.exceptions;

public class PresentationException extends Exception {

    public PresentationException(String message, Throwable cause,
                                 boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public PresentationException(String message, Throwable cause) {
        super(message, cause);
    }

    public PresentationException(String message) {
        super(message);
    }

    public PresentationException(Throwable cause) {
        super(cause);
    }

    public PresentationException() {

    }

}
