package com.project.expenses.presentation.dto.response;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.Data;

@Data
public class AccountResponse {
    private UUID id;
    private String name;
    private String description;
    private BigDecimal balance;
}
