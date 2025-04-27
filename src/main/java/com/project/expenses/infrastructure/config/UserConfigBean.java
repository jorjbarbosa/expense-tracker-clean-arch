package com.project.expenses.infrastructure.config;

import com.project.expenses.application.gateways.UserRepository;
import com.project.expenses.application.usecases.user.CreateUserUseCase;
import com.project.expenses.application.usecases.user.GetUserByEmailUseCase;
import com.project.expenses.application.usecases.user.GetUserByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfigBean {
    @Bean
    public CreateUserUseCase createUserUseCase(UserRepository userRepository) {
        return new CreateUserUseCase(userRepository);
    }

    @Bean
    public GetUserByIdUseCase getUserByIdUseCase(UserRepository userRepository) {
        return new GetUserByIdUseCase(userRepository);
    }

    @Bean
    public GetUserByEmailUseCase getUserByEmailUseCase(UserRepository userRepository) {
        return new GetUserByEmailUseCase(userRepository);
    }
}
