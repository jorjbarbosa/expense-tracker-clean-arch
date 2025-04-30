package com.project.expenses.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "E-mail is required")
    private String email;
    @NotBlank(message = "Password is required")
    private String password;
}
