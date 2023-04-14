package com.example.filestorage.controller;


import com.example.buildbase.Common.JPT;
import com.example.filestorage.Entity.FileEntity;
import com.example.filestorage.constant.ConstantCommon;
import com.example.filestorage.service.FileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;


@RestController
@RequestMapping("/file")
public class FIleController {
    @Autowired
    private FileServiceImpl fileServiceImpl;
    @PostMapping("//appen/{article_id}")
    public ResponseEntity<?> addWay1(@PathVariable Long article_id, @RequestParam MultipartFile multipartFile){
            FileEntity fileEntity = fileServiceImpl.append(multipartFile,article_id);
//            if (fileEntity){
//                return new ResponseEntity<>(ConstantCommon.SUCCESS,HttpStatus.OK);
//            }

          return new ResponseEntity<>(ConstantCommon.FAIL,HttpStatus.INTERNAL_SERVER_ERROR);
    }
//    @PostMapping("/upload")
//    public ResponseEntity uploadToLocalFileSystem(@RequestParam("file") MultipartFile file) {
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//        String fileBasePath ;
//        Path path = Paths.get(fileBasePath + fileName);
//        try {
//            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/files/download/")
//                .path(fileName)
//                .toUriString();
//        return ResponseEntity.ok(fileDownloadUri);
//    }

}
