package dev.alejandro.authinterceptor.auth;

import java.util.Optional;

public interface AuthRepository {
    Optional<User<?>> getUserByUsername(String username);
}
