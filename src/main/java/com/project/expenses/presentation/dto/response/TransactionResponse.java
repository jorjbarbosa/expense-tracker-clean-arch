package com.project.expenses.presentation.dto.response;

import com.project.expenses.domain.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionResponse {
    private UUID id;
    private String description;
    private BigDecimal amount;
    private CategoryResponse category;
    private TransactionType type;
    private LocalDateTime date;
}
