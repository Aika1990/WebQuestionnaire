package com.cit.rt.controller.dto;

public class QuestionnaireStrDTO {

    public String questionName;
    public String answerName;

    public QuestionnaireStrDTO() {
    }

    public QuestionnaireStrDTO(String questionName, String answerName, String descriptionOther) {
        this.questionName = questionName;
        this.answerName = answerName;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getAnswerName() {
        return answerName;
    }

    public void setAnswerName(String answerName) {
        this.answerName = answerName;
    }
}
