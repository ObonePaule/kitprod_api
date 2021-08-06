package com.paule.kitprod_api.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document()
public class DailyFood {

    private String type;
    private double value;

    public DailyFood(String type, double value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
