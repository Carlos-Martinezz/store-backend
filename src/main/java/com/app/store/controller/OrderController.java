package com.app.store.controller;

import com.app.store.common.Response;
import com.app.store.dto.OrderDTO;
import com.app.store.dto.ProductDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Product controller
 *
 * Provides product information
 */
@RestController
@RequestMapping("/api/v1/orders")
@AllArgsConstructor
public class OrderController {

    @GetMapping("/create")
    public ResponseEntity<Response<List<ProductDTO>>> createOrder(@RequestBody OrderDTO order) {
        return ResponseEntity.ok(
                Response.<List<ProductDTO>>builder()
                        .data(this.storeService.getAll())
                        .build()
        );
    }

}
