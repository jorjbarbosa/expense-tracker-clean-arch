package com.project.expenses.infrastructure.persistence.adapter;

import com.project.expenses.application.gateways.AccountRepositoryGateway;
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
public class AccountRepositoryGatewayAdapter implements AccountRepositoryGateway {
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

    @Override
    public Optional<Account> findByIdAndUserId(UUID id, UUID userId) {
        return accountJpaRepository.findByIdAndUserId(id, userId).map(accountMapper::toDomain);
    }
}
