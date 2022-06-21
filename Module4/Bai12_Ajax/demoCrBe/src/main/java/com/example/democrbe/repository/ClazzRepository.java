package com.example.democrbe.repository;

import com.example.democrbe.model.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClazzRepository extends JpaRepository<Clazz , Long> {
}
