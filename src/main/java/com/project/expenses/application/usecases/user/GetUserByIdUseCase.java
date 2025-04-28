package com.project.expenses.application.usecases.user;

import com.project.expenses.application.exception.BussinessException;
import com.project.expenses.application.gateways.UserRepositoryGateway;
import com.project.expenses.domain.entity.User;

import java.util.UUID;

public class GetUserByIdUseCase {
    private final UserRepositoryGateway userRepositoryGateway;

    public GetUserByIdUseCase(UserRepositoryGateway userRepositoryGateway) {
        this.userRepositoryGateway = userRepositoryGateway;
    }

    public User execute(UUID id) {
        return userRepositoryGateway.findById(id)
                .orElseThrow(() -> new BussinessException("User not found"));
    }
}
