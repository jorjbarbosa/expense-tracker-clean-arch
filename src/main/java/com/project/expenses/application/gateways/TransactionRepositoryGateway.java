package com.project.expenses.application.gateways;

import com.project.expenses.domain.entity.Transaction;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TransactionRepositoryGateway {
    Transaction save(Transaction category);
    Optional<Transaction> findById(UUID id);
    List<Transaction> findByUserIdAndDateBetween(UUID id, LocalDateTime startDate, LocalDateTime endDate);
}
