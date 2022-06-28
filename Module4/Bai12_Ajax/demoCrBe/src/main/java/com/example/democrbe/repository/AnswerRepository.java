package com.example.democrbe.repository;

import com.example.democrbe.model.Answer;
import com.example.democrbe.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    @Query(value = "select * from answers where id_question = :idQuestion and status = 1", nativeQuery = true)
    List<Answer> findAllByIdQuestion(@Param("idQuestion") Long idQuestion);

    @Query(value = "select id_question from answers where id_question = idQuestion group by id_question" , nativeQuery = true)
    Question findQuestionById(@Param("idQuestion") Long idQuestion);

}
