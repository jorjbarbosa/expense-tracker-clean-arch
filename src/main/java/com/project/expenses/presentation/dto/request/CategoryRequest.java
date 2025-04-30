package com.project.expenses.presentation.dto.request;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryRequest {
    private UUID id;
    @NotBlank(message = "Name is required")
    private String name;
}
