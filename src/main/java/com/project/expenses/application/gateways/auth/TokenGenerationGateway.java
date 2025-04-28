package com.project.expenses.application.gateways.auth;

import java.util.UUID;

public interface TokenGenerationGateway {
    String generateToken(UUID userId);
}
