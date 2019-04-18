package com.cit.rt.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "app_settings")
public class AppSettings implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "settlement_id", nullable = false)
    private Settlement settlement;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "phone", nullable = false)
    private String phone;

    public AppSettings() {
    }

    public AppSettings(Integer id, Settlement settlement, String lastName, String firstName, String phone) {
        this.id = id;
        this.settlement = settlement;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
    }
    public AppSettings(Settlement settlement, String lastName, String firstName, String phone) {
        this.settlement = settlement;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Settlement getSettlement() {
        return settlement;
    }

    public void setSettlement(Settlement settlement) {
        this.settlement = settlement;
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
