package com.example.filestorage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.filestorage.model.FileMetadata;
import com.example.filestorage.repository.FileMetadataRepository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.*;
import java.util.List;

@Service
public class FileService {

    @Autowired
    private FileMetadataRepository fileMetadataRepository;

    @Value("${file.storage.location}")
    private String fileStorageLocation;

    public FileMetadata storeFile(MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        Path targetLocation = Paths.get(fileStorageLocation).resolve(filename);
        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

        FileMetadata metadata = new FileMetadata();
        metadata.setFilename(filename);
        metadata.setFilepath(targetLocation.toString());
        metadata.setOwner("darshan");
        metadata.setVersion(1L); // Initial version
        return fileMetadataRepository.save(metadata);
    }

    public Resource loadFileAsResource(String filename) throws MalformedURLException, FileNotFoundException {
        Path filePath = Paths.get(fileStorageLocation).resolve(filename).normalize();
        System.out.println("File path: " + filePath.toString()); // Print the file path
        Resource resource = new UrlResource(filePath.toUri());
        if (resource.exists()) {
            return resource;
        } else {
            throw new FileNotFoundException("File not found " + filename);
        }
    }
}
