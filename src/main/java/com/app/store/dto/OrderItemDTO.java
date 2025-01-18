package com.app.store.dto;

import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Data;

/**
 * Detail of an order item or product
 */
@Data
@Builder
public class OrderItemDTO {

    /**
     * Product database identifier
     */
    @Min(value = 1, message = "productId field must be greater than 1")
    private int productId;

    /**
     * Quantity of products
     */
    @Min(value = 1, message = "productId field must be greater than 1")
    private int quantity;

    /**
     * Unit price
     */
    @Min(value = 1, message = "productId field must be greater than 1")
    private double price;

}
