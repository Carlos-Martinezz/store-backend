package com.app.store.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Represents a global cart object
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {

    /**
     * Cart database identifier
     */
    private Long id;

    /**
     * Customer database identifier associated with the cart
     */
    private Long customerId;

    /**
     * List of items in the cart
     */
    private List<CartItemDTO> items;

    /**
     * Last updated timestamp
     */
    private LocalDateTime updatedAt;
}
