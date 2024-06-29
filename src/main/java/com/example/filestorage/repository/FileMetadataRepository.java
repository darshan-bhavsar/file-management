package com.example.filestorage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.filestorage.model.FileMetadata;

import java.util.List;

public interface FileMetadataRepository extends JpaRepository<FileMetadata, Long> {
    List<FileMetadata> findByOwner(String owner);
}
