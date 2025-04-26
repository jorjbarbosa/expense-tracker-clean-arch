package com.project.expenses.application.usecases.transaction;

import com.project.expenses.application.usecases.category.GetCategoryUseCase;
import com.project.expenses.domain.entity.Category;
import com.project.expenses.domain.entity.Transaction;
import com.project.expenses.application.gateways.TransactionRepository;

public class CreateTransactionUseCase {
    private final TransactionRepository transactionRepository;
    private final GetCategoryUseCase getCategoryUseCase;

    public CreateTransactionUseCase(TransactionRepository transactionRepository, GetCategoryUseCase getCategoryUseCase) {
        this.transactionRepository = transactionRepository;
        this.getCategoryUseCase = getCategoryUseCase;
    }

    public Transaction execute(Transaction transaction) {
        Category category = getCategoryUseCase.execute(transaction.getCategory().getId());
        transaction.setCategory(category);
        return transactionRepository.save(transaction);
    }
}
