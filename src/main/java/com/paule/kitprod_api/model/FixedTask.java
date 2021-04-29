package com.paule.kitprod_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fixedTask")
public class FixedTask {

    @Transient
    public static final String SEQUENCE_NAME = "fixedtasks_sequence";

    @Id
    private long id;
    private FixedTaskType fixedTaskType;
    private double value;

    public FixedTask(){
        super();
    }

    public FixedTask(FixedTaskType fixedTaskType, double value){
        super();
        this.fixedTaskType = fixedTaskType;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public FixedTaskType getFixedTaskType() {
        return fixedTaskType;
    }

    public void setFixedTaskType(FixedTaskType fixedTaskType) {
        this.fixedTaskType = fixedTaskType;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
