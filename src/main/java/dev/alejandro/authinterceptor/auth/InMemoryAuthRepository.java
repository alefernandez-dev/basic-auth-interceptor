package dev.alejandro.authinterceptor.auth;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Component
public class InMemoryAuthRepository implements AuthRepository{

    private final Map<String, User<UUID>> users;

    public InMemoryAuthRepository() {
        var admin = new User<>(UUID.randomUUID(), "alejandro", "12345678");
        var user = new User<>(UUID.randomUUID(), "mariana", "12345678");
        this.users = Map.of(admin.getName(), admin, user.getName(), user);
    }

    @Override
    public Optional<User<?>> getUserByUsername(String username) {
        return Optional.ofNullable(users.get(username));
    }
}
