package com.cit.rt.service;

import com.cit.rt.entity.Questionnaire;
import com.cit.rt.exception.ResourceNotFoundException;

import java.util.List;

public interface QuestionnaireService {

    public List<Questionnaire> getAllQuestionnaires();
    public Questionnaire getQuestionnaireById(Integer id) throws ResourceNotFoundException;
    public void saveQuestionnaire(Questionnaire questionnaire);
    public void deleteQuestionnaireById(Integer id) throws ResourceNotFoundException;
    void deleteAllQuestionnaire();
}
