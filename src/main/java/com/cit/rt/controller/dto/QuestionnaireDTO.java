package com.cit.rt.controller.dto;

public class QuestionnaireDTO {

    public Integer id;
    public String questionnaireNum;
    public String answer;
    public String descriptionOther;
    public String idParentAnswer;

    public QuestionnaireDTO() {
    }

    public QuestionnaireDTO(Integer id, String questionnaireNum, String answer, String descriptionOther, String idParentAnswer) {
        this.id = id;
        this.questionnaireNum = questionnaireNum;
        this.answer = answer;
        this.descriptionOther = descriptionOther;
        this.idParentAnswer = idParentAnswer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionnaireNum() {
        return questionnaireNum;
    }

    public void setQuestionnaireNum(String questionnaireNum) {
        this.questionnaireNum = questionnaireNum;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDescriptionOther() {
        return descriptionOther;
    }

    public void setDescriptionOther(String descriptionOther) {
        this.descriptionOther = descriptionOther;
    }

    public String getIdParentAnswer() {
        return idParentAnswer;
    }

    public void setIdParentAnswer(String idParentAnswer) {
        this.idParentAnswer = idParentAnswer;
    }
}
