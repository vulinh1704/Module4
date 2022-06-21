package com.example.democrbe.service;

import java.util.Optional;

public interface ICategoryService<Category> {
    Iterable<Category> findAll();
    Optional<Category> findById(Long id);
}
