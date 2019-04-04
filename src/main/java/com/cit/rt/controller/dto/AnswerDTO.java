package com.cit.rt.controller.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnswerDTO {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("questionId")
    @Expose
    public Integer questionId;

    public AnswerDTO() {
    }

    public AnswerDTO(Integer id, String name, Integer questionId) {
        this.id = id;
        this.name = name;
        this.questionId = questionId;
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

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
}
