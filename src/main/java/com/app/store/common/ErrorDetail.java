package com.app.store.common;

import lombok.Builder;
import lombok.Data;

/**
 * Represents a specific error
 */
@Data
@Builder
public class ErrorDetail {

    /**
     * Specific error code
     */
    private int errorCode;

    /**
     * Message generated
     */
    private String message;

    /**
     * Transaction identifier
     */
    private String traceId;

}
