package com.paule.kitprod_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
public class Employee{

    @Id
    private long id;
    private String name;
    private double numberOfHour;
    private double hourCost;

    public Employee(){
        super();
    }

    public Employee(String name, double numberOfHour, double hourCost){
        super();
        this.name = name;
        this.numberOfHour = numberOfHour;
        this.hourCost = hourCost;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getHourCost() {
        return hourCost;
    }

    public double getNumberOfHour() {
        return numberOfHour;
    }
}