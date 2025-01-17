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
public class OrderDTO {

    /**
     * Customer full name
     */
    private String customerName;

    /**
     * Customer principal email
     */
    private String customerEmail;

    /**
     * Customer complete address
     */
    private String customerAddress;

    /**
     * List of ordered products
     */
    private List<OrderItem> items;

}
