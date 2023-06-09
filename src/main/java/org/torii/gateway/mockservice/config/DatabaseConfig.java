package org.torii.gateway.mockservice.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.torii.gateway.mockservice.domain.Content;
import org.torii.gateway.mockservice.repo.ContentRepository;

@Configuration
public class DatabaseConfig {


    @Bean
    CommandLineRunner initDatabase(ContentRepository repository) {
        return args -> {
            repository.save(new Content(1L, "Mock content 1"));
            repository.save(new Content(2L, "Mock content 2"));
        };
    }
}
