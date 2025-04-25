package com.project.expenses.presentation.controllers;

import com.project.expenses.application.usecases.category.CreateCategoryUseCase;
import com.project.expenses.application.usecases.category.GetCategoryUseCase;
import com.project.expenses.domain.entity.Category;
import com.project.expenses.infrastructure.mappers.CategoryMapper;
import com.project.expenses.presentation.dto.request.CategoryRequest;
import com.project.expenses.presentation.dto.response.CategoryResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CreateCategoryUseCase createCategoryUseCase;
    private final GetCategoryUseCase getCategoryUseCase;

    private final CategoryMapper categoryMapper;

    public CategoryController(
            CreateCategoryUseCase createCategoryUseCase,
            GetCategoryUseCase getCategoryUseCase,
            CategoryMapper categoryMapper
    ) {
        this.createCategoryUseCase = createCategoryUseCase;
        this.getCategoryUseCase = getCategoryUseCase;
        this.categoryMapper = categoryMapper;
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest request) {
        Category category = categoryMapper.toCategory(request);
        return new ResponseEntity<>(categoryMapper.toResponse(createCategoryUseCase.execute(category)), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryResponse> getCategory(@PathVariable UUID id) {
        return ResponseEntity.ok(categoryMapper.toResponse(getCategoryUseCase.execute(id)));
    }
}
