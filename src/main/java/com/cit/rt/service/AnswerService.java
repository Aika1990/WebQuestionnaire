package com.cit.rt.service;

import com.cit.rt.entity.Answer;
import com.cit.rt.entity.Question;
import com.cit.rt.exception.ResourceNotFoundException;

import java.util.List;

public interface AnswerService {

    public List<Answer> getAllAnswers();
    public void saveAnswer(Answer answer);
    Answer answersave(Answer answer);
    public Answer getAnswerById(Integer id) throws ResourceNotFoundException;
    public void deleteAnswerById(Integer id) throws ResourceNotFoundException;

    List<Answer> getAnswersByQuestion(Question question);
}
