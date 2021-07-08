package com.autentication.models;

import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
public class User {
    private Long id;
    private String email;
    private String userName;
    private String password;
}
