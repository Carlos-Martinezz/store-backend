package com.app.store.configuration.security.dto;

import lombok.Builder;
import lombok.Data;

/**
 * User representation
 */
@Data
@Builder
public class UserDTO {

    /**
     * User email
     * Generally it is a unique key within the database
     */
    private String email;

    /**
     * User provided password
     */
    private String password;

    /**
     * Full username
     */
    private String fullName;

}
