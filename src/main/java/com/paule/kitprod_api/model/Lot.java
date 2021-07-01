package com.paule.kitprod_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Document(collection = "lot")
public class Lot {

    @Transient
    public static final String SEQUENCE_NAME = "lots_sequence";

    @Id
    private String id;
    private String name;
    private String species;
    private int mepAge;
    private double costByAnimal;
    private int number;
    private double costOfLitter;
    private boolean isArchived;
    private List<LotSheet> lotSheets;

    public Lot(){
        super();
    }

    public Lot(String name, String species, int mepAge, int number, double costByAnimal, double costOfLitter, List<LotSheet> lotSheets){
        this.name = name;
        this.species = species;
        this.mepAge = mepAge;
        this.number = number;
        this.costByAnimal = costByAnimal;
        this.costOfLitter = costOfLitter;
        //this.isArchived = isArchived;
        this.lotSheets = lotSheets;
    }

    public void addLotSheet(LotSheet lotSheet){
        if (this.lotSheets == null) {
            this.lotSheets = new ArrayList<>();
        }
        this.lotSheets.add(lotSheet);
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

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getMepAge() {
        return mepAge;
    }

    public void setMepAge(int mepAge) {
        this.mepAge = mepAge;
    }

    public double getCostByAnimal() {
        return costByAnimal;
    }

    public void setCostByAnimal(double costByAnimal) {
        this.costByAnimal = costByAnimal;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getCostOfLitter() {
        return costOfLitter;
    }

    public void setCostOfLitter(double costOfLitter) {
        this.costOfLitter = costOfLitter;
    }

//    public boolean isArchived() {
//        return isArchived;
//    }
//
//    public void setArchived(boolean archived) {
//        isArchived = archived;
//    }

    public List<LotSheet> getLotSheets() {
        if (lotSheets == null) {
            return Collections.EMPTY_LIST;
        }
        return lotSheets;
    }

    public void setLotSheets(List<LotSheet> listOfLotSheet) {
        this.lotSheets = lotSheets;
    }
}

