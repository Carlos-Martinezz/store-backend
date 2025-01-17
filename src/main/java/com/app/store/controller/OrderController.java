package com.app.store.controller;

import com.app.store.common.Response;
import com.app.store.dto.CompleteOrderDTO;
import com.app.store.dto.OrderDTO;
import com.app.store.dto.ProductDTO;
import com.app.store.service.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Product controller
 *
 * Provides product information
 */
@RestController
@RequestMapping("/api/v1/orders")
@AllArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/create")
    public ResponseEntity<Response<CompleteOrderDTO>> createOrder(@RequestHeader(required = true) String traceId, @Valid @RequestBody @Validated OrderDTO order) {
        log.info("Received: {}", order);
        log.info("[createOrder] - traceId: {}", traceId);
        return ResponseEntity.ok(
                Response.<CompleteOrderDTO>builder()
                        .data(this.orderService.processOrder(order))
                        .build()
        );
    }

}
