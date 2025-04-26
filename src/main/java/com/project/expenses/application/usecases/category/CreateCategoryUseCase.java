package com.project.expenses.application.usecases.category;

import com.project.expenses.domain.entity.Category;
import com.project.expenses.application.gateways.CategoryRepository;

public class CreateCategoryUseCase {
    private final CategoryRepository categoryRepository;

    public CreateCategoryUseCase(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category execute(Category category) {
        return categoryRepository.save(category);
    }
}
