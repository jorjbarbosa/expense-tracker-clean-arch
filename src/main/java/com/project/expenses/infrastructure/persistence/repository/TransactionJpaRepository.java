package com.project.expenses.infrastructure.persistence.repository;

import com.project.expenses.infrastructure.persistence.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface TransactionJpaRepository extends JpaRepository<TransactionEntity, UUID> {
    List<TransactionEntity> findByUserIdAndDateBetween(UUID id, LocalDateTime startDate, LocalDateTime endDate);
}
