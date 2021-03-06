package com.cit.rt.service;

import com.cit.rt.entity.AppSettings;
import com.cit.rt.entity.QuestionnaireNum;
import com.cit.rt.exception.ResourceNotFoundException;

import java.util.Date;
import java.util.List;

public interface QuestionnaireNumService {

    public List<QuestionnaireNum> getAllQuestionnaireNums();
    public QuestionnaireNum getQuestionnaireNumById(Integer id) throws ResourceNotFoundException;
    public QuestionnaireNum saveQuestionnaireNum(QuestionnaireNum questionnaireNum);
    public void deleteQuestionnaireNumById(Integer id) throws ResourceNotFoundException;
    void deleteAllQuestionnaireNum();
    List<QuestionnaireNum> getQnaireByAppSettings(Integer appSettingsId);
    QuestionnaireNum getQuestionnaireNumByAppAndDate(Integer appSettingsId, String date);
}
