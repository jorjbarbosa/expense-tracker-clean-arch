package com.project.expenses.presentation.controllers;

import com.project.expenses.application.usecases.auth.LoginUseCase;
import com.project.expenses.application.usecases.auth.RegisterUseCase;
import com.project.expenses.application.usecases.user.CreateUserUseCase;
import com.project.expenses.domain.entity.User;
import com.project.expenses.infrastructure.mappers.UserMapper;
import com.project.expenses.presentation.dto.request.AuthRequest;
import com.project.expenses.presentation.dto.request.UserRequest;
import com.project.expenses.presentation.dto.response.AuthResponse;
import com.project.expenses.presentation.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final RegisterUseCase registerUseCase;
    private final LoginUseCase loginUseCase;

    private final UserMapper userMapper;

    @PostMapping("login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        String token = loginUseCase.login(request.getEmail(), request.getPassword());
        AuthResponse response = new AuthResponse();
        response.setToken(token);
        return ResponseEntity.ok(response);
    }

    @PostMapping("register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest request) {
        User user = userMapper.toUser(request);
        user = registerUseCase.execute(user);
        UserResponse response = userMapper.toResponse(user);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
