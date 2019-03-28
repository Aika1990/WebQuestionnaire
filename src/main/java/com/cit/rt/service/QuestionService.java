package com.cit.rt.service;

import com.cit.rt.entity.Question;
import com.cit.rt.exception.ResourceNotFoundException;

import java.util.List;

public interface QuestionService {

    public List<Question> getAllQuestions();
    public Question getQuestionById(Integer id) throws ResourceNotFoundException;
    public void saveQuestion(Question question);
    public void deleteQuestionById(Integer id) throws ResourceNotFoundException;
}
