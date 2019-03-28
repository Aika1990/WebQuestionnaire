package com.cit.rt.controller.dto;

public class QuestionDTO {

    public Integer id;
    public String name;
    public String typeQuestion;

    public QuestionDTO() {
    }

    public QuestionDTO(Integer id, String name, String typeQuestion) {
        this.id = id;
        this.name = name;
        this.typeQuestion = typeQuestion;
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

    public String getTypeQuestion() {
        return typeQuestion;
    }

    public void setTypeQuestion(String typeQuestion) {
        this.typeQuestion = typeQuestion;
    }
}
