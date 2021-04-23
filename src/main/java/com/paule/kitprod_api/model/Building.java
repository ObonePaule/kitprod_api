package com.paule.kitprod_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "building")
public class Building {

    @Id
    private long id;
    private String name;
    private int space;
    private int numberOfLots;

    public Building(){
        super();
    }

    public Building(String name, int space, int numberOfLots) {
        this.name = name;
        this.space = space;
        this.numberOfLots = numberOfLots;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSpace() {
        return space;
    }

    public int numberOfLots() {
        return numberOfLots;
    }
}