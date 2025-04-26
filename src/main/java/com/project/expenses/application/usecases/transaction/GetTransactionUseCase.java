package com.project.expenses.application.usecases.transaction;

import com.project.expenses.application.exception.BussinessException;
import com.project.expenses.domain.entity.Transaction;
import com.project.expenses.application.gateways.TransactionRepository;

import java.util.Optional;
import java.util.UUID;

public class GetTransactionUseCase {
    private final TransactionRepository transactionRepository;

    public GetTransactionUseCase(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction execute(UUID id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new BussinessException("Transaction not found"));
    }
}
