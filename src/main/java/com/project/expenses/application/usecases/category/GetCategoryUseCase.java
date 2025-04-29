package com.project.expenses.application.usecases.category;

import com.project.expenses.application.exception.BussinessException;
import com.project.expenses.domain.entity.Category;
import com.project.expenses.application.gateways.CategoryRepositoryGateway;

import java.util.UUID;

public class GetCategoryUseCase {
    private final CategoryRepositoryGateway categoryRepositoryGateway;

    public GetCategoryUseCase(CategoryRepositoryGateway categoryRepositoryGateway) {
        this.categoryRepositoryGateway = categoryRepositoryGateway;
    }

    public Category execute(UUID categoryId, UUID userId) {
        return categoryRepositoryGateway.findByIdAndUserId(categoryId, userId)
                .orElseThrow(() -> new BussinessException("Category Not Found"));
    }
}
