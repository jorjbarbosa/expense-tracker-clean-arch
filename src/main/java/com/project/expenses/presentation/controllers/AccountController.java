package com.project.expenses.presentation.controllers;

import com.project.expenses.application.usecases.account.CreateAccountUseCase;
import com.project.expenses.application.usecases.account.GetAccountUseCase;
import com.project.expenses.application.usecases.account.UpdateAccountUseCase;
import com.project.expenses.domain.entity.Account;
import com.project.expenses.infrastructure.mappers.AccountMapper;
import com.project.expenses.presentation.dto.request.AccountRequest;
import com.project.expenses.presentation.dto.response.AccountResponse;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
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
    private final UpdateAccountUseCase updateAccountUseCase;

    private final AccountMapper accountMapper;

    @PostMapping
    public ResponseEntity<AccountResponse> createAccount(@RequestBody AccountRequest request, JwtAuthenticationToken token) {
        UUID userId = UUID.fromString(token.getName());
        Account account = accountMapper.toAccount(request);
        account = createAccountUseCase.execute(account, userId);

        return new ResponseEntity<>(accountMapper.toResponse(account) ,HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<AccountResponse> getAccount(@PathVariable UUID id, JwtAuthenticationToken token) {
        UUID userId = UUID.fromString(token.getName());

        Account account = getAccountUseCase.execute(id, userId);

        return ResponseEntity.ok(accountMapper.toResponse(account));
    }

    @PutMapping("{id}")
    public ResponseEntity<AccountResponse> update(@PathVariable UUID id, @RequestBody AccountRequest request, JwtAuthenticationToken token) {
        UUID userId = UUID.fromString(token.getName());
        Account account = accountMapper.toAccount(request);
        account = updateAccountUseCase.execute(id, account, userId);

        return ResponseEntity.ok(accountMapper.toResponse(account));
    }

}
