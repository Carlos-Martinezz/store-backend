package com.app.store.exception;

import lombok.Data;

/**
 *  Custom exception for handled errors
 */
@Data
public class TechnicalException extends RuntimeException{

    private int errorCode;

    public TechnicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public TechnicalException(String message) {
        super(message);
    }

    public TechnicalException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

}
