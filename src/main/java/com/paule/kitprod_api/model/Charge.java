package com.paule.kitprod_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Transient;

@Document(collection = "charge")
public class Charge{

    @Transient
    public static final String SEQUENCE_NAME = "charges_sequence";

    @Id
    private String id;
    private ChargeType chargeType;
    private double value;

    public Charge(){
    }

    public Charge(ChargeType chargeType, double value){
        this.chargeType = chargeType;
        this.value = value;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public double getValue() {
        return value;
    }

    public ChargeType getChargeType() {
        return chargeType;
    }
}