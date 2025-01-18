package com.app.store.repository;

import com.app.store.entity.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * This repository allows you to manage orders.
 */
public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findByCustomerIdAndPaymentStatus(Long customerId, String paymentStatus);

    List<Order> findByCustomerId(Long customerId);

}
