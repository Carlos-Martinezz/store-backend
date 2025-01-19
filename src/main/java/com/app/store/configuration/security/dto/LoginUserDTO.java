package com.app.store.configuration.security.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Try a login
 */
@Data
@Builder
public class LoginUserDTO {

    /**
     * Email provided in the login
     */
    private String email;

    /**
     * Password provided in the login
     */
    private String password;

}
