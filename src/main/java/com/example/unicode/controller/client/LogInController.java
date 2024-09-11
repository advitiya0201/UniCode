package com.example.unicode.controller.client;

import com.example.unicode.dto.client.LogInRequest;
import com.example.unicode.dto.client.LogInResponse;
import com.example.unicode.service.client.LogInService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class LogInController {

    @Autowired
    private LogInService logInService;

    @GetMapping("/hi")  //Test GET API
    public String printer(){
        System.out.println("printer");
        return "printer";
    }

    @PostMapping("/logIn")
    public ResponseEntity<?> logInUser(@Valid @RequestBody LogInRequest request, HttpServletRequest httpRequest) {
        String clientIpAddress = httpRequest.getRemoteAddr(); // Get client's IP address
        String token = logInService.logInUser(request, clientIpAddress);
        return ResponseEntity.ok(new LogInResponse(token));
    }
}
