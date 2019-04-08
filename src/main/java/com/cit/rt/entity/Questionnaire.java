package com.cit.rt.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "questionnaire")
public class Questionnaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "questionnaire_num_id", nullable = false)
    private QuestionnaireNum questionnaireNum;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer_id")
    private Answer answer;
    @Column(name = "description_other")
    private String descriptionOther;

    public Questionnaire() {
    }

    public Questionnaire(QuestionnaireNum questionnaireNum, Question question, Answer answer, String descriptionOther) {
        this.questionnaireNum = questionnaireNum;
        this.question = question;
        this.answer = answer;
        this.descriptionOther = descriptionOther;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public QuestionnaireNum getQuestionnaireNum() {
        return questionnaireNum;
    }

    public void setQuestionnaireNum(QuestionnaireNum questionnaireNum) {
        this.questionnaireNum = questionnaireNum;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public String getDescriptionOther() {
        return descriptionOther;
    }

    public void setDescriptionOther(String descriptionOther) {
        this.descriptionOther = descriptionOther;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Questionnaire{" +
                "id=" + id +
                ", questionnaireNum=" + questionnaireNum +
                ", answer=" + answer +
                ", descriptionOther='" + descriptionOther + '\'' +
                '}';
    }
}

