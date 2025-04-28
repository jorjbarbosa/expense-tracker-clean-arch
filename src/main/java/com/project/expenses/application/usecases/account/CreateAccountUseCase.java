package com.project.expenses.application.usecases.account;

import com.project.expenses.application.gateways.AccountRepositoryGateway;
import com.project.expenses.domain.entity.Account;

public class CreateAccountUseCase {
    private final AccountRepositoryGateway accountRepositoryGateway;

    public CreateAccountUseCase(AccountRepositoryGateway accountRepositoryGateway) {
        this.accountRepositoryGateway = accountRepositoryGateway;
    }

    public Account execute(Account account) {
       return accountRepositoryGateway.save(account);
    }
}
