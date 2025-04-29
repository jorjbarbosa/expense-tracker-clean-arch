package com.project.expenses.application.usecases.category;

import com.project.expenses.application.usecases.user.GetUserByIdUseCase;
import com.project.expenses.domain.entity.Category;
import com.project.expenses.application.gateways.CategoryRepositoryGateway;
import com.project.expenses.domain.entity.User;

import java.util.UUID;

public class CreateCategoryUseCase {
    private final CategoryRepositoryGateway categoryRepositoryGateway;
    private final GetUserByIdUseCase getUserByIdUseCase;

    public CreateCategoryUseCase(CategoryRepositoryGateway categoryRepositoryGateway, GetUserByIdUseCase getUserByIdUseCase) {
        this.categoryRepositoryGateway = categoryRepositoryGateway;
        this.getUserByIdUseCase = getUserByIdUseCase;
    }

    public Category execute(Category category, UUID userId) {
        User user = getUserByIdUseCase.execute(userId);
        category.setUser(user);
        return categoryRepositoryGateway.save(category);
    }
}
