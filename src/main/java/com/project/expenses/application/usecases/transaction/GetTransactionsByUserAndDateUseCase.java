package com.project.expenses.application.usecases.transaction;

import com.project.expenses.application.gateways.TransactionRepositoryGateway;
import com.project.expenses.domain.entity.Transaction;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class GetTransactionsByUserAndDateUseCase {
    private final TransactionRepositoryGateway transactionRepository;

    public GetTransactionsByUserAndDateUseCase(TransactionRepositoryGateway transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> execute(UUID id, LocalDateTime startDate, LocalDateTime endDate) {
        return transactionRepository.findByUserIdAndDateBetween(id, startDate, endDate);
    }
}
