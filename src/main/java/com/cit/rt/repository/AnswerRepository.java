package com.cit.rt.repository;

import com.cit.rt.entity.Answer;
import com.cit.rt.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {

    @Query("select a from Answer a where a.question = :question")
    List<Answer> getAnswersByQuestion(Question question);
}
