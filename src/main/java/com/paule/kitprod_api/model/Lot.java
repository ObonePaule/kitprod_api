package com.paule.kitprod_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Document(collection = "lot")
public class Lot {

    @Id
    private String id;
    private String name;
    private String species;
    private int mepAge;
    private double costByAnimal;
    private int numberOfMales;
    private int numberOfFemales;
    private int numberOfAllcomers;
    private double costOfLitter;
    private boolean archived;
    private List<LotSheet> lotSheets;
    private List<FixedTask> fixedTasks;

    public Lot() {
        super();
    }

    public Lot(String name, String species, int mepAge, double costByAnimal, int numberOfMales, int numberOfFemales,
            int numberOfAllcomers, double costOfLitter, List<LotSheet> lotSheets, boolean archived,
            List<FixedTask> fixedTasks) {
        this.name = name;
        this.species = species;
        this.mepAge = mepAge;
        this.costByAnimal = costByAnimal;
        this.numberOfMales = numberOfMales;
        this.numberOfFemales = numberOfFemales;
        this.numberOfAllcomers = numberOfAllcomers;
        this.costOfLitter = costOfLitter;
        this.archived = archived;
        this.lotSheets = lotSheets;
        this.fixedTasks = fixedTasks;
    }

    public void addLotSheet(LotSheet lotSheet) {
        if (this.lotSheets == null) {
            this.lotSheets = new ArrayList<>();
        }
        this.lotSheets.add(lotSheet);
    }

    public void addFixedTask(FixedTask fixedTask) {
        if (this.fixedTasks == null) {
            this.fixedTasks = new ArrayList<>();
        }
        this.fixedTasks.add(fixedTask);
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

    public int getNumberOfMales() {
        return numberOfMales;
    }

    public void setNumberOfMales(int numberOfMales) {
        this.numberOfMales = numberOfMales;
    }

    public int getNumberOfFemales() {
        return numberOfFemales;
    }

    public void setNumberOfFemales(int numberOfFemales) {
        this.numberOfFemales = numberOfFemales;
    }

    public int getNumberOfAllcomers() {
        return numberOfAllcomers;
    }

    public void setNumberOfAllcomers(int numberOfAllcomers) {
        this.numberOfAllcomers = numberOfAllcomers;
    }

    public double getCostOfLitter() {
        return costOfLitter;
    }

    public void setCostOfLitter(double costOfLitter) {
        this.costOfLitter = costOfLitter;
    }

    public boolean getArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public List<LotSheet> getLotSheets() {
        if (lotSheets == null) {
            return Collections.emptyList();
        }
        return lotSheets;
    }

    public void setLotSheets(List<LotSheet> listOfLotSheet) {
        this.lotSheets = listOfLotSheet;
    }

    public List<FixedTask> getFixedTasks() {
        if (fixedTasks == null) {
            return Collections.emptyList();
        }
        return fixedTasks;
    }

    public void setFixedTasks(List<FixedTask> fixedTasks) {
        this.fixedTasks = fixedTasks;
    }
}
