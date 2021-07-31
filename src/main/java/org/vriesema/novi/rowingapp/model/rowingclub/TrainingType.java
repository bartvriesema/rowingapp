package org.vriesema.novi.rowingapp.model.rowingclub;

import javax.persistence.*;

@Entity
public class TrainingType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private long id;

    @Column
    private String shortDescription;

    @Column
    private int lowerHeartRate;

    @Column
    private int upperHeartRate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public int getLowerHeartRate() {
        return lowerHeartRate;
    }

    public void setLowerHeartRate(int lowerHeartRate) {
        this.lowerHeartRate = lowerHeartRate;
    }

    public int getUpperHeartRate() {
        return upperHeartRate;
    }

    public void setUpperHeartRate(int upperHeartRate) {
        this.upperHeartRate = upperHeartRate;
    }
}
