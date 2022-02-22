package com.example.jdbi.configuration;

import com.example.jdbi.repository.DeveloperRepository;
import org.jdbi.v3.core.Jdbi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

    @Bean
    public DeveloperRepository developerRepository(Jdbi jdbi) {
        return jdbi.onDemand(DeveloperRepository.class);
    }

}
