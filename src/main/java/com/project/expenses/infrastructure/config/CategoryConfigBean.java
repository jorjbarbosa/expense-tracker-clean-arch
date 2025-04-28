package com.project.expenses.infrastructure.config;

import com.project.expenses.application.usecases.category.CreateCategoryUseCase;
import com.project.expenses.application.usecases.category.GetCategoryUseCase;
import com.project.expenses.application.gateways.CategoryRepositoryGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryConfigBean {
    @Bean
    CreateCategoryUseCase createCategoryUseCase(CategoryRepositoryGateway repository) {
        return new CreateCategoryUseCase(repository);
    }

    @Bean
    GetCategoryUseCase getCategoryUseCase(CategoryRepositoryGateway repository) {
        return new GetCategoryUseCase(repository);
    }
}
