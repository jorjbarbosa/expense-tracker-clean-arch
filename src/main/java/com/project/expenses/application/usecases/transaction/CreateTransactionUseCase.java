package com.project.expenses.application.usecases.transaction;

import com.project.expenses.application.usecases.category.GetCategoryUseCase;
import com.project.expenses.domain.entity.Category;
import com.project.expenses.domain.entity.Transaction;
import com.project.expenses.application.gateways.TransactionRepositoryGateway;

public class CreateTransactionUseCase {
    private final TransactionRepositoryGateway transactionRepositoryGateway;
    private final GetCategoryUseCase getCategoryUseCase;

    public CreateTransactionUseCase(TransactionRepositoryGateway transactionRepositoryGateway, GetCategoryUseCase getCategoryUseCase) {
        this.transactionRepositoryGateway = transactionRepositoryGateway;
        this.getCategoryUseCase = getCategoryUseCase;
    }

    public Transaction execute(Transaction transaction) {
        Category category = getCategoryUseCase.execute(transaction.getCategory().getId());
        transaction.setCategory(category);
        return transactionRepositoryGateway.save(transaction);
    }
}
