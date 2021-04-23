package com.paule.kitprod_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection ="lotSheet")
public class LotSheet {

    @Id
    private long id;
    private Date dateDebut;
    private Date dateFin;
    private int loss;
    private Food dailyFood;
    private double feedingAndCareTime;
    private double removalWeight;
    private int removalNumber;
    private Lot idLot;

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

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public double getFeedingAndCareTime() {
        return feedingAndCareTime;
    }

    public double getRemovalWeight() {
        return removalWeight;
    }

    public Food getDailyFood() {
        return dailyFood;
    }

    public int getLoss() {
        return loss;
    }

    public int getRemovalNumber() {
        return removalNumber;
    }

    public Lot getIdLot() {
        return idLot;
    }
}
