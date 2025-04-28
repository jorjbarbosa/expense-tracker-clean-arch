package com.project.expenses.application.gateways;

import com.project.expenses.domain.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryGateway {
    User save(User user);
    Optional<User> findById(UUID id);
    Optional<User> findByEmail(String email);
}
