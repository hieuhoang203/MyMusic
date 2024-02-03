package com.example.mymusic.service.impl;

import com.example.mymusic.entity.Image;
import com.example.mymusic.repositories.ImageRepository;
import com.example.mymusic.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ImageService implements IService<Image, Long> {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Image insert(Image obj) {
        this.imageRepository.save(obj);
        return obj;
    }

    @Override
    public Image update(Long aLong, Image obj) {
        this.imageRepository.save(obj);
        return obj;
    }

    @Override
    public Image delete(Long aLong) {
        this.imageRepository.updateStatus(aLong);
        return this.imageRepository.findById(aLong).orElse(null);
    }

    @Override
    public Image detail(Long aLong) {
        return this.imageRepository.findById(aLong).orElse(null);
    }

    @Override
    public Map<Long, Image> select(String status) {
        return this.imageRepository.select(status).stream().collect(Collectors.toMap(Image::getId, Function.identity()));
    }

}
