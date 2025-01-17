package com.app.store.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Detail of an order item or product
 */
@Data
@Builder
public class OrderItem {

    /**
     * Product database identifier
     */
    private int productId;

    /**
     * Quantity of products
     */
    private int quantity;

    /**
     * Unit price
     */
    private double price;

}
