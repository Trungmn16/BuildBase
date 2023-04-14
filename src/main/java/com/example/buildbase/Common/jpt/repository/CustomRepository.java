package com.example.buildbase.Common.jpt.repository;

public interface CustomRepository<T, ID>  {
    <S extends T> S save(S entity);
    Iterable<T> findAll();

}
