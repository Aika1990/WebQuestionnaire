package com.cit.rt.service;

import com.cit.rt.entity.AppSettings;
import com.cit.rt.entity.QuestionnaireNum;
import com.cit.rt.exception.ResourceNotFoundException;
import com.cit.rt.repository.QuestionnaireNumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class QuestionnaireNumServiceImpl implements QuestionnaireNumService {

    @Autowired
    QuestionnaireNumRepository questionnaireNumRepository;

    @Override
    @Transactional
    public List<QuestionnaireNum> getAllQuestionnaireNums() {
        return questionnaireNumRepository.findAll();
    }

    @Override
    @Transactional
    public QuestionnaireNum getQuestionnaireNumById(Integer id) throws ResourceNotFoundException {
        return questionnaireNumRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public QuestionnaireNum saveQuestionnaireNum(QuestionnaireNum questionnaireNum) {
        questionnaireNumRepository.saveAndFlush(questionnaireNum);
        return questionnaireNum;
    }

    @Override
    @Transactional
    public void deleteQuestionnaireNumById(Integer id) {
        questionnaireNumRepository.deleteById(id);
    }

    @Override
    public void deleteAllQuestionnaireNum() {
        questionnaireNumRepository.deleteAll();
    }

    @Override
    public List<QuestionnaireNum> getQnaireByAppSettings(Integer appSettingsId) {
        return questionnaireNumRepository.getQnaireByAppSettings(appSettingsId);
    }

    @Override
    public QuestionnaireNum getQuestionnaireNumByAppAndDate(Integer appSettingsId, String date) {
        return questionnaireNumRepository.getQuestionnaireNumByAppAndDate(appSettingsId, date);
    }
}
