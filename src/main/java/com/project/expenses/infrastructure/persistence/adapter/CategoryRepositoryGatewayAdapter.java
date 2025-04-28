package com.project.expenses.infrastructure.persistence.adapter;

import com.project.expenses.domain.entity.Category;
import com.project.expenses.application.gateways.CategoryRepositoryGateway;
import com.project.expenses.infrastructure.mappers.CategoryMapper;
import com.project.expenses.infrastructure.persistence.entity.CategoryEntity;
import com.project.expenses.infrastructure.persistence.repository.CategoryJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CategoryRepositoryGatewayAdapter implements CategoryRepositoryGateway {
    private final CategoryJpaRepository repository;
    private final CategoryMapper categoryMapper;


    @Override
    public Category save(Category category) {
        CategoryEntity categoryEntity = categoryMapper.toEntity(category);
        return categoryMapper.toDomain(this.repository.save(categoryEntity));
    }

    @Override
    public Optional<Category> findById(UUID id) {
        return this.repository.findById(id).map(categoryMapper::toDomain);
    }

    @Override
    public List<Category> findAll() {
        return List.of();
    }
}
