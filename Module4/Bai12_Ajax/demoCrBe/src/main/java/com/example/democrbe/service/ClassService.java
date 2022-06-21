package com.example.democrbe.service;

import com.example.democrbe.repository.ClazzRepository;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassService implements IClassService{
    @Autowired
    private ClazzRepository clazzRepository;
    @Override
    public Iterable findAll() {
        return clazzRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return clazzRepository.findById(id);
    }
}
