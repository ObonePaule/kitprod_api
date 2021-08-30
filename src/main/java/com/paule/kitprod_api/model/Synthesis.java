package com.paule.kitprod_api.model;

import java.util.Map;

public class Synthesis {

    private Map<String, Double> costByFood;
    private double totalFoodCost;

    private Map<String, Double> quantityByFood;
    private double totalFoodQuantity;

    private Map<String, Double> costByCharge;
    private double totalChargeCost;

    private double totalEmployeesCost;

    private double lossPercent;

    private double averageWeight;

    private double averageDailyGain;

    private double consumptionIndex;

    private Map<String, Double> variousCharges;

    private double totalVariousCharges;

    public Synthesis(Map<String, Double> costByFood, double totalFoodCost, Map<String, Double> quantityByFood, double totalFoodQuantity, Map<String, Double> costByCharge, double totalChargeCost, double totalEmployeesCost, double lossPercent, double averageWeight, double averageDailyGain, double consumptionIndex, Map<String, Double> variousCharges, double totalVariousCharges) {
        this.costByFood = costByFood;
        this.totalFoodCost = totalFoodCost;
        this.quantityByFood = quantityByFood;
        this.totalFoodQuantity = totalFoodQuantity;
        this.costByCharge = costByCharge;
        this.totalChargeCost = totalChargeCost;
        this.totalEmployeesCost = totalEmployeesCost;
        this.lossPercent = lossPercent;
        this.averageWeight = averageWeight;
        this.averageDailyGain = averageDailyGain;
        this.consumptionIndex = consumptionIndex;
        this.variousCharges = variousCharges;
        this.totalVariousCharges = totalVariousCharges;
    }

    public Map<String, Double> getCostByFood() {
        return costByFood;
    }

    public void setCostByFood(Map<String, Double> costByFood) {
        this.costByFood = costByFood;
    }

    public double getTotalFoodCost() {
        return totalFoodCost;
    }

    public void setTotalFoodCost(double totalFoodCost) {
        this.totalFoodCost = totalFoodCost;
    }

    public Map<String, Double> getQuantityByFood() {
        return quantityByFood;
    }

    public void setQuantityByFood(Map<String, Double> quantityByFood) {
        this.quantityByFood = quantityByFood;
    }

    public double getTotalFoodQuantity() {
        return totalFoodQuantity;
    }

    public void setTotalFoodQuantity(double totalFoodQuantity) {
        this.totalFoodQuantity = totalFoodQuantity;
    }

    public Map<String, Double> getCostByCharge() {
        return costByCharge;
    }

    public void setCostByCharge(Map<String, Double> costByCharge) {
        this.costByCharge = costByCharge;
    }

    public double getTotalChargeCost() {
        return totalChargeCost;
    }

    public void setTotalChargeCost(double totalChargeCost) {
        this.totalChargeCost = totalChargeCost;
    }

    public double getTotalEmployeesCost() {
        return totalEmployeesCost;
    }

    public void setTotalEmployeesCost(double totalEmployeesCost) {
        this.totalEmployeesCost = totalEmployeesCost;
    }

    public double getLossPercent() {
        return lossPercent;
    }

    public void setLossPercent(double lossPercent) {
        this.lossPercent = lossPercent;
    }

    public double getAverageWeight() {
        return averageWeight;
    }

    public void setAverageWeight(double averageWeight) {
        this.averageWeight = averageWeight;
    }

    public double getAverageDailyGain() {
        return averageDailyGain;
    }

    public void setAverageDailyGain(double averageDailyGain) {
        this.averageDailyGain = averageDailyGain;
    }

    public double getConsumptionIndex() {
        return consumptionIndex;
    }

    public void setConsumptionIndex(double consumptionIndex) {
        this.consumptionIndex = consumptionIndex;
    }

    public Map<String, Double> getVariousCharges() {
        return variousCharges;
    }

    public void setVariousCharges(Map<String, Double> variousCharges) {
        this.variousCharges = variousCharges;
    }

    public double getTotalVariousCharges() {
        return totalVariousCharges;
    }

    public void setTotalVariousCharges(double totalVariousCharges) {
        this.totalVariousCharges = totalVariousCharges;
    }
}
