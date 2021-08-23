package com.paule.kitprod_api.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document()
public class DailyFood {

    private String idFood;
    private double value;

    public DailyFood(String idFood, double value) {
        this.idFood = idFood;
        this.value = value;
    }

    public String getIdFood() {
        return idFood;
    }

    public void setIdFood(String idFood) {
        this.idFood = idFood;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
