package com.project.expenses.presentation.dto.request;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
