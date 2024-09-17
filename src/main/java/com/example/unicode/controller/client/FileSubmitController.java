package com.example.unicode.controller.client;

import com.example.unicode.service.client.FileSubmitService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class FileSubmitController {

    @Autowired
    private FileSubmitService fileSubmitService;

    @PostMapping("/submit-zip")
    public ResponseEntity<String> submitFile(MultipartFile file, @NotNull String bitsId) {
        try {
            String message = fileSubmitService.submitFile(file, bitsId);
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Could not upload the file due to an internal error.");
        }
    }
}
