package com.api.restservice.modele;

public class ChargeType {

    private long id;
    private String label;

    public ChargeType(long id, String label){
        this.id = id;
        this.label = label;
    }

    public long getId(){
        return id;
    }

    public String getLabel(){
        return label;
    }
}

