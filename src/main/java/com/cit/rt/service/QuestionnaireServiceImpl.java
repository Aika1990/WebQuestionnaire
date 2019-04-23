package com.cit.rt.service;

import com.cit.rt.entity.Answer;
import com.cit.rt.entity.Question;
import com.cit.rt.entity.Questionnaire;
import com.cit.rt.entity.QuestionnaireNum;
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
        questionnaireRepository.saveAndFlush(questionnaire);
    }

    @Override
    @Transactional
    public void deleteQuestionnaireById(Integer id) {
        questionnaireRepository.deleteById(id);
    }

    @Override
    public void deleteAllQuestionnaire() {
        questionnaireRepository.deleteAll();
    }

    @Override
    public List<Questionnaire> getQuestionnareByQnaireNum(QuestionnaireNum id) {
        return questionnaireRepository.getQuestionnareByQnaireNum(id);
    }

    @Override
    public List<Questionnaire> getQuestionnaireByQuestionId(Question question) {
        return questionnaireRepository.getQuestionnaireByQuestionId(question);
    }

    @Override
    public List<Questionnaire> getQuestionnaireByAnswerId(Answer answer) {
        return questionnaireRepository.getQuestionnaireByAnswerId(answer);
    }

    @Override
    public List<Questionnaire> getQuestionnaireByDescription(String settlementId) {
        return questionnaireRepository.getQuestionnaireByDescription(settlementId);
    }
}
