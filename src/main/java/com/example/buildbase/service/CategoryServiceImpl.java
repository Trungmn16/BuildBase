package com.example.buildbase.service;

import com.example.buildbase.Entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{


    @Override
    public boolean insertOrUpdateCategory(Category category) {
        return false;
    }

    @Override
    public boolean deleteCategory(Category category) {
        return false;
    }

    @Override
    public Category getDetailCategory(Category category) {
        return null;
    }

    @Override
    public List<Category> searchCategory(Category category) {
        return null;
    }

    @Override
    public List<Category> getByFilterCategory(Category category) {
        return null;
    }
}
