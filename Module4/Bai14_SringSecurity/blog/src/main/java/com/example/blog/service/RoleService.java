package com.example.blog.service;


import com.example.blog.model.Role;

public interface RoleService {
    Iterable<Role> findAll();


    void save(Role role);

    Role findByName(String name);
}
