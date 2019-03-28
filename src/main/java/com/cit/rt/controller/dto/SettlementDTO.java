package com.cit.rt.controller.dto;

public class SettlementDTO {

    public Integer id;
    public String district;
    public String name;

    public SettlementDTO() {
    }

    public SettlementDTO(Integer id, String district, String name) {
        this.id = id;
        this.district = district;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
