package com.app.store.service;

import com.app.store.dto.CompleteOrderDTO;
import com.app.store.dto.OrderDTO;
import com.app.store.dto.PaymentDetailDTO;
import com.app.store.dto.PaymentRequestDTO;

import java.util.List;

public interface PaymentService {

    /**
     * Process and make a payment
     *
     * @param customerId A valid customerId
     * @param payAll Flag that determines whether the customer will pay for all orders
     * @param ordersId In case you do not want to pay for all the orders, this parameter will bring the ids of the orders that must be paid.
     *
     * @return PaymentDetailDTO All payment details
     */
    PaymentDetailDTO processPayment(PaymentRequestDTO paymentRequestDTO);

}
