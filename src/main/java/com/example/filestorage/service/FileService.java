package com.example.filestorage.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    public String append(MultipartFile file);
}
