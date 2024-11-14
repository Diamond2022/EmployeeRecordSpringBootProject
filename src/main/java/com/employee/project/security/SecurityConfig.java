package com.employee.project.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        // Disable CSRF and allow public access to /api/students/**
	        http.csrf().disable()  // Disable CSRF for non-browser clients
	            .authorizeHttpRequests((auth) -> auth
	                .requestMatchers("/api/employees/**").permitAll()  // Public access to /api/students/
	                .anyRequest().authenticated()  // Other requests require authentication
	            );
	        
	        return http.build();
	    }


}

