package com.app.store.controller;

import com.app.store.common.Response;
import com.app.store.dto.ProductDTO;
import com.app.store.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Order controller
 * Provides order management
 */
@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService storeService;

    @GetMapping("/all")
    public ResponseEntity<Response<List<ProductDTO>>> getAllProducts() {
        return ResponseEntity.ok(
                Response.<List<ProductDTO>>builder()
                        .data(this.storeService.getAll())
                        .build()
        );
    }

}
