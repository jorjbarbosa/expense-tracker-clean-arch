package com.project.expenses.application.usecases.account;

import com.project.expenses.application.exception.BussinessException;
import com.project.expenses.application.gateways.AccountRepositoryGateway;
import com.project.expenses.application.usecases.category.UpdateCategoryUseCase;
import com.project.expenses.domain.entity.Account;

import java.util.UUID;

public class UpdateAccountUseCase {
    private final AccountRepositoryGateway accountRepository;

    public UpdateAccountUseCase(AccountRepositoryGateway accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account execute(UUID id, Account data, UUID userId) {
        Account account = accountRepository.findByIdAndUserId(id, userId)
                .orElseThrow(() -> new BussinessException("Account not found"));

        account.setName(data.getName());
        account.setDescription(data.getDescription());

        return accountRepository.save(account);
    }

}
