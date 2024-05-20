package dev.alejandro.authinterceptor.auth;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthenticationManager {

    private final AuthRepository repository;

    public AuthenticationManager(AuthRepository repository) {
        this.repository = repository;
    }

    public Optional<User<?>> authenticate(String username, String password) {
        return repository.getUserByUsername(username)
                .filter(u -> u.getPassword().equals(password));
    }
}
