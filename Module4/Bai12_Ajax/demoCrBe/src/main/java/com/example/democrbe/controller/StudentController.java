package com.example.democrbe.controller;

import com.example.democrbe.model.Student;
import com.example.democrbe.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<Iterable> findAll(@PageableDefault(value = 2) Pageable pageable) {
        return new ResponseEntity<>(studentService.findAll(pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Student student) {
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
