package com.cit.rt.controller.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class AppSettingsDTO implements Serializable {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("settlement")
    @Expose
    public Integer settlement;
    @SerializedName("lastName")
    @Expose
    public String lastName;
    @SerializedName("firstName")
    @Expose
    public String firstName;
    @SerializedName("phone")
    @Expose
    public String phone;

    public AppSettingsDTO() {
    }

    public AppSettingsDTO(Integer id, Integer settlement, String lastName, String firstName, String phone) {
        this.id = id;
        this.settlement = settlement;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
    }

    //@XmlElement(name = "id")
    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    //@XmlElement(name = "settlement")
    public Integer getSettlement() {
        return settlement;
    }

    public void setSettlement(Integer settlement) {
        this.settlement = settlement;
    }

    //@XmlElement(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

   // @XmlElement(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //@XmlElement(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
