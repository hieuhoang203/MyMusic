package com.example.mymusic.service.impl;

import com.example.mymusic.entity.Album;
import com.example.mymusic.repositories.AlbumRepository;
import com.example.mymusic.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class AlbumService implements IService<Album, Long> {

    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public Album insert(Album obj) {
        this.albumRepository.save(obj);
        return obj;
    }

    @Override
    public Album update(Long aLong, Album obj) {
        this.albumRepository.save(obj);
        return obj;
    }

    @Override
    public Album delete(Long aLong) {
        this.albumRepository.updateStatus(aLong);
        return this.albumRepository.findById(aLong).orElse(null);
    }

    @Override
    public Album detail(Long aLong) {
        return this.albumRepository.findById(aLong).orElse(null);
    }

    @Override
    public Map<Long, Album> select(String status) {
        return this.albumRepository.select(status).stream().collect(Collectors.toMap(Album::getId, Function.identity()));
    }

}
