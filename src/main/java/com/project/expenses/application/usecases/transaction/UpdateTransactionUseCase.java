package com.project.expenses.application.usecases.transaction;

import com.project.expenses.application.gateways.TransactionRepositoryGateway;
import com.project.expenses.domain.entity.Transaction;

import java.util.UUID;

public class UpdateTransactionUseCase {
    private final TransactionRepositoryGateway transactionRepository;
    private final GetTransactionUseCase getTransactionUseCase;

    public UpdateTransactionUseCase(TransactionRepositoryGateway transactionRepository, GetTransactionUseCase getTransactionUseCase) {
        this.transactionRepository = transactionRepository;
        this.getTransactionUseCase = getTransactionUseCase;
    }

    public Transaction execute(UUID id, Transaction data, UUID userId) {
        Transaction transaction = getTransactionUseCase.execute(id, userId);

        transaction.setAccount(data.getAccount());
        transaction.setCategory(data.getCategory());
        transaction.setAmount(data.getAmount());
        transaction.setDate(data.getDate());
        transaction.setType(data.getType());

        return transactionRepository.save(transaction);
    }
}
