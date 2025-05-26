package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

/**
 * Test configuration that provides test implementations
 * of beans to avoid connecting to external resources
 */
@Configuration
@Profile("test")
public class TestConfiguration {
    
    /**
     * Overrides the CommandLineRunner bean to avoid connecting to Azure
     */
    @Bean
    @Primary
    public CommandLineRunner testCommandLineRunner() {
        return args -> {
            System.out.println("Running test CommandLineRunner");
            // Do nothing, just return immediately
        };
    }
}