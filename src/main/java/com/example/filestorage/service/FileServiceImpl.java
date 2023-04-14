package com.example.filestorage.service;

import com.example.filestorage.Entity.FileEntity;
import com.example.filestorage.constant.ConstantCommon;

import com.example.filestorage.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.util.List;

public class FileServiceImpl implements FileService{
    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private FileRepository fileRepository;
    @Override
    public FileEntity append(MultipartFile file, Long id) {
        if(file.isEmpty()){
            return null;
        }
        FileEntity fileEntity = new FileEntity();
        fileEntity.setName(file.getOriginalFilename());
        fileEntity.setSize(file.getSize());
        fileEntity.setLink(uploadPath+file.getOriginalFilename());
        fileEntity.setCreatedBy("trunmn1");
        fileEntity.setCreatedTime(LocalDateTime.now());
        fileEntity.setModifiedBy("trungmn1");
        fileEntity.setModifiedTime(LocalDateTime.now());
        fileEntity.setArticle_id(id);
        fileEntity.setOriginal_name(file.getOriginalFilename());
        return fileRepository.save(fileEntity);
    }

    @Override
    public String append_all(List<MultipartFile> files, Long id) {
        return null;
    }

    @Override
    public String appendOrUpdate(List<MultipartFile> files, Long id) {
        return null;
    }

    @Override
    public String deleted(List<Long> ids) {
        return null;
    }

    @Override
    public FileInputStream getContentFile(List<Long> ids) {
        return null;
    }



}
