package com.app.store.service;

import com.app.store.dto.CompleteOrderDTO;
import com.app.store.dto.OrderDTO;

/**
 * Order service interface
 * Definition or contract of the methods available for implementation.
 */
public interface OrderService {

    /**
     * Process and store an order
     *
     * @param order Represents the complete detail of an order.
     * @return OrderDTO An order processed
     */
    CompleteOrderDTO processOrder(OrderDTO order);
}
