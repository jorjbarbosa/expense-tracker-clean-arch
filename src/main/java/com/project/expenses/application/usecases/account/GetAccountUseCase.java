package com.project.expenses.application.usecases.account;

import com.project.expenses.application.exception.BussinessException;
import com.project.expenses.application.gateways.AccountRepository;
import com.project.expenses.domain.entity.Account;

import java.util.UUID;

public class GetAccountUseCase {
    private final AccountRepository accountRepository;

    public GetAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account execute(UUID id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new BussinessException("Category not found"));
    }
}
