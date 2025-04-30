package com.project.expenses.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class AccountRequest {
    private UUID id;
    @NotBlank(message = "Name is required")
    private String name;
    private String description;
    @NotBlank(message = "Balance is required")
    private BigDecimal initialBalance;
    private BigDecimal currentBalance;
}
