package com.example.unicode.service;

import com.example.unicode.entity.Student;
import com.example.unicode.repository.UniCodeRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniCodeService {

    @Autowired
    private UniCodeRepo repo;

    @Autowired
    private HttpServletRequest request;

    public Student signIn(Student student) {
        return repo.save(student);
    }

    public String getIpAddress() {
        return request.getRemoteAddr();
    }
}
