package com.project.expenses.presentation.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountRequest {
    private String name;
    private String description;
    private BigDecimal balance;
}
