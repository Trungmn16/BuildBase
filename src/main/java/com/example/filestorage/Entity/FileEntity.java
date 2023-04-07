package com.example.filestorage.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@Entity
@Table(name = "category")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "size")
    private Long size;
    @Column(name = "link")
    private String link;
    @Column(name = "createdBy")
    private String createdBy;
    @Column(name = "createdTime")
    private LocalDateTime createdTime;
    @Column(name = "modifiedBy")
    private String modifiedBy;
    @Column(name = "modifiedTime")
    private LocalDateTime modifiedTime;
    @Column(name = "article_id")
    private Long article_id;
    @Column(name = "original_name")
    private String original_name;
}
