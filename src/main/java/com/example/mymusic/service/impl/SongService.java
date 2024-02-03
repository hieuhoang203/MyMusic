package com.example.mymusic.service.impl;

import com.example.mymusic.entity.Song;
import com.example.mymusic.repositories.SongRepository;
import com.example.mymusic.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class SongService implements IService<Song, Long> {

    @Autowired
    private SongRepository songRepository;

    @Override
    public Song insert(Song obj) {
        this.songRepository.save(obj);
        return obj;
    }

    @Override
    public Song update(Long aLong, Song obj) {
        this.songRepository.save(obj);
        return obj;
    }

    @Override
    public Song delete(Long aLong) {
        this.songRepository.updateStatus(aLong);
        return this.songRepository.findById(aLong).orElse(null);
    }

    @Override
    public Song detail(Long aLong) {
        return this.songRepository.findById(aLong).orElse(null);
    }

    @Override
    public Map<Long, Song> select(String status) {
        return this.songRepository.select(status).stream().collect(Collectors.toMap(Song::getId, Function.identity()));
    }

}
