package com.project.expenses.infrastructure.persistence.repository;

import com.project.expenses.infrastructure.persistence.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CategoryJpaRepository extends JpaRepository<CategoryEntity, UUID> {
    Optional<CategoryEntity> findByIdAndUserId(UUID categoryId, UUID userId);
}
