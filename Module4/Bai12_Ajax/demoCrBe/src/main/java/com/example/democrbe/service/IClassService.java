package com.example.democrbe.service;

import jdk.nashorn.internal.runtime.options.Option;

import java.util.Optional;

public interface IClassService<Clazz> {
    Iterable<Clazz> findAll();
    Optional<Clazz> findById(Long id);
}
