package com.autentication.exceptions;

import com.autentication.models.payload.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHanlder extends ResponseEntityExceptionHandler {
    private String INCORRECT_REQUEST = "INCORRECT_REQUEST";

    @ExceptionHandler(UsernameNotFoundException.class)
    public final ResponseEntity<MessageResponse> handleUserNotFoundException(UsernameNotFoundException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        MessageResponse error = new MessageResponse(INCORRECT_REQUEST, details);
        return new ResponseEntity<MessageResponse>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(JwtInvalidException.class)
    public final ResponseEntity<MessageResponse> handleInvalidJwtException(JwtInvalidException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        MessageResponse error = new MessageResponse(HttpStatus.UNAUTHORIZED.name(), details);
        return new ResponseEntity<MessageResponse>(error, HttpStatus.UNAUTHORIZED);
    }
}
