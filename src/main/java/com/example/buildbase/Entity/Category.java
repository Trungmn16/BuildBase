package com.example.buildbase.Entity;
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
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "createdBy")
    private String createdBy;
    @Column(name = "createdTime")
    private LocalDateTime createdTime;
    @Column(name = "modifiedBy")
    private String modifiedBy;
    @Column(name = "modifiedTime")
    private LocalDateTime modifiedTime;
    @Column(name = "categoryName")
    private String categoryName;
    @Column(name = "manager")
    private String manager;
    @Column(name = "deleted")
    private short deleted;
    @Column(name = "introductionImage")
    private Long introductionImage;
    @Column(name = "avatarImage")
    private Long avatarImage;


}
