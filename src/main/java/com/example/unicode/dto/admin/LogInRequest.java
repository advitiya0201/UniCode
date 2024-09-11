package com.example.unicode.dto.admin;

import javax.validation.constraints.NotBlank;

public class LogInRequest {

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Password is required")
    private String password;

    // Getters and Setters
}