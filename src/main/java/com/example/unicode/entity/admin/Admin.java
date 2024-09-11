package com.example.unicode.entity.admin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "admins")
public class Admin {

    @Id
    @Column(name="username",nullable = false)
    @Getter
    private String username;

    @Column(name="password", nullable = false)
    @Getter
    private String password;

    // Getters and Setters
}