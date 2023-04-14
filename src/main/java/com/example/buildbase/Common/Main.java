package com.example.buildbase.Common;

import com.example.buildbase.Entity.Category;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Category category = new Category(null,"maitrungmnt01", LocalDateTime.now(), "maitrungmnt01", LocalDateTime.now(), "hub", "maitrungmnt01", (short) 1, 1L, 240L);
        JPTImpl jpt= new JPTImpl();
        Map<String, Object> map = new HashMap<>();
//        map.put("id", String.valueOf(1L));
        map.put("createdBy", category.getCreatedBy());
        map.put("createdTime", category.getCreatedTime());
        map.put("modifiedBy", category.getModifiedBy());
        map.put("modifiedTime", category.getModifiedTime());
        map.put("categoryName", category.getCategoryName());
        map.put("manager", category.getManager());
        map.put("deleted", category.getDeleted());
        map.put("introductionImage", category.getIntroductionImage());
        map.put("avatarImage", category.getAvatarImage());
//        jpt.insert("category", map);
        jpt.save(category);
    }


}
