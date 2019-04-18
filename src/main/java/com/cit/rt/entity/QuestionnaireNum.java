package com.cit.rt.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "questionnaire_numb")
public class QuestionnaireNum implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_settings_id", nullable = false)
    private AppSettings appSettings;

    @Column(name = "create_date")
    private String createDate;

    public QuestionnaireNum() {
    }

    public QuestionnaireNum(AppSettings appSettings, String createDate) {
        this.appSettings = appSettings;
        this.createDate = createDate;
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "QuestionnaireNum{" +
                "id=" + id +
                ", appSettings=" + appSettings +
                '}';
    }
}
