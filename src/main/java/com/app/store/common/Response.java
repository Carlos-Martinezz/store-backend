package com.app.store.common;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * A standard response from store
 * It represents a standard response provided by the service that within its content can provide personalized information.
 * @param T Specifies the type of object to send in the data
 */
@Data
@Builder
public class Response<T> {

    /**
     * Contains payload
     */
    private T data;

    /**
     * Contains list errors
     */
    private List<ErrorDetail> errors;

}
