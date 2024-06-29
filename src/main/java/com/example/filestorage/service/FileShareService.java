package com.example.filestorage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.filestorage.model.FileShare;
import com.example.filestorage.repository.FileShareRepository;

import java.util.List;

@Service
public class FileShareService {

    @Autowired
    private FileShareRepository fileShareRepository;

    public FileShare shareFile(Long fileId, String sharedWith) {
        FileShare fileShare = new FileShare();
        fileShare.setFileId(fileId);
        fileShare.setSharedWith(sharedWith);
//        fileShare.setOwner(owner);
        return fileShareRepository.save(fileShare);
    }

//    public List<FileShare> getSharedFiles() {
//        return fileShareRepository.findBySharedWithAll();
//    }
}
