package com.example.unicode.controller;

import com.example.unicode.entity.Student;
import com.example.unicode.repository.UniCodeRepo;
import com.example.unicode.service.UniCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
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



}
