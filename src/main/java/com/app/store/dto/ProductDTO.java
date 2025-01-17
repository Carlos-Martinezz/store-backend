package com.app.store.dto;

import lombok.Data;

/**
 * Product dto
 *
 * Represents a product available in the store.
 */
@Data
public class ProductDTO {

    /* Product details */

    /**
     * Database identifier
     */
    private int id;

    /**
     * Comercial title
     */
    private String title;

    /**
     * Unit price
     */
    private String price;

    /**
     * Assigned category
     */
    private String category;

    /**
     * Complete description
     */
    private String description;

    /**
     * Reference image
     */
    private String image;

}
