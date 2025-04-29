package com.project.expenses.infrastructure.config;

import com.project.expenses.application.gateways.TransactionRepositoryGateway;
import com.project.expenses.application.usecases.category.GetCategoryUseCase;
import com.project.expenses.application.usecases.transaction.CreateTransactionUseCase;
import com.project.expenses.application.usecases.transaction.GetTransactionUseCase;
import com.project.expenses.application.usecases.user.GetUserByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionConfigBean {
    @Bean
    CreateTransactionUseCase createTransactionUseCase(TransactionRepositoryGateway repository, GetCategoryUseCase getCategoryUseCase) {
        return new CreateTransactionUseCase(repository, getCategoryUseCase);
    }

    @Bean
    GetTransactionUseCase getTransactionUseCase(TransactionRepositoryGateway repository) {
        return new GetTransactionUseCase(repository);
    }
}
