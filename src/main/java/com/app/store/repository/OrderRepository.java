package com.app.store.repository;

import com.app.store.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This repository allows you to manage orders.
 */
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findByCustomerIdAndPaymentStatus(Long customerId, String paymentStatus);

    List<Order> findByCustomerId(Long customerId);

}
