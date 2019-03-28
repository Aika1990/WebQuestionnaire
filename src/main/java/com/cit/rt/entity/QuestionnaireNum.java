package com.cit.rt.entity;

import javax.persistence.*;

@Entity
@Table(name = "questionnaire_numb")
public class QuestionnaireNum {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_settings_id")
    private AppSettings appSettings;

    public QuestionnaireNum() {
    }

    public QuestionnaireNum(AppSettings appSettings) {
        this.appSettings = appSettings;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AppSettings getAppSettings() {
        return appSettings;
    }

    public void setAppSettings(AppSettings appSettings) {
        this.appSettings = appSettings;
    }

    @Override
    public String toString() {
        return "QuestionnaireNum{" +
                "id=" + id +
                ", appSettings=" + appSettings +
                '}';
    }
}
