package com.app.store.service.impl;

import com.app.store.configuration.feign.FakeStoreFeignClient;
import com.app.store.dto.ProductDTO;
import com.app.store.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Store service implementation
 */
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final FakeStoreFeignClient fakeStoreFeignClient;

    /**
     * Get all products
     *
     * @return A list of all available products from the supplier. List<ProductDTO>
     */
    @Override
    public List<ProductDTO> getAll() {
        return this.fakeStoreFeignClient.getProducts();
    }
}
