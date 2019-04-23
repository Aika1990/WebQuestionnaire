package com.cit.rt.controller.dto;

public class AnswerCountDTO {

    public String idQuestion;
    public String answerName;
    public Integer countAnswer;
    public String percent;

    public AnswerCountDTO() {
    }

    public AnswerCountDTO(String idQuestion, String answerName, Integer countAnswer, String percent) {
        this.idQuestion = idQuestion;
        this.answerName = answerName;
        this.countAnswer = countAnswer;
        this.percent = percent;
    }

    public AnswerCountDTO(String idQuestion, String answerName, Integer countAnswer) {
        this.idQuestion = idQuestion;
        this.answerName = answerName;
        this.countAnswer = countAnswer;
    }

    public String getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(String idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getAnswerName() {
        return answerName;
    }

    public void setAnswerName(String answerName) {
        this.answerName = answerName;
    }

    public Integer getCountAnswer() {
        return countAnswer;
    }

    public void setCountAnswer(Integer countAnswer) {
        this.countAnswer = countAnswer;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }
}
