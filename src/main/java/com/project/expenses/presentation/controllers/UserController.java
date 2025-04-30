package com.project.expenses.presentation.controllers;

import com.project.expenses.application.usecases.user.CreateUserUseCase;
import com.project.expenses.application.usecases.user.GetUserByEmailUseCase;
import com.project.expenses.application.usecases.user.GetUserByIdUseCase;
import com.project.expenses.application.usecases.user.UpdateUserUseCase;
import com.project.expenses.domain.entity.User;
import com.project.expenses.infrastructure.mappers.UserMapper;
import com.project.expenses.presentation.dto.request.UserRequest;
import com.project.expenses.presentation.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final CreateUserUseCase createUserUseCase;
    private final GetUserByIdUseCase getUserByIdUseCase;
    private final UpdateUserUseCase updateUserUseCase;

    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest request) {
        User user = userMapper.toUser(request);
        user = createUserUseCase.execute(user);
        UserResponse response = userMapper.toResponse(user);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable UUID id) {
        User user = getUserByIdUseCase.execute(id);
        return ResponseEntity.ok(userMapper.toResponse(user));
    }

    @PutMapping("{id}")
    public ResponseEntity<UserResponse> update(@PathVariable UUID id, @RequestBody UserRequest request) {
        User user = userMapper.toUser(request);
        user = updateUserUseCase.execute(id, user);
        UserResponse response = userMapper.toResponse(user);
        return ResponseEntity.ok(response);
    }
}
