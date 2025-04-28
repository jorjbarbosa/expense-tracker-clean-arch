package com.project.expenses.infrastructure.persistence.adapter;

import com.project.expenses.application.gateways.TransactionRepositoryGateway;
import com.project.expenses.domain.entity.Transaction;
import com.project.expenses.infrastructure.mappers.TransactionMapper;
import com.project.expenses.infrastructure.persistence.entity.TransactionEntity;
import com.project.expenses.infrastructure.persistence.repository.TransactionJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class TransactionRepositoryGatewayAdapter implements TransactionRepositoryGateway {

    private final TransactionJpaRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    @Override
    public Transaction save(Transaction transaction) {
        TransactionEntity transactionEntity = transactionMapper.toEntity(transaction);
        return transactionMapper.toDomain(transactionRepository.save(transactionEntity));
    }

    @Override
    public Optional<Transaction> findById(UUID id) {
        return transactionRepository.findById(id).map(transactionMapper::toDomain);
    }
}
