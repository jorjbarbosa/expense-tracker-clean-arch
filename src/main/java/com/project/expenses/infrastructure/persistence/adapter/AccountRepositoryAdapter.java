package com.project.expenses.infrastructure.persistence.adapter;

import com.project.expenses.application.gateways.AccountRepository;
import com.project.expenses.domain.entity.Account;
import com.project.expenses.infrastructure.mappers.AccountMapper;
import com.project.expenses.infrastructure.persistence.entity.AccountEntity;
import com.project.expenses.infrastructure.persistence.repository.AccountJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AccountRepositoryAdapter implements AccountRepository {
    private final AccountMapper accountMapper;
    private final AccountJpaRepository accountJpaRepository;

    @Override
    public Account save(Account account) {
        AccountEntity accountEntity = accountMapper.toEntity(account);
        return accountMapper.toDomain(accountJpaRepository.save(accountEntity));
    }

    @Override
    public Optional<Account> findById(UUID id) {
        return accountJpaRepository.findById(id).map(accountMapper::toDomain);
    }
}
