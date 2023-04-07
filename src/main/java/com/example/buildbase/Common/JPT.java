package com.example.buildbase.Common;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public  interface JPT {
     <T> void insert(String tableName, List<String> columns, List<T> values);
     <T> void insert(String tableName, Map<String, Object> map);
     <T> void findPaging(String query, String orderBy, Map<String,Object> map,int limit,int offset);


}
