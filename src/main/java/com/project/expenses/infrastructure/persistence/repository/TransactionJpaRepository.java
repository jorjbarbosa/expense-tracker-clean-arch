package com.project.expenses.infrastructure.persistence.repository;

import com.project.expenses.infrastructure.persistence.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TransactionJpaRepository extends JpaRepository<TransactionEntity, UUID> {
    @Query(value = "SELECT * FROM transactions WHERE user_id = ?1 AND date BETWEEN ?2 AND ?3 ORDER BY date DESC", nativeQuery = true)
    List<TransactionEntity> findByUserIdAndDateBetween(UUID userId, LocalDateTime startDate, LocalDateTime endDate);

    Optional<TransactionEntity> findByIdAndUserId(UUID id, UUID userId);
}
