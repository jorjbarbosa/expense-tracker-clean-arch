package com.project.expenses.application.usecases.auth;

import com.project.expenses.application.exception.BussinessException;
import com.project.expenses.application.gateways.auth.PasswordEncoderGateway;
import com.project.expenses.application.gateways.auth.TokenGenerationGateway;
import com.project.expenses.application.usecases.user.GetUserByEmailUseCase;
import com.project.expenses.domain.entity.User;

public class LoginUseCase {
    private final GetUserByEmailUseCase getUserByEmailUseCase;
    private final PasswordEncoderGateway passwordEncoder;
    private final TokenGenerationGateway tokenGenerator;

    public LoginUseCase(GetUserByEmailUseCase getUserByEmailUseCase, PasswordEncoderGateway passwordEncoder, TokenGenerationGateway tokenGenerator) {
        this.getUserByEmailUseCase = getUserByEmailUseCase;
        this.passwordEncoder = passwordEncoder;
        this.tokenGenerator = tokenGenerator;
    }

    public String login(String email, String password) {
        User user = getUserByEmailUseCase.execute(email);

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BussinessException("Invalid e-mail or password");
        }

        return tokenGenerator.generateToken(user.getId());
    }
}
