package com.paule.kitprod_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "food")
public class Food{

    @Transient
    public static final String SEQUENCE_NAME = "foods_sequence";

    @Id
    private long id;
    private String name;
    private List<RawMaterial> rawMaterials;

    public Food(){
        super();
    }

    public Food(String name, List<RawMaterial> rawMaterials){
        this.name = name;
        this.rawMaterials = rawMaterials;
    }

    public void addRawMaterial(RawMaterial rawMaterial){
        if (this.rawMaterials == null) {
            this.rawMaterials = new ArrayList<>();
        }
        this.rawMaterials.add(rawMaterial);

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

    public List<RawMaterial> getRawMaterials() {
        return rawMaterials;
    }

    public void setRawMaterials(List<RawMaterial> rawMaterials) {
        this.rawMaterials = rawMaterials;
    }
}
