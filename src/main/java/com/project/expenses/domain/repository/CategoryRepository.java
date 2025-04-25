package com.project.expenses.domain.repository;

import com.project.expenses.domain.entity.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryRepository {
    Category save(Category category);
    Category findById(UUID id);
    List<Category> findAll();
}
