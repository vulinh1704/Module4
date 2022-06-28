package com.example.webservice_exercise.service.impl;

import com.example.webservice_exercise.model.Customer;
import com.example.webservice_exercise.repository.ICustomerRepository;
import com.example.webservice_exercise.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public void save(Customer customer) {
       customerRepository.save(customer);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findAllByNameContaining(Pageable pageable, String name) {
        return null;
    }
}
