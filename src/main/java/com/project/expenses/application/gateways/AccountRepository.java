package com.project.expenses.application.gateways;

import com.project.expenses.domain.entity.Account;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository {
    Account save(Account account);
    Optional<Account> findById(UUID id);
}
