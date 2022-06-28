package com.example.democrbe.controller;

import com.example.democrbe.model.Answer;
import com.example.democrbe.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/answer")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @GetMapping
    public ResponseEntity<List<Answer>> findAll() {
        return new ResponseEntity<>(answerService.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Integer> findQues(@RequestBody Long[] listIdQuestion) {
        int score = 0;
        List<Answer> answerList = null;
        for (Long i : listIdQuestion) {
            if(answerService.findById(i).isPresent()) {
                answerList.add(answerService.findById(i).get());
                score = score + 1;
            }
        }
        return new ResponseEntity<>(score, HttpStatus.OK);
    }
}
