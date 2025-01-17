package com.app.store.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

/**
 * Entity order
 * Represents the orders table and stores the data necessary to correctly identify an order.
 */
@Data
@Builder
@Entity
@Table(name = "order")
public class Order {

    /**
     * Table identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Customer database identifier
     */
    private Long customerId;

    /**
     * Order total amount
     */
    private Double totalAmount;

    /**
     * Order status
     */
    private String status;

    /**
     * Order items
     */
    private String items;

    /**
     * Order payment status
     */
    private String paymentStatus;

}
