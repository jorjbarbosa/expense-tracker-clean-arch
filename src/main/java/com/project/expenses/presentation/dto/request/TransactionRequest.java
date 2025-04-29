package com.project.expenses.presentation.dto.request;

import com.project.expenses.domain.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionRequest {
    private String description;
    private BigDecimal amount;
    private CategoryRequest category;
    private AccountRequest account;
    private TransactionType type;
    private LocalDateTime date;
}