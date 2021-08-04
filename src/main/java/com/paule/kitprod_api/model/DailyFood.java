package com.paule.kitprod_api.model;

import org.springframework.data.annotation.Id;

public class DailyFood {

    @Id
    private String id;

    private String type;
    private double value;

    public DailyFood(String type, double value) {
        this.type = type;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String getType() {
        return type;
    }

    private void setType(String type) {
        this.type = type;
    }

    private double getValue() {
        return value;
    }

    private void setValue(double value) {
        this.value = value;
    }
}
