package com.example.unicode.service;

import com.example.unicode.entity.Student;
import com.example.unicode.repository.UniCodeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniCodeService {

    @Autowired
    private UniCodeRepo repo;

    public Student signIn(Student student) {
        return repo.save(student);
    }
}
