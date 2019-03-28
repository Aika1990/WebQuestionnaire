package com.cit.rt.controller.dto;

public class TableDTO {

    public String path;
    public String name;

    public TableDTO(String path, String name) {
        this.path = path;
        this.name = name;
    }


    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }
}
