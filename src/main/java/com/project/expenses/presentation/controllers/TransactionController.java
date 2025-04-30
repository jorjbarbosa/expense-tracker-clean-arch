package com.project.expenses.presentation.controllers;

import com.project.expenses.application.usecases.transaction.CreateTransactionUseCase;
import com.project.expenses.application.usecases.transaction.GetTransactionUseCase;
import com.project.expenses.application.usecases.transaction.GetTransactionsByUserAndDateUseCase;
import com.project.expenses.application.usecases.transaction.UpdateTransactionUseCase;
import com.project.expenses.domain.entity.Transaction;
import com.project.expenses.infrastructure.mappers.TransactionMapper;
import com.project.expenses.presentation.dto.request.TransactionRequest;
import com.project.expenses.presentation.dto.response.TransactionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final GetTransactionUseCase getTransactionUseCase;
    private final GetTransactionsByUserAndDateUseCase getTransactionsByUserAndDateUseCase;
    private final CreateTransactionUseCase createTransactionUseCase;
    private final UpdateTransactionUseCase updateTransactionUseCase;

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
    public ResponseEntity<TransactionResponse> getTransaction(@PathVariable UUID id, JwtAuthenticationToken token) {
        UUID userId = UUID.fromString(token.getName());

        Transaction transaction = getTransactionUseCase.execute(id, userId);
        var response = transactionMapper.toResponse(transaction);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<TransactionResponse>> getTransactions(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            JwtAuthenticationToken token) {
        UUID userId = UUID.fromString(token.getName());
        LocalDateTime start = startDate.atStartOfDay();
        LocalDateTime end = endDate.atTime(LocalTime.MAX);

        List<TransactionResponse> transactions = getTransactionsByUserAndDateUseCase
                .execute(userId, start, end)
                .stream()
                .map(transactionMapper::toResponse)
                .toList();

        return ResponseEntity.ok(transactions);
    }

    @PutMapping("{id}")
    public ResponseEntity<TransactionResponse> update(@PathVariable UUID id, @RequestBody TransactionRequest request, JwtAuthenticationToken token) {
        UUID userId = UUID.fromString(token.getName());
        Transaction transaction = transactionMapper.toTransaction(request);
        transaction = updateTransactionUseCase.execute(id, transaction, userId);

        return ResponseEntity.ok(transactionMapper.toResponse(transaction));
    }
}
