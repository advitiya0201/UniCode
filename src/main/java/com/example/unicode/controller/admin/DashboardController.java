package com.example.unicode.controller.admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class DashboardController {

    @GetMapping("/dashboard") //temporary dashboard method
    public String dashboard() {
        return "Welcome to the dashboard";
    }
}
