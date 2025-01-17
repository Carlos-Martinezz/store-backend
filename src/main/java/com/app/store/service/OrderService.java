package com.app.store.service;

import com.app.store.dto.OrderDTO;

/**
 * Order service interface
 * Definition or contract of the methods available for implementation.
 */
public interface OrderService {

    /**
     * Process and store an order
     */
    OrderDTO processOrder(OrderDTO order);
}
