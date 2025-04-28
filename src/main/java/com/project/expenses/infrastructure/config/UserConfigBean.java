package com.project.expenses.infrastructure.config;

import com.project.expenses.application.gateways.UserRepositoryGateway;
import com.project.expenses.application.usecases.user.CreateUserUseCase;
import com.project.expenses.application.usecases.user.GetUserByEmailUseCase;
import com.project.expenses.application.usecases.user.GetUserByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfigBean {
    @Bean
    public CreateUserUseCase createUserUseCase(UserRepositoryGateway userRepositoryGateway) {
        return new CreateUserUseCase(userRepositoryGateway);
    }

    @Bean
    public GetUserByIdUseCase getUserByIdUseCase(UserRepositoryGateway userRepositoryGateway) {
        return new GetUserByIdUseCase(userRepositoryGateway);
    }

    @Bean
    public GetUserByEmailUseCase getUserByEmailUseCase(UserRepositoryGateway userRepositoryGateway) {
        return new GetUserByEmailUseCase(userRepositoryGateway);
    }
}
