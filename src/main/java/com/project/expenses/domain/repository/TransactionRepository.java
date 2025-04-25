package com.project.expenses.domain.repository;

import com.project.expenses.domain.entity.Transaction;

import java.util.UUID;

public interface TransactionRepository {
    Transaction save(Transaction category);
    Transaction findById(UUID id);
}
