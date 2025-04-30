package com.project.expenses.application.usecases.transaction;

import com.project.expenses.application.exception.BussinessException;
import com.project.expenses.application.gateways.TransactionRepositoryGateway;
import com.project.expenses.domain.entity.Transaction;

import java.util.UUID;

public class UpdateTransactionUseCase {
    private final TransactionRepositoryGateway transactionRepository;

    public UpdateTransactionUseCase(TransactionRepositoryGateway transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction execute(UUID id, Transaction data, UUID userId) {
        Transaction transaction = transactionRepository.findByIdAndUserId(id, userId)
                .orElseThrow(() -> new BussinessException("Transaction not found"));

        transaction.setAccount(data.getAccount());
        transaction.setCategory(data.getCategory());
        transaction.setAmount(data.getAmount());
        transaction.setDate(data.getDate());
        transaction.setType(data.getType());

        return transactionRepository.save(transaction);
    }
}
