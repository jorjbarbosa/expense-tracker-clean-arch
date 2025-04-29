package com.project.expenses.application.gateways;

import com.project.expenses.domain.entity.Account;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepositoryGateway {
    Account save(Account account);
    Optional<Account> findById(UUID id);
    Optional<Account> findByIdAndUserId(UUID id, UUID userId);
}
