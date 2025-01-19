package com.app.store.service;

import com.app.store.dto.PaymentDetailDTO;
import com.app.store.dto.PaymentRequestDTO;

/**
 * Payment service interface
 * Definition or contract of the methods available for implementation.
 */
public interface PaymentService {

    /**
     * Process and make a payment
     *
     * @param paymentRequestDTO Object with the necessary data to simulate the payment.
     * @return PaymentDetailDTO All payment details
     */
    PaymentDetailDTO processPayment(PaymentRequestDTO paymentRequestDTO);

}
