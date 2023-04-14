package com.example.filestorage.repository;

import com.example.buildbase.Common.JPT;
import com.example.buildbase.Common.jpt.repository.CustomRepository;
import com.example.filestorage.Entity.FileEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends CustomRepository<FileEntity,Long> {
}
