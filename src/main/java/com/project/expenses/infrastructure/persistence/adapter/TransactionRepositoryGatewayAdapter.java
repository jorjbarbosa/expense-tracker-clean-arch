package com.project.expenses.infrastructure.persistence.adapter;

import com.project.expenses.application.gateways.TransactionRepositoryGateway;
import com.project.expenses.domain.entity.Transaction;
import com.project.expenses.infrastructure.mappers.TransactionMapper;
import com.project.expenses.infrastructure.persistence.entity.TransactionEntity;
import com.project.expenses.infrastructure.persistence.repository.TransactionJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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
    public Optional<Transaction> findByIdAndUserId(UUID id, UUID userId) {
        return transactionRepository.findByIdAndUserId(id, userId).map(transactionMapper::toDomain);
    }

    @Override
    public List<Transaction> findByUserIdAndDateBetween(UUID id, LocalDateTime startDate, LocalDateTime endDate) {
        return transactionRepository.findByUserIdAndDateBetween(id, startDate, endDate)
                .stream().map(transactionMapper::toDomain)
                .collect(Collectors.toList());
    }
}
