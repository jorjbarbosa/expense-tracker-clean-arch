package com.project.expenses.application.usecases.user;

import com.project.expenses.application.gateways.UserRepository;
import com.project.expenses.domain.entity.User;

public class CreateUserUseCase {
    private final UserRepository userRepository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(User user) {
        return userRepository.save(user);
    }
}
