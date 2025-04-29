package com.project.expenses.presentation.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class AccountRequest {
    private UUID id;
    private String name;
    private String description;
    private BigDecimal initialBalance;
    private BigDecimal currentBalance;
}
