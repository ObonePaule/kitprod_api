package com.paule.kitprod_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "lot")
public class Lot {

    @Id
    private long id;
    private String name;
    private String species;
    private int mepAge;
    private double costByAnimal;
    private int number;
    private double costOfLitter;
    private boolean isArchived;
    private Building idBuilding;

    public Lot(){
        super();
    }

    public Lot(String name, String species, int mepAge, int number, double costByAnimal, double costOfLitter,boolean isArchived){
        this.name = name;
        this.species = species;
        this.mepAge = mepAge;
        this.number = number;
        this.costByAnimal = costByAnimal;
        this.costOfLitter = costOfLitter;
        this.isArchived = isArchived;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getMepAge() {
        return mepAge;
    }

    public double getCostByAnimal() {
        return costByAnimal;
    }

    public double getCostOfLitter() {
        return costOfLitter;
    }

    public int getNumber() {
        return number;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public Building getIdBuilding() {
        return idBuilding;
    }
}

