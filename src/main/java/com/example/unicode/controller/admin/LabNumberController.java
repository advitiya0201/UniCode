package com.example.unicode.controller.admin;

import com.example.unicode.service.admin.LabNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/admin")
public class LabNumberController {

    @Autowired
    private LabNumberService labNumberService;

    @RequestMapping("/save-labs")
    public ResponseEntity<String> saveLabNumbers(@RequestBody List<String> labNumbers) {
        try {
            labNumberService.saveLabNumbers(labNumbers);
            return ResponseEntity.status(HttpStatus.OK).body("Lab numbers saved successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving lab numbers");
        }
    }

    @RequestMapping("/labs")
    public ResponseEntity<List<String>> getAllLabNumbers() {
        List<String> labNumbers = labNumberService.getAllLabNumbers();
        return ResponseEntity.ok(labNumbers); // Return the list of lab numbers
    }

}
