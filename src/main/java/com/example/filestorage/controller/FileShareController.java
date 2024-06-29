package com.example.filestorage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.filestorage.model.FileShare;
import com.example.filestorage.service.FileShareService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/shares")
public class FileShareController {

    @Autowired
    private FileShareService fileShareService;

    @PostMapping("/share")
    public ResponseEntity<FileShare> shareFile(@RequestParam Long fileId, @RequestParam String sharedWith) {
        if(sharedWith == null || sharedWith.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        FileShare fileShare = fileShareService.shareFile(fileId, sharedWith);
        return new ResponseEntity<>(fileShare, HttpStatus.CREATED);
    }

//    @GetMapping("/shared")
//    public ResponseEntity<List<FileShare>> getSharedFiles() {
//        List<FileShare> sharedFiles = fileShareService.getSharedFiles();
//        return new ResponseEntity<>(sharedFiles, HttpStatus.OK);
//    }
}
