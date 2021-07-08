package com.autentication.models.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.util.List;

@Builder
@Value
@Data
@AllArgsConstructor
public class MessageResponse {
    private String message;
    private List<String> details;
}
