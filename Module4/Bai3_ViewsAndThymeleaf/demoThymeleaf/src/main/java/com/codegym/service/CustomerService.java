package com.codegym.service;

import com.codegym.model.Customer;

import java.util.*;

public class CustomerService implements ICustomerService {
    private static final Map<Integer, Customer> customers;

    static {

        customers = new HashMap<>();
        customers.put(1, new Customer(1L, "John"));
        customers.put(2, new Customer(2L, "Bill"));
        customers.put(3, new Customer(3L, "Alex"));
        customers.put(4, new Customer(4L, "Adam"));
        customers.put(5, new Customer(5L, "Sophia"));
        customers.put(6, new Customer(6L, "Rose"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer customer) {
        customers.put(Math.toIntExact(customer.getId()), customer);
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customers.put(id, customer);

    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> customerList = new ArrayList<>();
        Set<Integer> keySet = customers.keySet();
        for (Integer key : keySet) {
            if (customers.get(key).getName().contains(name)){
                customerList.add(customers.get(key));
            }
        }
        return customerList;
    }
}