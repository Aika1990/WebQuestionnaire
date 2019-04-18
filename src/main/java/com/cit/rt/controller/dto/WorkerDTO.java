package com.cit.rt.controller.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WorkerDTO implements Serializable {

    @SerializedName("id")
    @Expose
    public Integer id;

    @SerializedName("lastName")
    @Expose
    public String lastName;

    @SerializedName("firstName")
    @Expose
    public String firstName;

    @SerializedName("phone")
    @Expose
    public String phone;

    @SerializedName("count")
    @Expose
    public Integer count;

    @SerializedName("settlement")
    @Expose
    public String settlement;

    public String getSettlement() {
        return settlement;
    }

    public void setSettlement(String settlement) {
        this.settlement = settlement;
    }

    public WorkerDTO() {
    }

    public WorkerDTO(Integer id, String lastName, String firstName, String phone, Integer count) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
