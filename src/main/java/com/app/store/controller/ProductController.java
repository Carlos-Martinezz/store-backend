package com.app.store.controller;

import com.app.store.common.Response;
import com.app.store.dto.ProductDTO;
import com.app.store.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
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
@Slf4j
public class ProductController {

    private final ProductService storeService;

    @GetMapping("/all")
    public ResponseEntity<Response<List<ProductDTO>>> getAllProducts(@RequestHeader(required = true) String traceId) {
        log.info("[getAllProducts] traceId: {}", traceId);
        return ResponseEntity.ok(
                Response.<List<ProductDTO>>builder()
                        .data(this.storeService.getAll())
                        .build()
        );
    }

}
