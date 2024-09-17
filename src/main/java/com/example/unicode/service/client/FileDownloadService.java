package com.example.unicode.service.client;
import com.example.unicode.utils.Constants;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FileDownloadService {

    public Resource downloadFile(String fileName) {
        try{
            Path filePath = Path.of(Constants.DIR, fileName);
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new FileNotFoundException("File not found: " + fileName);
            }
        } catch (Exception e) {
            throw new RuntimeException("File download error", e);
        }
    }

    public String getFileContentType(String fileName) {
        try{
            Path filePath = Path.of(Constants.DIR, fileName);
            String contentType = Files.probeContentType(filePath);
            return (contentType != null) ? contentType : "application/octet-stream";
        } catch (Exception e) {
            throw new RuntimeException("Error determining file content type", e);
        }
    }
}
