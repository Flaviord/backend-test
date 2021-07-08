package com.review.exceptions;

public class ReviewNotFoundException extends RuntimeException {
    public ReviewNotFoundException(String message) {
        super(message);
    }

    public ReviewNotFoundException(Throwable throwable) {
        super(throwable);
    }

    public ReviewNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
