package com.paule.kitprod_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection ="lotSheet")
public class LotSheet {

    @Transient
    public static final String SEQUENCE_NAME = "lotSheets_sequence";

    @Id
    private String id;
    private Date dateDebut;
    private int loss;
    private DailyFood dailyFood;
    private String complement;
    private double feedingAndCareTime;
    private double manufacturingTime;
    private SpecialEvent specialEvent;
    private Removal removal;

    public LotSheet(){
        super();
    }

    public LotSheet(Date dateDebut, int loss, DailyFood dailyFood, String complement, double feedingAndCareTime, double manufacturingTime, SpecialEvent specialEvent, Removal removal) {
        this.dateDebut = dateDebut;
        this.loss = loss;
        this.dailyFood = dailyFood;
        this.complement = complement;
        this.feedingAndCareTime = feedingAndCareTime;
        this.manufacturingTime = manufacturingTime;
        this.specialEvent = specialEvent;
        this.removal = removal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public int getLoss() {
        return loss;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }

    public DailyFood getDailyFood() {
        return dailyFood;
    }

    public void setDailyFood(DailyFood dailyFood) {
        this.dailyFood = dailyFood;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public double getFeedingAndCareTime() {
        return feedingAndCareTime;
    }

    public void setFeedingAndCareTime(double feedingAndCareTime) {
        this.feedingAndCareTime = feedingAndCareTime;
    }

    public double getManufacturingTime() {
        return manufacturingTime;
    }

    public void setManufacturingTime(double manufacturingTime) {
        this.manufacturingTime = manufacturingTime;
    }

    public SpecialEvent getSpecialEvent() {
        return specialEvent;
    }

    public void setSpecialEvent(SpecialEvent specialEvent) {
        this.specialEvent = specialEvent;
    }

    public Removal getRemoval() {
        return removal;
    }

    public void setRemoval(Removal removal) {
        this.removal = removal;
    }
}
