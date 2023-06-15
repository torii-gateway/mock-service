package org.torii.gateway.mockservice.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.torii.gateway.mockservice.log.CustomRequestInterceptor;

@Configuration
@RequiredArgsConstructor
public class RequestAppConfig implements WebMvcConfigurer {

    private final CustomRequestInterceptor customRequestInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(customRequestInterceptor)
                .addPathPatterns("/**");
    }
}