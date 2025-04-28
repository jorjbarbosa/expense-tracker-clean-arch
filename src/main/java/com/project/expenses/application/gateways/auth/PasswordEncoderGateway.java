package com.project.expenses.application.gateways.auth;

public interface PasswordEncoderGateway {
    boolean matches(String password, String encodedPassword);
    String encode(String password);
}
