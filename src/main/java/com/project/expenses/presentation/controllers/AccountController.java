package com.project.expenses.presentation.controllers;

import com.project.expenses.application.usecases.account.CreateAccountUseCase;
import com.project.expenses.application.usecases.account.GetAccountUseCase;
import com.project.expenses.domain.entity.Account;
import com.project.expenses.infrastructure.mappers.AccountMapper;
import com.project.expenses.presentation.dto.request.AccountRequest;
import com.project.expenses.presentation.dto.response.AccountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final CreateAccountUseCase createAccountUseCase;
    private final GetAccountUseCase getAccountUseCase;

    private final AccountMapper accountMapper;

    @PostMapping
    public ResponseEntity<AccountResponse> createAccount(@RequestBody AccountRequest request, JwtAuthenticationToken token) {
        UUID userId = UUID.fromString(token.getName());
        Account account = accountMapper.toAccount(request);
        account = createAccountUseCase.execute(account, userId);

        return new ResponseEntity<>(accountMapper.toResponse(account) ,HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<AccountResponse> getAccount(@PathVariable UUID id) {
        Account account = getAccountUseCase.execute(id);
        return ResponseEntity.ok(accountMapper.toResponse(account));
    }

}
