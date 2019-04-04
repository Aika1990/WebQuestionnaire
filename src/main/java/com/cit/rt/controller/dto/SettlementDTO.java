package com.cit.rt.controller.dto;

public class SettlementDTO {

    public Integer id;
    public String name;
    public Integer districtId;

    public SettlementDTO() {
    }


    public SettlementDTO(Integer id, String name, Integer districtId) {
        this.id = id;
        this.name = name;
        this.districtId = districtId;
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

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }
}
