package com.project.expenses.infrastructure.config;

import com.project.expenses.application.gateways.auth.PasswordEncoderGateway;
import com.project.expenses.application.gateways.auth.TokenGenerationGateway;
import com.project.expenses.application.usecases.auth.LoginUseCase;
import com.project.expenses.application.usecases.auth.RegisterUseCase;
import com.project.expenses.application.usecases.user.CreateUserUseCase;
import com.project.expenses.application.usecases.user.GetUserByEmailUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AuthConfigBean {
    @Bean
    LoginUseCase loginUseCase(GetUserByEmailUseCase getUserByEmailUseCase, PasswordEncoderGateway passwordEncoderGateway, TokenGenerationGateway tokenGenerationGateway) {
        return new LoginUseCase(getUserByEmailUseCase, passwordEncoderGateway, tokenGenerationGateway);
    }

    @Bean
    RegisterUseCase registerUseCase(CreateUserUseCase createUserUseCase, PasswordEncoderGateway passwordEncoderGateway) {
        return new RegisterUseCase(createUserUseCase, passwordEncoderGateway);
    }
}
