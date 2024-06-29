package com.example.filestorage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.filestorage.model.FileShare;

import java.util.List;

public interface FileShareRepository extends JpaRepository<FileShare, Long> {
    List<FileShare> findBySharedWith(String sharedWith);

    //List<FileShare> findBySharedWithAll();
}
