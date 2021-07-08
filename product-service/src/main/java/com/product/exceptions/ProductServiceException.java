package com.product.exceptions;

public class ProductServiceException extends RuntimeException {

    public ProductServiceException(String message) {
        super(message);
    }

    public ProductServiceException(Throwable throwable) {
        super(throwable);
    }

    public ProductServiceException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
