package com.paule.kitprod_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fixedTask")
public class FixedTask {

    @Id
    private long id;
    private double value;
    private FixedTaskType fixedTaskType;
    private Exploitation idExploitation;

    public FixedTask(){
        super();
    }

    public FixedTask(double value, FixedTaskType fixedTaskType){
        super();
        this.value = value;
        this.fixedTaskType = fixedTaskType;
    }

    public long getId() {
        return id;
    }

    public double getValue() {
        return value;
    }

    public FixedTaskType getFixedTaskType() {
        return fixedTaskType;
    }
}
