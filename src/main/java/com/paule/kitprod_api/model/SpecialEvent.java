package com.paule.kitprod_api.model;

public class SpecialEvent {

    private double vaccin;
    private double fraisVeterinaires;

    public SpecialEvent(double vaccin, double fraisVeterinaires) {
        this.vaccin = vaccin;
        this.fraisVeterinaires = fraisVeterinaires;
    }

    public double getVaccin() {
        return vaccin;
    }

    public void setVaccin(double vaccin) {
        this.vaccin = vaccin;
    }

    public double getFraisVeterinaires() {
        return fraisVeterinaires;
    }

    public void setFraisVeterinaires(double fraisVeterinaires) {
        this.fraisVeterinaires = fraisVeterinaires;
    }
}
