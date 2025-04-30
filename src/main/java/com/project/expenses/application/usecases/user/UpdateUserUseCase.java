package com.project.expenses.application.usecases.user;

import com.project.expenses.application.exception.BussinessException;
import com.project.expenses.application.gateways.UserRepositoryGateway;
import com.project.expenses.application.gateways.auth.PasswordEncoderGateway;
import com.project.expenses.domain.entity.User;

import java.util.UUID;

public class UpdateUserUseCase {
    private final UserRepositoryGateway userRepository;
    private final PasswordEncoderGateway passwordEncoder;

    public UpdateUserUseCase(UserRepositoryGateway userRepository, PasswordEncoderGateway passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User execute(UUID id, User data) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new BussinessException("User not found"));

        user.setName(data.getName());
        user.setEmail(data.getEmail());
        user.setPassword(passwordEncoder.encode(data.getPassword()));

        return userRepository.save(user);
    }
}
