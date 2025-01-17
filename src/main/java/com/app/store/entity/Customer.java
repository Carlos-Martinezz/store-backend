package com.app.store.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "customer")
public class Customer {

    /**
     * Table identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Customer full name
     */
    private String fullName;

    /**
     * Customer main email
     */
    private String email;

    /**
     * Customer full address
     */
    private Double address;

}
