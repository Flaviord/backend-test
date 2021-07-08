package com.autentication.models.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginRequest implements Serializable {
    @NonNull
    private String username;
    @NonNull
    private String password;
}
