package com.paule.kitprod_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Document(collection = "building")
public class Building {

    @Transient
    public static final String SEQUENCE_NAME = "buildings_sequence";

    @Id
    private String id;
    private String name;
    private int surface;
    private int numberOfLots;
    private List<Lot> lots;

    public Building(){
    }

    public Building(String name, int surface, int numberOfLots, List<Lot> lots) {
        this.name = name;
        this.surface = surface;
        this.numberOfLots = numberOfLots;
        this.lots = lots;
    }

    public void addLot(Lot lot){
        if (this.lots == null) {
            this.lots = new ArrayList<>();
        }
        this.lots.add(lot);
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

    public int getSurface() {
        return surface;
    }

    public void setSpace(int surface) {
        this.surface = surface;
    }

    public int getNumberOfLots() {
        return numberOfLots;
    }

    public void setNumberOfLots(int numberOfLots) {
        this.numberOfLots = numberOfLots;
    }

    public List<Lot> getLots() {
        if (lots == null) {
            return Collections.EMPTY_LIST;
        }
        return lots;
    }

    public void setLots(List<Lot> lots) {
        this.lots = lots;
    }
}