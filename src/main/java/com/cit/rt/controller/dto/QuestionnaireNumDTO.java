package com.cit.rt.controller.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class QuestionnaireNumDTO implements Serializable {

    @SerializedName("id")
    public Integer id;
    @SerializedName("appSettingsId")
    public Integer appSettingsId;

    public QuestionnaireNumDTO() {
    }

    public QuestionnaireNumDTO(Integer id, Integer appSettingsId) {
        this.id = id;
        this.appSettingsId = appSettingsId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAppSettingsId() {
        return appSettingsId;
    }

    public void setAppSettingsId(Integer appSettingsId) {
        this.appSettingsId = appSettingsId;
    }
}
