package com.project.expenses.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthRequest {
    @NotBlank(message = "E-mail is required")
    private String email;
    @NotBlank(message = "Password is required")
    private String password;
}
