package com.example.filestorage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.example.filestorage.model.FileMetadata;
import com.example.filestorage.service.FileService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.security.Principal;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<FileMetadata> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
//        if (principal == null) {
//            throw new RuntimeException("User is not authenticated");
//        }
        FileMetadata metadata = fileService.storeFile(file);
        if(metadata != null){
            System.out.println("File uploaded successfully");
        }
        return new ResponseEntity<>(metadata, HttpStatus.CREATED);
    }

    @GetMapping("/download/{filename:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) throws MalformedURLException, FileNotFoundException {
        Resource resource = fileService.loadFileAsResource(filename);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
