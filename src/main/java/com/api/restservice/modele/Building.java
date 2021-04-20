package com.api.restservice.modele;

public class Building {

    private long id;
    private String name;
    private float space;
    private int numberOfLots;

    public Building(long id, String name, float space, int numberOfLots) {
        this.id = id;
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

    public float getSpace() {
        return space;
    }

    public int numberOfLots() {
        return numberOfLots;
    }
}