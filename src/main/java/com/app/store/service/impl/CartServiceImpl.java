package com.app.store.service.impl;

import com.app.store.dto.CartDTO;
import com.app.store.dto.CartItemDTO;
import com.app.store.entity.Cart;
import com.app.store.entity.CartItem;
import com.app.store.entity.Customer;
import com.app.store.exception.TechnicalException;
import com.app.store.repository.CartRepository;
import com.app.store.repository.CustomerRepository;
import com.app.store.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Cart service implementation
 */
@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    /**
     * Cart repository
     */
    private final CartRepository cartRepository;

    /**
     * Customer repository
     */
    private final CustomerRepository customerRepository;

    /**
     * Create empty cart
     * Allows you to create a new cart for a customer
     *
     * @param customerId A valida customer database id
     * @return Created cart
     */
    @Override
    public CartDTO create(Long customerId) {

        Customer customer = this.customerRepository.findById(customerId).orElse(null);
        if (customer == null) {
            throw new TechnicalException("We did not find any orders associated with the client provided.", HttpStatus.NOT_FOUND.value());
        }

        Cart cart = this.cartRepository.save(
                Cart.builder()
                        .customerId(customerId)
                        .items(new ArrayList<>())
                        .updatedAt(LocalDateTime.now())
                        .build()
        );

        return CartDTO.builder()
                .id(cart.getId())
                .customerId(cart.getCustomerId())
                .items(cart.getItems().stream()
                        .map(item -> CartItemDTO.builder()
                                .id(item.getId())
                                .productId(item.getProductId())
                                .productName(item.getProductName())
                                .quantity(item.getQuantity())
                                .price(item.getPrice())
                                .cartId(item.getCart().getId())
                                .build())
                        .toList())
                .updatedAt(cart.getUpdatedAt())
                .build();
    }

    /**
     * Manage cart
     * Allows you to interact with the shopping cart, modifying it on demand
     *
     * @param cart Complete cart object
     * @return Updated cart
     */
    @Override
    public CartDTO manage(CartDTO cart) {

        Cart findCart = this.cartRepository.findById(cart.getId()).orElse(null);
        if (findCart == null) {
            throw new TechnicalException("We do not find the cart with its own id.", HttpStatus.NOT_FOUND.value());
        }

        Cart buildCart = Cart.builder()
                .id(cart.getId())
                .customerId(cart.getCustomerId())
                .updatedAt(cart.getUpdatedAt())
                .items(cart.getItems().stream()
                        .map(cartItemDTO -> CartItem.builder()
                                .id(cartItemDTO.getId())
                                .productId(cartItemDTO.getProductId())
                                .productName(cartItemDTO.getProductName())
                                .quantity(cartItemDTO.getQuantity())
                                .price(cartItemDTO.getPrice())
                                .cart(findCart)
                                .build())
                        .collect(Collectors.toList()))
                .build();

        Cart updatedCart = this.cartRepository.save(buildCart);

        return CartDTO.builder()
                .id(updatedCart.getId())
                .customerId(updatedCart.getCustomerId())
                .updatedAt(updatedCart.getUpdatedAt())
                .items(updatedCart.getItems().stream()
                        .map(cartItem -> CartItemDTO.builder()
                                .id(cartItem.getId())
                                .productId(cartItem.getProductId())
                                .productName(cartItem.getProductName())
                                .quantity(cartItem.getQuantity())
                                .price(cartItem.getPrice())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}
