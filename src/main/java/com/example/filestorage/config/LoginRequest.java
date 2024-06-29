package com.example.filestorage.config;


import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;

    // getters and setters
}