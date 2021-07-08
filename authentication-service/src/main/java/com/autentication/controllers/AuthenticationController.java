package com.autentication.controllers;

import com.autentication.models.UserToken;
import com.autentication.models.payload.LoginRequest;
import com.autentication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = "application/json")
public class AuthenticationController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserToken> login(@Validated @RequestBody LoginRequest loginRequest) {
        UserToken userToken = userService.logUser(loginRequest);
        return ResponseEntity.ok(userToken);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Validated @RequestBody LoginRequest loginRequest) {
        UserToken userToken = userService.register(loginRequest);
        return ResponseEntity.ok(userToken);
    }

    @PostMapping("/validateToken")
    public ResponseEntity<?> validateToken(@RequestParam String token) {
        UserToken userToken = userService.validateToken(token);
        return ResponseEntity.ok(userToken);
    }
}
