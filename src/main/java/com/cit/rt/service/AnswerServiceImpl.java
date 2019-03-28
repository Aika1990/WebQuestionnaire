package com.cit.rt.service;

import com.cit.rt.entity.Answer;
import com.cit.rt.exception.ResourceNotFoundException;
import com.cit.rt.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService{

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    @Transactional
    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }

    @Override
    @Transactional
    public Answer getAnswerById(Integer id) throws ResourceNotFoundException {
        return answerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public void saveAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    @Override
    @Transactional
    public void deleteAnswerById(Integer id) {
        answerRepository.deleteById(id);
    }
}
