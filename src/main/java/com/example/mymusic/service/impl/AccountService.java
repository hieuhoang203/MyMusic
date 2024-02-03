package com.example.mymusic.service.impl;

import com.example.mymusic.entity.Account;
import com.example.mymusic.repositories.AccountRepository;
import com.example.mymusic.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class AccountService implements IService<Account, String> {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account insert(Account obj) {
        this.accountRepository.save(obj);
        return obj;
    }

    @Override
    public Account update(String s, Account obj) {
        this.accountRepository.save(obj);
        return obj;
    }

    @Override
    public Account delete(String s) {
        this.accountRepository.updateStatus(s);
        return this.accountRepository.findById(s).orElse(null);
    }

    @Override
    public Account detail(String s) {
        return this.accountRepository.findById(s).orElse(null);
    }

    @Override
    public Map<String, Account> select(String status) {
        return this.accountRepository.select(status).stream().collect(Collectors.toMap(Account::getUser_name, Function.identity()));
    }
}
