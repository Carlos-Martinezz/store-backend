package com.app.store.repository;

import com.app.store.entity.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {

    List<Cart> findByCustomerId(Long customerId);

}