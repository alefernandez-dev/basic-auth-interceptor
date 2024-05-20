package dev.alejandro.authinterceptor.auth;

import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class InterceptorConfiguration implements WebMvcConfigurer {

    private final BasicAuthInterceptor basicAuthInterceptor;

    public InterceptorConfiguration(BasicAuthInterceptor basicAuthInterceptor) {
        this.basicAuthInterceptor = basicAuthInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        var ptm = new AntPathMatcher();
        registry.addInterceptor(basicAuthInterceptor)
                .addPathPatterns("/fbi/secret")
                .excludePathPatterns("/fbi/public");
    }
}
