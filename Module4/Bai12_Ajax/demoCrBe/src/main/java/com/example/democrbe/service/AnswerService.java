package com.example.democrbe.service;

import com.example.democrbe.model.Answer;
import com.example.democrbe.model.Question;
import com.example.democrbe.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    public List<Answer> findAllByIdQuestion(Long idQuestion){
        return answerRepository.findAllByIdQuestion(idQuestion);
    }
    public List<Answer> findAll(){
        return answerRepository.findAll();
    }
    public Question findQuestion(Long idQuestion){
        return answerRepository.findQuestionById(idQuestion);
    }

    public Optional<Answer> findById(Long id){
        return answerRepository.findById(id);
    }
}
