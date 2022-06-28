package com.example.webservice_exercise.service.impl;

import com.example.webservice_exercise.model.Product;
import com.example.webservice_exercise.repository.IProductRepository;
import com.example.webservice_exercise.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;
    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> findAllByNameContaining(Pageable pageable, String name) {
        return null;
    }
}
