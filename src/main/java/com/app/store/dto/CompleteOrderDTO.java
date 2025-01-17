package com.app.store.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Order request
 * Representa el detalle completo de una orden.
 */
@Data
@Builder
public class CompleteOrderDTO {

    /**
     * Order database id
     */
    private Long id;

    /**
     * Customer database identifier
     */
    private Long customerId;

    /**
     * List of product ids
     */
    private String items;

    /**
     * Total amount to pay
     */
    private double totalAmount;

    /**
     * Order status
     */
    private String status;

    /**
     * Optional message
     */
    private String message;

}
