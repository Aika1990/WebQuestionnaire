package com.cit.rt.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table (name = "district")
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;

    public District() {
    }

    public District(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "District{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getColumnCount() {

        return getClass().getDeclaredFields().length;
    }

//    public Set<Settlement> getSettlements() {
//        return settlements;
//    }
//
//    public void setSettlements(Set<Settlement> settlements) {
//        this.settlements = settlements;
//    }
//
//    @Override
//    public String toString() {
//        String result = String.format(
//                "District[id=%d, name='%s']%n",
//                id, name);
//        if(settlements != null) {
//            for(Settlement settlement : settlements) {
//                result += String.format(
//                        "Settlement[id=%d, name='%s']%n",
//                        settlement.getId(), settlement.getName());
//            }
//        }
//        return result;
//    }
}
