package com.paule.kitprod_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "chargeType")
public class ChargeType {

    @Id
    private long id;
    private String label;

    public ChargeType(){
        super();
    }

    public ChargeType(String label){
        this.label = label;
    }

    public long getId(){
        return id;
    }

    public String getLabel(){
        return label;
    }
}

