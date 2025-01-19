package com.app.store.configuration.security.dto;

import lombok.Data;

/**
 * Login information
 */
@Data
public class LoginResponseDTO {

    /**
     * Generated token
     */
    private String token;

    /**
     * Token expiration
     */
    private long expiresIn;

}
