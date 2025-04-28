package com.project.expenses.application.usecases.category;

import com.project.expenses.domain.entity.Category;
import com.project.expenses.application.gateways.CategoryRepositoryGateway;

public class CreateCategoryUseCase {
    private final CategoryRepositoryGateway categoryRepositoryGateway;

    public CreateCategoryUseCase(CategoryRepositoryGateway categoryRepositoryGateway) {
        this.categoryRepositoryGateway = categoryRepositoryGateway;
    }

    public Category execute(Category category) {
        return categoryRepositoryGateway.save(category);
    }
}
