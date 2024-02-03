package com.example.mymusic.controller.impl;

import com.example.mymusic.controller.IController;
import com.example.mymusic.entity.Role;
import com.example.mymusic.entity.commonProperties.Status;
import com.example.mymusic.service.impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/role")
public class RoleController implements IController<Role, Byte> {

    @Autowired
    private RoleService roleService;

    @Override
    @GetMapping(value = "/{status}")
    public Map<Byte, Role> select(@PathVariable String status) {
        return this.roleService.select(status);
    }

    @Override
    @PostMapping(value = "/save")
    public Role insert(@RequestBody Role object) {
        return this.roleService.insert(object);
    }

    @Override
    @PutMapping(value = "/update/{aByte}")
    public Role update(@PathVariable Byte aByte, @RequestBody Role object) {
        return this.roleService.update(aByte, object);
    }

    @Override
    @DeleteMapping(value = "/delete/{aByte}")
    public Role delete(@PathVariable Byte aByte) {
        return this.roleService.delete(aByte);
    }

    @Override
    @GetMapping(value = "/search/{aByte}")
    public Role search(@PathVariable Byte aByte) {
        return this.roleService.detail(aByte);
    }

}
