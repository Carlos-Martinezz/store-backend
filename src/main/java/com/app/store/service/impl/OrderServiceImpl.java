package com.app.store.service.impl;

import com.app.store.constant.OrderStatus;
import com.app.store.constant.PaymentStatus;
import com.app.store.dto.CompleteOrderDTO;
import com.app.store.entity.Cart;
import com.app.store.entity.CartItem;
import com.app.store.entity.Order;
import com.app.store.exception.TechnicalException;
import com.app.store.repository.CartRepository;
import com.app.store.repository.OrderRepository;
import com.app.store.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Order service implementation
 */
@Service
@AllArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    /**
     * Orders repository
     */
    private final OrderRepository orderRepository;

    /**
     * Cart repository
     */
    private final CartRepository cartRepository;

    /**
     * Process and store an order
     *
     * @param cartId A valid cart
     * @return OrderDTO An order processed
     */
    @Override
    public CompleteOrderDTO processOrder(Long cartId) {

        Cart cartToPay = this.cartRepository.findById(cartId).orElse(null);

        if(cartToPay == null) {
            throw new TechnicalException("We did not find any cart with the provided id.", HttpStatus.NOT_FOUND.value());
        }
        log.info("[processOrder] Find cart: {}", cartToPay);

        if(cartToPay.getItems().isEmpty()) {
            throw new TechnicalException("Your cart is empty.", HttpStatus.BAD_REQUEST.value());
        }

        double totalAmount = cartToPay.getItems().stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();

        Order savedOrder = this.orderRepository.save(
                Order.builder()
                     .customerId(cartToPay.getCustomerId())
                     .totalAmount(totalAmount)
                     .status(OrderStatus.PROCESSED.name())
                     .paymentStatus(PaymentStatus.NO_PAID.name())
                     .items(this.joinItemId(cartToPay.getItems()))
                     .build()
        );

        CompleteOrderDTO storedOrder;
        if(savedOrder != null) {
            this.cartRepository.deleteById(cartToPay.getId());
            storedOrder = CompleteOrderDTO.builder()
                    .id(savedOrder.getId())
                    .customerId(savedOrder.getCustomerId())
                    .items(savedOrder.getItems())
                    .totalAmount(savedOrder.getTotalAmount())
                    .status(savedOrder.getStatus())
                    .message("Your order has been processed!")
                    .paymentStatus(savedOrder.getPaymentStatus())
                    .createdDate(savedOrder.getCreatedDate())
                    .build();
            return storedOrder;
        } else {
            throw new TechnicalException("We couldn't save your order, please try again in a few minutes.", HttpStatus.INTERNAL_SERVER_ERROR.value());
        }

    }

    /**
     * Get orders by customer database id
     *
     * @param customerId Valid database identifier
     * @return List<OrderDTO> List of customer orders
     */
    @Override
    public List<CompleteOrderDTO> getOrdersByCustomerId(Long customerId) {
        List<Order> orders = this.orderRepository.findByCustomerId(customerId);
        if (orders.isEmpty()) {
            throw new TechnicalException("We did not find any orders associated with the client provided.", HttpStatus.NOT_FOUND.value());
        }
        return orders.stream()
                .map(order -> CompleteOrderDTO.builder()
                        .id(order.getId())
                        .customerId(order.getCustomerId())
                        .items(null)
                        .totalAmount(order.getTotalAmount())
                        .status(order.getStatus())
                        .paymentStatus(order.getPaymentStatus())
                        .createdDate(order.getCreatedDate())
                        .build())
                .collect(Collectors.toList());
    }

    /**
     * Convert a list of identifiers to a string separated by ,
     *
     * @param ids List of items
     * @return String joined by ,
     */
    private String joinItemId(List<CartItem> ids) {
        return ids.stream()
                .map(item -> String.valueOf(item.getProductId()))
                .collect(Collectors.joining(","));
    }

}
