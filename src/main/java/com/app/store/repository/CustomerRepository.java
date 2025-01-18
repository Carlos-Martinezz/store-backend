package com.app.store.repository;

import com.app.store.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This repository allows you to manage customers.
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
