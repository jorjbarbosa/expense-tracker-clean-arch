package com.project.expenses.application.usecases.category;

import com.project.expenses.application.gateways.CategoryRepositoryGateway;
import com.project.expenses.domain.entity.Category;

import java.util.UUID;

public class UpdateCategoryUseCase {
    private CategoryRepositoryGateway categoryRepository;
    private GetCategoryUseCase getCategoryUseCase;

    public UpdateCategoryUseCase(CategoryRepositoryGateway categoryRepository, GetCategoryUseCase getCategoryUseCase) {
        this.categoryRepository = categoryRepository;
        this.getCategoryUseCase = getCategoryUseCase;
    }

    public Category execute(UUID id, Category data, UUID userID) {
            Category category = getCategoryUseCase.execute(id, userID);

        category.setName(data.getName());

        return categoryRepository.save(category);
    }
}
