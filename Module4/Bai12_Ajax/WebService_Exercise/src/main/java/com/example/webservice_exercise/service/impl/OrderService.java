package com.example.webservice_exercise.service.impl;

import com.example.webservice_exercise.model.Order;
import com.example.webservice_exercise.repository.IOrderRepository;
import com.example.webservice_exercise.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository iOrderRepository;
    @Override
    public void save(Order order) {
       iOrderRepository.save(order);
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return iOrderRepository.findAll(pageable);
    }

    @Override
    public Optional<Order> findById(Long id) {
        return iOrderRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iOrderRepository.deleteById(id);
    }

    @Override
    public Page<Order> findAllByNameContaining(Pageable pageable, String name) {
        return null;
    }
}
