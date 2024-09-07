package com.example.unicode.controller;

import com.example.unicode.entity.Student;
import com.example.unicode.service.UniCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/unicode")
public class UniCodeController {

    @Autowired
    UniCodeService service;

    @GetMapping("/hi")  //Test GET API
    public String printer(){
        System.out.println("printer");
        return "printer";
    }

    @PostMapping("/sign-in")
    public ResponseEntity<Student> signIn(@RequestBody Student student){
        Student savedStudent = service.signIn(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping("/student-ip")
    public ResponseEntity<String> getIpAddress() {
        String ipAddress = service.getIpAddress();
        if (ipAddress == null || ipAddress.isEmpty()) {
            return new ResponseEntity<>("IP address not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ipAddress, HttpStatus.OK);
    }

    @PostMapping("/hash-code")
    public ResponseEntity<String> getHashCode(@RequestParam String bitsId, @RequestParam String ipAddress) {
        String hashCode = service.getHashCode(bitsId, ipAddress);
        return new ResponseEntity<>(hashCode, HttpStatus.OK);
    }
}
