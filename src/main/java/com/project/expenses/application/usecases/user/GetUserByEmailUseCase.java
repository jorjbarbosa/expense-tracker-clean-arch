package com.project.expenses.application.usecases.user;

import com.project.expenses.application.exception.BussinessException;
import com.project.expenses.application.gateways.UserRepositoryGateway;
import com.project.expenses.domain.entity.User;

public class GetUserByEmailUseCase {
    private final UserRepositoryGateway userRepositoryGateway;

    public GetUserByEmailUseCase(UserRepositoryGateway userRepositoryGateway) {
        this.userRepositoryGateway = userRepositoryGateway;
    }

    public User execute(String email) {
        return userRepositoryGateway.findByEmail(email)
                .orElseThrow(() -> new BussinessException("User not found"));
    }
}
