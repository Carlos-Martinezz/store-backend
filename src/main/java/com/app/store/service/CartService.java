package com.app.store.service;

import com.app.store.dto.CartDTO;

public interface CartService {

    /**
     * Create cart
     *
     * @param customerId A valida customer database id
     * @return Created cart
     */
    CartDTO create(Long customerId);

    /**
     * Manage cart
     *
     * @param cart Complete cart object
     * @return Updated cart
     */
    CartDTO manage(CartDTO cart);

}
