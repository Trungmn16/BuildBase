package com.example.buildbase.Common;

//import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Map;
//@NoRepositoryBean
public  interface JPT {
     <T> void insert(String tableName, List<String> columns, List<T> values);
     <T> void insert(String tableName, Map<String, Object> map);
     <T> void findPaging(String query, String orderBy, Map<String,Object> map,int limit,int offset);


}
