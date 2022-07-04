package com.example.blog.service;

import com.example.blog.model.Post;

import java.util.Optional;

public interface PostService {
    Iterable<Post> findAll();
    void save(Post post);
    void delete(Long id);
    Iterable<Post> findByNameUser(String name);
    Optional<Post> findById(Long id);
}
