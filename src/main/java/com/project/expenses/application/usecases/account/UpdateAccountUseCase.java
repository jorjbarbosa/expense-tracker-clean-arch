package com.project.expenses.application.usecases.account;

import com.project.expenses.application.gateways.AccountRepositoryGateway;
import com.project.expenses.domain.entity.Account;

import java.util.UUID;

public class UpdateAccountUseCase {
    private final AccountRepositoryGateway accountRepository;
    private final GetAccountUseCase getAccountUseCase;

    public UpdateAccountUseCase(AccountRepositoryGateway accountRepository, GetAccountUseCase getAccountUseCase) {
        this.accountRepository = accountRepository;
        this.getAccountUseCase = getAccountUseCase;
    }

    public Account execute(UUID id, Account data, UUID userId) {
        Account account = getAccountUseCase.execute(id, userId);

        account.setName(data.getName());

        account.setName(data.getName());
        account.setDescription(data.getDescription());

        return accountRepository.save(account);
    }

}
