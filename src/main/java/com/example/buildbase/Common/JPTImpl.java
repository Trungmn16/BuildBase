package com.example.buildbase.Common;

import com.example.buildbase.Entity.Category;
import lombok.Value;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;

public class JPTImpl implements JPT{
    private static Connection conn;
    public static void getConnection(){
        Properties prop = new Properties();
        try (InputStream input = JPTImpl.class.getClassLoader().getResourceAsStream("application.properties")){
            prop.load(input);
            String url = prop.getProperty("spring.datasource.url");
            String username = prop.getProperty("spring.datasource.username");
            String password = prop.getProperty("spring.datasource.password");
             conn = DriverManager.getConnection(url,username,password);
            // Sử dụng url, username và password để kết nối cơ sở dữ liệu
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void closeConnection(){
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public <T> void insert(String tableName, List<String> columns, List<T> values) {

        String sql = "INSERT INTO " + tableName + " (";
        for (int i = 0; i < columns.size(); i++) {
            sql += columns.get(i);
            if (i < columns.size() - 1) {
                sql += ", ";
            }
        }
        sql += ") VALUES (";
        for (int i = 0; i < values.size(); i++) {
            sql += "?";
            if (i < values.size() - 1) {
                sql += ", ";
            }
        }
        sql += ")";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
                for (int i = 0; i < values.size(); i++) {
                    pstmt.setObject(i + 1, values.get(i));
                }
                pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

//    public <T> void insert(String tableName, List<String> columns, List<T> values) {
    public static <T> void insert(String tableName, Map<String, Object> map) {


        getConnection();
        String sql = "INSERT INTO " + tableName + " (";
        Set<String> keys = map.keySet();
        int count=0;
        for (String key : keys) {
            sql += key;
            count++;
            if (count<map.size()){
                sql += ", ";
            }
        }

        sql += ") VALUES (";
        for (int i = 0; i < map.size(); i++) {
            sql += "?";
            if (i < map.size() - 1) {
                sql += ", ";
            }
        }
        sql += ")";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
//            for (int i = 0; i < map.size(); i++) {
//                pstmt.setObject(i + 1, map.get(map.keySet()));
//            }
            int i =0;
            for (String key : keys) {
                pstmt.setObject(i + 1, map.get(key));
                i++;
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            closeConnection();
        }
    }
    public static void main(String[] args) {
        Category category = new Category(0L,"maitrungmnt01",LocalDateTime.now(),"maitrungmnt01",LocalDateTime.now(),"hub","maitrungmnt01", (short) 1,1L,240L);
        Map<String, Object> map = new HashMap<>();
//        map.put("id", String.valueOf(1L));
        map.put("createdBy",category.getCreatedBy());
        map.put("createdTime", category.getCreatedTime());
        map.put("modifiedBy",category.getModifiedBy());
        map.put("modifiedTime", category.getModifiedTime());
        map.put("categoryName", category.getCategoryName());
        map.put("manager", category.getManager());
        map.put("deleted", category.getDeleted());
        map.put("introductionImage", category.getIntroductionImage());
        map.put("avatarImage", category.getAvatarImage());
        insert("category",map);
//        System.out.println(map.keySet());

    }
}
