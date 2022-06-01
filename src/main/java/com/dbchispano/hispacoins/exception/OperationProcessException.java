package com.dbchispano.hispacoins.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OperationProcessException extends RuntimeException {

    public OperationProcessException() {
        super("An exception caused the operation to not be processed");
    }

    public OperationProcessException(String message) {
        super(message);
    }

    public OperationProcessException(String message, Throwable cause) {
        super(message, cause);
    }

    public OperationProcessException(Throwable cause) {
        super("The given exception caused the operation to not be processed", cause);
    }

    public OperationProcessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
