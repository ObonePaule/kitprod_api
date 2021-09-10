package com.paule.kitprod_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Document(collection = "food")
public class Food {

    @Id
    private String id;
    private String name;
    private double fafPrestation;
    private List<RawMaterial> rawMaterials;

    public Food() {
    }

    public Food(String name, double fafPrestation, List<RawMaterial> rawMaterials) {
        this.name = name;
        this.fafPrestation = fafPrestation;
        this.rawMaterials = rawMaterials;
    }

    public void addRawMaterial(RawMaterial rawMaterial) {
        if (this.rawMaterials == null) {
            this.rawMaterials = new ArrayList<>();
        }
        this.rawMaterials.add(rawMaterial);
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

    public List<RawMaterial> getRawMaterials() {
        if (rawMaterials == null) {
            return Collections.emptyList();
        }
        return rawMaterials;
    }

    public void setRawMaterials(List<RawMaterial> rawMaterials) {
        this.rawMaterials = rawMaterials;
    }

    public double getFafPrestation() {
        return fafPrestation;
    }

    public void setFafPrestation(double fafPrestation) {
        this.fafPrestation = fafPrestation;
    }

    // Calcul du prix d'un kilo d'aliment(x%MP1 + y%MP2...)
    public double getPrice() {
        double price = 0;
        for (RawMaterial rawMaterial : getRawMaterials()) {
            price += rawMaterial.getMpPrice() * rawMaterial.getProportion() * 0.01;
        }
        price = price + getFafPrestation();
        return price;
    }

    public boolean removeRawMaterial(String idRawMaterial) {
        return rawMaterials.removeIf(rawMaterial -> rawMaterial.getId().equals(idRawMaterial));
    }
}
