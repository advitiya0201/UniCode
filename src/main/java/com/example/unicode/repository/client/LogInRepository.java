package com.example.unicode.repository.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.unicode.entity.client.LogIn;

@Repository
public interface LogInRepository extends JpaRepository<LogIn, Long> {
    // Add custom query methods if needed, e.g., findByStudentId()
}
