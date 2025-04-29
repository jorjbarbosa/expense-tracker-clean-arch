package com.project.expenses.domain.entity;

import com.project.expenses.domain.enums.TransactionType;

import java.math.BigDecimal;
import java.util.UUID;


public class Account {
    private UUID id;
    private String name;
    private String description;
    private BigDecimal initialBalance;
    private BigDecimal currentBalance;
    private User user;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(BigDecimal initialBalance) {
        this.initialBalance = initialBalance;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void applyTransaction(Transaction transaction) {
        if (TransactionType.REVENUE.equals(transaction.getType())) {
            this.currentBalance = currentBalance.add(transaction.getAmount());
        } else {
            this.currentBalance = currentBalance.subtract(transaction.getAmount());
        }
    }
}
