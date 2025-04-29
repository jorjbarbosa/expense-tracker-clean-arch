package com.project.expenses.infrastructure.mappers;

import com.project.expenses.domain.entity.Category;
import com.project.expenses.domain.entity.Transaction;
import com.project.expenses.infrastructure.persistence.entity.TransactionEntity;
import com.project.expenses.presentation.dto.request.TransactionRequest;
import com.project.expenses.presentation.dto.response.TransactionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    Transaction toDomain(TransactionEntity entity);

    @Mapping(source = "category", target = "category")
    TransactionEntity toEntity(Transaction transaction);

    TransactionResponse toResponse(Transaction transaction);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    Transaction toTransaction(TransactionRequest request);
}
