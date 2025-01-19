package com.app.store.service;

import com.app.store.dto.CartDTO;

/**
 * Cart service interface
 * Definition or contract of the methods available for implementation.
 */
public interface CartService {

    /**
     * Create cart
     * Allows you to create a new cart for a customer
     *
     * @param customerId A valid customer database id
     * @return Created cart
     */
    CartDTO create(Long customerId);

    /**
     * Manage cart
     * Allows you to interact with the shopping cart, modifying it on demand
     *
     * @param cart Complete cart object
     * @return Updated cart
     */
    CartDTO manage(CartDTO cart);

}
