package com.app.store.service.impl;

import com.app.store.constant.PaymentStatus;
import com.app.store.dto.PaymentDetailDTO;
import com.app.store.dto.PaymentRequestDTO;
import com.app.store.entity.Customer;
import com.app.store.entity.Order;
import com.app.store.exception.TechnicalException;
import com.app.store.repository.CustomerRepository;
import com.app.store.repository.OrderRepository;
import com.app.store.service.PaymentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Payment service implementation
 */
@Service
@Slf4j
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    /**
     * Orders repository
     */
    private final OrderRepository orderRepository;

    /**
     * Customers repository
     */
    private final CustomerRepository customerRepository;

    /**
     * Process and make a payment
     *
     * @param paymentRequestDTO Object with the necessary data to simulate the payment.
     * @return PaymentDetailDTO All payment details
     */
    @Override
    public PaymentDetailDTO processPayment(PaymentRequestDTO paymentRequestDTO) {

        /**
         * Get complete customer information
         */
        Customer customer = this.customerRepository.findById(paymentRequestDTO.getCustomerId()).orElse(null);
        if (customer == null) {
            throw new TechnicalException("We could not find the client with the provided id", HttpStatus.NOT_FOUND.value());
        }

        List<Order> orders;

        if(paymentRequestDTO.getPayAll()) {
            orders = this.orderRepository.findByCustomerIdAndPaymentStatus(customer.getId(), PaymentStatus.NO_PAID.name());
        } else {
            orders = StreamSupport.stream(orderRepository.findAllById(paymentRequestDTO.getOrdersId()).spliterator(), false)
                    .collect(Collectors.toList());
        }

        if(orders == null || orders.isEmpty()) {
            throw new TechnicalException("We did not find any orders associated with the client provided.", HttpStatus.NOT_FOUND.value());
        }

        double totalAmountDue = orders.stream()
                .mapToDouble(Order::getTotalAmount)
                .sum();

        /**
         * Simulate payment
         */
        this.simulatePayment(customer, totalAmountDue);

        /**
         * Set customer orders as PAID
         */
        orders.forEach(order -> order.setPaymentStatus(PaymentStatus.PAID.name()));
        this.orderRepository.saveAll(orders);

        return PaymentDetailDTO.builder()
                .customerId(customer.getId()) // Customer database id
                .transactionId(UUID.randomUUID().toString()) // Transaction random
                .paymentDate(new Date())
                .totalPaid(totalAmountDue)
                .build();
    }

    /**
     * Simulate payment
     * This simulates a payment.
     * The payment after being processed or "prepared" by our service, can travel to a "core" or to a payment gateway such as Cybersource, etc.
     *
     * @param customer Valid customer
     * @param totalAmountDue Total amount to be paid by the client
     */
    private void simulatePayment(Customer customer, double totalAmountDue) {
        //TODO: Build the request for the payment gateway
        log.info("Payment was made successfully. Customer: {}, Total Amount Due: {}", customer, totalAmountDue);
    }

}
