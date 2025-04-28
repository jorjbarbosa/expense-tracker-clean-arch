package com.project.expenses.application.usecases.auth;


import com.project.expenses.application.gateways.auth.PasswordEncoderGateway;
import com.project.expenses.application.usecases.user.CreateUserUseCase;
import com.project.expenses.domain.entity.User;

public class RegisterUseCase {
    private final CreateUserUseCase createUserUseCase;
    private final PasswordEncoderGateway passwordEncoder;

    public RegisterUseCase(CreateUserUseCase createUserUseCase, PasswordEncoderGateway passwordEncoder) {
        this.createUserUseCase = createUserUseCase;
        this.passwordEncoder = passwordEncoder;
    }

    public User execute(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return createUserUseCase.execute(user);
    }
}
