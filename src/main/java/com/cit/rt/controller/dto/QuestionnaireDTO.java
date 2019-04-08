package com.cit.rt.controller.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class QuestionnaireDTO implements Serializable {

    @SerializedName("id")
    public Integer id;
    @SerializedName("questionnaireNumId")
    public Integer questionnaireNumId;
    @SerializedName("questionId")
    public Integer questionId;
    @SerializedName("answerId")
    public Integer answerId;
    @SerializedName("descriptionOther")
    public String descriptionOther;

    public QuestionnaireDTO() {
    }

    public QuestionnaireDTO(Integer id, Integer questionnaireNumId, Integer questionId, Integer answerId, String descriptionOther) {
        this.id = id;
        this.questionnaireNumId = questionnaireNumId;
        this.questionId = questionId;
        this.answerId = answerId;
        this.descriptionOther = descriptionOther;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionnaireNumId() {
        return questionnaireNumId;
    }

    public void setQuestionnaireNumId(Integer questionnaireNumId) {
        this.questionnaireNumId = questionnaireNumId;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public String getDescriptionOther() {
        return descriptionOther;
    }

    public void setDescriptionOther(String descriptionOther) {
        this.descriptionOther = descriptionOther;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
}
