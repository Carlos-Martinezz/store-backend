package com.app.store.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents one product of a cart
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDTO {

    /**
     * Item database identifier
     */
    private Long id;

    /**
     * Product database identifier
     */
    private Long productId;

    /**
     * Product name
     */
    private String productName;

    /**
     * Quantity of the product
     */
    private Integer quantity;

    /**
     * Unit price of the product
     */
    private Double price;

    /**
     * Cart identifier that this item belongs to
     */
    private Long cartId;

}
