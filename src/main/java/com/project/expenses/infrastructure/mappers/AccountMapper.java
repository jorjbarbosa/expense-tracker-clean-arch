package com.project.expenses.infrastructure.mappers;

import com.project.expenses.domain.entity.Account;
import com.project.expenses.infrastructure.persistence.entity.AccountEntity;
import com.project.expenses.presentation.dto.request.AccountRequest;
import com.project.expenses.presentation.dto.response.AccountResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountEntity toEntity(Account account);
    Account toDomain(AccountEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    Account toAccount(AccountRequest request);

    AccountResponse toResponse(Account account);
}
