package com.example.unicode.service.client;

import com.example.unicode.dto.client.LogInRequest;
import com.example.unicode.entity.client.LogIn;
import com.example.unicode.repository.client.LogInRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Formatter;

import javax.validation.Valid;

@Service
@Validated
public class LogInService {

    @Autowired
    private LogInRepository logInRepository;

    public String logInUser(@Valid LogInRequest request, String ipAddress) {
        LogIn login = convertToEntity(request);
        login.setIpAddress(ipAddress);

        // Create a hashed token
        String token = createHashedToken(login.getBitsID(), login.getName(), 
                        login.getLabNumber(), login.getSystemNumber(), ipAddress, LocalDateTime.now());

        login.setHashedToken(token);

        logInRepository.save(login);
        return token;
    }

    private LogIn convertToEntity(LogInRequest request) {
        LogIn login = new LogIn();
        login.setBitsID(request.getBitsID());
        login.setName(request.getName());
        login.setLabNumber(request.getLabNumber());
        login.setSystemNumber(request.getSystemNumber());

        return login;
    }

    private String createHashedToken(String BITSID, String name, String labNumber, 
                                      int systemNumber, String ipAddress, LocalDateTime logInTime) {
        String toHash = BITSID + name + labNumber + systemNumber + ipAddress + logInTime;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(toHash.getBytes()); // compute hash
            return byteArray2Hex(hashBytes); // convert hash to hex string
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing data", e);
        }
    }

    private String byteArray2Hex(final byte[] hashBytes) { // the function to convert hash to hex
        Formatter formatter = new Formatter();
        for (byte b : hashBytes) {
            formatter.format("%02x", b);
        }
        String hashedValue = formatter.toString();
        formatter.close();
        return hashedValue;
    }
}