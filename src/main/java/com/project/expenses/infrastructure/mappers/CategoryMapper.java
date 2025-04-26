package com.project.expenses.infrastructure.mappers;

import com.project.expenses.domain.entity.Category;
import com.project.expenses.infrastructure.persistence.entity.CategoryEntity;
import com.project.expenses.presentation.dto.request.CategoryRequest;
import com.project.expenses.presentation.dto.response.CategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toDomain(CategoryEntity entity);

    CategoryEntity toEntity(Category category);

    CategoryResponse toResponse(Category category);

    @Mapping(target = "id", ignore = true)
    Category toCategory(CategoryRequest request);
}
