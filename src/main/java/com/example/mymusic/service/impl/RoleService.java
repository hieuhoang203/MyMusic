package com.example.mymusic.service.impl;

import com.example.mymusic.entity.Role;
import com.example.mymusic.repositories.RoleRepository;
import com.example.mymusic.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class RoleService implements IService <Role, Byte> {

    @Autowired
    private RoleRepository repository;

    @Override
    public Role insert(Role obj) {
        this.repository.save(obj);
        return obj;
    }

    @Override
    public Role update(Byte aByte, Role obj) {
        this.repository.save(obj);
        return obj;
    }

    @Override
    public Role delete(Byte aByte) {
        this.repository.updateStatus(aByte);
        return this.repository.findById(aByte).orElse(null);
    }

    @Override
    public Role detail(Byte aByte) {
        return this.repository.findById(aByte).orElse(null);
    }

    @Override
    public Map<Byte, Role> select(String status) {
        Map<Byte, Role> roleMap;
        roleMap = this.repository.select(status).stream().collect(Collectors.toMap(Role::getId, Function.identity()));
        return roleMap;
    }

}
