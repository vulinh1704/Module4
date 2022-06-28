package com.example.webservice_exercise.repository;

import com.example.webservice_exercise.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<Order , Long> {
}
