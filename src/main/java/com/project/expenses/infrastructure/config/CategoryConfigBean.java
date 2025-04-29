package com.project.expenses.infrastructure.config;

import com.project.expenses.application.usecases.category.CreateCategoryUseCase;
import com.project.expenses.application.usecases.category.GetCategoryUseCase;
import com.project.expenses.application.gateways.CategoryRepositoryGateway;
import com.project.expenses.application.usecases.category.UpdateCategoryUseCase;
import com.project.expenses.application.usecases.user.GetUserByIdUseCase;
import org.hibernate.sql.Update;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryConfigBean {
    @Bean
    CreateCategoryUseCase createCategoryUseCase(CategoryRepositoryGateway repository, GetUserByIdUseCase getUserByIdUseCase) {
        return new CreateCategoryUseCase(repository, getUserByIdUseCase);
    }

    @Bean
    GetCategoryUseCase getCategoryUseCase(CategoryRepositoryGateway repository) {
        return new GetCategoryUseCase(repository);
    }

    @Bean
    UpdateCategoryUseCase updateCategoryUseCase(CategoryRepositoryGateway repository) {
        return new UpdateCategoryUseCase(repository);
    }
}
