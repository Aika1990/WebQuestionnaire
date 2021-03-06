package com.cit.rt.controller.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class AppSettingsDTO implements Serializable {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("settlementId")
    @Expose
    public Integer settlementId;
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

    public AppSettingsDTO(Integer id, Integer settlementId, String lastName, String firstName, String phone) {
        this.id = id;
        this.settlementId = settlementId;
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

    public Integer getSettlementId() {
        return settlementId;
    }

    public void setSettlementId(Integer settlementId) {
        this.settlementId = settlementId;
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
