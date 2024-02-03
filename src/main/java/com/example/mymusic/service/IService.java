package com.example.mymusic.service;

import com.example.mymusic.entity.commonProperties.Status;

import java.util.Map;
import java.util.Set;

public interface IService <T, ID> {

    T insert(T obj);

    T update(ID id, T obj);

    T delete(ID id);

    T detail(ID id);

    Map<ID, T> select(String status);

}
