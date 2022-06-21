package com.example.democrbe.service;

import com.example.democrbe.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Iterable findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return categoryRepository.findById(id);
    }
}
