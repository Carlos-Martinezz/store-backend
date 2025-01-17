package com.app.store.configuration.feign;

import com.app.store.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Fake store client
 * Client configuration for Fake Store API resource consumption
 */
@FeignClient(name = "fakeStoreClient", url = "${data-provider.url}")
public interface FakeStoreFeignClient {

    @GetMapping("/products")
    List<ProductDTO> getProducts();

}
