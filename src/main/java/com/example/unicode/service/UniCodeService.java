package com.example.unicode.service;

import com.example.unicode.entity.Student;
import com.example.unicode.repository.UniCodeRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

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

    public String getHashCode(String bitsId, String ipAddress) {
        try {
            // Combine the BITS ID and IP address
            String combinedString = bitsId + ":" + ipAddress;

            // Create SHA-256 hash
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(combinedString.getBytes(StandardCharsets.UTF_8));

            // Encode the byte array into a Base64 string to make it URL safe
            return Base64.getUrlEncoder().withoutPadding().encodeToString(hashBytes);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating unique code", e);
        }

    }
}
