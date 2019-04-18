package com.cit.rt.controller.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class QuestionnaireNumDTO implements Serializable {

    @SerializedName("id")
    public Integer id;
    @SerializedName("appSettingsId")
    public Integer appSettingsId;
    @SerializedName("createDate")
    public String createDate;

    public QuestionnaireNumDTO() {
    }

    public QuestionnaireNumDTO(Integer id, Integer appSettingsId, String createDate) {
        this.id = id;
        this.appSettingsId = appSettingsId;
        this.createDate = createDate;
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

    public String getDateNum() {
        return createDate;
    }

    public void setDateNum(String createDate) {
        this.createDate = createDate;
    }
}
