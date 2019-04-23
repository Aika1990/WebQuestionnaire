package com.cit.rt.entity;

import javax.persistence.*;

@Entity
@Table(name = "settlement", indexes = {@Index(
        name = "idx_settlement_district_id_name",
        columnList = "district_id, name",
        unique = true)})

public class Settlement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "district_id", nullable = false)
    private District district;

    public Settlement() {
    }

    public Settlement(String name, District district) {
        this.name = name;
        this.district = district;
    }

    public Settlement(Integer id, String name, District district) {
        this.id = id;
        this.name = name;
        this.district = district;
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

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

//    @Override
//    public String toString() {
//        return "Settlement{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", district=" + district +
//                '}';
//    }
}
