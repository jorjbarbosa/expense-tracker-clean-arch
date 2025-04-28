package com.project.expenses.infrastructure.security.adapter;

import com.project.expenses.application.gateways.auth.TokenGenerationGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class TokenGeneratorAdapter implements TokenGenerationGateway {
    private final JwtEncoder jwtEncoder;

    @Override
    public String generateToken(UUID id) {
        var now = Instant.now();
        var expiresIn = 3600L;

        var claims = JwtClaimsSet.builder()
                .issuer("expenses-app")
                .subject(id.toString())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}
