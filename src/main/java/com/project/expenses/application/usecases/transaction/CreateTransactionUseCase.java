package com.project.expenses.application.usecases.transaction;

import com.project.expenses.application.exception.BussinessException;
import com.project.expenses.application.gateways.AccountRepositoryGateway;
import com.project.expenses.application.usecases.category.GetCategoryUseCase;
import com.project.expenses.domain.entity.Account;
import com.project.expenses.domain.entity.Category;
import com.project.expenses.domain.entity.Transaction;
import com.project.expenses.application.gateways.TransactionRepositoryGateway;

import java.util.UUID;

public class CreateTransactionUseCase {
    private final TransactionRepositoryGateway transactionRepositoryGateway;
    private final AccountRepositoryGateway accountRepository;
    private final GetCategoryUseCase getCategoryUseCase;

    public CreateTransactionUseCase(TransactionRepositoryGateway transactionRepositoryGateway, GetCategoryUseCase getCategoryUseCase, AccountRepositoryGateway accountRepository) {
        this.transactionRepositoryGateway = transactionRepositoryGateway;
        this.getCategoryUseCase = getCategoryUseCase;
        this.accountRepository = accountRepository;
    }

    public Transaction execute(Transaction transaction, UUID userId) {
        Category category = getCategoryUseCase.execute(transaction.getCategory().getId(), userId);

        Account account = accountRepository.findById(transaction.getAccount().getId())
                        .orElseThrow(() -> new BussinessException("Account not found"));

        account.applyTransaction(transaction);
        account = accountRepository.save(account);

        transaction.setCategory(category);
        transaction.setUser(category.getUser());
        transaction.setAccount(account);

        return transactionRepositoryGateway.save(transaction);
    }
}
