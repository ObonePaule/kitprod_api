package com.paule.kitprod_api.model;

public class Removal {

    private int numberOfMales;
    private int numberOfFemales;
    private int numberOfAllComers;
    private double weightByMale;
    private double weightByFemale;
    private double weightByAllComers;
    private double deadWeightCoef;

    public Removal(int numberOfMales, int numberOfFemales, int numberOfAllComers, double weightByMale, double weightByFemale, double weightByAllComers, double deadWeightCoef) {
        this.numberOfMales = numberOfMales;
        this.numberOfFemales = numberOfFemales;
        this.numberOfAllComers = numberOfAllComers;
        this.weightByMale = weightByMale;
        this.weightByFemale = weightByFemale;
        this.weightByAllComers = weightByAllComers;
        this.deadWeightCoef = deadWeightCoef;
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

    public int getNumberOfAllComers() {
        return numberOfAllComers;
    }

    public void setNumberOfAllComers(int numberOfAllComers) {
        this.numberOfAllComers = numberOfAllComers;
    }

    public double getWeightByMale() {
        if (getDeadWeightCoef() != 0){
            return weightByMale * getDeadWeightCoef();
        }
        return weightByMale;
    }

    public void setWeightByMale(double weightByMale) {
        this.weightByMale = weightByMale;
    }

    public double getWeightByFemale() {
        if (getDeadWeightCoef() != 0){
            return weightByFemale * getDeadWeightCoef();
        }
        return weightByFemale;
    }

    public void setWeightByFemale(double weightByFemale) {
        this.weightByFemale = weightByFemale;
    }

    public double getWeightByAllComers() {
        if (getDeadWeightCoef() != 0){
            return weightByAllComers * getDeadWeightCoef();
        }
        return weightByAllComers;
    }

    public void setWeightByAllComers(double weightByAllComers) {
        this.weightByAllComers = weightByAllComers;
    }

    public double getDeadWeightCoef() {
        return deadWeightCoef;
    }

    public void setDeadWeightCoef(double deadWeightCoef) {
        this.deadWeightCoef = deadWeightCoef;
    }

    public boolean isDone(){
        if (getNumberOfMales()==0 && getNumberOfFemales()==0 && getNumberOfAllComers()==0){
            return false;
        }
        return true;
    }
}
