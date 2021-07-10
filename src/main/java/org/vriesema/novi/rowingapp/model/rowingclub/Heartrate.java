package org.vriesema.novi.rowingapp.model.rowingclub;
/*
 * @created:  2021-07-10
 * @project:  rowingapp
 * @author:   bartvriesema
 */

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Heartrate {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long heartRateId;

    @Column
    private LocalDate heartRateDate;

    @Column
    private int heartRate;

    @ManyToOne
    private Rower rower;

    public LocalDate getHeartRateDate() {
        return heartRateDate;
    }

    public void setHeartRateDate(LocalDate heartRateDate) {
        this.heartRateDate = heartRateDate;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public Rower getRower() {
        return rower;
    }

    public void setRower(Rower rower) {
        this.rower = rower;
    }
}
