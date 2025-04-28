package com.project.expenses.infrastructure.security.adapter;

import com.project.expenses.application.gateways.auth.PasswordEncoderGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PasswordEncoderAdapter implements PasswordEncoderGateway {
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean matches(String password, String encodedPassword) {
        return passwordEncoder.matches(password, encodedPassword);
    }

    @Override
    public String encode(String password) {
        return passwordEncoder.encode(password);
    }

}
