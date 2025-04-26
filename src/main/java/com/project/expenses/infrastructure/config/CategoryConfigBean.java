package com.project.expenses.infrastructure.config;

import com.project.expenses.application.usecases.category.CreateCategoryUseCase;
import com.project.expenses.application.usecases.category.GetCategoryUseCase;
import com.project.expenses.application.gateways.CategoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryConfigBean {
    @Bean
    CreateCategoryUseCase createCategoryUseCase(CategoryRepository repository) {
        return new CreateCategoryUseCase(repository);
    }

    @Bean
    GetCategoryUseCase getCategoryUseCase(CategoryRepository repository) {
        return new GetCategoryUseCase(repository);
    }
}
