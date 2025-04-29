package com.project.expenses.presentation.controllers;

import com.project.expenses.application.usecases.transaction.CreateTransactionUseCase;
import com.project.expenses.application.usecases.transaction.GetTransactionUseCase;
import com.project.expenses.domain.entity.Transaction;
import com.project.expenses.infrastructure.mappers.TransactionMapper;
import com.project.expenses.presentation.dto.request.TransactionRequest;
import com.project.expenses.presentation.dto.response.TransactionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@RestController
@RequestMapping("/api/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final GetTransactionUseCase getTransactionUseCase;
    private final CreateTransactionUseCase createTransactionUseCase;
    private final TransactionMapper transactionMapper;

    @PostMapping
    public ResponseEntity<TransactionResponse> createTransaction(@RequestBody TransactionRequest request, JwtAuthenticationToken token) {
        UUID userId = UUID.fromString(token.getName());
        Transaction transaction = transactionMapper.toTransaction(request);
        Transaction createdTransaction = createTransactionUseCase.execute(transaction, userId);
        TransactionResponse response = transactionMapper.toResponse(createdTransaction);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<TransactionResponse> getTransaction(@PathVariable UUID id) {
        Transaction transaction = getTransactionUseCase.execute(id);
        var response = transactionMapper.toResponse(transaction);

        return ResponseEntity.ok(response);
    }
}
