package com.example.wolf.entiry;

public class DictCustomer {

    private Integer id;

    private String name;

    private String areaCode;

    public DictCustomer(String name, String areaCode) {
        this.name = name;
        this.areaCode = areaCode;
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

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
}
