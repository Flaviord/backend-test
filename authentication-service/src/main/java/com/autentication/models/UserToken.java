package com.autentication.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserToken {
    private long id;
    private String login;
    private String token;
}
