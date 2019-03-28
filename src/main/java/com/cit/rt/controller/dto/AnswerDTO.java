package com.cit.rt.controller.dto;

public class AnswerDTO {

    public Integer id;
    public String name;
    public String question;

    public AnswerDTO() {
    }

    public AnswerDTO(Integer id, String name, String question) {
        this.id = id;
        this.name = name;
        this.question = question;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
