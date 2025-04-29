package com.project.expenses.infrastructure.config;

import com.project.expenses.application.gateways.AccountRepositoryGateway;
import com.project.expenses.application.usecases.account.CreateAccountUseCase;
import com.project.expenses.application.usecases.account.GetAccountUseCase;
import com.project.expenses.application.usecases.user.GetUserByIdUseCase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountConfigBean {
    @Bean
    CreateAccountUseCase createAccountUseCase(AccountRepositoryGateway repository, GetUserByIdUseCase getUserByIdUseCase) {
        return new CreateAccountUseCase(repository, getUserByIdUseCase);
    }

    @Bean
    GetAccountUseCase getAccountUseCase(AccountRepositoryGateway repository) {
        return new GetAccountUseCase(repository);
    }
}
