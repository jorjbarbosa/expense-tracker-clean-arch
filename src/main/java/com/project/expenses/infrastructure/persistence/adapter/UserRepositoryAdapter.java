package com.project.expenses.infrastructure.persistence.adapter;

import com.project.expenses.application.gateways.UserRepository;
import com.project.expenses.domain.entity.User;
import com.project.expenses.infrastructure.mappers.UserMapper;
import com.project.expenses.infrastructure.persistence.entity.UserEntity;
import com.project.expenses.infrastructure.persistence.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepository {

    private final UserJpaRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User save(User user) {
        UserEntity entity = userMapper.toEntity(user);
        entity = userRepository.save(entity);

        return userMapper.toDomain(entity);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return userRepository.findById(id).map(userMapper::toDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email).map(userMapper::toDomain);
    }
}
