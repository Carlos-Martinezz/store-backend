package com.app.store.repository;

import com.app.store.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * This repository allows you to manage customers.
 * Simulates that customers are in a repository or external customer database
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
