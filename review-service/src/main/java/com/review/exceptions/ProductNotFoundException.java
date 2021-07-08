package com.review.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Product NOT FOUND")
public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(Throwable throwable) {
        super(throwable);
    }

    public ProductNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
