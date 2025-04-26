package com.project.expenses.application.gateways;

import com.project.expenses.domain.entity.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository {
    Category save(Category category);

    Optional<Category> findById(UUID id);

    List<Category> findAll();
}
