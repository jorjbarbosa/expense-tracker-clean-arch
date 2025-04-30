package com.project.expenses.application.usecases.account;

import com.project.expenses.application.exception.BussinessException;
import com.project.expenses.application.gateways.AccountRepositoryGateway;
import com.project.expenses.domain.entity.Account;

import java.util.UUID;

public class GetAccountUseCase {
    private final AccountRepositoryGateway accountRepositoryGateway;

    public GetAccountUseCase(AccountRepositoryGateway accountRepositoryGateway) {
        this.accountRepositoryGateway = accountRepositoryGateway;
    }

    public Account execute(UUID id, UUID userId) {
        return accountRepositoryGateway.findByIdAndUserId(id, userId)
                .orElseThrow(() -> new BussinessException("Category not found"));
    }
}
