package com.project.expenses.application.usecases.transaction;

import com.project.expenses.domain.entity.Transaction;
import com.project.expenses.domain.repository.TransactionRepository;

public class CreateTransactionUseCase {
    private final TransactionRepository transactionRepository;

    public CreateTransactionUseCase(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction execute(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
