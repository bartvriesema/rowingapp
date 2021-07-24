package org.vriesema.novi.rowingapp.model.rowingclub;
/*
 * @created:  2021-07-10
 * @project:  rowingapp
 * @author:   bartvriesema
 */

import javax.persistence.*;

@Entity
public class TrainingType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
