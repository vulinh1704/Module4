package com.example.democrbe.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IService<T> {
    void save(T t);
    Page<T> findAll(Pageable pageable);
    Optional<T> findById(Long id);
    void remove(Long id);
    Page<T> findAllByNameContaining(Pageable pageable, String name);
}
