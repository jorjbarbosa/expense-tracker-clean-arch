package com.project.expenses.application.usecases.user;

import com.project.expenses.application.gateways.UserRepositoryGateway;
import com.project.expenses.domain.entity.User;

public class CreateUserUseCase {
    private final UserRepositoryGateway userRepositoryGateway;

    public CreateUserUseCase(UserRepositoryGateway userRepositoryGateway) {
        this.userRepositoryGateway = userRepositoryGateway;
    }

    public User execute(User user) {
        return userRepositoryGateway.save(user);
    }
}
