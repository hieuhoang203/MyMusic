package com.example.mymusic.controller.impl;

import com.example.mymusic.controller.IController;
import com.example.mymusic.entity.Image;
import com.example.mymusic.service.impl.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/image")
public class ImageController implements IController<Image, Long> {
    
    @Autowired
    private ImageService imageService;
    
    @Override
    @GetMapping(value = "")
    public Map<Long, Image> select(@RequestParam(value = "status", defaultValue = "DANG_HOAT_DONG", required = false) String status) {
        return this.imageService.select(status);
    }

    @Override
    @PostMapping(value = "/save")
    public Image insert(@RequestBody Image image) {
        return this.imageService.insert(image);
    }

    @Override
    @PutMapping(value = "/update/{id}")
    public Image update(@PathVariable Long id, @RequestBody Image image) {
        return this.imageService.update(id, image);
    }

    @Override
    @DeleteMapping(value = "/delete/{id}")
    public Image delete(@PathVariable Long id) {
        return this.imageService.delete(id);
    }

    @Override
    @GetMapping(value = "/search/{id}")
    public Image search(@PathVariable Long id) {
        return this.imageService.delete(id);
    }
    
}
