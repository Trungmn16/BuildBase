package com.example.filestorage.service;

import com.example.filestorage.Entity.FileEntity;
import com.example.filestorage.constant.ConstantCommon;
import org.springframework.web.multipart.MultipartFile;

public class FileServiceImpl implements FileService{
    @Override
    public String append(MultipartFile files) {
        if(files.isEmpty()){
            return null;
        }
        FileEntity fileEntity = new FileEntity();
        fileEntity.setName(files.getOriginalFilename());
        fileEntity.setSize(files.getSize());
//        fileEntity.setLink(files.getgetAbsolutePath());

        return ConstantCommon.FAIL;
    }
}
