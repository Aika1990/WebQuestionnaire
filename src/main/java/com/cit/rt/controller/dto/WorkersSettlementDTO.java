package com.cit.rt.controller.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WorkersSettlementDTO implements Serializable {

    @SerializedName("id")
    public Integer id;

    @SerializedName("nameSettlement")
    public String nameSettlement;

    @SerializedName("qnaireNum")
    public Integer qnaireNum;

    @SerializedName("workers")
    public List<WorkerDTO> workerDTOs;

    public WorkersSettlementDTO() {
    }

    public WorkersSettlementDTO(Integer id, String nameSettlement, Integer qnaireNum, List<WorkerDTO> workerDTOs) {
        this.id = id;
        this.nameSettlement = nameSettlement;
        this.qnaireNum = qnaireNum;
        this.workerDTOs = workerDTOs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameSettlement() {
        return nameSettlement;
    }

    public void setNameSettlement(String nameSettlement) {
        this.nameSettlement = nameSettlement;
    }

    public Integer getQnaireNum() {
        return qnaireNum;
    }

    public void setQnaireNum(Integer qnaireNum) {
        this.qnaireNum = qnaireNum;
    }

    public List<WorkerDTO> getWorkerDTOs() {
        return workerDTOs;
    }

    public void setWorkerDTOs(List<WorkerDTO> workerDTOs) {
        this.workerDTOs = workerDTOs;
    }
}
