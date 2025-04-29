package com.project.expenses.application.usecases.transaction;

import com.project.expenses.application.usecases.category.GetCategoryUseCase;
import com.project.expenses.domain.entity.Category;
import com.project.expenses.domain.entity.Transaction;
import com.project.expenses.application.gateways.TransactionRepositoryGateway;

import java.util.UUID;

public class CreateTransactionUseCase {
    private final TransactionRepositoryGateway transactionRepositoryGateway;
    private final GetCategoryUseCase getCategoryUseCase;

    public CreateTransactionUseCase(TransactionRepositoryGateway transactionRepositoryGateway, GetCategoryUseCase getCategoryUseCase) {
        this.transactionRepositoryGateway = transactionRepositoryGateway;
        this.getCategoryUseCase = getCategoryUseCase;
    }

    public Transaction execute(Transaction transaction, UUID userId) {
        Category category = getCategoryUseCase.execute(transaction.getCategory().getId(), userId);
        transaction.setCategory(category);
        transaction.setUser(category.getUser());
        return transactionRepositoryGateway.save(transaction);
    }
}
