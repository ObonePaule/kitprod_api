package com.paule.kitprod_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

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
    private List<LotSheet> listOfLotSheet;

    public Lot(){
        super();
    }

    public Lot(String name, String species, int mepAge, int number, double costByAnimal, double costOfLitter,boolean isArchived, List<LotSheet> listOfLotSheet){
        this.name = name;
        this.species = species;
        this.mepAge = mepAge;
        this.number = number;
        this.costByAnimal = costByAnimal;
        this.costOfLitter = costOfLitter;
        this.isArchived = isArchived;
        this.listOfLotSheet = listOfLotSheet;
    }

}

