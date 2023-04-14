package com.example;

import javax.imageio.ImageIO;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test1 {
    public static void main(String[] args) {
        StringBuilder builder= new StringBuilder();
        builder.append("a");
//        String s="@echo off\n";

        byte[] imageData = String.valueOf(builder).getBytes(); // Mảng byte chứa dữ liệu ảnh
        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(imageData)) {
            if (ImageIO.read(inputStream) != null) {
                System.out.println("The byte array is a valid image.");
            } else {
                System.out.println("The byte array is not a valid image.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }
}
