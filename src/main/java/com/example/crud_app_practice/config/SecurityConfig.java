package com.example.crud_app_practice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable()) // Disable CSRF for stateless API
        .authorizeHttpRequests(authorize -> authorize
            .requestMatchers("/products/**", "/categories/**", "/ws/**").permitAll() // Allow unauthenticated access to product and category endpoints
            .anyRequest().authenticated() // All other requests require authentication
        );
    return http.build();
  }

}
