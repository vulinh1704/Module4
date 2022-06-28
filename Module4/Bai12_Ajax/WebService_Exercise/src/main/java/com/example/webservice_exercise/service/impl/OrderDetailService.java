package com.example.webservice_exercise.service.impl;

import com.example.webservice_exercise.model.OrderDetail;
import com.example.webservice_exercise.repository.IOrderDetailRepository;
import com.example.webservice_exercise.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderDetailService implements IOrderDetailService {
    @Autowired
    private IOrderDetailRepository orderDetailRepository;

    @Override
    public void save(OrderDetail orderDetail) {
       orderDetailRepository.save(orderDetail);
    }

    @Override
    public Page<OrderDetail> findAll(Pageable pageable) {
        return orderDetailRepository.findAll(pageable);
    }

    @Override
    public Optional<OrderDetail> findById(Long id) {
        return orderDetailRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        orderDetailRepository.deleteById(id);
    }

    @Override
    public Page<OrderDetail> findAllByNameContaining(Pageable pageable, String name) {
        return null;
    }
}
