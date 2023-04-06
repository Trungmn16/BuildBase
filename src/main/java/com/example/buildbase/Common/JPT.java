package com.example.buildbase.Common;

import java.util.List;
public  interface JPT {
     <T> void insert(String tableName, List<String> columns, List<T> values);


}
