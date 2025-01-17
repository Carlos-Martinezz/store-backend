package com.app.store.dto;

import lombok.Data;

import java.util.List;

/**
 * Represents a simple request for payment
 */
@Data
public class PaymentRequestDTO {

    /**
     * Customer database identifier
     */
    private Long customerId;

    /**
     * Indicates whether all orders should be paid
     */
    private Boolean payAll;

    /**
     * List of order IDs to be paid
     */
    private List<Long> ordersId;

}