package com.example.filestorage.controller;


import com.example.filestorage.constant.ConstantCommon;
import com.example.filestorage.service.FileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/file")
public class FIleController {
    @Autowired
    private FileServiceImpl fileServiceImpl;
    @PostMapping("/{fileType}/append/{secret}")
    public ResponseEntity<?> add(@PathVariable Long fileType, @RequestParam MultipartFile multipartFile){
            String success = fileServiceImpl.append(multipartFile);
            if (success.equals(ConstantCommon.SUCCESS)){
                return new ResponseEntity<>(ConstantCommon.SUCCESS,HttpStatus.OK);
            }

          return new ResponseEntity<>(ConstantCommon.FAIL,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
