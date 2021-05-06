package com.paule.kitprod_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "building")
public class Building {

    @Transient
    public static final String SEQUENCE_NAME = "buildings_sequence";

    @Id
    private long id;
    private String name;
    private int space;
    private int numberOfLots;
    private ArrayList<Lot> lots;

    public Building(){
        super();
    }

    public Building(String name, int space, int numberOfLots, ArrayList<Lot> lots) {
        this.name = name;
        this.space = space;
        this.numberOfLots = numberOfLots;
        this.lots = lots;
    }

    public void addLot(Lot lot){
        if (this.lots == null) {
            this.lots = new ArrayList<>();
        }
        this.lots.add(lot);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public int getNumberOfLots() {
        return numberOfLots;
    }

    public void setNumberOfLots(int numberOfLots) {
        this.numberOfLots = numberOfLots;
    }

    public List<Lot> getLots() {
        return lots;
    }

    public void setLots(ArrayList<Lot> lots) {
        this.lots = lots;
    }
}