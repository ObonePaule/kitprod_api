package com.paule.kitprod_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "charge")
public class Charge{

    @Id
    private long id;
    private double value;
    private ChargeType chargeType;
    private Exploitation idExploitation;

    public Charge(){
    }

    public Charge(double value, ChargeType chargeType){
        this.value = value;
        this.chargeType = chargeType;
    }

    public long getId() {
        return id;
    }

    public double getValue() {
        return value;
    }

    public ChargeType getChargeType() {
        return chargeType;
    }
}