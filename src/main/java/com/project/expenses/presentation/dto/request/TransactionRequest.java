package com.project.expenses.presentation.dto.request;

import com.project.expenses.domain.enums.TransactionType;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Amount is required")
    private BigDecimal amount;
    @NotBlank(message = "Category is required")
    private CategoryRequest category;
    @NotBlank(message = "Account is required")
    private AccountRequest account;
    @NotBlank(message = "Transaction type is required")
    private TransactionType type;
    @NotBlank(message = "The date of the transaction is required")
    private LocalDateTime date;
}