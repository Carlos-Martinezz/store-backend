package com.app.store.dto;

/**
 * Detail of an order item or product
 */
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

    /** Complementary information **/
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
