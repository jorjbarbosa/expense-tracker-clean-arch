package com.project.expenses.application.usecases.category;

import com.project.expenses.application.exception.BussinessException;
import com.project.expenses.application.gateways.CategoryRepositoryGateway;
import com.project.expenses.domain.entity.Category;

import java.util.UUID;

public class UpdateCategoryUseCase {
    private CategoryRepositoryGateway categoryRepository;

    public UpdateCategoryUseCase(CategoryRepositoryGateway categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category execute(UUID id, Category data, UUID userID) {
        Category category = categoryRepository.findByIdAndUserId(id, userID)
                .orElseThrow(() -> new BussinessException("Category not found"));

        category.setName(data.getName());

        return categoryRepository.save(category);
    }
}
