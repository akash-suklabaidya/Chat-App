//package com.ChatApp.Chat.App.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/ws/**").permitAll()  // Allow WebSocket connections without authentication
//                .anyRequest().authenticated()  // All other requests require authentication
//                .and()
//                .httpBasic()  // Enable basic auth for other endpoints
//                .and()
//                .csrf().disable();  // Disable CSRF for WebSocket connections (optional)
//
//        return http.build();
//    }
//}
