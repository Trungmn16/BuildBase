package com.example.filestorage.service;

import com.example.filestorage.Entity.FileEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.util.List;

public interface FileService {

    FileEntity append(MultipartFile file, Long id);

    public String append_all(List<MultipartFile> files, Long id);
    public String appendOrUpdate(List<MultipartFile> files, Long id);
    public String deleted(List<Long>  ids);
    public FileInputStream getContentFile(List<Long>  ids);

}
