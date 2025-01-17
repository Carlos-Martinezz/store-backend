package com.app.store.service;

import com.app.store.dto.ProductDTO;

import java.util.List;

/**
 * Store service interface
 * Definition or contract of the methods available for implementation.
 */
public interface ProductService {

    /**
     * Get all products
     *
     * @return A list of all available products from the supplier. List<ProductDTO>
     */
    List<ProductDTO> getAll();

}
