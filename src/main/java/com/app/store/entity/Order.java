package com.app.store.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

/**
 * Entity order_entry
 * Represents the orders table and stores the data necessary to correctly identify an order.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_entry")
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

    /**
     * Creation date
     */
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date createdDate;

    /**
     * Updated date
     */
    @UpdateTimestamp
    @Column(nullable = false)
    private Date updatedDate;

}
