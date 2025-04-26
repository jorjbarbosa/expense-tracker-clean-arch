package com.project.expenses.application.usecases.category;

import com.project.expenses.application.exception.BussinessException;
import com.project.expenses.domain.entity.Category;
import com.project.expenses.application.gateways.CategoryRepository;

import java.util.Optional;
import java.util.UUID;

public class GetCategoryUseCase {
    private final CategoryRepository categoryRepository;

    public GetCategoryUseCase(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category execute(UUID id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new BussinessException("Category Not Found"));
    }
}
