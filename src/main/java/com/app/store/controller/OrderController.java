package com.app.store.controller;

import com.app.store.common.Response;
import com.app.store.dto.CompleteOrderDTO;
import com.app.store.dto.OrderDTO;
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

    @PostMapping("/create/{cartId}")
    public ResponseEntity<Response<CompleteOrderDTO>> createOrder(@RequestHeader(required = true) String traceId, @PathVariable Long cartId) {
        log.info("[createOrder] Cart received: {}", cartId);
        log.info("[createOrder] traceId: {}", traceId);
        return ResponseEntity.ok(
                Response.<CompleteOrderDTO>builder()
                        .data(this.orderService.processOrder(cartId))
                        .build()
        );
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Response<List<CompleteOrderDTO>>> getOrdersByCustomerId(@RequestHeader(required = true) String traceId, @PathVariable Long customerId) {
        log.info("[getOrdersByCustomerId] customerId received: {}", customerId);
        log.info("[getOrdersByCustomerId] traceId: {}", traceId);
        return ResponseEntity.ok(
                Response.<List<CompleteOrderDTO>>builder()
                        .data(this.orderService.getOrdersByCustomerId(customerId))
                        .build()
        );
    }

}
