package com.autentication.models.payload;

import lombok.Value;

import java.util.List;

@Value
public class JwtResponse {
    private String jwt;
    private Long id;
    private String username;
    private String email;
    private List<String> roles;
}
