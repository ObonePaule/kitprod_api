package com.api.restservice.modele;

public class Charge{

    private long id;
    private long value;
    private ChargeType chargeType;

    public Charge(){
    }

    public Charge(long id, long value, ChargeType chargeType){
        this.id = id;
        this.value = value;
        this.chargeType = chargeType;
    }

}