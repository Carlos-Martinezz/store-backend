package com.app.store.repository;

import com.app.store.entity.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * This repository allows you to manage orders.
 */
public interface OrderRepository extends CrudRepository<Order, Long> {

}
