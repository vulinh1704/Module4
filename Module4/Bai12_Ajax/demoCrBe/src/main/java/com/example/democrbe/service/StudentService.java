package com.example.democrbe.service;

import com.example.democrbe.model.Clazz;
import com.example.democrbe.model.Student;
import com.example.democrbe.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService implements IStudentService{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Page<Student> findAllByNameContaining(Pageable pageable, String name) {
        return studentRepository.findAllByNameContaining(pageable , name);
    }

    @Override
    public Page<Student> findAllByScoreGreaterThan8(Pageable pageable, Double score) {
        return studentRepository.findAllByScoreGreaterThan(pageable , score);
    }

    @Override
    public Iterable<Clazz> findAllByClazzId(Long id) {
        return studentRepository.findAllByClazzId(id);
    }

    @Override
    public Iterable<Student> findAllScoreBetween(Double from, Double to) {
        return studentRepository.findAllByScoreBetween(from , to);
    }
}
