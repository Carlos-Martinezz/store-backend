package com.app.store.controller;

import com.app.store.common.Response;
import com.app.store.dto.CartDTO;
import com.app.store.service.CartService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Cart controller
 *
 * Allows manage cart
 * Note: To make the test easier, in this controller we do not use the standard response with "Response"-
 * -but rather we return the original CartDTO object, to be able to handle it more easily in Postman
 */
@RestController
@RequestMapping("/api/v1/cart")
@AllArgsConstructor
@Slf4j
public class CartController {

    private final CartService cartService;

    @PostMapping("/create/{customerId}")
    public ResponseEntity<CartDTO> createCart(@RequestHeader(required = true) String traceId,
                                                        @PathVariable Long customerId) {
        log.info("[createCart] traceId: {}", traceId);
        return ResponseEntity.ok(this.cartService.create(customerId));
    }

    @PutMapping("/update")
    public ResponseEntity<CartDTO> updateCart(@RequestHeader(required = true) String traceId,
                                                        @RequestBody CartDTO cart) {
        log.info("[updateCart] - traceId: {}", traceId);
        return ResponseEntity.ok(this.cartService.manage(cart));
    }

}