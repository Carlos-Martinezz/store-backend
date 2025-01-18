package com.app.store.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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
     * Customer database identifier
     */
    @NotNull(message = "customerId field is required")
    private Long customerId;

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
    @NotNull(message = "items field is required")
    @Valid
    private List<OrderItemDTO> items;

}
