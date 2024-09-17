package com.example.unicode.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private final AdminDetailsService adminDetailsService;

    public SecurityConfig(AdminDetailsService adminDetailsService) {
        this.adminDetailsService = adminDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)  // Disable CSRF (if necessary)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/admin/**").hasRole(Constants.ADMIN)  // Secure /admin/** routes
                        .anyRequest().permitAll()                       // Allow public access to all other routes
                )
                .formLogin(form -> form
                        .defaultSuccessUrl("/admin/dashboard", true)  // Redirect after successful login
                        .permitAll()
                )
                .logout(logout -> logout.permitAll());

        return http.build();
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new NoOpPasswordEncoder();
//    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(adminDetailsService);
    }
}
