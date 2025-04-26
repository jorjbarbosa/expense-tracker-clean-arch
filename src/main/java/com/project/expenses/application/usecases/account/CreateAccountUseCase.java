package com.project.expenses.application.usecases.account;

import com.project.expenses.application.gateways.AccountRepository;
import com.project.expenses.domain.entity.Account;

public class CreateAccountUseCase {
    private final AccountRepository accountRepository;

    public CreateAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account execute(Account account) {
       return accountRepository.save(account);
    }
}
