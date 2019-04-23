package com.cit.rt.controller.dto;

import java.util.List;

public class QuestionnaireWorkerDTO {

    public String settlementName;
    public String lastName;
    public String firstName;
    public String phoneName;
    public Integer countQnaire;
    public List<QnaireNumWorkerDTO> qnaireNumWorkerDTOs;

    public QuestionnaireWorkerDTO() {
    }

    public QuestionnaireWorkerDTO(String settlementName, String lastName, String firstName, String phoneName, Integer countQnaire, List<QnaireNumWorkerDTO> qnaireNumWorkerDTOs) {
        this.settlementName = settlementName;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneName = phoneName;
        this.countQnaire = countQnaire;
        this.qnaireNumWorkerDTOs = qnaireNumWorkerDTOs;
    }

    public QuestionnaireWorkerDTO(String settlementName, String lastName, String firstName, String phoneName) {
        this.settlementName = settlementName;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneName = phoneName;
    }

    public String getSettlementName() {
        return settlementName;
    }

    public void setSettlementName(String settlementName) {
        this.settlementName = settlementName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public Integer getCountQnaire() {
        return countQnaire;
    }

    public void setCountQnaire(Integer countQnaire) {
        this.countQnaire = countQnaire;
    }

    public List<QnaireNumWorkerDTO> getQnaireNumWorkerDTOs() {
        return qnaireNumWorkerDTOs;
    }

    public void setQnaireNumWorkerDTOs(List<QnaireNumWorkerDTO> qnaireNumWorkerDTOs) {
        this.qnaireNumWorkerDTOs = qnaireNumWorkerDTOs;
    }
}
