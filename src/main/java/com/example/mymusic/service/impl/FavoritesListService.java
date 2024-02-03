package com.example.mymusic.service.impl;

import com.example.mymusic.entity.FavoritesList;
import com.example.mymusic.repositories.FavoritesListRepository;
import com.example.mymusic.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class FavoritesListService implements IService<FavoritesList, Long> {

    @Autowired
    private FavoritesListRepository favoritesListRepository;

    @Override
    public FavoritesList insert(FavoritesList favorites) {
        this.favoritesListRepository.save(favorites);
        return favorites;
    }

    @Override
    public FavoritesList update(Long id, FavoritesList favorites) {
        this.favoritesListRepository.save(favorites);
        return favorites;
    }

    @Override
    public FavoritesList delete(Long id) {
        this.favoritesListRepository.updateStatus(id);
        return this.favoritesListRepository.findById(id).orElse(null);
    }

    @Override
    public FavoritesList detail(Long id) {
        return this.favoritesListRepository.findById(id).orElse(null);
    }

    @Override
    public Map<Long, FavoritesList> select(String status) {
        return this.favoritesListRepository.select(status).stream().collect(Collectors.toMap(FavoritesList::getId, Function.identity()));
    }

}
