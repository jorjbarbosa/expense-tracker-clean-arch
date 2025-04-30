package com.project.expenses.infrastructure.config;

import com.project.expenses.application.gateways.UserRepositoryGateway;
import com.project.expenses.application.gateways.auth.PasswordEncoderGateway;
import com.project.expenses.application.usecases.user.CreateUserUseCase;
import com.project.expenses.application.usecases.user.GetUserByEmailUseCase;
import com.project.expenses.application.usecases.user.GetUserByIdUseCase;
import com.project.expenses.application.usecases.user.UpdateUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfigBean {
    @Bean
    CreateUserUseCase createUserUseCase(UserRepositoryGateway userRepositoryGateway) {
        return new CreateUserUseCase(userRepositoryGateway);
    }

    @Bean
    GetUserByIdUseCase getUserByIdUseCase(UserRepositoryGateway userRepositoryGateway) {
        return new GetUserByIdUseCase(userRepositoryGateway);
    }

    @Bean
    GetUserByEmailUseCase getUserByEmailUseCase(UserRepositoryGateway userRepositoryGateway) {
        return new GetUserByEmailUseCase(userRepositoryGateway);
    }

    @Bean
    UpdateUserUseCase updateUserUseCase(UserRepositoryGateway userRepository, PasswordEncoderGateway passwordEncoder, GetUserByIdUseCase getUserByIdUseCase) {
        return new UpdateUserUseCase(userRepository, passwordEncoder, getUserByIdUseCase);
    }
}
