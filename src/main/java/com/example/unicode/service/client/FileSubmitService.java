package com.example.unicode.service.client;
import com.example.unicode.entity.client.LogIn;
import com.example.unicode.repository.client.LogInRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class FileSubmitService {

    @Autowired
    private LogInRepository logInRepository;

    @Value("${submissionFilePath}")
    private String basePath;

    public String submitFile(MultipartFile file, @NotNull String bitsID) throws IOException {
        //Check if the File is a zip file
        if (!Objects.requireNonNull(file.getOriginalFilename()).endsWith(".zip")) {
            throw new IllegalArgumentException("Only .zip files are allowed");
        }

        // Fetch the student's details based on BITS ID
        LogIn student = logInRepository.findByBitsID(bitsID);
        if (student == null) {
            throw new IllegalArgumentException("Student not found with BITS ID: " + bitsID);
        }

        // Create directory for the lab number
        String labNumber = student.getLabNumber();
        Path labDir = Paths.get(basePath, labNumber);
        if (!Files.exists(labDir)) {
            Files.createDirectories(labDir);
        }

        // Rename the file to match the student's BITS ID (e.g., "2021AAPS0979P.zip")
        String newFileName = bitsID + ".zip";
        // Define the path for the uploaded file within the lab directory
        Path filePath = labDir.resolve(newFileName); //combines both the paths
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return "File uploaded successfully to lab " + labNumber + ": " + file.getOriginalFilename();
    }
}
