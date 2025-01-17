package com.app.store.exception;

/**
 *  Custom exception for handled errors
 */
public class TechnicalException extends RuntimeException{

    public TechnicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public TechnicalException(String message) {
        super(message);
    }

}
