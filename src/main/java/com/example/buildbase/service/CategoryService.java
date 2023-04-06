package com.example.buildbase.service;

import com.example.buildbase.Entity.Category;
import org.springframework.stereotype.Component;

import java.util.List;
public interface CategoryService {
    public boolean insertOrUpdateCategory(Category category);
    public boolean deleteCategory(Category category);
    public Category getDetailCategory(Category category);
    public List<Category> searchCategory(Category category);
    public List<Category> getByFilterCategory(Category category);
}
