package com.cit.rt.controller.dto;

public class QuestionnaireNumDTO {

    public Integer id;
    public String appSettings;

    public QuestionnaireNumDTO() {
    }

    public QuestionnaireNumDTO(Integer id, String appSettings) {
        this.id = id;
        this.appSettings = appSettings;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppSettings() {
        return appSettings;
    }

    public void setAppSettings(String appSettings) {
        this.appSettings = appSettings;
    }
}
