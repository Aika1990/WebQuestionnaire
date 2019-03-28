package com.cit.rt.service;

import com.cit.rt.entity.Question;
import com.cit.rt.exception.ResourceNotFoundException;
import com.cit.rt.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Override
    @Transactional
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    @Transactional
    public Question getQuestionById(Integer id) throws ResourceNotFoundException {
        return questionRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public void saveQuestion(Question question) {
        questionRepository.save(question);
    }

    @Override
    @Transactional
    public void deleteQuestionById(Integer id) {
        questionRepository.deleteById(id);
    }
}
