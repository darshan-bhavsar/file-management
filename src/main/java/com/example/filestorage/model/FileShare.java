package com.example.filestorage.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class FileShare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long fileId;
    private String sharedWith;
    private String owner;

//    public void setSharedWith(String sharedWith) {
//    }

    // Getters and Setters
}
