package com.cit.rt.service;

import com.cit.rt.entity.Questionnaire;
import com.cit.rt.exception.ResourceNotFoundException;
import com.cit.rt.repository.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService{

    @Autowired
    QuestionnaireRepository questionnaireRepository;

    @Override
    @Transactional
    public List<Questionnaire> getAllQuestionnaires() {
        return questionnaireRepository.findAll();
    }

    @Override
    @Transactional
    public Questionnaire getQuestionnaireById(Integer id) throws ResourceNotFoundException {
        return questionnaireRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public void saveQuestionnaire(Questionnaire questionnaire) {
        questionnaireRepository.save(questionnaire);
    }

    @Override
    @Transactional
    public void deleteQuestionnaireById(Integer id) {
        questionnaireRepository.deleteById(id);
    }
}
