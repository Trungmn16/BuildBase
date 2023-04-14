package com.example.buildbase.Common.jpt.repository;

import com.example.buildbase.Common.JPTImpl;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.Properties;

@Repository
public class CustomRepositoryImpl<T, ID> implements CustomRepository<T, ID>  {

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
    @Override
    public <S extends T> S save(S entity) {
        try {
            getConnection();
            Field[] fields = entity.getClass().getDeclaredFields();
            String tableName = entity.getClass().getSimpleName();
            StringBuilder columns = new StringBuilder();
            StringBuilder values = new StringBuilder();
            String idColumn = null;
            String idValue = null;
            for (Field field : fields) {
                field.setAccessible(true);
                String columnName = field.getName();
                String columnValue = field.get(entity).toString();
                if ("id".equals(columnName)) {
                    idColumn = columnName;
                    idValue = columnValue;
                }
                columns.append(field.getName()).append(",");
                values.append("'").append(field.get(entity)).append("',");
            }
            columns.setLength(columns.length() - 1);
            values.setLength(values.length() - 1);
            StringBuilder sqlInsertOrUpdate = new StringBuilder();
            if (idColumn != null && idValue != null) {
                String sqlSelect = "SELECT COUNT(*) FROM " + tableName + " WHERE " + idColumn + " = '" + idValue + "'";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sqlSelect);
                rs.next();
                int count = rs.getInt(1);
                if (count > 0) {
                    // Đối tượng đã tồn tại trong cơ sở dữ liệu
                    // Cập nhật thông tin của đối tượng
                    // ...
//                    return;
                }
            }
            sqlInsertOrUpdate.append("INSERT INTO " + tableName + " (" + columns + ") VALUES (" + values + ")");

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(String.valueOf(sqlInsertOrUpdate));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }finally {
            closeConnection();
        }
        return entity;
    }

    @Override
    public Iterable<T> findAll() {
        return null;
    }
}