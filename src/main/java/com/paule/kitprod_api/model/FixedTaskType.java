package com.paule.kitprod_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fixedTaskType")
public class FixedTaskType {

    @Id
    private long id;
    private String label;

    public FixedTaskType(){
        super();
    }

    public FixedTaskType(String label){
        super();
        this.label = label;
    }

    public long getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }
}
