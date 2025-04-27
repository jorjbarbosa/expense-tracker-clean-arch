package com.project.expenses.application.usecases.user;

import com.project.expenses.application.exception.BussinessException;
import com.project.expenses.application.gateways.UserRepository;
import com.project.expenses.domain.entity.User;

import java.util.UUID;

public class GetUserByIdUseCase {
    private final UserRepository userRepository;

    public GetUserByIdUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new BussinessException("User not found"));
    }
}
