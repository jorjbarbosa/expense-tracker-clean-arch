package com.project.expenses.infrastructure.config;

import com.project.expenses.application.gateways.AccountRepository;
import com.project.expenses.application.usecases.account.CreateAccountUseCase;
import com.project.expenses.application.usecases.account.GetAccountUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountConfigBean {
    @Bean
    public CreateAccountUseCase createAccountUseCase(AccountRepository repository) {
        return new CreateAccountUseCase(repository);
    }

    @Bean
    public GetAccountUseCase getAccountUseCase(AccountRepository repository) {
        return new GetAccountUseCase(repository);
    }
}
