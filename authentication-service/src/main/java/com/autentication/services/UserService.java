package com.autentication.services;

import com.autentication.dao.UserDao;
import com.autentication.exceptions.JwtInvalidException;
import com.autentication.models.User;
import com.autentication.models.UserToken;
import com.autentication.models.payload.LoginRequest;
import com.autentication.security.JwtUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;

@Service
public class UserService {
    @Autowired
    UserDao userRepository;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserToken logUser(LoginRequest loginRequest) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(loginRequest.getUsername())
            .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + loginRequest.getUsername()));

        if (passwordEncoder.matches(CharBuffer.wrap(loginRequest.getPassword()), user.getPassword())) {
            String jwtToken = jwtUtils.generateJwtToken(loginRequest.getUsername());
            return UserToken.builder()
                .id(user.getId())
                .login(user.getPassword())
                .token(jwtToken)
                .build();
        }
        throw new UsernameNotFoundException("Password not matches");
    }

    public UserToken validateToken(String token) {
        if (!jwtUtils.validateJwtToken(token)) {
            throw new JwtInvalidException("AUTHENTICATION INVALID.");
        }
        String username = jwtUtils.getUserNameFromJwtToken(token);
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        String jwtToken = jwtUtils.generateJwtToken(username);
        return UserToken.builder()
            .id(user.getId())
            .login(user.getPassword())
            .token(jwtToken)
            .build();
    }

    public UserToken register(LoginRequest loginRequest) {
        boolean userExists = userRepository.userExists(loginRequest.getUsername());
        if (userExists) {
            throw new IllegalStateException("User already exists!");
        }
        User newUser = User.builder()
            .userName(loginRequest.getUsername())
            .password(passwordEncoder.encode(loginRequest.getPassword()))
            .build();

        String jwtToken = StringUtils.EMPTY;

        if (userRepository.insert(newUser) == 1) {
            jwtToken = jwtUtils.generateJwtToken(loginRequest.getUsername());
        }
        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + loginRequest.getUsername()));
        return UserToken.builder()
            .id(user.getId())
            .login(user.getPassword())
            .token(jwtToken)
            .build();
    }
}
