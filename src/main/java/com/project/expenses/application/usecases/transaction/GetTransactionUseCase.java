package com.project.expenses.application.usecases.transaction;

import com.project.expenses.application.exception.BussinessException;
import com.project.expenses.domain.entity.Transaction;
import com.project.expenses.application.gateways.TransactionRepositoryGateway;

import java.util.UUID;

public class GetTransactionUseCase {
    private final TransactionRepositoryGateway transactionRepositoryGateway;

    public GetTransactionUseCase(TransactionRepositoryGateway transactionRepositoryGateway) {
        this.transactionRepositoryGateway = transactionRepositoryGateway;
    }

    public Transaction execute(UUID id, UUID userId) {
        return transactionRepositoryGateway.findByIdAndUserId(id, userId)
                .orElseThrow(() -> new BussinessException("Transaction not found"));
    }
}
