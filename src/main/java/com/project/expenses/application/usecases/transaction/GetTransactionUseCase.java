package com.project.expenses.application.usecases.transaction;

import com.project.expenses.domain.entity.Transaction;
import com.project.expenses.domain.repository.TransactionRepository;

import java.util.UUID;

public class GetTransactionUseCase {
    private final TransactionRepository transactionRepository;

    public GetTransactionUseCase(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction execute(UUID id) {
        return transactionRepository.findById(id);
    }
}
