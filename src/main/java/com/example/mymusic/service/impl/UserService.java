package com.example.mymusic.service.impl;

import com.example.mymusic.entity.User;
import com.example.mymusic.repositories.UserRepository;
import com.example.mymusic.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UserService implements IService<User, Long> {

    @Autowired
    private UserRepository repository;

    @Override
    public User insert(User obj) {
        return this.repository.save(obj);
    }

    @Override
    public User update(Long aLong, User obj) {
        return this.repository.save(obj);
    }

    @Override
    public User delete(Long aLong) {
        this.repository.updateStatus(aLong);
        return this.repository.findById(aLong).orElse(null);
    }

    @Override
    public User detail(Long aLong) {
        return this.repository.findById(aLong).orElse(null);
    }

    @Override
    public Map<Long, User> select(String status) {
        Map<Long, User> userMap = new HashMap<>();
        this.repository.select(status).stream().collect(Collectors.toMap(User::getId, Function.identity()));
        return userMap;
    }

}
