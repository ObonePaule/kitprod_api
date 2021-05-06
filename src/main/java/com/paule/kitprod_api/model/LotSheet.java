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
    private long id;
    private Date dateDebut;
    private Date dateFin;
    private int loss;
    private Food dailyFood;
    private double feedingAndCareTime;
    private double removalWeight;
    private int removalNumber;

    public LotSheet(){
        super();
    }

    public LotSheet(Date dateDebut, Date dateFin, int loss, double feedingAndCareTime, double removalWeight, int removalNumber){
        super();
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.loss = loss;
        this.feedingAndCareTime = feedingAndCareTime;
        this.removalWeight = removalWeight;
        this.removalNumber = removalNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getLoss() {
        return loss;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }

    public Food getDailyFood() {
        return dailyFood;
    }

    public void setDailyFood(Food dailyFood) {
        this.dailyFood = dailyFood;
    }

    public double getFeedingAndCareTime() {
        return feedingAndCareTime;
    }

    public void setFeedingAndCareTime(double feedingAndCareTime) {
        this.feedingAndCareTime = feedingAndCareTime;
    }

    public double getRemovalWeight() {
        return removalWeight;
    }

    public void setRemovalWeight(double removalWeight) {
        this.removalWeight = removalWeight;
    }

    public int getRemovalNumber() {
        return removalNumber;
    }

    public void setRemovalNumber(int removalNumber) {
        this.removalNumber = removalNumber;
    }
}
