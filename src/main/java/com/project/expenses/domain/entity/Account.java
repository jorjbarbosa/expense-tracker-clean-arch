package com.project.expenses.domain.entity;

import java.math.BigDecimal;
import java.util.UUID;

public record Account(UUID id, String name, String description, BigDecimal balance, User user) {
}
