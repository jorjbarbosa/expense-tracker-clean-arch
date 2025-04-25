package com.project.expenses.infrastructure.persistence.adapter;

import com.project.expenses.application.exception.BussinessException;
import com.project.expenses.domain.entity.Category;
import com.project.expenses.domain.repository.CategoryRepository;
import com.project.expenses.infrastructure.mappers.CategoryMapper;
import com.project.expenses.infrastructure.persistence.entity.CategoryEntity;
import com.project.expenses.infrastructure.persistence.repository.CategoryJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CategoryRepositoryAdapter implements CategoryRepository {
    private final CategoryJpaRepository repository;
    private final CategoryMapper categoryMapper;

    private CategoryRepositoryAdapter(CategoryJpaRepository repository, CategoryMapper categoryMapper) {
        this.repository = repository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public Category save(Category category) {
        CategoryEntity categoryEntity = categoryMapper.toEntity(category);
        return categoryMapper.toDomain(this.repository.save(categoryEntity));
    }

    @Override
    public Category findById(UUID id) {
        CategoryEntity categoryEntity = this.repository.findById(id).orElseThrow(() -> new BussinessException("Category not found"));
        return categoryMapper.toDomain(categoryEntity);
    }

    @Override
    public List<Category> findAll() {
        return List.of();
    }
}
