package com.mcmxc.controller.exceptions;

public class FormParamaterParsingException extends PresentationException {

    public FormParamaterParsingException(String message, Throwable cause,
                                         boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public FormParamaterParsingException(String message, Throwable cause) {
        super(message, cause);
    }

    public FormParamaterParsingException(String message) {
        super(message);
    }

    public FormParamaterParsingException(Throwable cause) {
        super(cause);
    }

    public FormParamaterParsingException() {
    }

}
