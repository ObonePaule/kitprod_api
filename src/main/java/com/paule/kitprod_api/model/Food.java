package com.paule.kitprod_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "food")
public class Food{

    @Id
    private long id;
    private String name;

    public Food(){
        super();
    }

    public Food(String name){
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName(){
        return name ;
    }
}
