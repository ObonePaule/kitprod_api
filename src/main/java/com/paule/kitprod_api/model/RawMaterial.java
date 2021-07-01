package com.paule.kitprod_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class RawMaterial {

    @Transient
    public static final String SEQUENCE_NAME = "rawmaterials_sequence";

    @Id private String id;
    private String name;
    private double proportion;
    private double mpPrice;

    public RawMaterial() {
    }

    public RawMaterial(String name, double proportion, double mpPrice) {
        this.name = name;
        this.proportion = proportion;
        this.mpPrice = mpPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getProportion() {
        return proportion;
    }

    public void setProportion(double proportion) {
        this.proportion = proportion;
    }

    public double getMpPrice() {
        return mpPrice;
    }

    public void setMpPrice(double mpPrice) {
        this.mpPrice = mpPrice;
    }
}
