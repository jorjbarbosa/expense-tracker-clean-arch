package com.project.expenses.infrastructure.mappers;

import com.project.expenses.domain.entity.User;
import com.project.expenses.infrastructure.persistence.entity.UserEntity;
import com.project.expenses.presentation.dto.request.UserRequest;
import com.project.expenses.presentation.dto.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toEntity(User user);
    User toDomain(UserEntity userEntity);
    UserResponse toResponse(User user);

    @Mapping(target = "id", ignore = true)
    User toUser(UserRequest request);

}
