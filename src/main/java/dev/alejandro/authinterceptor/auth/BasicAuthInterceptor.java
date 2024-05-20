package dev.alejandro.authinterceptor.auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;

@Component
public class BasicAuthInterceptor implements HandlerInterceptor {

    private final AuthenticationManager manager;

    public BasicAuthInterceptor(AuthenticationManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Basic ")) {
            var userOptional = resolveCredentials(authHeader);
            if (userOptional.isPresent()) {
                request.setAttribute("X-Request-Maker", userOptional.get().getName());
                return true;
            }
            response.setStatus(401);
            return false;
        }
        response.setStatus(401);
        return false;
    }

    private Optional<User<?>> resolveCredentials(String authHeader) {
        String base64Credentials = authHeader.substring("Basic ".length()).trim();
        String credentials = new String(Base64.getDecoder().decode(base64Credentials), StandardCharsets.UTF_8);
        var values = credentials.split(":", 2);
        String username = values[0];
        String password = values[1];
        return manager.authenticate(username, password);
    }
}
