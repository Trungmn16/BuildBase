package com.example.buildbase.controller;

import com.example.buildbase.Entity.Category;
import com.example.buildbase.service.CategoryService;
import com.example.buildbase.service.CategoryServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryServiceImpl categoryServiceImpl;

    public CategoryController(CategoryService categoryService, CategoryServiceImpl categoryServiceImpl) {
        this.categoryService = categoryService;
        this.categoryServiceImpl = categoryServiceImpl;
    }

    @PostMapping()
    public @ResponseBody ResponseEntity<String> addCategory(HttpServletRequest req, @RequestBody Category categoryInput){


        return new ResponseEntity<String>("Not completed", HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
