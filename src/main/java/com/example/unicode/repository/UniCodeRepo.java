package com.example.unicode.repository;

import com.example.unicode.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UniCodeRepo extends JpaRepository<Student, Long> {
}
