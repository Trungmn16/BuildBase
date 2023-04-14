package com.example.buildbase.Common;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class JPTImpl implements JPT {
    private static Connection conn;

    /**
     * Open connection
     */
    public void getConnection() {
        Properties prop = new Properties();
        try (InputStream input = JPTImpl.class.getClassLoader().getResourceAsStream("application.properties")) {
            prop.load(input);
            String url = prop.getProperty("spring.datasource.url");
            String username = prop.getProperty("spring.datasource.username");
            String password = prop.getProperty("spring.datasource.password");
            conn = DriverManager.getConnection(url, username, password);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * close connection
     */
    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * insert by List
     * @param tableName
     * @param columns
     * @param values
     * @param <T>
     */
    @Override
    public <T> void insert(String tableName, List<String> columns, List<T> values) {

        String sql = "INSERT INTO " + tableName + " (";
        //To browse the columns
        for (int i = 0; i < columns.size(); i++) {
            sql += columns.get(i);
            if (i < columns.size() - 1) {
                sql += ", ";
            }
        }
        //set value for columns
        sql += ") VALUES (";
        for (int i = 0; i < values.size(); i++) {
            sql += "?";
            if (i < values.size() - 1) {
                sql += ", ";
            }
        }
        sql += ")";

        // initialization PreparedStatement object set param and execute
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < values.size(); i++) {
                pstmt.setObject(i + 1, values.get(i));
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            closeConnection();
        }

    }

    /**
     * insert by Map
     *
     * @param tableName
     * @param map
     * @param <T>
     */
    public <T> void insert(String tableName, Map<String, Object> map) {
        getConnection();
        String sql = "INSERT INTO " + tableName + " (";
        // create Set Object to browse the columns
        Set<String> keys = map.keySet();
        int count = 0;
        for (String key : keys) {
            sql += key;
            count++;
            if (count < map.size()) {
                sql += ", ";
            }
        }
        // set value for each column
        sql += ") VALUES (";
        for (int i = 0; i < map.size(); i++) {
            sql += "?";
            if (i < map.size() - 1) {
                sql += ", ";
            }
        }
        sql += ")";
        // initialization PreparedStatement object set param and execute
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            int i = 0;
            for (String key : keys) {
                pstmt.setObject(i + 1, map.get(key));
                i++;
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public <T> void findPaging(String query, String orderBy, Map<String, Object> map, int limit, int offset) {

    }
    public void save(Object obj){
        try {
            getConnection();
            Field[] fields = obj.getClass().getDeclaredFields();
            String tableName = obj.getClass().getSimpleName();
            StringBuilder columns = new StringBuilder();
            StringBuilder values = new StringBuilder();
            for (Field field : fields) {
                field.setAccessible(true);
                columns.append(field.getName()).append(",");
                values.append("'").append(field.get(obj)).append("',");
            }
            columns.setLength(columns.length() - 1);
            values.setLength(values.length() - 1);
            String sql = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + values + ")";

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

}
