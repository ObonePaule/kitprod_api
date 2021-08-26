package com.paule.kitprod_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
public class Employee{

    @Transient public static final String SEQUENCE_NAME = "employees_sequence";

    @Id private String id;
    private String name;
    private String employeeType;
    private double numberOfHour;
    private double hourCost;

    public Employee(){
        super();
    }

    public Employee(String name,String employeeType, double numberOfHour, double hourCost){
        this.name = name;
        this.employeeType = employeeType;
        this.numberOfHour = numberOfHour;
        this.hourCost = hourCost;
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

    public double getNumberOfHour() {
        return numberOfHour;
    }

    public void setNumberOfHour(double numberOfHour) {
        this.numberOfHour = numberOfHour;
    }

    public double getHourCost() {
        return hourCost;
    }

    public void setHourCost(double hourCost) {
        this.hourCost = hourCost;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }
}