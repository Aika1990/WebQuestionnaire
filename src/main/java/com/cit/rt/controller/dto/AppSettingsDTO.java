package com.cit.rt.controller.dto;

public class AppSettingsDTO {

    public Integer id;
    public String settlement;
    public String lastName;
    public String firstName;
    public String phone;

    public AppSettingsDTO() {
    }

    public AppSettingsDTO(Integer id, String settlement, String lastName, String firstName, String phone) {
        this.id = id;
        this.settlement = settlement;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public String getSettlement() {
        return settlement;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSettlement(String settlement) {
        this.settlement = settlement;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
