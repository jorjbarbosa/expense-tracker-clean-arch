package com.project.expenses.application.usecases.account;

import java.util.UUID;

import com.project.expenses.application.gateways.AccountRepositoryGateway;
import com.project.expenses.application.usecases.user.GetUserByIdUseCase;
import com.project.expenses.domain.entity.Account;
import com.project.expenses.domain.entity.User;

public class CreateAccountUseCase {
    private final AccountRepositoryGateway accountRepositoryGateway;
    private final GetUserByIdUseCase getUserByIdUseCase;

    public CreateAccountUseCase(AccountRepositoryGateway accountRepositoryGateway, GetUserByIdUseCase getUserByIdUseCase) {
        this.accountRepositoryGateway = accountRepositoryGateway;
        this.getUserByIdUseCase = getUserByIdUseCase;
    }

    public Account execute(Account account, UUID userId) {
        User user = getUserByIdUseCase.execute(userId);
        account.setUser(user);
        return accountRepositoryGateway.save(account);
    }
}
