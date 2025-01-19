package com.app.store.controller;

import com.app.store.common.Response;
import com.app.store.dto.PaymentDetailDTO;
import com.app.store.dto.PaymentRequestDTO;
import com.app.store.service.PaymentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Payment controller
 *
 * Allows you to simulate the payment of orders
 */
@RestController
@RequestMapping("/api/v1/payments")
@AllArgsConstructor
@Slf4j
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity<Response<PaymentDetailDTO>> createPayment(@RequestHeader(required = true) String traceId,
                                                                  @RequestBody PaymentRequestDTO paymentRequestDTO) {
        log.info("[createPayment] traceId: {}", traceId);
        return ResponseEntity.ok(
                Response.<PaymentDetailDTO>builder()
                        .data(this.paymentService.processPayment(paymentRequestDTO))
                        .build()
        );
    }

}