package com.example.filestorage.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class FileMetadata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String filename;
    private String filepath;
    private String owner;
    private Long version;

    @ManyToOne
    @JoinColumn(name = "previous_version_id")
    private FileMetadata previousVersion;

    public void setFilename(String filename) {
    }

    // Getters and Setters
}
