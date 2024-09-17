package com.example.unicode.service.admin;

import com.example.unicode.utils.Constants;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class FileUploadService {

    public String uploadFile(MultipartFile file) throws IOException {
        //Check if the File is a zip file
        if (!Objects.requireNonNull(file.getOriginalFilename()).endsWith(".zip")) {
            throw new IllegalArgumentException("Only .zip files are allowed");
        }
        Path path = Paths.get(Constants.DIR + file.getOriginalFilename());
        System.out.println(path);
        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

        return "File uploaded successfully: " + file.getOriginalFilename();
    }
}
