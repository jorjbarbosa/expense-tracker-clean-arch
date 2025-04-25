package com.project.expenses.domain.entity;

import com.project.expenses.domain.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record Transaction(
        UUID id,
        String description,
        BigDecimal amount,
        Category category,
        TransactionType type,
        LocalDateTime date,
        Account account) {
}
