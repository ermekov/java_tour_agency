package com.postgresql.java_tour_agenstvo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/register", "/login", "/css/**", "/js/**", "/images/**").permitAll() // Разрешаем доступ к главной странице и статическим ресурсам
                        .anyRequest().authenticated() // Остальные страницы доступны только авторизованным пользователям
                )
                .formLogin(login -> login
                        .loginPage("/login") // Указываем кастомную страницу логина
                        .defaultSuccessUrl("/") // Перенаправляем на главную страницу после успешного входа
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // URL для выхода из системы
                        .logoutSuccessUrl("/login") // Перенаправляем на страницу логина после выхода
                        .permitAll()
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
