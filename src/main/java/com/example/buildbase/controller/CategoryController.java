package com.example.buildbase.controller;

import com.example.buildbase.Entity.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/test")
public class TestController {
    @PostMapping("/insert")
    public @ResponseBody ResponseEntity<String> addCategory(HttpServletRequest req, @RequestBody Category categoryInput){


        return new ResponseEntity<String>("Not completed", HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
